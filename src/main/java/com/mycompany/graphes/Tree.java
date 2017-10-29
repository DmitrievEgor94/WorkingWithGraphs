package com.mycompany.graphes;

import com.mycompany.graphes.Client.Visitor;
import com.mycompany.graphes.Iterators.DepthIteratorStrategy;
import com.mycompany.graphes.Iterators.IteratorStrategy;
import com.mycompany.graphes.Iterators.TreeIteratorStrategy;
import com.mycompany.graphes.Iterators.WrongIteratorStrategyException;

import java.util.Iterator;
import java.util.function.Consumer;

import static com.mycompany.graphes.TreeNode.TypeOfNode;

public class Tree<T> implements Graph<T> {

    private TreeNode<T> root;
    private TreeIteratorStrategy<T> treeIteratorStrategy;

    public Tree(T root) {
        this.root = new TreeNode<>(root, TypeOfNode.ROOT, null);
        this.treeIteratorStrategy = new DepthIteratorStrategy<>();
    }

    @Override
    public void accept(Visitor<T> v) {
        v.visit(this);
    }

    @Override
    public Node<T> findNode(T val) {
        for (Node<T> tNode : this) {
            if (tNode.getValue() != null) {
                if (tNode.getValue().equals(val)) {
                    return tNode;
                }
            }
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
        } else {
            throw new WrongIteratorStrategyException("There is no instance of TreeIteratorStrategy!");
        }
    }

    private void setChildrenNodesToCurrentNode(TreeNode<T> currentNode, T... puttedElements) {
        TreeNode<T> children[] = new TreeNode[puttedElements.length];

        for (int i = 0; i < children.length; i++) {
            children[i] = new TreeNode<>(puttedElements[i], TypeOfNode.LEAF, null);
        }

        currentNode.setChildren(children);
        if (currentNode != root)
            currentNode.setType(TypeOfNode.BRANCH);
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return treeIteratorStrategy.getIterator(this.root);
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
