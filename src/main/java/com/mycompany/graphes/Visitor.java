package com.mycompany.graphes;

public interface Visitor<T> {
    void visit(Tree<T> tree);
}
