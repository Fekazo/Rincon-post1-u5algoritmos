package rincon.post1.u5.grafos;

import java.util.*;

/** Grafo no dirigido genérico con lista de adyacencia. */
public class Graph<T> {
    private final Map<T, Integer> index = new LinkedHashMap<>();
    private final List<List<Integer>> adj   = new ArrayList<>();
    private int V = 0;

    /** Agrega un vértice al grafo; sin efecto si ya existe. */
    public void addVertex(T v) {
        if (!index.containsKey(v)) {
            index.put(v, V++);
            adj.add(new ArrayList<>());
        }
    }

    /** Agrega arista no dirigida entre u y v. */
    public void addEdge(T u, T v) {
        addVertex(u); addVertex(v);
        int ui = index.get(u), vi = index.get(v);
        adj.get(ui).add(vi);
        adj.get(vi).add(ui);
    }

    public int            size()              { return V; }
    public int            indexOf(T v)        { return index.getOrDefault(v, -1); }
    public List<Integer>  neighbors(int u)    { return adj.get(u); }
}