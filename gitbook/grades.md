

# Grade pass back

A common feature that learning tools provide is some form of assessment, in which a student generates an outcome, or grade. Often, it is desirable to have that outcome automatically populated back to the LMS's gradebook. Consumers can implement LTI outcomes to enable tools to do this.

In the LTI launch, the consumer provides a url in the `lis_outcomes_service_url` parameter, along with a grade cell identifier in the `lis_result_sourced_id` parameter.
Using this url, the provider can send an XML POST request, containing the grade cell identifier and the grade value. The request is signed by the provider (just like a launch request), except the request isn't sent by the user's client; it's sent from the provider directly (server to server). 

Along with sending a grade back, the provider can also **read** the current grade, and **delete** grades that were previously sent. The three types of requests that a provider can send are:

`replaceResultRequest` - update the current grade for the given cell id.
`readResultRequest` - return the current grade for the given cell id.
`deleteResultRequest` - remove the current grade for the given cell id.

### Updating grades
When the provider wants to sync a grade back to the consumer, they can send a `replaceResultRequest`. Even though the name might suggest, the provider doesn't need to have already sent a grade to send a `replaceResultRequest`.

The XML body of this request would look like:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<imsx_POXEnvelopeRequest xmlns="http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms_v1p0">
  <imsx_POXHeader>
    <imsx_POXRequestHeaderInfo>
      <imsx_version>V1.0</imsx_version>
      <imsx_messageIdentifier>1</imsx_messageIdentifier>
    </imsx_POXRequestHeaderInfo>
  </imsx_POXHeader>
  <imsx_POXBody>
    <replaceResultRequest>
      <resultRecord>
        <sourcedGUID>
          <sourcedId>1234</sourcedId>
        </sourcedGUID>
        <result>
          <resultScore>
            <language>en</language>
            <textString>0.85</textString>
          </resultScore>
        </result>
      </resultRecord>
    </replaceResultRequest>
  </imsx_POXBody>
</imsx_POXEnvelopeRequest>
```

The `<sourcedId>3124567</sourcedId>` is the value from the `lis_result_sourced_id` parameter that was received in the LTI launch. This value identifies a cell in a gradebook, so it's unique to the user and activity.

*Note: The grade is a decimal value between 1 and 0. If the provider's grades are not stored this way, they'll need to scale them, with 0 meaning the student didn't score any points, and 1 meaning the student scored all the available points. There is no mechanism for extra credit (TODO: How do the particular consumers deal with values outside of this range?).*

*Note: the grade cell identifier is unique to the student and column, and even though the LTI outcomes standard says the `lis_outcomes_service_url` _should_ remain the same across launches, there are a few consumers that don't follow that rule, so it's best to assume that it's different every time. Realistically, providers end up just storing the url alongside the grade cell identifier, and update it for every launch they receive.*

To send an update result request, you can create an instance of `ReadResultRequest`, and sign it using the `BasicOutcomesService`

```java
BasicOutcomesService service = new BasicOutcomesServiceImpl();
ReplaceResultRequest replace = new ReplaceResultRequest(sourcedId, resultScore, messageId);

Optional<HttpPost> req = service.signOutcomeMessage(replace);
req.ifPresent(r -> {
    DefaultHttpClient client = new DefaultHttpClient();  
    HttpResponse response = client.execute(r);
    // do something with response...
});
```

The consumer will respond with an XML body that contains the status of the update:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<imsx_POXEnvelopeResponse xmlns="http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms_v1p0">
  <imsx_POXHeader>
    <imsx_POXResponseHeaderInfo>
      <imsx_version>V1.0</imsx_version>
      <imsx_messageIdentifier>4560</imsx_messageIdentifier>
      <imsx_statusInfo>
        <imsx_codeMajor>success</imsx_codeMajor>
        <imsx_severity>status</imsx_severity>
        <imsx_messageRefIdentifier>999999123</imsx_messageRefIdentifier>
        <imsx_operationRefIdentifier>deleteResult</imsx_operationRefIdentifier>
      </imsx_statusInfo>
    </imsx_POXResponseHeaderInfo>
  </imsx_POXHeader>
  <imsx_POXBody>
    <deleteResultResponse />
  </imsx_POXBody>
</imsx_POXEnvelopeResponse>
```

### Reading grades
The provider can find out what grade the consumer has on record for a particular grade cell by sending a `readResultRequest` request.

The provider POSTs an XML body which contains the grade cell identifier to the `lis_outcomes_service_url`, and the consumer sends a response with an XML body that contains the value it has on record for that grade cell.

