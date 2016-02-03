import java.util.List;


public class Main {

	public static void main(String[] args){
		SimpleGraph G = new SimpleGraph();
		Vertex a, b, c,d;
		Edge e,f, g, h, i, j;


		a = G.insertVertex(null, "a");
		b = G.insertVertex(null, "b");
		c = G.insertVertex(null, "c");
		d = G.insertVertex(null, "d");

		G.insertEdge(a, b, 1, "A,B");
		G.insertEdge(b, d, 2, "B,D");
		G.insertEdge(d, c, 3, "D,C");
		G.insertEdge(c, a, 4, "C,A");
		G.insertEdge(a, d, 5, "A,D");
		G.insertEdge(c, b, 6, "C,B");


		List<Edge> list = Kruskals.KruskalsAlgorithm(G);

		for(Edge edge: list){
			System.out.println("Edge: " + edge.getName() + " with weight " + edge.getData()
					+ " Is part of the minimum spanning tree");
		}

	}
}
