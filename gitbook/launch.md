
## The Launch
One capability that LTI enables is SSO (Single Sign-on). This means that users who are signed into the consumer, can follow a link to the provider, and be authenticated automatically, without having to provide an additional set of credentials.  

This is accomplished via the **LTI Launch**, in which the consumer builds a request containing the user's information (name, role, etc), and gives it to the user. The user then sends the request to the provider, where the provider reads the name and role and provides an interface for for it's capabilities.

### Signing
Since the launch request comes from the user's client, the provider cannot trust that the information in the request is valid by itself. For example: When the consumer builds a request and sends it to a student. The student can change their role to "instructor," which could  cause the the tool the give that student elevated rights.

**Consumers** can sign a list of parameters using an instance of `LtiOauthSigner`:

```java
import net.paulgray.lti.launch.LtiSigner

// ...

LtiSigner signer = new LtiOauthSigner();
Map<String, String> parameters = new HashMap<>();
...

Map<String, String> signedParameters = signer.sign(parameters.entrySet(), key, secret, url, "POST");
```

These parameters can be returned to the client and inserted into an auto-submittted form. Here's an example using JSP:
```
<form action="${launchUrl}" method="POST">
  <c:forEach items="${parameters}" var="param">
    <input type="hidden" name="${param.key}" value="${param.value}" />
  </c:forEach>
  <input type="submit">Launch Tool</input>
</form>
```

### Signature Verification

In order for the **provider** to verify that the user's  request contains valid information, and that it wasn't changed by the user, the provider and consumer must agree on a key and secret beforehand that the consumer will sign launch requests with. When the consumer builds the request, they take the secret that is only known by it and the provider and uses it to compute a signature for the information in the request. The compiled request now contains the user's information _and_ the signature based on that information.

When the user sends the request to the provider, the provider takes the information in the request, and the secret that it arranged before hand with the consumer, and applies the same process to compute the signatures. If the signature computed by the provider matches the one included in the request, then the provider can trust that they information came from the consumer. If the user had tampered with the information in the request, then the signature computed by the provider would not match the one in the request, and the provider would know not to trust it. The user also cannot recompute a new signature for their modified information because they don't know the secret.

As a **provider**, I can verify a set of parameters using an instance of `LtiOauthVerifier`:

```java
LtiVerifier verifier = new LtiOauthVerifier();
Map<String, String> parameters = request.getParameters();

// retrieve the stored secret for the key in the request:
String key = parameters.get("oauth_consumer_key");
String secret = keyService.fetchSecretForKey(key);

LtiVerificationRequest = verifier.verifyParameters(parameters.entrySet(), url, "POST", secret);
```

### Launch Parameters
The LTI launch includes information about the user and the context of where the user came from (i.e. did the user click on the link from within a course? or from within their profile page, etc). This allows the tool to provide functionality pertaining to that information. For example, a tool could provide a chat system for every course, matching users that come from the same course together.

The full list of LTI parameters in the standard is _(note: some consumers may provide additional parameters based on custom functionality)_:

