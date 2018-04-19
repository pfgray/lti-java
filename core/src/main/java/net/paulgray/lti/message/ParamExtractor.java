package net.paulgray.lti.message;

import net.paulgray.lti.message.error.LtiError;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParamExtractor {

    private Collection<? extends Map.Entry<String, String>> params;

    public ParamExtractor(Collection<? extends Map.Entry<String, String>> params) {
        this.params = params;
    }

    public Optional<String> getFirst(String name) {
        return this.params.stream()
          .filter(e -> e.getKey().equalsIgnoreCase(name))
          .map(Map.Entry::getValue)
          .findFirst();
    }

    public LtiErrorable<String> getFirst(String name, LtiError orError) {
        return getFirst(name)
          .map(LtiErrorable::success)
          .orElseGet(() -> LtiErrorable.error(orError));
    }

    Map<String, String> getParamsWithPrefix(String prefix) {
        return this.params.stream()
          .filter(e -> e.getKey().startsWith(prefix))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
