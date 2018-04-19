package net.paulgray.lti.message;

import net.paulgray.lti.message.error.MissingMessageType;

import static net.paulgray.lti.LtiConstants.*;
import static net.paulgray.lti.message.error.LtiError.MISSING_MESSAGE_TYPE;

public interface MessageType {

    String getValue();

    static LtiErrorable<MessageType> fromParams(ParamExtractor e) {
        return e.getFirst(LTI_MESSAGE_TYPE, MISSING_MESSAGE_TYPE).map(MessageType::fromString);
    }

    static MessageType fromString(String messageType) {
        for (KnownMessageType type : KnownMessageType.values()) {
            if (type.getValue().equalsIgnoreCase(messageType)) {
                return type;
            }
        }
        return new ExtensionMessageType(messageType);
    }
}
