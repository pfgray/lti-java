package net.paulgray.lti.outcomes;

import java.text.MessageFormat;

public class ReplaceResultRequest implements OutcomesMessage {

    private String sourcedId;
    private String resultScore;
    private String messageIdentifier;

    public ReplaceResultRequest(String sourcedId, String resultScore, String messageIdentifier) {
        this.sourcedId = sourcedId;
        this.resultScore = resultScore;
        this.messageIdentifier = messageIdentifier;
    }

    public String getSourcedId() {
        return sourcedId;
    }

    public String getResultScore() {
        return resultScore;
    }

    public String getMessageIdentifier() {
        return messageIdentifier;
    }

    public static String TEMPLATE =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
        "<imsx_POXEnvelopeRequest xmlns=\"http://www.imsglobal.org/services/ltiv1p1/xsd/imsoms_v1p0\">" +
        "  <imsx_POXHeader>" +
        "    <imsx_POXRequestHeaderInfo>" +
        "      <imsx_version>V1.0</imsx_version>" +
        "      <imsx_messageIdentifier>{0}</imsx_messageIdentifier>" +
        "    </imsx_POXRequestHeaderInfo>" +
        "  </imsx_POXHeader>" +
        "  <imsx_POXBody>" +
        "    <replaceResultRequest>" +
        "      <resultRecord>" +
        "        <sourcedGUID>" +
        "          <sourcedId>{1}</sourcedId>" +
        "        </sourcedGUID>" +
        "        <result>" +
        "          <resultScore>" +
        "            <language>en</language>" +
        "            <textString>{2}</textString>" +
        "          </resultScore>" +
        "        </result>" +
        "      </resultRecord>" +
        "    </replaceResultRequest>" +
        "  </imsx_POXBody>" +
        "</imsx_POXEnvelopeRequest>";

    @Override
    public String serialize() {
        return MessageFormat.format(TEMPLATE, sourcedId, resultScore, messageIdentifier);
    }
}
