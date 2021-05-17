import java.util.LinkedList;

public class Graph {
    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        adj[v].listIterator();
    }
}
