package com.mycompany.graphes;

import com.mycompany.graphes.Client.Visitor;
import com.mycompany.graphes.Iterators.IteratorStrategy;
import com.mycompany.graphes.Iterators.WrongIteratorStrategyException;

public interface Graph<T> extends Iterable<Node<T>> {
    Node<T> findNode(T val);

    void addNodes(T... elements);

    void addNodesToNode(Node<T> node, T...values);

    void setIteratorStrategy(IteratorStrategy<T> iterator) throws WrongIteratorStrategyException;

    void accept(Visitor<T> v);
}
