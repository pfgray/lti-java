package net.paulgray.aspect;

import net.paulgray.lti.launch.LtiVerifier;
import net.paulgray.lti.message.LtiErrorable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author pgray
 */
@Aspect
public class LtiLaunchVerifier {

    public LtiKeySecretService keyService;

    public LtiVerifier ltiVerifier;

    public LtiLaunchVerifier(LtiKeySecretService keyService, LtiVerifier ltiVerifier) {
        this.keyService = keyService;
        this.ltiVerifier = ltiVerifier;
    }

    @Around("@annotation(launch)")
    public Object verifyLtiLaunch(ProceedingJoinPoint pjp, Lti launch) throws Throwable {
        HttpServletRequest request = null;
        for (Object arg : pjp.getArgs()) {
            if (HttpServletRequest.class.isInstance(arg)) {
                request = (HttpServletRequest) arg;
            }
        }
        if (request == null) {
            throw new IllegalStateException(getErrorMessageForArgumentClass("HttpServletRequest", pjp.getSignature().toLongString()));
        }

        String oauthSecret = keyService.getSecretForKey(request.getParameter("oauth_consumer_key"));
        LtiErrorable<HttpServletRequest> ltiResult = ltiVerifier.verify(request, oauthSecret);

        return pjp.proceed(Arrays.stream(pjp.getArgs()).map(arg -> {
            // todo: this may not be sound... no way to check the inner type of LtiErrorable, though.. "joys of java"
            if(arg != null && arg.getClass().equals(LtiErrorable.class)) {
                return ltiResult;
            } else {
                return arg;
            }
        }).collect(Collectors.toList()).toArray());
    }

    public String getErrorMessageForArgumentClass(String argumentClass, String signature) {
        return "The LtiLaunchVerifier instance cannot find the " + argumentClass + " argument on method: " + signature + ", are you sure it was declared?";
    }

}
