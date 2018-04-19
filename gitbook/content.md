
# Content Selection.  
  
Oftentimes, a tool may want enable users to create content inside the consumer (LMS) from inside the tool automatically. "Content" can mean many different things: ranging from images, to reading material, to even LTI launches. The consumer launches into the tool with a `content_item_return_url` parameter. The user can make some choices about the content they want to add, and then the tool launches the user back to the LMS, using a form POST that contains the content they've chosen.  
  
### Content Item Selection Request

First, The consumer launches to the tool provider with a few useful parameters:

```  
...
lti_message_type=ContentItemSelectionRequest
content_item_return_url=https://consumer.com/content-item-return
accept_unsigned=true
data=...
```

The `ContentItemSelectionRequest` value indicates to the tool that the user wants to pick some content to add to their LMS. The `content_item_return_url` is the url that the provider will launch the user back into when they've made their selection. The `accept_unsigned` parameter specifies whether or not the consumer accepts unsigned messages. `data` is simply some opaque data that the tool needs to return in the launch back with.

The POST back to the tool consumer will also contain some useful parameters: 
```
...
lti_message_type=ContentItemSelection
content_items={...}
```

The `content_items` parameter contains a json representation of one or more content items that the user has chosen to add to their lms.

```json
{
  "@context":"http://purl.imsglobal.org/ctx/lti/v1/ContentItem", 
  "@graph":[{
    "@type":"ContentItem",
    "url":"http://www.google.com",
	"mediaType":"text/html",
	"thumbnail":{
	  "@id":"https://www.google.com/icon.png",
	  "width":150,
	  "height":150
	},
    "title":"Search Engine",
    "placementAdvice" : {
      "presentationDocumentTarget" : "window",
      "windowTarget" : "_blank"
    }
  },{
    "@type" : "LtiLinkItem",
    "mediaType" : "application/vnd.ims.lti.v1.ltilink",
    "icon" : {
      "@id" : "https://www.example.com/activity/1/icon.png",
      "width" : 100,
      "height" : 100
    },
    "title" : "Quiz #1",
    "text" : "You will have 30 minutes to complete this assessment",
    "custom" : {
      "time_to_complete" : "900"
    }
  }]
}
```

To build a list of content items, create an instance of `ContentItemSelection` class, filling it with a list of `ContentItem`s, `FileItem`s, and `LtiLinkItems`:

```java
ContentItemSelection selection =
  ContentItemSelection.builder()
    .addGraph(
      ContentItem.builder()
        .url("http://www.google.com")
        .mediaType("text/html")
        .thumbnail(Image.builder()
          .id("https://www.google.com/icon.png")
          .width(150)
          .height(150).build()
        )
        .title("Search Engine")
        .placementAdvice(PlacementAdvice.builder()
          .presentationDocumentTarget("window")
          .windowTarget("_blank").build()
        ).build(),
      LtiLinkItem.builder()
        .icon(Image.builder()
          .id("https://www.example.com/activity/1/icon.png")
          .width(100)
          .height(100).build()
        )
        .title("Quiz #1")
        .text("You will have 30 minutes to complete this assessment")
        .putCustom("time_to_complete", "900")
        .build()
    ).build();
```

Then you can use Jackson to convert it into json:

```java
ObjectMapper mapper = new ObjectMapper();

String selectionParam = mapper.writeValueAsString(contentItemSelection);
```

### Content Item Selection

Add the generated json to the `content_items` param and sign the launch back to the consumer:
 
```java
Map<String, String> params = Map.of(
  "lti_message_type": "ContentItemSelection",
  "data", dataFromConsumer,
  "content_items", selectionParam
);

LtiSigner signer = new LtiOauth10aSigner();

Map<String, String> signedParams = signer.signParameters(params.entrySet(), key, secret, contentItemReturnUrl, "POST");
```

Finally, add the the signed parameters to an html form so the user can post it back to the consumer:
```
<form action="${launchUrl}" method="POST">
  <c:forEach items="${parameters}" var="param">
    <input type="hidden" name="${param.key}" value="${param.value}" />
  </c:forEach>
  <input type="submit">Launch Tool</input>
</form>
```
