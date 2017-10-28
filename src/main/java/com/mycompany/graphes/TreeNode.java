package com.mycompany.graphes;

import java.util.Arrays;
import java.util.List;

public class TreeNode<T> implements Node<T> {

    private T val;
    private String type;
    private List<TreeNode<T>> children;

    TreeNode(T val, String type, TreeNode<T>... children) {
        this.val = val;
        if (children != null) {
            this.children = Arrays.asList(children);
        }
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void print() {
        System.out.println("Type: " + type + ", value: " + val);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    void setChildren(TreeNode<T>... children) {
        this.children = Arrays.asList(children);
    }

    void setType(String type) {
        this.type = type;
    }

    public T getValue() {
        return val;
    }

}
