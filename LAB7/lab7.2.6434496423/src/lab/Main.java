package lab;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception{
        Random random =new Random();
        int num = random.nextInt(5)+6;
        Graph g=new Graph(num,(num*num)/4);
        System.out.println("Adjacency matrix\n"+g+"--------------------------------------------");
        System.out.println("Hash table of edges\n"+g.hashToString());
    }
}