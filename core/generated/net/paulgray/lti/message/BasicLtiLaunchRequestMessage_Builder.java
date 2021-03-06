// Autogenerated code. Do not modify.
package net.paulgray.lti.message;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import net.paulgray.lti.LtiVersion;

/**
 * Auto-generated superclass of {@link BasicLtiLaunchRequestMessage.Builder}, derived from the API
 * of {@link BasicLtiLaunchRequestMessage}.
 */
@Generated("org.inferred.freebuilder.processor.CodeGenerator")
abstract class BasicLtiLaunchRequestMessage_Builder {

  /** Creates a new builder using {@code value} as a template. */
  public static BasicLtiLaunchRequestMessage.Builder from(BasicLtiLaunchRequestMessage value) {
    return BasicLtiLaunchRequestMessage.builder().mergeFrom(value);
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
  private Object user = null;
  // Store a nullable object instead of an Optional. Escape analysis then
  // allows the JVM to optimize away the Optional objects created by and
  // passed to our API.
  private ToolConsumer toolConsumer = null;
  // Store a nullable object instead of an Optional. Escape analysis then
  // allows the JVM to optimize away the Optional objects created by and
  // passed to our API.
  private Context context = null;
  // Store a nullable object instead of an Optional. Escape analysis then
  // allows the JVM to optimize away the Optional objects created by and
  // passed to our API.
  private LaunchPresentation launchPresentation = null;
  private final EnumSet<BasicLtiLaunchRequestMessage_Builder.Property> _unsetProperties =
      EnumSet.allOf(BasicLtiLaunchRequestMessage_Builder.Property.class);

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#version()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code version} is null
   */
  public BasicLtiLaunchRequestMessage.Builder version(LtiVersion version) {
    this.version = Objects.requireNonNull(version);
    _unsetProperties.remove(BasicLtiLaunchRequestMessage_Builder.Property.VERSION);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Replaces the value to be returned by {@link BasicLtiLaunchRequestMessage#version()} by applying
   * {@code mapper} to it and using the result.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null or returns null
   * @throws IllegalStateException if the field has not been set
   */
  public BasicLtiLaunchRequestMessage.Builder mapVersion(UnaryOperator<LtiVersion> mapper) {
    Objects.requireNonNull(mapper);
    return version(mapper.apply(version()));
  }

  /**
   * Returns the value that will be returned by {@link BasicLtiLaunchRequestMessage#version()}.
   *
   * @throws IllegalStateException if the field has not been set
   */
  public LtiVersion version() {
    if (_unsetProperties.contains(BasicLtiLaunchRequestMessage_Builder.Property.VERSION)) {
      throw new IllegalStateException("version not set");
    }
    return version;
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#type()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code type} is null
   */
  public BasicLtiLaunchRequestMessage.Builder type(MessageType type) {
    this.type = Objects.requireNonNull(type);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Replaces the value to be returned by {@link BasicLtiLaunchRequestMessage#type()} by applying
   * {@code mapper} to it and using the result.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null or returns null
   */
  public BasicLtiLaunchRequestMessage.Builder mapType(UnaryOperator<MessageType> mapper) {
    return type(mapper.apply(type()));
  }

  /** Returns the value that will be returned by {@link BasicLtiLaunchRequestMessage#type()}. */
  public MessageType type() {
    return type;
  }

  /**
   * Associates {@code key} with {@code value} in the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#customParameters()}. If the map previously contained a mapping for
   * the key, the old value is replaced by the specified value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if either {@code key} or {@code value} are null
   */
  public BasicLtiLaunchRequestMessage.Builder putCustomParameters(String key, String value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    customParameters.put(key, value);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Copies all of the mappings from {@code map} to the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#customParameters()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code map} is null or contains a null key or value
   */
  public BasicLtiLaunchRequestMessage.Builder putAllCustomParameters(
      Map<? extends String, ? extends String> map) {
    for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
      putCustomParameters(entry.getKey(), entry.getValue());
    }
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Removes the mapping for {@code key} from the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#customParameters()}, if one is present.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code key} is null
   */
  public BasicLtiLaunchRequestMessage.Builder removeCustomParameters(String key) {
    Objects.requireNonNull(key);
    customParameters.remove(key);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Invokes {@code mutator} with the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#customParameters()}.
   *
   * <p>This method mutates the map in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored. Take care not to call pure functions, like {@link
   * Collection#stream()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public BasicLtiLaunchRequestMessage.Builder mutateCustomParameters(
      Consumer<? super Map<String, String>> mutator) {
    // If putCustomParameters is overridden, this method will be updated to delegate to it
    mutator.accept(customParameters);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Removes all of the mappings from the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#customParameters()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder clearCustomParameters() {
    customParameters.clear();
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Returns an unmodifiable view of the map that will be returned by {@link
   * BasicLtiLaunchRequestMessage#customParameters()}. Changes to this builder will be reflected in
   * the view.
   */
  public Map<String, String> customParameters() {
    return Collections.unmodifiableMap(customParameters);
  }

  /**
   * Associates {@code key} with {@code value} in the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#extensionParameters()}. If the map previously contained a mapping
   * for the key, the old value is replaced by the specified value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if either {@code key} or {@code value} are null
   */
  public BasicLtiLaunchRequestMessage.Builder putExtensionParameters(String key, String value) {
    Objects.requireNonNull(key);
    Objects.requireNonNull(value);
    extensionParameters.put(key, value);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Copies all of the mappings from {@code map} to the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#extensionParameters()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code map} is null or contains a null key or value
   */
  public BasicLtiLaunchRequestMessage.Builder putAllExtensionParameters(
      Map<? extends String, ? extends String> map) {
    for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
      putExtensionParameters(entry.getKey(), entry.getValue());
    }
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Removes the mapping for {@code key} from the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#extensionParameters()}, if one is present.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code key} is null
   */
  public BasicLtiLaunchRequestMessage.Builder removeExtensionParameters(String key) {
    Objects.requireNonNull(key);
    extensionParameters.remove(key);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Invokes {@code mutator} with the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#extensionParameters()}.
   *
   * <p>This method mutates the map in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored. Take care not to call pure functions, like {@link
   * Collection#stream()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public BasicLtiLaunchRequestMessage.Builder mutateExtensionParameters(
      Consumer<? super Map<String, String>> mutator) {
    // If putExtensionParameters is overridden, this method will be updated to delegate to it
    mutator.accept(extensionParameters);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Removes all of the mappings from the map to be returned from {@link
   * BasicLtiLaunchRequestMessage#extensionParameters()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder clearExtensionParameters() {
    extensionParameters.clear();
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Returns an unmodifiable view of the map that will be returned by {@link
   * BasicLtiLaunchRequestMessage#extensionParameters()}. Changes to this builder will be reflected
   * in the view.
   */
  public Map<String, String> extensionParameters() {
    return Collections.unmodifiableMap(extensionParameters);
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#user()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code user} is null
   */
  public BasicLtiLaunchRequestMessage.Builder user(User user) {
    Objects.requireNonNull(user);
    if (this.user == null || this.user instanceof User) {
      this.user = user;
    } else {
      User.Builder builder = (User.Builder) this.user;
      builder.clear();
      builder.mergeFrom(user);
    }
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#user()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code builder} is null
   */
  public BasicLtiLaunchRequestMessage.Builder user(User.Builder builder) {
    return user(builder.build());
  }

  /**
   * Applies {@code mutator} to the builder for the value that will be returned by {@link
   * BasicLtiLaunchRequestMessage#user()}.
   *
   * <p>This method mutates the builder in-place. {@code mutator} is a void consumer, so any value
   * returned from a lambda will be ignored.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mutator} is null
   */
  public BasicLtiLaunchRequestMessage.Builder mutateUser(Consumer<User.Builder> mutator) {
    mutator.accept(userBuilder());
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Returns a builder for the value that will be returned by {@link
   * BasicLtiLaunchRequestMessage#user()}.
   */
  public User.Builder userBuilder() {
    if (user == null) {
      user = User.builder();
    } else if (user instanceof User) {
      User value = (User) user;
      user = value.toBuilder();
    }
    User.Builder builder = (User.Builder) user;
    return builder;
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#toolConsumer()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code toolConsumer} is null
   */
  public BasicLtiLaunchRequestMessage.Builder toolConsumer(ToolConsumer toolConsumer) {
    this.toolConsumer = Objects.requireNonNull(toolConsumer);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#toolConsumer()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder toolConsumer(
      Optional<? extends ToolConsumer> toolConsumer) {
    if (toolConsumer.isPresent()) {
      return toolConsumer(toolConsumer.get());
    } else {
      return clearToolConsumer();
    }
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#toolConsumer()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder nullableToolConsumer(
      @Nullable ToolConsumer toolConsumer) {
    if (toolConsumer != null) {
      return toolConsumer(toolConsumer);
    } else {
      return clearToolConsumer();
    }
  }

  /**
   * If the value to be returned by {@link BasicLtiLaunchRequestMessage#toolConsumer()} is present,
   * replaces it by applying {@code mapper} to it and using the result.
   *
   * <p>If the result is null, clears the value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null
   */
  public BasicLtiLaunchRequestMessage.Builder mapToolConsumer(UnaryOperator<ToolConsumer> mapper) {
    return toolConsumer(toolConsumer().map(mapper));
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#toolConsumer()} to {@link
   * Optional#empty() Optional.empty()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder clearToolConsumer() {
    toolConsumer = null;
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Returns the value that will be returned by {@link BasicLtiLaunchRequestMessage#toolConsumer()}.
   */
  public Optional<ToolConsumer> toolConsumer() {
    return Optional.ofNullable(toolConsumer);
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#context()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code context} is null
   */
  public BasicLtiLaunchRequestMessage.Builder context(Context context) {
    this.context = Objects.requireNonNull(context);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#context()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder context(Optional<? extends Context> context) {
    if (context.isPresent()) {
      return context(context.get());
    } else {
      return clearContext();
    }
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#context()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder nullableContext(@Nullable Context context) {
    if (context != null) {
      return context(context);
    } else {
      return clearContext();
    }
  }

  /**
   * If the value to be returned by {@link BasicLtiLaunchRequestMessage#context()} is present,
   * replaces it by applying {@code mapper} to it and using the result.
   *
   * <p>If the result is null, clears the value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null
   */
  public BasicLtiLaunchRequestMessage.Builder mapContext(UnaryOperator<Context> mapper) {
    return context(context().map(mapper));
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#context()} to {@link
   * Optional#empty() Optional.empty()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder clearContext() {
    context = null;
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /** Returns the value that will be returned by {@link BasicLtiLaunchRequestMessage#context()}. */
  public Optional<Context> context() {
    return Optional.ofNullable(context);
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#launchPresentation()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code launchPresentation} is null
   */
  public BasicLtiLaunchRequestMessage.Builder launchPresentation(
      LaunchPresentation launchPresentation) {
    this.launchPresentation = Objects.requireNonNull(launchPresentation);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#launchPresentation()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder launchPresentation(
      Optional<? extends LaunchPresentation> launchPresentation) {
    if (launchPresentation.isPresent()) {
      return launchPresentation(launchPresentation.get());
    } else {
      return clearLaunchPresentation();
    }
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#launchPresentation()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder nullableLaunchPresentation(
      @Nullable LaunchPresentation launchPresentation) {
    if (launchPresentation != null) {
      return launchPresentation(launchPresentation);
    } else {
      return clearLaunchPresentation();
    }
  }

  /**
   * If the value to be returned by {@link BasicLtiLaunchRequestMessage#launchPresentation()} is
   * present, replaces it by applying {@code mapper} to it and using the result.
   *
   * <p>If the result is null, clears the value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null
   */
  public BasicLtiLaunchRequestMessage.Builder mapLaunchPresentation(
      UnaryOperator<LaunchPresentation> mapper) {
    return launchPresentation(launchPresentation().map(mapper));
  }

  /**
   * Sets the value to be returned by {@link BasicLtiLaunchRequestMessage#launchPresentation()} to
   * {@link Optional#empty() Optional.empty()}.
   *
   * @return this {@code Builder} object
   */
  public BasicLtiLaunchRequestMessage.Builder clearLaunchPresentation() {
    launchPresentation = null;
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Returns the value that will be returned by {@link
   * BasicLtiLaunchRequestMessage#launchPresentation()}.
   */
  public Optional<LaunchPresentation> launchPresentation() {
    return Optional.ofNullable(launchPresentation);
  }

  /**
   * Sets all property values using the given {@code BasicLtiLaunchRequestMessage} as a template.
   */
  public BasicLtiLaunchRequestMessage.Builder mergeFrom(BasicLtiLaunchRequestMessage value) {
    BasicLtiLaunchRequestMessage_Builder _defaults = BasicLtiLaunchRequestMessage.builder();
    if (_defaults._unsetProperties.contains(BasicLtiLaunchRequestMessage_Builder.Property.VERSION)
        || !Objects.equals(value.version(), _defaults.version())) {
      version(value.version());
    }
    if (!Objects.equals(value.type(), _defaults.type())) {
      type(value.type());
    }
    putAllCustomParameters(value.customParameters());
    putAllExtensionParameters(value.extensionParameters());
    if (user == null) {
      user = value.user();
    } else {
      userBuilder().mergeFrom(value.user());
    }
    value.toolConsumer().ifPresent(this::toolConsumer);
    value.context().ifPresent(this::context);
    value.launchPresentation().ifPresent(this::launchPresentation);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Copies values from the given {@code Builder}. Does not affect any properties not set on the
   * input.
   */
  public BasicLtiLaunchRequestMessage.Builder mergeFrom(
      BasicLtiLaunchRequestMessage.Builder template) {
    // Upcast to access private fields; otherwise, oddly, we get an access violation.
    BasicLtiLaunchRequestMessage_Builder base = template;
    BasicLtiLaunchRequestMessage_Builder _defaults = BasicLtiLaunchRequestMessage.builder();
    if (!base._unsetProperties.contains(BasicLtiLaunchRequestMessage_Builder.Property.VERSION)
        && (_defaults._unsetProperties.contains(
                BasicLtiLaunchRequestMessage_Builder.Property.VERSION)
            || !Objects.equals(template.version(), _defaults.version()))) {
      version(template.version());
    }
    if (!Objects.equals(template.type(), _defaults.type())) {
      type(template.type());
    }
    putAllCustomParameters(base.customParameters);
    putAllExtensionParameters(base.extensionParameters);
    if (base.user == null) {
      // Nothing to merge
    } else if (base.user instanceof User) {
      User userValue = (User) base.user;
      if (user == null) {
        user = userValue;
      } else {
        userBuilder().mergeFrom(userValue);
      }
    } else {
      userBuilder().mergeFrom(base.userBuilder());
    }
    template.toolConsumer().ifPresent(this::toolConsumer);
    template.context().ifPresent(this::context);
    template.launchPresentation().ifPresent(this::launchPresentation);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /** Resets the state of this builder. */
  public BasicLtiLaunchRequestMessage.Builder clear() {
    BasicLtiLaunchRequestMessage_Builder _defaults = BasicLtiLaunchRequestMessage.builder();
    version = _defaults.version;
    type = _defaults.type;
    customParameters.clear();
    extensionParameters.clear();
    if (user == null || user instanceof User) {
      user = null;
    } else {
      User.Builder userBuilder = (User.Builder) user;
      userBuilder.clear();
    }
    toolConsumer = _defaults.toolConsumer;
    context = _defaults.context;
    launchPresentation = _defaults.launchPresentation;
    _unsetProperties.clear();
    _unsetProperties.addAll(_defaults._unsetProperties);
    return (BasicLtiLaunchRequestMessage.Builder) this;
  }

  /**
   * Returns a newly-created {@link BasicLtiLaunchRequestMessage} based on the contents of the
   * {@code Builder}.
   *
   * @throws IllegalStateException if any field has not been set
   */
  public BasicLtiLaunchRequestMessage build() {
    if (!_unsetProperties.isEmpty()) {
      throw new IllegalStateException("Not set: " + _unsetProperties);
    }
    return new BasicLtiLaunchRequestMessage_Builder.Value(this);
  }

  /**
   * Returns a newly-created partial {@link BasicLtiLaunchRequestMessage} for use in unit tests.
   * State checking will not be performed. Unset properties will throw an {@link
   * UnsupportedOperationException} when accessed via the partial object.
   *
   * <p>Partials should only ever be used in tests. They permit writing robust test cases that won't
   * fail if this type gains more application-level constraints (e.g. new required fields) in
   * future. If you require partially complete values in production code, consider using a Builder.
   */
  public BasicLtiLaunchRequestMessage buildPartial() {
    return new BasicLtiLaunchRequestMessage_Builder.Partial(this);
  }

  private static final class Value implements BasicLtiLaunchRequestMessage {
    private final LtiVersion version;
    private final MessageType type;
    private final Map<String, String> customParameters;
    private final Map<String, String> extensionParameters;
    private final User user;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final ToolConsumer toolConsumer;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final Context context;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final LaunchPresentation launchPresentation;

    private Value(BasicLtiLaunchRequestMessage_Builder builder) {
      this.version = builder.version;
      this.type = builder.type;
      this.customParameters = immutableMap(builder.customParameters);
      this.extensionParameters = immutableMap(builder.extensionParameters);
      if (builder.user == null) {
        this.user = User.builder().build();
      } else if (builder.user instanceof User) {
        this.user = (User) builder.user;
      } else {
        User.Builder userBuilder = (User.Builder) builder.user;
        this.user = userBuilder.build();
      }
      this.toolConsumer = builder.toolConsumer;
      this.context = builder.context;
      this.launchPresentation = builder.launchPresentation;
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
    public User user() {
      return user;
    }

    @Override
    public Optional<ToolConsumer> toolConsumer() {
      return Optional.ofNullable(toolConsumer);
    }

    @Override
    public Optional<Context> context() {
      return Optional.ofNullable(context);
    }

    @Override
    public Optional<LaunchPresentation> launchPresentation() {
      return Optional.ofNullable(launchPresentation);
    }

    @Override
    public BasicLtiLaunchRequestMessage.Builder toBuilder() {
      return BasicLtiLaunchRequestMessage.builder().mergeFrom(this);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof BasicLtiLaunchRequestMessage_Builder.Value)) {
        return false;
      }
      BasicLtiLaunchRequestMessage_Builder.Value other =
          (BasicLtiLaunchRequestMessage_Builder.Value) obj;
      return Objects.equals(version, other.version)
          && Objects.equals(type, other.type)
          && Objects.equals(customParameters, other.customParameters)
          && Objects.equals(extensionParameters, other.extensionParameters)
          && Objects.equals(user, other.user)
          && Objects.equals(toolConsumer, other.toolConsumer)
          && Objects.equals(context, other.context)
          && Objects.equals(launchPresentation, other.launchPresentation);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          version,
          type,
          customParameters,
          extensionParameters,
          user,
          toolConsumer,
          context,
          launchPresentation);
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("BasicLtiLaunchRequestMessage{");
      result.append("version=").append(version);
      result.append(", ");
      result.append("type=").append(type);
      result.append(", ");
      result.append("customParameters=").append(customParameters);
      result.append(", ");
      result.append("extensionParameters=").append(extensionParameters);
      result.append(", ");
      result.append("user=").append(user);
      if (toolConsumer != null) {
        result.append(", ");
        result.append("toolConsumer=").append(toolConsumer);
      }
      if (context != null) {
        result.append(", ");
        result.append("context=").append(context);
      }
      if (launchPresentation != null) {
        result.append(", ");
        result.append("launchPresentation=").append(launchPresentation);
      }
      result.append("}");
      return result.toString();
    }
  }

  private static final class Partial implements BasicLtiLaunchRequestMessage {
    private final LtiVersion version;
    private final MessageType type;
    private final Map<String, String> customParameters;
    private final Map<String, String> extensionParameters;
    private final User user;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final ToolConsumer toolConsumer;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final Context context;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final LaunchPresentation launchPresentation;
    private final EnumSet<BasicLtiLaunchRequestMessage_Builder.Property> _unsetProperties;

    Partial(BasicLtiLaunchRequestMessage_Builder builder) {
      this.version = builder.version;
      this.type = builder.type;
      this.customParameters = immutableMap(builder.customParameters);
      this.extensionParameters = immutableMap(builder.extensionParameters);
      if (builder.user == null) {
        this.user = User.builder().buildPartial();
      } else if (builder.user instanceof User) {
        this.user = (User) builder.user;
      } else {
        User.Builder userBuilder = (User.Builder) builder.user;
        this.user = userBuilder.buildPartial();
      }
      this.toolConsumer = builder.toolConsumer;
      this.context = builder.context;
      this.launchPresentation = builder.launchPresentation;
      this._unsetProperties = builder._unsetProperties.clone();
    }

    @Override
    public LtiVersion version() {
      if (_unsetProperties.contains(BasicLtiLaunchRequestMessage_Builder.Property.VERSION)) {
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
    public User user() {
      return user;
    }

    @Override
    public Optional<ToolConsumer> toolConsumer() {
      return Optional.ofNullable(toolConsumer);
    }

    @Override
    public Optional<Context> context() {
      return Optional.ofNullable(context);
    }

    @Override
    public Optional<LaunchPresentation> launchPresentation() {
      return Optional.ofNullable(launchPresentation);
    }

    private static class PartialBuilder extends BasicLtiLaunchRequestMessage.Builder {
      @Override
      public BasicLtiLaunchRequestMessage build() {
        return buildPartial();
      }
    }

    @Override
    public BasicLtiLaunchRequestMessage.Builder toBuilder() {
      BasicLtiLaunchRequestMessage.Builder builder = new PartialBuilder();
      if (!_unsetProperties.contains(BasicLtiLaunchRequestMessage_Builder.Property.VERSION)) {
        builder.version(version);
      }
      builder.type(type);
      builder.putAllCustomParameters(customParameters);
      builder.putAllExtensionParameters(extensionParameters);
      builder.userBuilder().mergeFrom(user.toBuilder());
      builder.nullableToolConsumer(toolConsumer);
      builder.nullableContext(context);
      builder.nullableLaunchPresentation(launchPresentation);
      return builder;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof BasicLtiLaunchRequestMessage_Builder.Partial)) {
        return false;
      }
      BasicLtiLaunchRequestMessage_Builder.Partial other =
          (BasicLtiLaunchRequestMessage_Builder.Partial) obj;
      return Objects.equals(version, other.version)
          && Objects.equals(type, other.type)
          && Objects.equals(customParameters, other.customParameters)
          && Objects.equals(extensionParameters, other.extensionParameters)
          && Objects.equals(user, other.user)
          && Objects.equals(toolConsumer, other.toolConsumer)
          && Objects.equals(context, other.context)
          && Objects.equals(launchPresentation, other.launchPresentation)
          && Objects.equals(_unsetProperties, other._unsetProperties);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          version,
          type,
          customParameters,
          extensionParameters,
          user,
          toolConsumer,
          context,
          launchPresentation,
          _unsetProperties);
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("partial BasicLtiLaunchRequestMessage{");
      if (!_unsetProperties.contains(BasicLtiLaunchRequestMessage_Builder.Property.VERSION)) {
        result.append("version=").append(version);
        result.append(", ");
      }
      result.append("type=").append(type);
      result.append(", ");
      result.append("customParameters=").append(customParameters);
      result.append(", ");
      result.append("extensionParameters=").append(extensionParameters);
      result.append(", ");
      result.append("user=").append(user);
      if (toolConsumer != null) {
        result.append(", ");
        result.append("toolConsumer=").append(toolConsumer);
      }
      if (context != null) {
        result.append(", ");
        result.append("context=").append(context);
      }
      if (launchPresentation != null) {
        result.append(", ");
        result.append("launchPresentation=").append(launchPresentation);
      }
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
