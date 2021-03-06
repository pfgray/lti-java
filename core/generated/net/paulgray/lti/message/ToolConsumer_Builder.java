// Autogenerated code. Do not modify.
package net.paulgray.lti.message;

import java.util.Objects;
import java.util.Optional;
import java.util.function.UnaryOperator;
import javax.annotation.Generated;
import javax.annotation.Nullable;

/**
 * Auto-generated superclass of {@link ToolConsumer.Builder}, derived from the API of {@link
 * ToolConsumer}.
 */
@Generated("org.inferred.freebuilder.processor.CodeGenerator")
abstract class ToolConsumer_Builder {

  /** Creates a new builder using {@code value} as a template. */
  public static ToolConsumer.Builder from(ToolConsumer value) {
    return ToolConsumer.builder().mergeFrom(value);
  }

  // Store a nullable object instead of an Optional. Escape analysis then
  // allows the JVM to optimize away the Optional objects created by and
  // passed to our API.
  private ToolConsumerInfo info = null;
  // Store a nullable object instead of an Optional. Escape analysis then
  // allows the JVM to optimize away the Optional objects created by and
  // passed to our API.
  private ToolConsumerInstance instance = null;

  /**
   * Sets the value to be returned by {@link ToolConsumer#info()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code info} is null
   */
  public ToolConsumer.Builder info(ToolConsumerInfo info) {
    this.info = Objects.requireNonNull(info);
    return (ToolConsumer.Builder) this;
  }

  /**
   * Sets the value to be returned by {@link ToolConsumer#info()}.
   *
   * @return this {@code Builder} object
   */
  public ToolConsumer.Builder info(Optional<? extends ToolConsumerInfo> info) {
    if (info.isPresent()) {
      return info(info.get());
    } else {
      return clearInfo();
    }
  }

  /**
   * Sets the value to be returned by {@link ToolConsumer#info()}.
   *
   * @return this {@code Builder} object
   */
  public ToolConsumer.Builder nullableInfo(@Nullable ToolConsumerInfo info) {
    if (info != null) {
      return info(info);
    } else {
      return clearInfo();
    }
  }

  /**
   * If the value to be returned by {@link ToolConsumer#info()} is present, replaces it by applying
   * {@code mapper} to it and using the result.
   *
   * <p>If the result is null, clears the value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null
   */
  public ToolConsumer.Builder mapInfo(UnaryOperator<ToolConsumerInfo> mapper) {
    return info(info().map(mapper));
  }

  /**
   * Sets the value to be returned by {@link ToolConsumer#info()} to {@link Optional#empty()
   * Optional.empty()}.
   *
   * @return this {@code Builder} object
   */
  public ToolConsumer.Builder clearInfo() {
    info = null;
    return (ToolConsumer.Builder) this;
  }

  /** Returns the value that will be returned by {@link ToolConsumer#info()}. */
  public Optional<ToolConsumerInfo> info() {
    return Optional.ofNullable(info);
  }

  /**
   * Sets the value to be returned by {@link ToolConsumer#instance()}.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code instance} is null
   */
  public ToolConsumer.Builder instance(ToolConsumerInstance instance) {
    this.instance = Objects.requireNonNull(instance);
    return (ToolConsumer.Builder) this;
  }

  /**
   * Sets the value to be returned by {@link ToolConsumer#instance()}.
   *
   * @return this {@code Builder} object
   */
  public ToolConsumer.Builder instance(Optional<? extends ToolConsumerInstance> instance) {
    if (instance.isPresent()) {
      return instance(instance.get());
    } else {
      return clearInstance();
    }
  }

  /**
   * Sets the value to be returned by {@link ToolConsumer#instance()}.
   *
   * @return this {@code Builder} object
   */
  public ToolConsumer.Builder nullableInstance(@Nullable ToolConsumerInstance instance) {
    if (instance != null) {
      return instance(instance);
    } else {
      return clearInstance();
    }
  }

  /**
   * If the value to be returned by {@link ToolConsumer#instance()} is present, replaces it by
   * applying {@code mapper} to it and using the result.
   *
   * <p>If the result is null, clears the value.
   *
   * @return this {@code Builder} object
   * @throws NullPointerException if {@code mapper} is null
   */
  public ToolConsumer.Builder mapInstance(UnaryOperator<ToolConsumerInstance> mapper) {
    return instance(instance().map(mapper));
  }

  /**
   * Sets the value to be returned by {@link ToolConsumer#instance()} to {@link Optional#empty()
   * Optional.empty()}.
   *
   * @return this {@code Builder} object
   */
  public ToolConsumer.Builder clearInstance() {
    instance = null;
    return (ToolConsumer.Builder) this;
  }

