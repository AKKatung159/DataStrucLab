public class Point {
    public int x,y,z;
    public Point(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public int getHash(){
        return x*0+y*1+z*2;
    }
}
