package dijkstra;

import graph.Vertex;
import graph.WeightedGraph;

public class Main {
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(9, false);
		
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		Vertex i = new Vertex("i");
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);
		
		graph.addEdge(a, b, 6);
		graph.addEdge(a, f, 4);
		graph.addEdge(a, i, 2);

		graph.addEdge(b, c, 7);
		graph.addEdge(b, e, 9);
	
		graph.addEdge(f, g, 2);

		graph.addEdge(c, d, 4);
		graph.addEdge(c, e, 3);

		graph.addEdge(d, h, 1);
		graph.addEdge(d, g, 5);
		graph.addEdge(g, e, 8);
		
		graph.addEdge(i, a, 2);

//		graph.addEdge(a, b, 10);
//		graph.addEdge(a, c, 5);
//		graph.addEdge(c, e, 3);
//		graph.addEdge(c, d, 8);
//		graph.addEdge(e, f, 25);
//		graph.addEdge(e, d, 1);
//		graph.addEdge(b, f, 15);
	
		Djikstra algo = new Djikstra(graph, a);
		
		algo.djikstra();
		algo.printRes();
	}
}
