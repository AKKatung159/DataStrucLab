import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception{
        Random random =new Random();
        int num = random.nextInt(5)+6;
        Graph g1=new Graph(7,10);
        System.out.println("Random adjacency matrix of graph 1\n"+g1+"--------------------------------------------");
        Graph g1c=new Graph(g1.toMatrix());
        System.out.println("Adjacency matrix create from graph 1\n"+g1c+"--------------------------------------------");
        Graph g2=new Graph(num,(num*num)/4);
        System.out.println("Adjacency matrix create from graph 2\n"+g2+"--------------------------------------------");
    }
}