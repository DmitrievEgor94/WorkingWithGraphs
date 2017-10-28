package com.mycompany.graphes;

import java.util.Iterator;
import java.util.Stack;

public class DepthIteratorTree<T> extends TreeIteratorStrategy<T> {
    private Stack<TreeNode<T>> stackWithNodes;

    @Override
    public Iterator<Node<T>> getIterator() {
        return new DepthIterator(root);
    }

    private class DepthIterator implements Iterator<Node<T>> {

        private DepthIterator(TreeNode<T> root){
            stackWithNodes = new Stack<>();
            stackWithNodes.add(root);
        }

        @Override
        public boolean hasNext() {
            return stackWithNodes.size() != 0;
        }

        @Override
        public Node<T> next() {
            TreeNode<T> currentNode = stackWithNodes.pop();

            if (currentNode.getChildren() != null)
                stackWithNodes.addAll(currentNode.getChildren());

            return currentNode;
        }

    }
}
