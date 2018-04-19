// Autogenerated code. Do not modify.
package net.paulgray.lti.message;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import javax.annotation.Generated;
import net.paulgray.lti.LtiVersion;

/**
 * Auto-generated superclass of {@link ExtensionMessage.Builder}, derived from the API of {@link
 * ExtensionMessage}.
 */
@Generated("org.inferred.freebuilder.processor.CodeGenerator")
abstract class ExtensionMessage_Builder {

  /** Creates a new builder using {@code value} as a template. */
  public static ExtensionMessage.Builder from(ExtensionMessage value) {
    return ExtensionMessage.builder().mergeFrom(value);
  }

  private enum Property {
    VERSION("version"),
    TYPE("type"),
    ;

    private final String name;

    private Property(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  private LtiVersion version;
  private MessageType type;
  private final LinkedHashMap<String, String> customParameters = new LinkedHashMap<>();
  private final LinkedHashMap<String, String> extensionParameters = new LinkedHashMap<>();
  private final EnumSet<ExtensionMessage_Builder.Property> _unsetProperties =
      EnumSet.allOf(ExtensionMessage_Builder.Property.class);

  /**
   * Sets the value to be returned by {@link ExtensionMessage#version()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code version} is null
   */
  public ExtensionMessage.Builder version(LtiVersion version) {
    this.version = Objects.requireNonNull(version);
    _unsetProperties.remove(ExtensionMessage_Builder.Property.VERSION);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Replaces the value to be returned by {@link ExtensionMessage#version()} by applying {@code
   * mapper} to it and using the result.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null or returns null
   * @throws IllegalStateException if the field has not been set
   */
  public ExtensionMessage.Builder mapVersion(UnaryOperator<LtiVersion> mapper) {
    Objects.requireNonNull(mapper);
    return version(mapper.apply(version()));
  }

  /**
   * Returns the value that will be returned by {@link ExtensionMessage#version()}.
   *
   * @throws IllegalStateException if the field has not been set
   */
  public LtiVersion version() {
    if (_unsetProperties.contains(ExtensionMessage_Builder.Property.VERSION)) {
      throw new IllegalStateException("version not set");
    }
    return version;
  }

  /**
   * Sets the value to be returned by {@link ExtensionMessage#type()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code type} is null
   */
  public ExtensionMessage.Builder type(MessageType type) {
    this.type = Objects.requireNonNull(type);
    _unsetProperties.remove(ExtensionMessage_Builder.Property.TYPE);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Replaces the value to be returned by {@link ExtensionMessage#type()} by applying {@code mapper}
   * to it and using the result.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null or returns null
   * @throws IllegalStateException if the field has not been set
   */
  public ExtensionMessage.Builder mapType(UnaryOperator<MessageType> mapper) {
    Objects.requireNonNull(mapper);
    return type(mapper.apply(type()));
  }

  /**
   * Returns the value that will be returned by {@link ExtensionMessage#type()}.
   *
   * @throws IllegalStateException if the field has not been set
   */
  public MessageType type() {
    if (_unsetProperties.contains(ExtensionMessage_Builder.Property.TYPE)) {
      throw new IllegalStateException("type not set");
    }
    return type;
  }

  /**
   * Associates {@code key} with {@code value} in the map to be returned from {@link
   * ExtensionMessage#customParameters()}. If the map previously contained a mapping for the key,
   * the old value is replaced by the specified value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if either {@code key} or {@code value} are null
   */
  public ExtensionMessage.Builder putCustomParameters(String key, String value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    customParameters.put(key, value);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Copies all of the mappings from {@code map} to the map to be returned from {@link
   * ExtensionMessage#customParameters()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code map} is null or contains a null key or value
   */
  public ExtensionMessage.Builder putAllCustomParameters(
      Map<? extends String, ? extends String> map) {
    for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
      putCustomParameters(entry.getKey(), entry.getValue());
    }
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Removes the mapping for {@code key} from the map to be returned from {@link
   * ExtensionMessage#customParameters()}, if one is present.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code key} is null
   */
  public ExtensionMessage.Builder removeCustomParameters(String key) {
    Objects.requireNonNull(key);
    customParameters.remove(key);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Invokes {@code mutator} with the map to be returned from {@link
   * ExtensionMessage#customParameters()}.
   *
   * <p>This method mutates the map in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored. Take care not to call pure functions, like {@link
   * Collection#stream()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public ExtensionMessage.Builder mutateCustomParameters(
      Consumer<? super Map<String, String>> mutator) {
    // If putCustomParameters is overridden, this method will be updated to delegate to it
    mutator.accept(customParameters);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Removes all of the mappings from the map to be returned from {@link
   * ExtensionMessage#customParameters()}.
   *
   * @return this {@code Builder} object
   */
  public ExtensionMessage.Builder clearCustomParameters() {
    customParameters.clear();
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Returns an unmodifiable view of the map that will be returned by {@link
   * ExtensionMessage#customParameters()}. Changes to this builder will be reflected in the view.
   */
  public Map<String, String> customParameters() {
    return Collections.unmodifiableMap(customParameters);
  }

  /**
   * Associates {@code key} with {@code value} in the map to be returned from {@link
   * ExtensionMessage#extensionParameters()}. If the map previously contained a mapping for the key,
   * the old value is replaced by the specified value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if either {@code key} or {@code value} are null
   */
  public ExtensionMessage.Builder putExtensionParameters(String key, String value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    extensionParameters.put(key, value);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Copies all of the mappings from {@code map} to the map to be returned from {@link
   * ExtensionMessage#extensionParameters()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code map} is null or contains a null key or value
   */
  public ExtensionMessage.Builder putAllExtensionParameters(
      Map<? extends String, ? extends String> map) {
    for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
      putExtensionParameters(entry.getKey(), entry.getValue());
    }
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Removes the mapping for {@code key} from the map to be returned from {@link
   * ExtensionMessage#extensionParameters()}, if one is present.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code key} is null
   */
  public ExtensionMessage.Builder removeExtensionParameters(String key) {
    Objects.requireNonNull(key);
    extensionParameters.remove(key);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Invokes {@code mutator} with the map to be returned from {@link
   * ExtensionMessage#extensionParameters()}.
   *
   * <p>This method mutates the map in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored. Take care not to call pure functions, like {@link
   * Collection#stream()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public ExtensionMessage.Builder mutateExtensionParameters(
      Consumer<? super Map<String, String>> mutator) {
    // If putExtensionParameters is overridden, this method will be updated to delegate to it
    mutator.accept(extensionParameters);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Removes all of the mappings from the map to be returned from {@link
   * ExtensionMessage#extensionParameters()}.
   *
   * @return this {@code Builder} object
   */
  public ExtensionMessage.Builder clearExtensionParameters() {
    extensionParameters.clear();
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Returns an unmodifiable view of the map that will be returned by {@link
   * ExtensionMessage#extensionParameters()}. Changes to this builder will be reflected in the view.
   */
  public Map<String, String> extensionParameters() {
    return Collections.unmodifiableMap(extensionParameters);
  }

  /** Sets all property values using the given {@code ExtensionMessage} as a template. */
  public ExtensionMessage.Builder mergeFrom(ExtensionMessage value) {
    ExtensionMessage_Builder _defaults = ExtensionMessage.builder();
    if (_defaults._unsetProperties.contains(ExtensionMessage_Builder.Property.VERSION)
        || !Objects.equals(value.version(), _defaults.version())) {
      version(value.version());
    }
    if (_defaults._unsetProperties.contains(ExtensionMessage_Builder.Property.TYPE)
        || !Objects.equals(value.type(), _defaults.type())) {
      type(value.type());
    }
    putAllCustomParameters(value.customParameters());
    putAllExtensionParameters(value.extensionParameters());
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Copies values from the given {@code Builder}. Does not affect any properties not set on the
   * input.
   */
  public ExtensionMessage.Builder mergeFrom(ExtensionMessage.Builder template) {
    // Upcast to access private fields; otherwise, oddly, we get an access violation.
    ExtensionMessage_Builder base = template;
    ExtensionMessage_Builder _defaults = ExtensionMessage.builder();
    if (!base._unsetProperties.contains(ExtensionMessage_Builder.Property.VERSION)
        && (_defaults._unsetProperties.contains(ExtensionMessage_Builder.Property.VERSION)
            || !Objects.equals(template.version(), _defaults.version()))) {
      version(template.version());
    }
    if (!base._unsetProperties.contains(ExtensionMessage_Builder.Property.TYPE)
        && (_defaults._unsetProperties.contains(ExtensionMessage_Builder.Property.TYPE)
            || !Objects.equals(template.type(), _defaults.type()))) {
      type(template.type());
    }
    putAllCustomParameters(base.customParameters);
    putAllExtensionParameters(base.extensionParameters);
    return (ExtensionMessage.Builder) this;
  }

  /** Resets the state of this builder. */
  public ExtensionMessage.Builder clear() {
    ExtensionMessage_Builder _defaults = ExtensionMessage.builder();
    version = _defaults.version;
    type = _defaults.type;
    customParameters.clear();
    extensionParameters.clear();
    _unsetProperties.clear();
    _unsetProperties.addAll(_defaults._unsetProperties);
    return (ExtensionMessage.Builder) this;
  }

  /**
   * Returns a newly-created {@link ExtensionMessage} based on the contents of the {@code Builder}.
   *
   * @throws IllegalStateException if any field has not been set
   */
  public ExtensionMessage build() {
    if (!_unsetProperties.isEmpty()) {
      throw new IllegalStateException("Not set: " + _unsetProperties);
    }
    return new ExtensionMessage_Builder.Value(this);
  }

  /**
   * Returns a newly-created partial {@link ExtensionMessage} for use in unit tests. State checking
   * will not be performed. Unset properties will throw an {@link UnsupportedOperationException}
   * when accessed via the partial object.
   *
   * <p>Partials should only ever be used in tests. They permit writing robust test cases that won't
   * fail if this type gains more application-level constraints (e.g. new required fields) in
   * future. If you require partially complete values in production code, consider using a Builder.
   */
  public ExtensionMessage buildPartial() {
    return new ExtensionMessage_Builder.Partial(this);
  }

  private static final class Value implements ExtensionMessage {
    private final LtiVersion version;
    private final MessageType type;
    private final Map<String, String> customParameters;
    private final Map<String, String> extensionParameters;

    private Value(ExtensionMessage_Builder builder) {
      this.version = builder.version;
      this.type = builder.type;
      this.customParameters = immutableMap(builder.customParameters);
      this.extensionParameters = immutableMap(builder.extensionParameters);
    }

    @Override
    public LtiVersion version() {
      return version;
    }

    @Override
    public MessageType type() {
      return type;
    }

    @Override
    public Map<String, String> customParameters() {
      return customParameters;
    }

    @Override
    public Map<String, String> extensionParameters() {
      return extensionParameters;
    }

    @Override
    public ExtensionMessage.Builder toBuilder() {
      return ExtensionMessage.builder().mergeFrom(this);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ExtensionMessage_Builder.Value)) {
        return false;
      }
      ExtensionMessage_Builder.Value other = (ExtensionMessage_Builder.Value) obj;
      return Objects.equals(version, other.version)
          && Objects.equals(type, other.type)
          && Objects.equals(customParameters, other.customParameters)
          && Objects.equals(extensionParameters, other.extensionParameters);
    }

    @Override
    public int hashCode() {
      return Objects.hash(version, type, customParameters, extensionParameters);
    }

    @Override
    public String toString() {
      return "ExtensionMessage{"
          + "version="
          + version
          + ", "
          + "type="
          + type
          + ", "
          + "customParameters="
          + customParameters
          + ", "
          + "extensionParameters="
          + extensionParameters
          + "}";
    }
  }

  private static final class Partial implements ExtensionMessage {
    private final LtiVersion version;
    private final MessageType type;
    private final Map<String, String> customParameters;
    private final Map<String, String> extensionParameters;
    private final EnumSet<ExtensionMessage_Builder.Property> _unsetProperties;

    Partial(ExtensionMessage_Builder builder) {
      this.version = builder.version;
      this.type = builder.type;
      this.customParameters = immutableMap(builder.customParameters);
      this.extensionParameters = immutableMap(builder.extensionParameters);
      this._unsetProperties = builder._unsetProperties.clone();
    }

    @Override
    public LtiVersion version() {
      if (_unsetProperties.contains(ExtensionMessage_Builder.Property.VERSION)) {
        throw new UnsupportedOperationException("version not set");
      }
      return version;
    }

    @Override
    public MessageType type() {
      if (_unsetProperties.contains(ExtensionMessage_Builder.Property.TYPE)) {
        throw new UnsupportedOperationException("type not set");
      }
      return type;
    }

    @Override
    public Map<String, String> customParameters() {
      return customParameters;
    }

    @Override
    public Map<String, String> extensionParameters() {
      return extensionParameters;
    }

    private static class PartialBuilder extends ExtensionMessage.Builder {
      @Override
      public ExtensionMessage build() {
        return buildPartial();
      }
    }

    @Override
    public ExtensionMessage.Builder toBuilder() {
      ExtensionMessage.Builder builder = new PartialBuilder();
      if (!_unsetProperties.contains(ExtensionMessage_Builder.Property.VERSION)) {
        builder.version(version);
      }
      if (!_unsetProperties.contains(ExtensionMessage_Builder.Property.TYPE)) {
        builder.type(type);
      }
      builder.putAllCustomParameters(customParameters);
      builder.putAllExtensionParameters(extensionParameters);
      return builder;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ExtensionMessage_Builder.Partial)) {
        return false;
      }
      ExtensionMessage_Builder.Partial other = (ExtensionMessage_Builder.Partial) obj;
      return Objects.equals(version, other.version)
          && Objects.equals(type, other.type)
          && Objects.equals(customParameters, other.customParameters)
          && Objects.equals(extensionParameters, other.extensionParameters)
          && Objects.equals(_unsetProperties, other._unsetProperties);
    }

    @Override
    public int hashCode() {
      return Objects.hash(version, type, customParameters, extensionParameters, _unsetProperties);
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("partial ExtensionMessage{");
      if (!_unsetProperties.contains(ExtensionMessage_Builder.Property.VERSION)) {
        result.append("version=").append(version);
        result.append(", ");
      }
      if (!_unsetProperties.contains(ExtensionMessage_Builder.Property.TYPE)) {
        result.append("type=").append(type);
        result.append(", ");
      }
      result.append("customParameters=").append(customParameters);
      result.append(", ");
      result.append("extensionParameters=").append(extensionParameters);
      result.append("}");
      return result.toString();
    }
  }

  private static <K, V> Map<K, V> immutableMap(Map<K, V> entries) {
    switch (entries.size()) {
      case 0:
        return Collections.emptyMap();
      case 1:
        Map.Entry<K, V> entry = entries.entrySet().iterator().next();
        return Collections.singletonMap(entry.getKey(), entry.getValue());
      default:
        return Collections.unmodifiableMap(new LinkedHashMap<>(entries));
    }
  }
}