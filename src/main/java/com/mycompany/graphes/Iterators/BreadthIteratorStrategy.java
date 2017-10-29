package com.mycompany.graphes.Iterators;

import com.mycompany.graphes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthIteratorStrategy<T> extends TreeIteratorStrategy<T> {

    public BreadthIteratorStrategy() {
        Container<T> queueContainer = new QueueContainer();
        super.setContainer(queueContainer);
    }

    private class QueueContainer implements Container<T> {
        Queue<TreeNode<T>> queueWithNodes;

        private QueueContainer() {
            queueWithNodes = new LinkedList<>();
        }

        @Override
        public void putElement(TreeNode<T> element) {
            queueWithNodes.add(element);
        }

        @Override
        public TreeNode<T> getNextElement() {
            return queueWithNodes.poll();
        }

        @Override
        public int size() {
            return queueWithNodes.size();
        }
    }
}

