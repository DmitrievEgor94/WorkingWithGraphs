package com.mycompany.graphes;

import java.util.Iterator;

public interface IteratorStrategy<T> {
    Iterator<Node<T>> getIterator();
}
