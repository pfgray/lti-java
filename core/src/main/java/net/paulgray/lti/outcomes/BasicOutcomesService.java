package net.paulgray.lti.outcomes;

import org.apache.http.client.methods.HttpPost;

import java.util.Optional;

public interface BasicOutcomesService {

    Optional<HttpPost> signOutcomeMessage(OutcomesMessage message, String url, String key, String secret, Optional<String> algorithm);

}
