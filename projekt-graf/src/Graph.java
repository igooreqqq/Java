import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Graph {

    ArrayList<ArrayList<Edge>> vertexList = new ArrayList<>();
    ArrayList<Integer> visited_BFS = new ArrayList<>();
    ArrayList<Integer> visited_DFS = new ArrayList<>();
    LinkedList<Integer> queue = new LinkedList<>();

    public Graph() {

    }

    public void createVertices(int ile) {
        for(int i = 0; i < ile; i++) {
            ArrayList<Edge> vec = new ArrayList<>();
            vertexList.add(vec);
        }
    }

    void addEdge(int i_Vertex_Index_1, int i_Vertex_Index_2, int weight) {
        vertexList.get(i_Vertex_Index_1).add(new Edge(i_Vertex_Index_1, i_Vertex_Index_2, weight));
    }

    void removeEdge(int i_Vertex_Index_1, int i_Vertex_Index_2) {
        for(int i = 0; i < vertexList.get(i_Vertex_Index_1).size(); i++) {
            if(vertexList.get(i_Vertex_Index_1).get(i).vertex_Index2 == i_Vertex_Index_2) {
                vertexList.get(i_Vertex_Index_1).remove(vertexList.get(i_Vertex_Index_1).get(i));
            }
        }
    }

    boolean checkEdge(int i_Vertex_Index_1, int i_Vertex_Index_2) {
        for(int i = 0; i < vertexList.get(i_Vertex_Index_1).size(); i++) {
            if(vertexList.get(i_Vertex_Index_1).get(i).vertex_Index2 == i_Vertex_Index_2) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfEdges() {
        int edgeCounter = 0;

        for(int i = 0; i < vertexList.size(); i++) {
            edgeCounter += vertexList.get(i).size();
        }

        return edgeCounter;
    }

    int graphDegree(int idx) {
        return vertexList.get(idx).size();
    }

    public int getWeight(int i_Vertex_Index_1, int i_Vertex_Index_2) {
        return vertexList.get(i_Vertex_Index_1).get(i_Vertex_Index_2).weight;
    }

    public void clearGraph() {
        vertexList.clear();
    }

    public void printNeighbourIndices(int idx) {
        System.out.print("Sasiedzi wierzcholka " + idx + ": ");

        for(int j = 0; j < vertexList.get(idx).size(); j++) {
            System.out.print(vertexList.get(idx).get(j).vertex_Index2 + " waga: " + vertexList.get(idx).get(j).weight + ", ");
        }
        System.out.println();
    }

    public void printAllNeighbourIndices() {
        for(int i = 0; i < vertexList.size(); i++) {
            System.out.print("Sasiedzi wierzcholka " + i + ": ");

            for(int j = 0; j < vertexList.get(i).size(); j++) {
                System.out.print(vertexList.get(i).get(j).vertex_Index2 + " waga: " + vertexList.get(i).get(j).weight + ", ");
            }
            System.out.println();
        }
    }

    public void readGraphFromFile(String path) throws Exception{
        if(!vertexList.isEmpty())
            this.clearGraph();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            int first = 0, second = 0, third = 0;
            int counter = 0;

            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.trim().split("\\s+");

                if(counter == 0) {
                    first = Integer.parseInt(values[0]);
                    this.createVertices(first);
                    counter++;
                } else {
                    first = Integer.parseInt(values[0]);
                    second = Integer.parseInt(values[1]);
                    third = Integer.parseInt(values[2]);
                    this.addEdge(first, second, third);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortNeighbours() {
        for(int i = 0; i < vertexList.size(); i++) {
            Collections.sort(vertexList.get(i), new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Integer.compare(o1.vertex_Index2, o2.vertex_Index2);
                }
            });
        }
    }

    public void bfs(int vertex) {
        visited_BFS.add(vertex);
        queue.add(vertex);

        while(!queue.isEmpty()) {
            int m = queue.remove();
            System.out.print(m + ", ");

            for(Edge i : vertexList.get(m)) {
                if(!visited_BFS.contains(i.vertex_Index2)) {
                    visited_BFS.add(i.vertex_Index2);
                    queue.add(i.vertex_Index2);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int vertex) {
        if(!visited_DFS.contains(vertex)) {
            System.out.print(vertex + ", ");

            visited_DFS.add(vertex);
            for(Edge i : vertexList.get(vertex)) {
                dfs(i.vertex_Index2);
            }
        }
    }

    public void floyd() {
        int v = vertexList.size();

        int dist[][] = new int[v][v];

        for(int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 999999;
                }
            }
        }

        for(int i = 0; i < vertexList.size(); i++) {
            for(int j = 0; j < vertexList.get(i).size(); j++) {
                dist[i][vertexList.get(i).get(j).vertex_Index2] = vertexList.get(i).get(j).weight;
            }
        }

        for(int k = 0; k < v; k++) {
            for(int i = 0; i < v; i++) {
                for(int j = 0; j < v; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for(int i = 0; i < v; i++) {
            System.out.println();
            for(int j = 0; j < v; j++) {
                System.out.print(String.format("%-10d", dist[i][j]));
            }
        }
    }
}
