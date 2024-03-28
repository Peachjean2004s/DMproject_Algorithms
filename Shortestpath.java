import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Shortestpath {
    private int vertices;
    private int[][] matrix ;
    Scanner sc = new Scanner(System.in);

    Shortestpath(int v,int [][] m){
        vertices = v ;
        this.matrix = m;
    }

     public void dijkstra(int form, int to) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[form] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{form, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];

            for (int v = 0; v < vertices; v++) {
                if (matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + matrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + matrix[u][v];
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("Shortest distance from vertex " + form + " to vertex " + to + ": " + dist[to]);
    }

}
