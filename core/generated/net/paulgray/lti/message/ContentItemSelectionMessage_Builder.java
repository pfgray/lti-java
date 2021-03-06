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
import net.paulgray.lti.contentitem.ContentItemSelection;

/**
 * Auto-generated superclass of {@link ContentItemSelectionMessage.Builder}, derived from the API of
 * {@link ContentItemSelectionMessage}.
 */
@Generated("org.inferred.freebuilder.processor.CodeGenerator")
abstract class ContentItemSelectionMessage_Builder {

  /** Creates a new builder using {@code value} as a template. */
  public static ContentItemSelectionMessage.Builder from(ContentItemSelectionMessage value) {
    return ContentItemSelectionMessage.builder().mergeFrom(value);
  }

  private enum Property {
    VERSION("version"),
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
  private Object contentItems = null;
  private final EnumSet<ContentItemSelectionMessage_Builder.Property> _unsetProperties =
      EnumSet.allOf(ContentItemSelectionMessage_Builder.Property.class);

  /**
   * Sets the value to be returned by {@link ContentItemSelectionMessage#version()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code version} is null
   */
  public ContentItemSelectionMessage.Builder version(LtiVersion version) {
    this.version = Objects.requireNonNull(version);
    _unsetProperties.remove(ContentItemSelectionMessage_Builder.Property.VERSION);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Replaces the value to be returned by {@link ContentItemSelectionMessage#version()} by applying
   * {@code mapper} to it and using the result.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null or returns null
   * @throws IllegalStateException if the field has not been set
   */
  public ContentItemSelectionMessage.Builder mapVersion(UnaryOperator<LtiVersion> mapper) {
    Objects.requireNonNull(mapper);
    return version(mapper.apply(version()));
  }

  /**
   * Returns the value that will be returned by {@link ContentItemSelectionMessage#version()}.
   *
   * @throws IllegalStateException if the field has not been set
   */
  public LtiVersion version() {
    if (_unsetProperties.contains(ContentItemSelectionMessage_Builder.Property.VERSION)) {
      throw new IllegalStateException("version not set");
    }
    return version;
  }

  /**
   * Sets the value to be returned by {@link ContentItemSelectionMessage#type()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code type} is null
   */
  public ContentItemSelectionMessage.Builder type(MessageType type) {
    this.type = Objects.requireNonNull(type);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Replaces the value to be returned by {@link ContentItemSelectionMessage#type()} by applying
   * {@code mapper} to it and using the result.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null or returns null
   */
  public ContentItemSelectionMessage.Builder mapType(UnaryOperator<MessageType> mapper) {
    return type(mapper.apply(type()));
  }

  /** Returns the value that will be returned by {@link ContentItemSelectionMessage#type()}. */
  public MessageType type() {
    return type;
  }

  /**
   * Associates {@code key} with {@code value} in the map to be returned from {@link
   * ContentItemSelectionMessage#customParameters()}. If the map previously contained a mapping for
   * the key, the old value is replaced by the specified value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if either {@code key} or {@code value} are null
   */
  public ContentItemSelectionMessage.Builder putCustomParameters(String key, String value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    customParameters.put(key, value);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Copies all of the mappings from {@code map} to the map to be returned from {@link
   * ContentItemSelectionMessage#customParameters()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code map} is null or contains a null key or value
   */
  public ContentItemSelectionMessage.Builder putAllCustomParameters(
      Map<? extends String, ? extends String> map) {
    for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
      putCustomParameters(entry.getKey(), entry.getValue());
    }
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Removes the mapping for {@code key} from the map to be returned from {@link
   * ContentItemSelectionMessage#customParameters()}, if one is present.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code key} is null
   */
  public ContentItemSelectionMessage.Builder removeCustomParameters(String key) {
    Objects.requireNonNull(key);
    customParameters.remove(key);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Invokes {@code mutator} with the map to be returned from {@link
   * ContentItemSelectionMessage#customParameters()}.
   *
   * <p>This method mutates the map in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored. Take care not to call pure functions, like {@link
   * Collection#stream()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public ContentItemSelectionMessage.Builder mutateCustomParameters(
      Consumer<? super Map<String, String>> mutator) {
    // If putCustomParameters is overridden, this method will be updated to delegate to it
    mutator.accept(customParameters);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Removes all of the mappings from the map to be returned from {@link
   * ContentItemSelectionMessage#customParameters()}.
   *
   * @return this {@code Builder} object
   */
  public ContentItemSelectionMessage.Builder clearCustomParameters() {
    customParameters.clear();
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Returns an unmodifiable view of the map that will be returned by {@link
   * ContentItemSelectionMessage#customParameters()}. Changes to this builder will be reflected in
   * the view.
   */
  public Map<String, String> customParameters() {
    return Collections.unmodifiableMap(customParameters);
  }

  /**
   * Associates {@code key} with {@code value} in the map to be returned from {@link
   * ContentItemSelectionMessage#extensionParameters()}. If the map previously contained a mapping
   * for the key, the old value is replaced by the specified value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if either {@code key} or {@code value} are null
   */
  public ContentItemSelectionMessage.Builder putExtensionParameters(String key, String value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    extensionParameters.put(key, value);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Copies all of the mappings from {@code map} to the map to be returned from {@link
   * ContentItemSelectionMessage#extensionParameters()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code map} is null or contains a null key or value
   */
  public ContentItemSelectionMessage.Builder putAllExtensionParameters(
      Map<? extends String, ? extends String> map) {
    for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
      putExtensionParameters(entry.getKey(), entry.getValue());
    }
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Removes the mapping for {@code key} from the map to be returned from {@link
   * ContentItemSelectionMessage#extensionParameters()}, if one is present.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code key} is null
   */
  public ContentItemSelectionMessage.Builder removeExtensionParameters(String key) {
    Objects.requireNonNull(key);
    extensionParameters.remove(key);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Invokes {@code mutator} with the map to be returned from {@link
   * ContentItemSelectionMessage#extensionParameters()}.
   *
   * <p>This method mutates the map in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored. Take care not to call pure functions, like {@link
   * Collection#stream()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public ContentItemSelectionMessage.Builder mutateExtensionParameters(
      Consumer<? super Map<String, String>> mutator) {
    // If putExtensionParameters is overridden, this method will be updated to delegate to it
    mutator.accept(extensionParameters);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Removes all of the mappings from the map to be returned from {@link
   * ContentItemSelectionMessage#extensionParameters()}.
   *
   * @return this {@code Builder} object
   */
  public ContentItemSelectionMessage.Builder clearExtensionParameters() {
    extensionParameters.clear();
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Returns an unmodifiable view of the map that will be returned by {@link
   * ContentItemSelectionMessage#extensionParameters()}. Changes to this builder will be reflected
   * in the view.
   */
  public Map<String, String> extensionParameters() {
    return Collections.unmodifiableMap(extensionParameters);
  }

  /**
   * Sets the value to be returned by {@link ContentItemSelectionMessage#contentItems()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code contentItems} is null
   */
  public ContentItemSelectionMessage.Builder contentItems(ContentItemSelection contentItems) {
    Objects.requireNonNull(contentItems);
    if (this.contentItems == null || this.contentItems instanceof ContentItemSelection) {
      this.contentItems = contentItems;
    } else {
      ContentItemSelection.Builder builder = (ContentItemSelection.Builder) this.contentItems;
      builder.clear();
      builder.mergeFrom(contentItems);
    }
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Sets the value to be returned by {@link ContentItemSelectionMessage#contentItems()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code builder} is null
   */
  public ContentItemSelectionMessage.Builder contentItems(ContentItemSelection.Builder builder) {
    return contentItems(builder.build());
  }

  /**
   * Applies {@code mutator} to the builder for the value that will be returned by {@link
   * ContentItemSelectionMessage#contentItems()}.
   *
   * <p>This method mutates the builder in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public ContentItemSelectionMessage.Builder mutateContentItems(
      Consumer<ContentItemSelection.Builder> mutator) {
    mutator.accept(contentItemsBuilder());
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Returns a builder for the value that will be returned by {@link
   * ContentItemSelectionMessage#contentItems()}.
   */
  public ContentItemSelection.Builder contentItemsBuilder() {
    if (contentItems == null) {
      contentItems = ContentItemSelection.builder();
    } else if (contentItems instanceof ContentItemSelection) {
      ContentItemSelection value = (ContentItemSelection) contentItems;
      contentItems = value.toBuilder();
    }
    ContentItemSelection.Builder builder = (ContentItemSelection.Builder) contentItems;
    return builder;
  }

  /** Sets all property values using the given {@code ContentItemSelectionMessage} as a template. */
  public ContentItemSelectionMessage.Builder mergeFrom(ContentItemSelectionMessage value) {
    ContentItemSelectionMessage_Builder _defaults = ContentItemSelectionMessage.builder();
    if (_defaults._unsetProperties.contains(ContentItemSelectionMessage_Builder.Property.VERSION)
        || !Objects.equals(value.version(), _defaults.version())) {
      version(value.version());
    }
    if (!Objects.equals(value.type(), _defaults.type())) {
      type(value.type());
    }
    putAllCustomParameters(value.customParameters());
    putAllExtensionParameters(value.extensionParameters());
    if (contentItems == null) {
      contentItems = value.contentItems();
    } else {
      contentItemsBuilder().mergeFrom(value.contentItems());
    }
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Copies values from the given {@code Builder}. Does not affect any properties not set on the
   * input.
   */
  public ContentItemSelectionMessage.Builder mergeFrom(
      ContentItemSelectionMessage.Builder template) {
    // Upcast to access private fields; otherwise, oddly, we get an access violation.
    ContentItemSelectionMessage_Builder base = template;
    ContentItemSelectionMessage_Builder _defaults = ContentItemSelectionMessage.builder();
    if (!base._unsetProperties.contains(ContentItemSelectionMessage_Builder.Property.VERSION)
        && (_defaults._unsetProperties.contains(
                ContentItemSelectionMessage_Builder.Property.VERSION)
            || !Objects.equals(template.version(), _defaults.version()))) {
      version(template.version());
    }
    if (!Objects.equals(template.type(), _defaults.type())) {
      type(template.type());
    }
    putAllCustomParameters(base.customParameters);
    putAllExtensionParameters(base.extensionParameters);
    if (base.contentItems == null) {
      // Nothing to merge
    } else if (base.contentItems instanceof ContentItemSelection) {
      ContentItemSelection contentItemsValue = (ContentItemSelection) base.contentItems;
      if (contentItems == null) {
        contentItems = contentItemsValue;
      } else {
        contentItemsBuilder().mergeFrom(contentItemsValue);
      }
    } else {
      contentItemsBuilder().mergeFrom(base.contentItemsBuilder());
    }
    return (ContentItemSelectionMessage.Builder) this;
  }

  /** Resets the state of this builder. */
  public ContentItemSelectionMessage.Builder clear() {
    ContentItemSelectionMessage_Builder _defaults = ContentItemSelectionMessage.builder();
    version = _defaults.version;
    type = _defaults.type;
    customParameters.clear();
    extensionParameters.clear();
    if (contentItems == null || contentItems instanceof ContentItemSelection) {
      contentItems = null;
    } else {
      ContentItemSelection.Builder contentItemsBuilder =
          (ContentItemSelection.Builder) contentItems;
      contentItemsBuilder.clear();
    }
    _unsetProperties.clear();
    _unsetProperties.addAll(_defaults._unsetProperties);
    return (ContentItemSelectionMessage.Builder) this;
  }

  /**
   * Returns a newly-created {@link ContentItemSelectionMessage} based on the contents of the {@code
   * Builder}.
   *
   * @throws IllegalStateException if any field has not been set
   */
  public ContentItemSelectionMessage build() {
    if (!_unsetProperties.isEmpty()) {
      throw new IllegalStateException("Not set: " + _unsetProperties);
    }
    return new ContentItemSelectionMessage_Builder.Value(this);
  }

  /**
   * Returns a newly-created partial {@link ContentItemSelectionMessage} for use in unit tests.
   * State checking will not be performed. Unset properties will throw an {@link
   * UnsupportedOperationException} when accessed via the partial object.
   *
   * <p>Partials should only ever be used in tests. They permit writing robust test cases that won't
   * fail if this type gains more application-level constraints (e.g. new required fields) in
   * future. If you require partially complete values in production code, consider using a Builder.
   */
  public ContentItemSelectionMessage buildPartial() {
    return new ContentItemSelectionMessage_Builder.Partial(this);
  }

  private static final class Value implements ContentItemSelectionMessage {
    private final LtiVersion version;
    private final MessageType type;
    private final Map<String, String> customParameters;
    private final Map<String, String> extensionParameters;
    private final ContentItemSelection contentItems;

    private Value(ContentItemSelectionMessage_Builder builder) {
      this.version = builder.version;
      this.type = builder.type;
      this.customParameters = immutableMap(builder.customParameters);
      this.extensionParameters = immutableMap(builder.extensionParameters);
      if (builder.contentItems == null) {
        this.contentItems = ContentItemSelection.builder().build();
      } else if (builder.contentItems instanceof ContentItemSelection) {
        this.contentItems = (ContentItemSelection) builder.contentItems;
      } else {
        ContentItemSelection.Builder contentItemsBuilder =
            (ContentItemSelection.Builder) builder.contentItems;
        this.contentItems = contentItemsBuilder.build();
      }
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
    public ContentItemSelection contentItems() {
      return contentItems;
    }

    @Override
    public ContentItemSelectionMessage.Builder toBuilder() {
      return ContentItemSelectionMessage.builder().mergeFrom(this);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ContentItemSelectionMessage_Builder.Value)) {
        return false;
      }
      ContentItemSelectionMessage_Builder.Value other =
          (ContentItemSelectionMessage_Builder.Value) obj;
      return Objects.equals(version, other.version)
          && Objects.equals(type, other.type)
          && Objects.equals(customParameters, other.customParameters)
          && Objects.equals(extensionParameters, other.extensionParameters)
          && Objects.equals(contentItems, other.contentItems);
    }

    @Override
    public int hashCode() {
      return Objects.hash(version, type, customParameters, extensionParameters, contentItems);
    }

    @Override
    public String toString() {
      return "ContentItemSelectionMessage{"
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
          + ", "
          + "contentItems="
          + contentItems
          + "}";
    }
  }

  private static final class Partial implements ContentItemSelectionMessage {
    private final LtiVersion version;
    private final MessageType type;
    private final Map<String, String> customParameters;
    private final Map<String, String> extensionParameters;
    private final ContentItemSelection contentItems;
    private final EnumSet<ContentItemSelectionMessage_Builder.Property> _unsetProperties;

    Partial(ContentItemSelectionMessage_Builder builder) {
      this.version = builder.version;
      this.type = builder.type;
      this.customParameters = immutableMap(builder.customParameters);
      this.extensionParameters = immutableMap(builder.extensionParameters);
      if (builder.contentItems == null) {
        this.contentItems = ContentItemSelection.builder().buildPartial();
      } else if (builder.contentItems instanceof ContentItemSelection) {
        this.contentItems = (ContentItemSelection) builder.contentItems;
      } else {
        ContentItemSelection.Builder contentItemsBuilder =
            (ContentItemSelection.Builder) builder.contentItems;
        this.contentItems = contentItemsBuilder.buildPartial();
      }
      this._unsetProperties = builder._unsetProperties.clone();
    }

    @Override
    public LtiVersion version() {
      if (_unsetProperties.contains(ContentItemSelectionMessage_Builder.Property.VERSION)) {
        throw new UnsupportedOperationException("version not set");
      }
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
    public ContentItemSelection contentItems() {
      return contentItems;
    }

    private static class PartialBuilder extends ContentItemSelectionMessage.Builder {
      @Override
      public ContentItemSelectionMessage build() {
        return buildPartial();
      }
    }

    @Override
    public ContentItemSelectionMessage.Builder toBuilder() {
      ContentItemSelectionMessage.Builder builder = new PartialBuilder();
      if (!_unsetProperties.contains(ContentItemSelectionMessage_Builder.Property.VERSION)) {
        builder.version(version);
      }
      builder.type(type);
      builder.putAllCustomParameters(customParameters);
      builder.putAllExtensionParameters(extensionParameters);
      builder.contentItemsBuilder().mergeFrom(contentItems.toBuilder());
      return builder;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ContentItemSelectionMessage_Builder.Partial)) {
        return false;
      }
      ContentItemSelectionMessage_Builder.Partial other =
          (ContentItemSelectionMessage_Builder.Partial) obj;
      return Objects.equals(version, other.version)
          && Objects.equals(type, other.type)
          && Objects.equals(customParameters, other.customParameters)
          && Objects.equals(extensionParameters, other.extensionParameters)
          && Objects.equals(contentItems, other.contentItems)
          && Objects.equals(_unsetProperties, other._unsetProperties);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          version, type, customParameters, extensionParameters, contentItems, _unsetProperties);
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("partial ContentItemSelectionMessage{");
      if (!_unsetProperties.contains(ContentItemSelectionMessage_Builder.Property.VERSION)) {
        result.append("version=").append(version);
        result.append(", ");
      }
      result.append("type=").append(type);
      result.append(", ");
      result.append("customParameters=").append(customParameters);
      result.append(", ");
      result.append("extensionParameters=").append(extensionParameters);
      result.append(", ");
      result.append("contentItems=").append(contentItems);
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
