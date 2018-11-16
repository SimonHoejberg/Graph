package graph;

public class TopologicalOrder {
	public static void main(String[] args) {
		GraphIF graph = new MatrixGraph(14);
		
		Vertex m = new Vertex("m");
		Vertex q = new Vertex("q");
		Vertex t = new Vertex("t");
		Vertex n = new Vertex("n");
		Vertex u = new Vertex("u");
		Vertex r = new Vertex("r");
		Vertex v = new Vertex("v");
		Vertex y = new Vertex("y");
		Vertex w = new Vertex("w");
		Vertex p = new Vertex("p");
		Vertex s = new Vertex("s");
		Vertex o = new Vertex("o");
		Vertex z = new Vertex("z");
		Vertex x = new Vertex("x");
		
		graph.addVertex(m);
		graph.addVertex(q);
		graph.addVertex(t);
		graph.addVertex(n);
		graph.addVertex(u);
		graph.addVertex(r);
		graph.addVertex(v);
		graph.addVertex(y);
		graph.addVertex(w);
		graph.addVertex(p);
		graph.addVertex(s);
		graph.addVertex(o);
		graph.addVertex(z);
		graph.addVertex(x);

		graph.addEdge(m, q);
		graph.addEdge(m, x);
		graph.addEdge(m, r);
		graph.addEdge(n, q);
		graph.addEdge(n, u);
		graph.addEdge(n, o);
		graph.addEdge(u, t);
		graph.addEdge(r, y);
		graph.addEdge(r, u);
		graph.addEdge(v, x);
		graph.addEdge(v, w);
		graph.addEdge(y, v);
		graph.addEdge(w, z);
		graph.addEdge(p, o);
		graph.addEdge(p, s);
		graph.addEdge(p, z);
		graph.addEdge(s, r);
		graph.addEdge(o, r);
		graph.addEdge(o, v);
		graph.addEdge(o, s);
		
		graph.addEdge(q, t);
		
		for (Vertex vertex : graph.getTopologicalOrder()) {
			System.out.println(vertex.getName());
		}
		
		
	}
}
