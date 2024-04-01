
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph g = new Graph();
        int Select = 0;
        boolean graphCreated = false;

        while (true) {
            switch (Select) {
                case 0:
                    if (!graphCreated) {
                        System.out.println("---------- Please create a graph ---------- ");
                        g.Creategraph();
                        graphCreated = true;
                    }
                    System.out.println("---------- MENU ----------");
                    System.out.println("1. Prim's Algorithm");
                    System.out.println("2. Kruskal's Algorithm");
                    System.out.println("3. Shortest Path");
                    System.out.println("4. CLOSE PROGRAM");
                    System.out.print("Enter your choice: ");
                    Select = sc.nextInt();
                    break;
                case 1:
                if (g.isConnected()) {
                    g.prim();
                } else {
                    System.out.println("Graph is not Connected.");
                    return;
                }
                    System.out.println("-------------------------");
                    System.out.println("0. Back to the Menus");
                    System.out.println("4. Close Program");
                    Select = sc.nextInt();
                    break;
                case 2:
                if (g.isConnected()) {
                    g.kruskal();
                } else {
                    System.out.println("Graph is not Connected.");
                    return;
                }
                    System.out.println("-------------------------");
                    System.out.println("0. Back to the Menus");
                    System.out.println("4. Close Program");
                    Select = sc.nextInt();
                    break;
                case 3:
                if (g.isConnected()) {
                    g.shortestPath();;
                } else {
                    System.out.println("Graph is not Connected.");
                    return;
                }
                    System.out.println("-------------------------");
                    System.out.println("0. Back to the Menus");
                    System.out.println("4. Close Program");
                    Select = sc.nextInt();
                    break;
                case 4:
                    System.out.println("CLOSE PROGRAM");
                    return;
                default:
                    System.out.println("PLEASE CHOOSE A NUMBER FROM THE MENU");
                    Select = 0;
                    break;
            }
        }

    }

}
