package lab;

import datastr.LinearProbingHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
    private Vertex[] arrayVertex;
    private Edge[] arrayEdge;
    private LinearProbingHashMap lphashMap;

    public Graph(int numVer, int numEdge) {
        Random r = new Random();
        arrayVertex = new Vertex[numVer];
        arrayEdge = new Edge[numEdge];
        lphashMap = new LinearProbingHashMap(numVer*numVer);
        for (int i = 0; i < numVer; i++) {
            arrayVertex[i] = new Vertex(i);
        }
        for (int i = 0; i < numEdge; i++) {
            Edge a = new Edge(arrayVertex[r.nextInt(numVer)], arrayVertex[r.nextInt(numVer)]);
            while (true) {
                a = new Edge(arrayVertex[r.nextInt(numVer)], arrayVertex[r.nextInt(numVer)]);
                if (!lphashMap.containsKey(a)) {
                    break;
                }
            }
            arrayEdge[i] = a;
            lphashMap.put(arrayEdge[i], r.nextInt(5) + 1);
        }
    }

    public Graph(int[][] adjacencyMatrix) {
        int k = 0;
        List listVertex = new ArrayList<>();
        List listEdge = new ArrayList<>();
        lphashMap = new LinearProbingHashMap(adjacencyMatrix.length*adjacencyMatrix.length);
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    if (listVertex.contains(new Vertex(i))) {
                    } else {
                        listVertex.add(new Vertex(i));
                    }
                    if (listVertex.contains(new Vertex(j))) {
                    } else {
                        listVertex.add(new Vertex(j));
                    }
                    listEdge.add(new Edge(new Vertex(i), new Vertex(j)));
                    lphashMap.put(listEdge.get(k), adjacencyMatrix[i][j]);
                    k++;
                }
            }
        }
        arrayVertex = new Vertex[listVertex.size()];
        arrayEdge = new Edge[listEdge.size()];
        listVertex.toArray(arrayVertex);
        listEdge.toArray(arrayEdge);
    }

    public int weight(Edge e) {
        if (lphashMap.containsKey(e)) {
            return (int) lphashMap.get(e);
        }
        return 0;
    }

    public int[][] toMatrix() {
        int[][] ans = new int[arrayVertex.length][arrayVertex.length];
        for (int i = 0; i < arrayEdge.length; i++) {
            ans[arrayEdge[i].getSource()][arrayEdge[i].getDest()] = (int) lphashMap.get(arrayEdge[i]);
        }
        return ans;
    }

    public String toString() {
        String ans = "";
        int[][] a = toMatrix();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                ans += (a[i][j] + "\t");
            }
            ans += "\n";
        }
        return ans;
    }
    public String hashToString(){
        String ans="";
        ans+=lphashMap;
        return ans;
    }
}
