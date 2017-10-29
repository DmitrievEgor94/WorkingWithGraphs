package com.mycompany.graphes.Client;

import com.mycompany.graphes.Client.Visitor;
import com.mycompany.graphes.Node;
import com.mycompany.graphes.Tree;
import com.mycompany.graphes.TreeNode;

public class PrintElements<T> implements Visitor<T> {
    @Override
    public void visit(Tree<T> tree) {
        for (Node<T> tNode : tree) {
            TreeNode<T> treeNode =(TreeNode<T>) tNode;
            System.out.println("I found "+ treeNode.getType());
        }
    }
}
