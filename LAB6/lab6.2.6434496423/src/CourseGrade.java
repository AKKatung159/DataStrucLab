public class CourseGrade {
    String CID,Cname,year;
    int semester;
    double credit,grade;
    public CourseGrade(String CID,String Cname,int semester,String year,double credit,double grade){
        this.CID=CID;
        this.Cname=Cname;
        this.year=year;
        this.semester=semester;
        this.credit=credit;
        this.grade=grade;
    }
    public String toString() {
        return CID+" "+Cname+" "+year+"/"+semester+" "+credit+" "+grade;
    }
}
