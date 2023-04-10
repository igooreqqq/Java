public class Main {

    public static void main(String[] args) throws Exception{

        Graph graph = new Graph();

        graph.readGraphFromFile("src/floyd.txt");
        graph.sortNeighbours();

        graph.printAllNeighbourIndices();

        System.out.println("\nCzy istnieje krawedz 3 - 6 przed jej usunieciem?");
        System.out.println(graph.checkEdge(3, 6));
        graph.removeEdge(3, 6);
        System.out.println("\nCzy istnieje krawedz 3 - 6 po jej usunieciu?");
        System.out.println(graph.checkEdge(3, 6));

        System.out.println();
        System.out.print("BFS: ");
        graph.bfs(5);
        System.out.print("DFS: ");
        graph.dfs(5);
        System.out.println();
        System.out.println();
        System.out.print("Macierz floyda: ");
        graph.floyd();
    }
}