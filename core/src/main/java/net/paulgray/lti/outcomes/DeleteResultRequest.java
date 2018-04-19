package net.paulgray.lti.outcomes;

import java.text.MessageFormat;

public class DeleteResultRequest implements OutcomesMessage {

    private String messageIdentifier;
    private String sourcedId;

    public DeleteResultRequest(String messageIdentifier, String sourcedId) {
        this.messageIdentifier = messageIdentifier;
        this.sourcedId = sourcedId;
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
        "    <deleteResultRequest>" +
        "      <resultRecord>" +
        "        <sourcedGUID>" +
        "          <sourcedId>{1}</sourcedId>" +
        "        </sourcedGUID>" +
        "      </resultRecord>" +
        "    </deleteResultRequest>" +
        "  </imsx_POXBody>" +
        "</imsx_POXEnvelopeRequest>";

    @Override
    public String serialize() {
        return MessageFormat.format(TEMPLATE, messageIdentifier, sourcedId);
    }
}
