package rincon.post1.u5.grafos;

import java.util.Random;

/** Genera grafos aleatorios para benchmarks. */
public class RandomGraphGen {
    private static final Random rng = new Random(42);

    public static Graph<Integer> buildList(int V, int E) {
        Graph<Integer> g = new Graph<>();
        for (int i = 0; i < V; i++) g.addVertex(i);
        int added = 0;
        while (added < E) {
            int u = rng.nextInt(V);
            int v = rng.nextInt(V);
            if (u != v) { g.addEdge(u, v); added++; }
        }
        return g;
    }

    public static MatrixGraph buildMatrix(int V, int E) {
        MatrixGraph g = new MatrixGraph(V);
        int added = 0;
        while (added < E) {
            int u = rng.nextInt(V);
            int v = rng.nextInt(V);
            if (u != v) { g.addEdge(u, v); added++; }
        }
        return g;
    }
}