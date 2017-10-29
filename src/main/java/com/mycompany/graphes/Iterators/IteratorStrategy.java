package com.mycompany.graphes.Iterators;

import com.mycompany.graphes.Node;

import java.util.Iterator;

public interface IteratorStrategy<T> {
    Iterator<Node<T>> getIterator(Node<T> firstElement);
}
