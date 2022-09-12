package lab;

import datastr.ArrayStack;

public class ARI {
    String call;
    String ret;
    String s;
    String back;
    String backR;
    public ARI(String type,String s,String back,String backR){
        if(type.equals("r")){
            ret="Return from reverse(\""+s+"\")";
        }
        else {
            call="Call reverse(\""+s+"\")";
        }
        this.back="back \t= "+back;
        this.backR="backR \t= "+backR;
        this.s="s \t\t= "+s;
    }
    public ARI(String s,String back,String backR){
        this.back="back \t= "+back;
        this.backR="backR \t= "+backR;
        this.s="s \t\t= "+s;
    }
    public String toString() {
        String ans="";
        if(call==null){
            ans+=ret;
        }
        else {
            ans+=call;
        }
        ans+="\n"+s+"\n"+back+"\n"+backR+"\n-------------------------------";
        return  ans;
    }
}
