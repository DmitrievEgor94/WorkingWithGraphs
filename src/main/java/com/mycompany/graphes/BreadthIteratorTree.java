package com.mycompany.graphes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthIteratorTree<T> extends TreeIteratorStrategy<T> {
    private Queue<TreeNode<T>> queueWithNodes;

    @Override
    public Iterator<Node<T>> getIterator() {
        return new BreadthIterator(super.root);
    }

    private class BreadthIterator implements Iterator<Node<T>> {

        private BreadthIterator(TreeNode<T> root) {
            queueWithNodes = new LinkedList<>();
            queueWithNodes.add(root);
        }

        @Override
        public boolean hasNext() {
            return queueWithNodes.size() != 0;
        }

        @Override
        public Node<T> next() {
            TreeNode<T> currentNode = queueWithNodes.poll();

            if (currentNode.getChildren() != null)
                queueWithNodes.addAll(currentNode.getChildren());

            return currentNode;
        }
    }
}

