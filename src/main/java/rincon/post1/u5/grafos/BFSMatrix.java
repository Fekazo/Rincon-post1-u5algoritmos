package rincon.post1.u5.grafos;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/** BFS sobre MatrixGraph. */
public class BFSMatrix {
    public static int[] run(MatrixGraph g, int src) {
        int V = g.size();
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist[src] = 0;
        q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < V; v++)
                if (g.hasEdge(u, v) && dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
        }
        return dist;
    }
}