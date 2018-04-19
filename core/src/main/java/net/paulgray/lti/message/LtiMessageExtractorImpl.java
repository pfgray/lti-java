package net.paulgray.lti.message;

import net.paulgray.lti.LtiVersion;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class LtiMessageExtractorImpl implements LtiMessageExtractor {

    @Override
    public LtiErrorable<LtiMessage> extractLtiMessage(HttpServletRequest req) {
        // we'll need to add a check here to determine the type/version of the launch
        // when there are additional mechanisms for launching.
        return extractLtiMessage(convertMapToEntries(req.getParameterMap()));
    }

    @Override
    public LtiErrorable<LtiMessage> extractLtiMessage(Collection<? extends Map.Entry<String, String>> parameters) {
        ParamExtractor e = new ParamExtractor(parameters);

        ToolConsumer consumer = ToolConsumer.fromParams(e);
        Context context = Context.fromParams(e);
        LaunchPresentation presentation = LaunchPresentation.fromParams(e);

        return
          LtiVersion.fromParams(e).combine(
          MessageType.fromParams(e),
          (version, type) -> {
              LtiLaunchContext launchContext =
                LtiLaunchContext.builder()
                  .consumer(consumer)
                  .presentation(presentation)
                  .consumer(consumer)
                  .version(version)
                  .messageType(type)
                  .build();

              // todo: Make this dynamic based on annotations? it needs to be extendable...
              if(type.equals(KnownMessageType.BasicLtiLaunchRequest)) {
                  return BasicLtiLaunchRequestMessage.fromLaunchContext(launchContext, e);
              } else if(type.equals(KnownMessageType.ContentItemSelectionRequest)) {
                  return ContentItemSelectionRequestMessage.fromLaunchContext(launchContext, e);
              } else if(type.equals(KnownMessageType.ContentItemSelection)) {
                  return ContentItemSelectionMessage.fromLaunchContext(launchContext, e);
              } else if(type.equals(KnownMessageType.DashboardRequest)) {
                  return DashboardRequestMessage.fromLaunchContext(launchContext, e);
              } else {
                  return ExtensionMessage.fromLaunchContext(launchContext, e);
              }
          });
    }

    // lol java
    private List<Map.Entry<String, String>> convertMapToEntries(Map<String, String[]> params) {
        return params.entrySet().stream().<Map.Entry<String, String>>flatMap(entry ->
          Arrays.stream(entry.getValue())
            .map(value -> new AbstractMap.SimpleEntry<>(entry.getKey(), value))
        ).collect(Collectors.toList());
    }

}
