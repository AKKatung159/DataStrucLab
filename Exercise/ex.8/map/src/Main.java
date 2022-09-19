public class Main {
    public static void main(String[] args) {
        System.out.println(new Point(1,2,3).getHash());
        System.out.println(new Point(3,2,1).getHash());
        System.out.println(new Point(1,3,2).getHash());
        System.out.println(new Point(0,2,1).getHash());
        System.out.println(new Point(0,1,2).getHash());
    }
}