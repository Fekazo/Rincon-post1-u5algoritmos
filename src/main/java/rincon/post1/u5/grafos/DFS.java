package rincon.post1.u5.grafos;

import java.util.*;

/** DFS con tiempos disc/fin y clasificación de aristas. */
public class DFS {
    public enum EdgeType { TREE, BACK, FORWARD, CROSS }

    public final int[]    disc, fin;
    public final boolean  hasCycle;
    public final Map<String, EdgeType> edgeTypes = new LinkedHashMap<>();

    private final int[] color; // 0=white,1=gray,2=black
    private int timer = 0;
    private boolean cycleFound = false;

    public DFS(Graph<?> g) {
        int V = g.size();
        disc = new int[V]; fin = new int[V]; color = new int[V];
        for (int u = 0; u < V; u++)
            if (color[u] == 0) visit(u, -1, g);
        hasCycle = cycleFound;
    }

    private void visit(int u, int parent, Graph<?> g) {
        color[u] = 1; disc[u] = ++timer;
        for (int v : g.neighbors(u)) {
            if (v == parent) continue; // ignorar arista de regreso al padre
            String key = u + "->" + v;
            if (color[v] == 0) {
                edgeTypes.put(key, EdgeType.TREE);
                visit(v, u, g);
            } else if (color[v] == 1) {
                edgeTypes.put(key, EdgeType.BACK);
                cycleFound = true;
            } else {
                EdgeType t = disc[u] < disc[v] ? EdgeType.FORWARD : EdgeType.CROSS;
                edgeTypes.put(key, t);
            }
        }
        color[u] = 2; fin[u] = ++timer;
    }
}