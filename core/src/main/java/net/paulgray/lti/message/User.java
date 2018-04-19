package net.paulgray.lti.message;

import net.paulgray.lti.message.error.LtiError;
import net.paulgray.lti.message.error.MissingUserId;
import org.inferred.freebuilder.FreeBuilder;

import java.util.Optional;

import static net.paulgray.lti.LtiConstants.*;
import static net.paulgray.lti.message.error.LtiError.MISSING_USER_ID;

@FreeBuilder
public interface User {

    String id();
    Optional<String> image();
    Optional<String> email();
    Optional<String> fullName();
    Optional<String> givenName();
    Optional<String> familyName();
    Optional<String> sourcedid();

    static Builder builder() {
        return new Builder();
    }

    Builder toBuilder();

    /** Builder of instances. */
    class Builder extends User_Builder {
        public Builder() {
            image(Optional.empty());
            email(Optional.empty());
            fullName(Optional.empty());
            givenName(Optional.empty());
            familyName(Optional.empty());
            sourcedid(Optional.empty());
        }
    }

    static LtiErrorable<User> fromParams(ParamExtractor e) {
        return e.getFirst(USER_ID, MISSING_USER_ID).map(userId ->
          User.builder()
            .id(userId)
            .image(e.getFirst(USER_IMAGE))
            .email(e.getFirst(LIS_PERSON_CONTACT_EMAIL_PRIMARY))
            .fullName(e.getFirst(LIS_PERSON_NAME_FULL))
            .givenName(e.getFirst(LIS_PERSON_NAME_GIVEN))
            .familyName(e.getFirst(LIS_PERSON_NAME_FAMILY))
            .sourcedid(e.getFirst(LIS_PERSON_SOURCEDID))
            .build()
        );
    }

}
