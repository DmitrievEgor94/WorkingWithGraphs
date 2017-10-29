package com.mycompany.graphes.Iterators;

import com.mycompany.graphes.Node;
import com.mycompany.graphes.TreeNode;

import java.util.Iterator;

public abstract class TreeIteratorStrategy<T> implements IteratorStrategy<T> {

    private Container<T> container;

    @Override
    public Iterator<Node<T>> getIterator(Node<T> firstElement) {
        return new TreeIterator<>((TreeNode<T>) firstElement, container);
    }

    void setContainer(Container<T> container) {
        this.container = container;
    }

    private class TreeIterator<T> implements Iterator<Node<T>> {
        private Container<T> container;

        private TreeIterator(TreeNode<T> firstElement, Container<T> container) {
            container.putElement(firstElement);
            this.container = container;
        }

        @Override
        public boolean hasNext() {
            return container.size() != 0;
        }

        @Override
        public Node<T> next() {
            TreeNode<T> currentNode = container.getNextElement();

            if (currentNode.getChildren() != null)
                currentNode.getChildren().forEach(node -> container.putElement(node));

            return currentNode;
        }
    }
}