|Parameter name|Description|
|----|----|
|lti_message_type|This indicates that this is a Basic LTI Launch Message.  This allows a TP to accept a number of different LTI message types at the same launch URL.  This parameter is required.|
|lti_version|This indicates which version of the specification is being used for this particular message.  This parameter is required.|
|resource_link_id|This is an opaque unique identifier that the TC guarantees will be unique within the TC for every placement of the link.   If the tool / activity is placed multiple times in the same context, each of those placements will be distinct. This value will also change if the item is exported from one system or context and imported into another system or context.  This parameter is required.|
|resource_link_title|A title for the resource. This is the clickable text that appears in the link. This parameter is recommended.|
|resource_link_description|A plain text description of the link’s destination, suitable for display alongside the link. Typically no more than several lines long. This parameter is optional.|
|user_id|Uniquely identifies the user.  This should not contain any identifying information for the user.  Best practice is that this field should be a TC-generated long-term “primary key” to the user record – not the “logical key".  This parameter is recommended.|
|user_image|This attribute specifies the URI for an image of the user who launched this request.  This image is suitable for use as a "profile picture" or an avatar representing the user.  This parameter is optional.|
|roles|A comma-separated list of URN values for roles.  If this list is non-empty, it should contain at least one role from the LIS System Role, LIS Institution Role, or LIS Context Role vocabularies (See Appendix A).  The assumed namespace of these URNs is the LIS vocabulary of LIS Context Roles so TCs can use the handles when the intent is to refer to an LIS context role.  If the TC wants to include a role from another namespace, a fully-qualified URN should be used.  Usage of roles from non-LIS vocabularies is discouraged as it may limit interoperability.   This parameter is recommended.|
|lis_person_name_given|The first name of the launching user.|
|lis_person_name_family|The last name of the launching user.|
|lis_person_name_full|The full name of the launching user|
|lis_person_contact_email_primary|The primary email of the launching user.|
|context_id|This is an opaque identifier that uniquely identifies the context that contains the link being launched. This parameter is recommended.|
|context_type|This string is a comma-separated list of URN values that identify the type of context.  At a minimum, the list MUST include a URN value drawn from the LIS vocabulary (see Appendix A). The assumed namespace of these URNs is the LIS vocabulary so TCs can use the handles when the intent is to refer to an LIS context type.  If the TC wants to include a context type from another namespace, a fully-qualified URN should be used. This parameter is optional.|
|context_title|A title of the context – it should be about the length of a line. This parameter is recommended.|
|context_label|A value for the context – intended to fit in a column. This parameter is recommended.|
|launch_presentation_locale|Language, country and variant as represented using the IETF Best Practices for Tags for Identifying Languages (BCP-47) available at http://www.rfc-editor.org/rfc/bcp/bcp47.txt|
|launch_presentation_document_target|The value should be either ‘frame’, ‘iframe’ or ‘window’.  This field communicates the kind of browser window/frame where the TC has launched the tool. This parameter is recommended.|
|launch_presentation_width|The width of the window or frame where the content from the tool will be displayed. This parameter is recommended.|
|launch_presentation_height|The height of the window or frame where the content from the tool will be displayed. This parameter is recommended.|
|launch_presentation_return_url|Fully qualified URL where the TP can redirect the user back to the TC interface.  This URL can be used once the TP is finished or if the TP cannot start or has some technical difficulty.  In the case of an error, the TP may add a parameter called lti_errormsg that includes some detail as to the nature of the error.  The lti_errormsg value should make sense if displayed to the user.  If the tool has displayed a message to the end user and only wants to give the TC a message to log, use the parameter lti_errorlog instead of lti_errormsg. If the tool is terminating normally, and wants a message displayed to the user it can include a text message as the lti_msg parameter to the return URL. If the tool is terminating normally and wants to give the TC a message to log, use the parameter lti_log. This data should be sent on the URL as a GET – so the TP should take care to keep the overall length of the parameters small enough to fit within the limitations of a GET request. This parameter is recommended.|
|tool_consumer_instance_guid|This is a unique identifier for the TC.  A common practice is to use the DNS of the organization or the DNS of the TC instance.  If the organization has multiple TC instances, then the best practice is to prefix the domain name with a locally unique identifier for the TC instance.  This parameter is recommended.|
|tool_consumer_instance_name|This is a user visible field – it should be about the length of a column. This parameter is recommended.|
|tool_consumer_instance_description|This is a user visible field – it should be about the length of a line. This parameter is optional.|
|tool_consumer_instance_url|This is the URL of the consumer instance.  This parameter is optional.|
|tool_consumer_instance_contact_email|An email contact for the TC instance. This parameter is recommended.|

### Extracting/Validating Information from a launch
Often it's useful to extract values from an LTI message into a more meaningful representation.

You can use `LtiMessageExtractorImpl` to make this easier:

```java
HttpServlet request = ...;
LtiMessageExtractorImpl extractor = new LtiMessageExtractorImpl();

LtiErrorable<LtiMessage> message = extractor.extractLtiMessage(request.getParameters());

message.collapse(
  message -> {
    //success
    BasicLtiLaunchRequestMessage launch = (BasicLtiLaunchRequestMessage) message;
    User user = launch.user();

    return "ltiSuccess.jsp";
  },
  errors -> {
    // error
    return "ltiError.jsp";
  }
);
```
