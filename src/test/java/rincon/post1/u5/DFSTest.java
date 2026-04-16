package rincon.post1.u5;

import org.junit.jupiter.api.Test;
import rincon.post1.u5.grafos.DFS;
import rincon.post1.u5.grafos.Graph;

import static org.junit.jupiter.api.Assertions.*;

public class DFSTest {

    @Test
    void dfsDetectsCycle() {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1); g.addEdge(1, 2); g.addEdge(2, 0); // triángulo
        DFS dfs = new DFS(g);
        assertTrue(dfs.hasCycle);
    }

    @Test
    void dfsNoCycleInTree() {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(1, 3);
        DFS dfs = new DFS(g);
        assertFalse(dfs.hasCycle);
        assertTrue(dfs.disc[0] < dfs.fin[0]);
    }
}