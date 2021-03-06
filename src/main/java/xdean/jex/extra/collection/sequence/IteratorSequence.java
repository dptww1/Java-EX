package xdean.jex.extra.collection.sequence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xdean.jex.extra.annotation.marker.OnHold;

@OnHold
class IteratorSequence<E> implements Sequence<E> {
  private Iterator<E> origin;
  private List<E> released = new ArrayList<>();

  public IteratorSequence(Iterator<E> origin) {
    this.origin = origin;
  }

  @Override
  public boolean hasNext() {
    return !released.isEmpty() || origin.hasNext();
  }

  @Override
  public E next() {
    if (released.isEmpty()) {
      return null;
    } else {
      return released.remove(0);
    }
  }

  @Override
  public boolean release(E e) {
    return false;
  }

}
