import com.mycompany.graphes.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodesOperationsTest {
    private Tree<String> tree;

    public NodesOperationsTest() {
        tree = new Tree<>("2");
    }

    @Test
    public void addNodesTest() {
        tree.addNodes("1", "2", "3");
        tree.addNodes("1");

        int check = tree.getRoot().getChildren().size()+tree.getRoot().getChildren().get(0).getChildren().size()+1;

        assertEquals(5,check);
    }

    @Test
    public void addNodesToNode(){
        tree.addNodesToNode(tree.getRoot(),"1","2","5");

        tree.addNodesToNode(tree.getRoot().getChildren().get(2),"6");

        int check = tree.getRoot().getChildren().size()+tree.getRoot().getChildren().get(2).getChildren().size()+1;

       assertEquals(5,check);
    }
}
