package com.mycompany.graphes;

abstract class TreeIteratorStrategy<T> implements IteratorStrategy<T> {
    TreeNode<T> root;

    void setRoot(TreeNode<T> root) {
        this.root = root;
    }
}
