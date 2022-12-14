package lab;

import java.util.Objects;

public class Vertex {
    private int name;
    public Vertex(int name){
        this.name=name;
    }
    public int getName(){
        return name;
    }
    public String toString() {
        return ""+name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name == vertex.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
