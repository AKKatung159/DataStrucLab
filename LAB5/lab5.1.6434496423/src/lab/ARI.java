package lab;

import datastr.ArrayStack;

public class ARI {
    String s;
    String back;
    String backR;
    public ARI(String s,String back,String backR){
        this.back="back \t= "+back;
        this.backR="backR \t= "+backR;
        this.s="s \t\t= "+s;
    }
    public String toString() {
        return  "\n"+s+"\n"+back+"\n"+backR+"\n-----------------------";
    }

    public void setBackR(String backR) {
        this.backR="backR \t= "+backR;
    }

    public void setBack(String back) {
        this.back="back \t= "+back;
    }
}
