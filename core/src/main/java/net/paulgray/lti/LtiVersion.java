package net.paulgray.lti;

import net.paulgray.lti.message.*;
import net.paulgray.lti.message.error.MissingLtiVersion;

import static net.paulgray.lti.LtiConstants.*;
import static net.paulgray.lti.message.error.LtiError.MISSING_LTI_VERSION;

public interface LtiVersion {

    String getValue();

    static LtiErrorable<LtiVersion> fromParams(ParamExtractor e) {
        return e.getFirst(LTI_VERSION, MISSING_LTI_VERSION).map(LtiVersion::fromString);
    }

    static LtiVersion fromString(String version) {
        for (KnownLtiVersion type : KnownLtiVersion.values()) {
            if (type.getValue().equalsIgnoreCase(version)) {
                return type;
            }
        }
        return new UnknownLtiVersion(version);
    }

}
