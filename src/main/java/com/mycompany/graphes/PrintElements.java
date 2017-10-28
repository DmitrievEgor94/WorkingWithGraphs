package com.mycompany.graphes;

public class PrintElements<T> implements Visitor<T> {
    @Override
    public void visit(Tree<T> tree) {
        for (Node<T> tNode : tree) {
            TreeNode<T> treeNode =(TreeNode<T>) tNode;
            System.out.println("I found "+ treeNode.getType());
        }
    }
}
