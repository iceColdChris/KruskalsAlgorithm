import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class Kruskals {

	public static List<Edge> KruskalsAlgorithm(SimpleGraph graph){
		PriorityQueue<Edge> pq =  sortEdges(graph.edgeList);

		List<Edge> acceptedEdges = new LinkedList<Edge>();
		int edgeCounter = 0;
		//DisjointSet set = new DisjointSet(graph.numEdges());
		UpTree set = new UpTree(graph.vertexList);
		while(edgeCounter < graph.numVertices() -1){
			Edge e = pq.poll();

			Object firstVertex = e.getFirstEndpoint().getName();
			Object secondVertex= e.getSecondEndpoint().getName();

			Object set1 = set.find(firstVertex);
			Object set2 = set.find(secondVertex);


			if(!set1.equals(set2)){
				edgeCounter++;
				set.union(set1, set2);
				acceptedEdges.add(e);	
			}

		}
		return acceptedEdges;		
	}


	private static PriorityQueue<Edge> sortEdges(LinkedList<Edge> edges){
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(1, new EdgeComparator());

		for(Edge e : edges){
			pq.add(e);
		}

		return pq;
	}
}
