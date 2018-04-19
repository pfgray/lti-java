package net.paulgray.lti.outcomes;

import java.text.MessageFormat;

public class ReadResultResponse implements OutcomesMessage {

    private String messageIdentifier;
    private ResponseCodeMajor responseCodeMajor;
    private ResponseSeverity responseSeverity;
    private String description;
    private String messageRefIdentifier;
    private String score;

    public ReadResultResponse(String messageIdentifier, ResponseCodeMajor responseCodeMajor, ResponseSeverity responseSeverity, String description, String messageRefIdentifier, String score) {
        this.messageIdentifier = messageIdentifier;
        this.responseCodeMajor = responseCodeMajor;
        this.responseSeverity = responseSeverity;
        this.description = description;
        this.messageRefIdentifier = messageRefIdentifier;
        this.score = score;
    }

    public String getMessageIdentifier() {
        return messageIdentifier;
    }

    public ResponseCodeMajor getResponseCodeMajor() {
        return responseCodeMajor;
    }

    public ResponseSeverity getResponseSeverity() {
        return responseSeverity;
    }

    public String getDescription() {
        return description;
    }

    public String getMessageRefIdentifier() {
        return messageRefIdentifier;
    }

    public String getScore() {
        return score;
    }

    public static String TEMPLATE =
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
        "<imsx_POXEnvelopeResponse xmlns=\"http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms_v1p0\">" +
        "  <imsx_POXHeader>" +
        "    <imsx_POXResponseHeaderInfo>" +
        "      <imsx_version>V1.0</imsx_version>" +
        "      <imsx_messageIdentifier>{0}</imsx_messageIdentifier>" +
        "      <imsx_statusInfo>" +
        "        <imsx_codeMajor>{1}</imsx_codeMajor>" +
        "        <imsx_severity>{2}</imsx_severity>" +
        "        <imsx_description>{3}</imsx_description>" +
        "        <imsx_messageRefIdentifier>{4}</imsx_messageRefIdentifier>" +
        "        <imsx_operationRefIdentifier>readResult</imsx_operationRefIdentifier>" +
        "      </imsx_statusInfo>" +
        "    </imsx_POXResponseHeaderInfo>" +
        "  </imsx_POXHeader>" +
        "  <imsx_POXBody>" +
        "    <readResultResponse>" +
        "       <result>" +
        "         <resultScore>" +
        "           <language>en</language>" +
        "           <textString>{5}</textString>" +
        "         </resultScore>" +
        "       </result>" +
        "    </readResultResponse>" +
        "  </imsx_POXBody>" +
        "</imsx_POXEnvelopeResponse>";

    @Override
    public String serialize() {
        return MessageFormat.format(TEMPLATE, messageIdentifier, responseCodeMajor, responseSeverity, description, messageRefIdentifier, score);
    }
}
