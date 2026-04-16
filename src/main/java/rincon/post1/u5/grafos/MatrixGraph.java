package rincon.post1.u5.grafos;

/** Grafo no dirigido representado como matriz de adyacencia. */
public class MatrixGraph {
    private final boolean[][] adj;
    private final int V;

    public MatrixGraph(int V) {
        this.V = V;
        this.adj = new boolean[V][V];
    }

    public void addEdge(int u, int v) {
        adj[u][v] = true;
        adj[v][u] = true;
    }

    public int size() { return V; }

    public boolean hasEdge(int u, int v) { return adj[u][v]; }
}