package com.mycompany.graphes;

import java.util.Iterator;
import java.util.function.Consumer;

public class Tree<T> implements Graph<T> {
    @Override
    public void accept(Visitor<T> v) {
        v.visit(this);
    }

    private TreeNode<T> root;
    private TreeIteratorStrategy<T> treeIteratorStrategy;

    public Tree(T root) {
        this.root = new TreeNode<>(root, "root", null);
        this.treeIteratorStrategy = new DepthIteratorTree<>();
        this.treeIteratorStrategy.setRoot(this.root);
    }

    @Override
    public Node<T> findNode(T val) {
        for (Node<T> tNode : this) {
            if (tNode.getValue().equals(val))
                return tNode;
        }
        return null;
    }

    @Override
    public void addNodes(T... elements) {
        TreeNode<T> currentNode = root;

        while (currentNode.getChildren() != null)
            if (currentNode.getChildren().size() > 0)
                currentNode = currentNode.getChildren().get(0);

        setChildrenNodesToCurrentNode(currentNode, elements);
    }

    @Override
    public void addNodesToNode(Node<T> node, T... elements) {
        TreeNode<T> currentNode = null;

        for (Node<T> tNode : this) {
            currentNode = (TreeNode<T>) tNode;
            if (currentNode == node) break;
        }
        if (currentNode != null)
            setChildrenNodesToCurrentNode(currentNode, elements);
    }

    @Override
    public void setIteratorStrategy(IteratorStrategy<T> iteratorStrategy) throws WrongIteratorStrategyException {
        if (iteratorStrategy instanceof TreeIteratorStrategy) {
            treeIteratorStrategy = (TreeIteratorStrategy) iteratorStrategy;
            treeIteratorStrategy.setRoot(this.root);
        } else {
            throw new WrongIteratorStrategyException("There is no instance of TreeIteratorStrategy!");
        }
    }

    private void setChildrenNodesToCurrentNode(TreeNode<T> currentNode, T... puttedElements) {
        TreeNode<T> children[] = new TreeNode[puttedElements.length];

        for (int i = 0; i < children.length; i++) {
            children[i] = new TreeNode<>(puttedElements[i], "leaf", null);
        }

        currentNode.setChildren(children);
        if (currentNode != root)
            currentNode.setType("branch");
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return treeIteratorStrategy.getIterator();
    }


    @Override
    public void forEach(Consumer<? super Node<T>> action) {
        for (Node<T> tNode : this) {
            action.accept(tNode);
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

}
