package com.mycompany.graphes.Iterators;

import com.mycompany.graphes.TreeNode;

import java.util.Stack;

public class DepthIteratorStrategy<T> extends TreeIteratorStrategy<T> {

    public DepthIteratorStrategy() {
        Container<T> container = new StackContainer();
        super.setContainer(container);
    }

    private class StackContainer implements Container<T> {
        Stack<TreeNode<T>> stackWithNodes;

        private StackContainer() {
            stackWithNodes = new Stack<>();
        }

        @Override
        public void putElement(TreeNode<T> element) {
            stackWithNodes.push(element);
        }

        @Override
        public TreeNode<T> getNextElement() {
            return stackWithNodes.pop();
        }

        @Override
        public int size() {
            return stackWithNodes.size();
        }
    }
}