  /** Returns the value that will be returned by {@link ToolConsumer#instance()}. */
  public Optional<ToolConsumerInstance> instance() {
    return Optional.ofNullable(instance);
  }

  /** Sets all property values using the given {@code ToolConsumer} as a template. */
  public ToolConsumer.Builder mergeFrom(ToolConsumer value) {
    value.info().ifPresent(this::info);
    value.instance().ifPresent(this::instance);
    return (ToolConsumer.Builder) this;
  }

  /**
   * Copies values from the given {@code Builder}. Does not affect any properties not set on the
   * input.
   */
  public ToolConsumer.Builder mergeFrom(ToolConsumer.Builder template) {
    template.info().ifPresent(this::info);
    template.instance().ifPresent(this::instance);
    return (ToolConsumer.Builder) this;
  }

  /** Resets the state of this builder. */
  public ToolConsumer.Builder clear() {
    ToolConsumer_Builder _defaults = ToolConsumer.builder();
    info = _defaults.info;
    instance = _defaults.instance;
    return (ToolConsumer.Builder) this;
  }

  /** Returns a newly-created {@link ToolConsumer} based on the contents of the {@code Builder}. */
  public ToolConsumer build() {
    return new ToolConsumer_Builder.Value(this);
  }

  /**
   * Returns a newly-created partial {@link ToolConsumer} for use in unit tests. State checking will
   * not be performed.
   *
   * <p>Partials should only ever be used in tests. They permit writing robust test cases that won't
   * fail if this type gains more application-level constraints (e.g. new required fields) in
   * future. If you require partially complete values in production code, consider using a Builder.
   */
  public ToolConsumer buildPartial() {
    return new ToolConsumer_Builder.Partial(this);
  }

  private static final class Value implements ToolConsumer {
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final ToolConsumerInfo info;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final ToolConsumerInstance instance;

    private Value(ToolConsumer_Builder builder) {
      this.info = builder.info;
      this.instance = builder.instance;
    }

    @Override
    public Optional<ToolConsumerInfo> info() {
      return Optional.ofNullable(info);
    }

    @Override
    public Optional<ToolConsumerInstance> instance() {
      return Optional.ofNullable(instance);
    }

    @Override
    public ToolConsumer.Builder toBuilder() {
      return ToolConsumer.builder().mergeFrom(this);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ToolConsumer_Builder.Value)) {
        return false;
      }
      ToolConsumer_Builder.Value other = (ToolConsumer_Builder.Value) obj;
      return Objects.equals(info, other.info) && Objects.equals(instance, other.instance);
    }

    @Override
    public int hashCode() {
      return Objects.hash(info, instance);
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("ToolConsumer{");
      String separator = "";
      if (info != null) {
        result.append("info=").append(info);
        separator = ", ";
      }
      if (instance != null) {
        result.append(separator);
        result.append("instance=").append(instance);
      }
      result.append("}");
      return result.toString();
    }
  }

  private static final class Partial implements ToolConsumer {
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final ToolConsumerInfo info;
    // Store a nullable object instead of an Optional. Escape analysis then
    // allows the JVM to optimize away the Optional objects created by our
    // getter method.
    private final ToolConsumerInstance instance;

    Partial(ToolConsumer_Builder builder) {
      this.info = builder.info;
      this.instance = builder.instance;
    }

    @Override
    public Optional<ToolConsumerInfo> info() {
      return Optional.ofNullable(info);
    }

    @Override
    public Optional<ToolConsumerInstance> instance() {
      return Optional.ofNullable(instance);
    }

    private static class PartialBuilder extends ToolConsumer.Builder {
      @Override
      public ToolConsumer build() {
        return buildPartial();
      }
    }

    @Override
    public ToolConsumer.Builder toBuilder() {
      ToolConsumer.Builder builder = new PartialBuilder();
      builder.nullableInfo(info);
      builder.nullableInstance(instance);
      return builder;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ToolConsumer_Builder.Partial)) {
        return false;
      }
      ToolConsumer_Builder.Partial other = (ToolConsumer_Builder.Partial) obj;
      return Objects.equals(info, other.info) && Objects.equals(instance, other.instance);
    }

    @Override
    public int hashCode() {
      return Objects.hash(info, instance);
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder("partial ToolConsumer{");
      String separator = "";
      if (info != null) {
        result.append("info=").append(info);
        separator = ", ";
      }
      if (instance != null) {
        result.append(separator);
        result.append("instance=").append(instance);
      }
      result.append("}");
      return result.toString();
    }
  }
}
