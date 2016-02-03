
import java.util.Comparator;
 
 
public class EdgeComparator implements Comparator<Edge> {
 
    @Override
    public int compare(Edge a, Edge b) {
        return  (int)a.getData() - (int)b.getData();
    }
}