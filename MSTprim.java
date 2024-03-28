
class MSTprim {
    private int vertices;

    public MSTprim(int V) {
        vertices = V;
    }

    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v <= vertices; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void primMST(int graph[][]) {
        int parent[] = new int[vertices + 1];
        int key[] = new int[vertices + 1];
        Boolean mstSet[] = new Boolean[vertices + 1];

        for (int i = 1; i <= vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[1] = 0;
        parent[1] = -1;

        for (int count = 1; count <= vertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 1; v <= vertices; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph);
    }

    void printMST(int parent[], int graph[][]) {
        int minimum = 0 ;
        System.out.println("Edge \t  Length");
        for (int i = 2; i <= vertices; i++) {
            if(parent[i] != -1){
                int from = Math.min(parent[i], i);
                int to = Math.max(parent[i], i);
               // System.out.println(parent[i] + " - " + i + "\t      " + graph[i][parent[i]]);
                System.out.println(from + " - " + to + "\t      " + graph[i][parent[i]]);
                minimum += graph[i][parent[i]];
            }
        }
        System.out.println("Minimum Spanning Tree Prim's Algorithm : " + minimum);
    }
}
