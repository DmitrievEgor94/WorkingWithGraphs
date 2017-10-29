package com.mycompany.graphes.Iterators;

import com.mycompany.graphes.TreeNode;

public interface Container<T> {
    void putElement(TreeNode<T> element);

    TreeNode<T> getNextElement();

    int size();
}
