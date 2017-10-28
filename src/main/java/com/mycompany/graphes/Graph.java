package com.mycompany.graphes;

public interface Graph<T> extends Iterable<Node<T>> {
    Node<T> findNode(T val);

    void addNodes(T... elements);

    void addNodesToNode(Node<T> node, T...values);

    void setIteratorStrategy(IteratorStrategy <T> iterator) throws WrongIteratorStrategyException;

    void accept(Visitor<T> v);
}
