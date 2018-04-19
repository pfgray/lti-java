package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemTypeResolver extends TypeIdResolverBase implements TypeIdResolver {

    private JavaType baseType;

    private Map<String, Class<?>> MAPPINGS = new HashMap<>();

    @Override
    public void init(JavaType baseType) {
        MAPPINGS.put("ContentItem", ContentItem.class);
        MAPPINGS.put("LtiLinkItem", LtiLinkItem.class);
        MAPPINGS.put("FileItem", FileItem.class);
        this.baseType = baseType;
    }

    @Override
    public String idFromValue(Object value) {
        return idFromValueAndType(value, value.getClass());
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> suggestedType) {

        Optional<Map.Entry<String, Class<?>>> matchedClass = MAPPINGS.entrySet()
          .stream()
          .filter(e ->  e.getValue().isAssignableFrom(suggestedType))
          .findFirst();

        return matchedClass.map(Map.Entry::getKey)
          .orElseThrow(() -> new IllegalStateException(suggestedType + " is not supported."));
    }

    @Override
    public String idFromBaseType() {
        return idFromValueAndType(null, baseType.getRawClass());
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        JavaType ttpye = Optional.ofNullable(MAPPINGS.get(id))
          .map(clazz -> TypeFactory.defaultInstance().constructType(clazz))
          .orElseThrow(() -> new IllegalStateException("cannot find class '" + id + "'"));
        return ttpye;
    }

    @Override
    public String getDescForKnownTypeIds() {
        return String.format("Known type ids for {0} are: {1}, {2}, {3}", ItemTypeResolver.class, "ContentItem", "FileItem", "LtiLinkItem");
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}
