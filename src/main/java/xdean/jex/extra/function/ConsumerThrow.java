package xdean.jex.extra.function;

import java.util.Objects;

import xdean.jex.internal.codecov.CodecovIgnore;

@FunctionalInterface
@CodecovIgnore
public interface ConsumerThrow<T, E extends Exception> {

  void accept(T t) throws E;

  default ConsumerThrow<T, E> andThen(ConsumerThrow<? super T, E> after) {
    Objects.requireNonNull(after);
    return (T t) -> {
      accept(t);
      after.accept(t);
    };
  }
}