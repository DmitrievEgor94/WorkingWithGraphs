package com.mycompany.graphes.Client;

import com.mycompany.graphes.Tree;

public interface Visitor<T> {
    void visit(Tree<T> tree);
}
