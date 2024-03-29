import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Shortestpath {
    public static void shortestpath(int[][] MatrixGraph, int vertices) {
        Scanner sc = new Scanner(System.in);
        System.out.print("From vertex: ");
        int from = sc.nextInt();
        System.out.print("To vertex: ");
        int to = sc.nextInt();

        if (from < 1 || from > vertices || to < 1 || to > vertices) {
            System.out.println("Invalid");
            return;
        }
        int[] distance = new int[vertices + 1];
        int[] parent = new int[vertices + 1]; 
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[from] = 0; 

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> distance[vertex]));
        pq.offer(from); 

        while (!pq.isEmpty()) {
            int currentVertex = pq.poll();

            for (int neighbor = 1; neighbor <= vertices; neighbor++) {
                if (MatrixGraph[currentVertex][neighbor] != 0) {
                    int newDistance = distance[currentVertex] + MatrixGraph[currentVertex][neighbor];
                    if (newDistance < distance[neighbor]) {
                        distance[neighbor] = newDistance;
                        parent[neighbor] = currentVertex;
                        pq.offer(neighbor); 
                    }
                }
            }
        }

        if (distance[to] == Integer.MAX_VALUE) {
            System.out.println("There is no path from vertex " + from + " to vertex " + to + ".");
        } else {
              System.out.println("Edge    Length");
              int currentVertex = to;
              StringBuilder pathBuilder = new StringBuilder();
              while (currentVertex != from) {
                  int parentVertex = parent[currentVertex];
                  pathBuilder.insert(0, "" + parentVertex + " - " + currentVertex + "     " + MatrixGraph[currentVertex][parentVertex] + "\n");
                  currentVertex = parentVertex;
              }
              System.out.print(pathBuilder);
            System.out.println("Shortest distance from vertex " + from + " to vertex " + to + " is : " + distance[to]);

        }
    }
}