The body of the provider's request looks like: 
```xml
<?xml version="1.0" encoding="UTF-8"?>
<imsx_POXEnvelopeRequest xmlns="http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms_v1p0">
  <imsx_POXHeader>
    <imsx_POXRequestHeaderInfo>
      <imsx_version>V1.0</imsx_version>
      <imsx_messageIdentifier>2</imsx_messageIdentifier>
    </imsx_POXRequestHeaderInfo>
  </imsx_POXHeader>
  <imsx_POXBody>
    <readResultRequest>
      <resultRecord>
        <sourcedGUID>
          <sourcedId>1234</sourcedId>
        </sourcedGUID>
      </resultRecord>
    </readResultRequest>
  </imsx_POXBody>
</imsx_POXEnvelopeRequest>
```

You can create and sign ReadResult requests by using the `BasicOutcomesService`:

```java
BasicOutcomesService service = new BasicOutcomesServiceImpl();
ReadResultRequest read = new ReadResultRequest(messageId, sourcedId);

Optional<HttpPost> req = service.signOutcomeMessage(read);
req.ifPresent(r -> {
    DefaultHttpClient client = new DefaultHttpClient();  
    HttpResponse response = client.execute(r);
    // do something with response...
});
```

The consumer responds with an XML body containing the grade for that particular grade cell identifier:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<imsx_POXEnvelopeResponse xmlns="http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms_v1p0">
  <imsx_POXHeader>
    <imsx_POXResponseHeaderInfo>
      <imsx_version>V1.0</imsx_version>
      <imsx_messageIdentifier>AA</imsx_messageIdentifier>
      <imsx_statusInfo>
        <imsx_codeMajor>success</imsx_codeMajor>
        <imsx_severity>status</imsx_severity>
        <imsx_description>Result read</imsx_description>
        <imsx_messageRefIdentifier>2</imsx_messageRefIdentifier>
        <imsx_operationRefIdentifier>readResult</imsx_operationRefIdentifier>
      </imsx_statusInfo>
    </imsx_POXResponseHeaderInfo>
  </imsx_POXHeader>
  <imsx_POXBody>
    <readResultResponse>
      <result>
        <resultScore>
          <language>en</language>
          <textString>0.85</textString>
        </resultScore>
      </result>
    </readResultResponse>
  </imsx_POXBody>
</imsx_POXEnvelopeResponse>
```

### Deleting grades
The provider can delete grades by sending a `deleteResult` request to the `lti_outcomes_service_url` which the consumer sent in the LTI Launch.

The `deleteResult` request is a POST made from the provider to the consumer with an XML body like:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<imsx_POXEnvelopeRequest xmlns="http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms_v1p0">
  <imsx_POXHeader>
    <imsx_POXRequestHeaderInfo>
      <imsx_version>V1.0</imsx_version>
      <imsx_messageIdentifier>3</imsx_messageIdentifier>
    </imsx_POXRequestHeaderInfo>
  </imsx_POXHeader>
  <imsx_POXBody>
    <deleteResultRequest>
      <resultRecord>
        <sourcedGUID>
          <sourcedId>1234</sourcedId>
        </sourcedGUID>
      </resultRecord>
    </deleteResultRequest>
  </imsx_POXBody>
</imsx_POXEnvelopeRequest>
```

You can create and sign DeleteResult requests by using the `BasicOutcomesService`:

```java
BasicOutcomesService service = new BasicOutcomesServiceImpl();
DeleteResultRequest del = new DeleteResultRequest(messageId, sourcedId);

Optional<HttpPost> req = service.signOutcomeMessage(del);
req.ifPresent(r -> {
    DefaultHttpClient client = new DefaultHttpClient();  
    HttpResponse response = client.execute(r);
    // do something with response...
});
```

The consumer will respond with an xml body containing the status of the request:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<imsx_POXEnvelopeResponse xmlns="http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms\_v1p0">
  <imsx_POXHeader>
    <imsx_POXResponseHeaderInfo>
      <imsx_version>V1.0</imsx_version>
      <imsx_messageIdentifier>AB</imsx_messageIdentifier>
      <imsx_statusInfo>
        <imsx_codeMajor>success</imsx_codeMajor>
        <imsx_severity>status</imsx_severity>
        <imsx_messageRefIdentifier>3</imsx_messageRefIdentifier>
        <imsx_operationRefIdentifier>deleteResult</imsx_operationRefIdentifier>
      </imsx_statusInfo>
    </imsx_POXResponseHeaderInfo>
  </imsx_POXHeader>
  <imsx_POXBody>
    <deleteResultResponse />
  </imsx_POXBody>
</imsx_POXEnvelopeResponse>
```
