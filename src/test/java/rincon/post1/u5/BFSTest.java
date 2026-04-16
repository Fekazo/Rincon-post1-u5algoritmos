package rincon.post1.u5;

import org.junit.jupiter.api.Test;
import rincon.post1.u5.grafos.BFS;
import rincon.post1.u5.grafos.Graph;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BFSTest {

    @Test
    void bfsDistancesLinearGraph() {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1); g.addEdge(1, 2); g.addEdge(2, 3);
        int[] dist = BFS.shortestDistances(g, 0);
        assertArrayEquals(new int[]{0, 1, 2, 3}, dist);
    }

    @Test
    void bfsDisconnectedGraph() {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1); g.addVertex(2); // 2 aislado
        int[] comp = BFS.connectedComponents(g);
        assertEquals(2, Arrays.stream(comp).max().getAsInt() + 1);
    }

    @Test
    void bfsPathReconstruction() {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 3); g.addEdge(2, 3);
        int[] parent = BFS.parentTree(g, 0);
        List<Integer> p = BFS.path(parent, 3);
        assertEquals(0, p.get(0));
        assertEquals(3, p.get(p.size() - 1));
    }
}