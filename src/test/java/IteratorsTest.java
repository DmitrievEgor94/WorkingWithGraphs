import com.mycompany.graphes.Iterators.BreadthIteratorStrategy;
import com.mycompany.graphes.Iterators.DepthIteratorStrategy;
import com.mycompany.graphes.Node;
import com.mycompany.graphes.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IteratorsTest {
    private Tree<Integer> tree;

    public IteratorsTest() {
        this.tree = new Tree<>(1);
        tree.addNodes(1, 3, 4);
        tree.addNodesToNode(tree.findNode(4), 1, 2);
    }

    @Test
    public void depthIteratorTest() throws Exception {
        tree.setIteratorStrategy(new DepthIteratorStrategy<>());

        String check = "";

        for (Node<Integer> integerNode : tree) {
            check += integerNode.getValue() + " ";
        }

        assertEquals("1 4 2 1 3 1 ", check);
    }

    @Test
    public void breadthIteratorTest() throws Exception {
        tree.setIteratorStrategy(new BreadthIteratorStrategy<>());

        String check = "";

        for (Node<Integer> integerNode : tree) {
            check += integerNode.getValue() + " ";
        }

        assertEquals("1 1 3 4 1 2 ", check);
    }
}
