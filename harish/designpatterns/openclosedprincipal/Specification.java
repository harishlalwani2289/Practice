package practice.harish.designpatterns.openclosedprincipal;

import java.util.List;
import java.util.stream.Stream;

public interface Specification<T> {

    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}