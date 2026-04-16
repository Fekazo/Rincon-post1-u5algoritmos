package rincon.post1.u5.grafos;

import java.util.*;

/** Algoritmos BFS sobre un grafo genérico. */
public class BFS {

    /**
     * BFS desde src. Retorna arreglo dist[] donde dist[v] es la
     * distancia mínima en aristas desde src; -1 si no alcanzable.
     */
    public static int[] shortestDistances(Graph<?> g, int src) {
        int V = g.size();
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist[src] = 0;
        q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.neighbors(u))
                if (dist[v] == -1) { dist[v] = dist[u]+1; q.offer(v); }
        }
        return dist;
    }

    /**
     * BFS desde src. Retorna parent[] para reconstruir caminos.
     * parent[src] = -1; parent[v] = u si BFS llegó a v desde u.
     */
    public static int[] parentTree(Graph<?> g, int src) {
        int V = g.size();
        int[] parent = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new ArrayDeque<>();
        vis[src] = true;
        q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.neighbors(u))
                if (!vis[v]) { vis[v]=true; parent[v]=u; q.offer(v); }
        }
        return parent;
    }

    /**
     * Reconstruye el camino mínimo entre src y dst usando parent[].
     * Retorna lista vacía si dst no es alcanzable.
     */
    public static List<Integer> path(int[] parent, int dst) {
        List<Integer> result = new ArrayList<>();
        if (parent[dst] == -1 && dst != 0) return result;
        for (int v = dst; v != -1; v = parent[v]) result.add(v);
        Collections.reverse(result);
        return result;
    }

    /**
     * Etiqueta componentes conexas. Retorna component[] donde
     * component[v] = id de la componente (0-indexed).
     */
    public static int[] connectedComponents(Graph<?> g) {
        int V = g.size();
        int[] comp = new int[V];
        Arrays.fill(comp, -1);
        int id = 0;
        for (int s = 0; s < V; s++) {
            if (comp[s] != -1) continue;
            Queue<Integer> q = new ArrayDeque<>();
            comp[s] = id; q.offer(s);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g.neighbors(u))
                    if (comp[v]==-1) { comp[v]=id; q.offer(v); }
            }
            id++;
        }
        return comp;
    }
}