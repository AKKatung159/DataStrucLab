package lab;

import java.util.Objects;

public class Edge {
    private Vertex st,end;
    public Edge(Vertex b, Vertex e){
        st=b;
        end=e;
    }
    public int getSource(){
        return st.getName();
    }
    public int getDest(){
        return end.getName();
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(st.getName(), edge.st.getName()) && Objects.equals(end.getName(), edge.end.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(st.getName(), end.getName());
    }

    @Override
    public String toString() {
        return getDest()+" - "+getSource();
    }
}
