package net.paulgray.lti.message;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

public interface LtiMessageExtractor {

    LtiErrorable<LtiMessage> extractLtiMessage(HttpServletRequest req);

    LtiErrorable<LtiMessage> extractLtiMessage(Collection<? extends Map.Entry<String, String>> parameters);

}
