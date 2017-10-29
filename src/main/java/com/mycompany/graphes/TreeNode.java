package com.mycompany.graphes;

import java.util.Arrays;
import java.util.List;

public class TreeNode<T> implements Node<T> {

    enum TypeOfNode {LEAF, BRANCH, ROOT}

    private T val;
    private TypeOfNode typeOfNode;
    private List<TreeNode<T>> children;

    TreeNode(T val, TypeOfNode type, TreeNode<T>... children) {
        this.val = val;
        if (children != null) {
            this.children = Arrays.asList(children);
        }
        this.typeOfNode = type;
    }

    public TypeOfNode getType() {
        return typeOfNode;
    }

    public void print() {
        System.out.println("Type: " + typeOfNode + ", value: " + val);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    void setChildren(TreeNode<T>... children) {
        this.children = Arrays.asList(children);
    }

    void setType(TypeOfNode type) {
        this.typeOfNode = type;
    }

    public T getValue() {
        return val;
    }

}
