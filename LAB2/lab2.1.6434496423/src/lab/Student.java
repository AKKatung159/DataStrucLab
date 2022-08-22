package lab;

public class Student {
    String ID,Fname,Lname;
    float GPAX;
    public Student(String id,String fname,String lname,Float gpax){
        ID=id; Fname=fname; Lname=lname; GPAX=gpax;
    }

    public Student(String id) {
        ID=id;
    }

    public void setGPAX(float gpax){
        GPAX=gpax;
    }
    public String getID(){
        return ID;
    }
    public String getFname(){
        return Fname;
    }
    public String getLname(){
        return Lname;
    }
    public float getGPAX(){
        return GPAX;
    }
    public boolean equals(Object x){
        if(x instanceof Student && this.getID().equals(((Student) x).getID())){
            return true;
        }
        else {
            return false;
        }
    }
    public String toString(){
        return getID()+","+getFname()+","+getLname()+","+getGPAX();
    }
}
