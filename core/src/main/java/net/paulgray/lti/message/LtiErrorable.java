package net.paulgray.lti.message;

import net.paulgray.lti.launch.LaunchError;
import net.paulgray.lti.message.error.LtiError;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LtiErrorable<A> {

    private List<LaunchError> errors;
    private Optional<A> entity;

    private LtiErrorable(LaunchError error) {
        this.errors = Collections.singletonList(error);
        this.entity = Optional.empty();
    }

    private LtiErrorable(List<LaunchError> errors) {
        this.errors = errors;
        this.entity = Optional.empty();
    }

    private LtiErrorable(A entity) {
        this.entity = Optional.of(entity);
        this.errors = Collections.emptyList();
    }

    public List<LaunchError> getErrors() {
        return errors;
    }

    public Optional<A> getEntity() {
        return entity;
    }

    public static <B> LtiErrorable<B> error(LaunchError error) {
        return new LtiErrorable<>(error);
    }

    public static <B> LtiErrorable<B> errors(List<LaunchError> errors) {
        return new LtiErrorable<>(errors);
    }

    public static <B> LtiErrorable<B> success(B b) {
        return new LtiErrorable<>(b);
    }

    public static <B> LtiErrorable<B> from(Optional<B> entity, LaunchError error) {
        return entity
          .map(LtiErrorable::success)
          .orElseGet(() -> error(error));
    }

    public <Z> Z collapse(Function<A, Z> ifSuccess, Function<List<LaunchError>, Z> ifFail) {
        if(!this.errors.isEmpty()){
            return ifFail.apply(this.errors);
        } else {
            return ifSuccess.apply(this.entity.get());
        }
    }

    public <B> LtiErrorable<B> map(Function<A, B> f){
        if(!this.errors.isEmpty()){
            return (LtiErrorable<B>) this;
        } else {
            return success(f.apply(this.entity.get()));
        }
    }

    public <B> LtiErrorable<B> flatMap(Function<A, LtiErrorable<B>> f){
        if(!this.errors.isEmpty()){
            return (LtiErrorable<B>) this;
        } else {
            return f.apply(this.entity.get());
        }
    }

    @FunctionalInterface
    interface Function2<A, B, Z> {
        Z apply(A a, B b);
    }
    @FunctionalInterface
    interface Function3<A, B, C, Z> {
        Z apply(A a, B b, C c);
    }

    public <B, Z> LtiErrorable<Z> combine(LtiErrorable<B> b, Function2<A, B, LtiErrorable<Z>> f) {
        List<LaunchError> ltiErrors = combineLists(this.errors, b.getErrors());
        if (!ltiErrors.isEmpty()) {
            return LtiErrorable.errors(ltiErrors);
        } else {
            return f.apply(this.entity.get(), b.getEntity().get());
        }
    }

    public <B, C,  Z> LtiErrorable<Z> combine(LtiErrorable<B> b, LtiErrorable<C> c, Function3<A, B, C, LtiErrorable<Z>> f){
        List<LaunchError> ltiErrors = combineLists(this.errors, b.getErrors(), c.getErrors());

        if(!ltiErrors.isEmpty()){
            return LtiErrorable.errors(ltiErrors);
        } else {
            return f.apply(this.entity.get(), b.getEntity().get(), c.getEntity().get());
        }
    }

    public <B> List<B> combineLists(List<B> ...a) {
        return Arrays.stream(a).flatMap(List::stream).collect(Collectors.toList());
    }
}
