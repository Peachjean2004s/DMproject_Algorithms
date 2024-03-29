import java.util.Scanner;

class Graph {
    Scanner sc = new Scanner(System.in);
    int vertices;
    int edges;
    int[][] MatrixGraph;
    MSTprim m ;
    Shortestpath sp = new Shortestpath();
    MSTKruskal k = new MSTKruskal() ;

    void Creategraph() {
        
        System.out.println("Enter the number of vertices : ");
        vertices = sc.nextInt();
        System.out.println("Enter the number of edges : ");
        edges = sc.nextInt();
        MatrixGraph = new int[vertices + 1][vertices + 1];
        m = new MSTprim(vertices);


        for (int i = 1; i <= edges; i++) {
            System.out.println("Enter details for edge " + i + ":");
            System.out.print("From vertex : ");
            int from = sc.nextInt();
            System.out.print("To vertex : ");
            int to = sc.nextInt();
            if (MatrixGraph[from][to] != 0 || MatrixGraph[to][from] != 0) {
                System.out.println("Edge already exists.");
                return;
            }
            System.out.print("Label : ");
            int label = sc.nextInt();
            MatrixGraph[from][to] = label;
            MatrixGraph[to][from] = label;
        }

        if (vertices < 2 || edges < 1 ) {
            System.out.println("The graph is not correct. It should have at least 2 vertices and 1 edge.");
            return;
        }
        if (isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }
       
    }

    void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int i = 1; i <= vertices; i++) {
            if (MatrixGraph[vertex][i] != 0 && !visited[i]) {
                DFS(i, visited);
            }
        }
    }

    boolean isConnected() {
        boolean[] visited = new boolean[vertices + 1];
        DFS(1, visited);
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    void prim(){
        System.out.println("---------- Prim's Minimum Spanning Tree Algorithm ----------");
        m.prim(MatrixGraph);
    }

    void kruskal(){
        System.out.println("---------- Kruskal's Minimum Spanning Tree Algorithm ----------");
        k.kruskals(MatrixGraph);
      
    }

    void  shortestPath() {
        System.out.println("---------- Find the shortest path Dijkstra's Algorithm ----------");
        Shortestpath.shortestpath(MatrixGraph, vertices);
    }
}