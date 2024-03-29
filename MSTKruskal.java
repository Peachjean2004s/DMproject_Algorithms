import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MSTKruskal {
    
    class Edge {
        int form, to, length;
        
        public Edge(int form, int to, int length) {
            this.form = form;
            this.to = to;
            this.length = length;
        }
    }

    class Subset {
        int parent, rank;
        
        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    private void union(Subset[] subsets, int x, int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    private int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    public void kruskals(int[][] matrix) {
        int V = matrix.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (matrix[i][j] != 0) {
                    edges.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
        
        edges.sort(Comparator.comparingInt(e -> e.length));

        int j = 0;
        int noOfEdges = 0;
        Subset[] subsets = new Subset[V];
        Edge[] results = new Edge[V];

        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        System.out.println("Edge    Length");

        while (noOfEdges < V - 1 && j < edges.size()) {
            Edge nextEdge = edges.get(j);
            int x = findRoot(subsets, nextEdge.form);
            int y = findRoot(subsets, nextEdge.to);

            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }

        int minimum = 0;
        for (int i = 0; i < V - 1; i++) {
            if(results[i] != null){
            System.out.println(results[i].form + " - " + results[i].to+ "     " + results[i].length);
            minimum += results[i].length;
            }
        }
        System.out.println("Minimum Spanning Tree Kruskal's Algorithm : " + minimum);
    }

}
