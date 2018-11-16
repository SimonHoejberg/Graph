package dijkstra;


import java.util.ArrayList;
import java.util.List;

import graph.Vertex;
import graph.WeightedGraph;

public class Djikstra {
	WeightedGraph graph;
	Vertex source;
	Integer dist[];
	Vertex prev[];
	List<Vertex> verteces;
	Object[] q;
	List<Vertex> list;
	
	public Djikstra(WeightedGraph graph, Vertex source) {
		this.graph = graph;
		this.source = source;
		list = new ArrayList<Vertex>();
	}
	
	public void djikstra() {
		verteces = new ArrayList<>(graph.getVerteces());
		list = graph.getVerteces();
		q = verteces.toArray();
		dist = new Integer[verteces.size()];
		prev = new Vertex[verteces.size()];
		int temp0 = Integer.MAX_VALUE;
		
		dist[verteces.indexOf(source)] = 0;
		
		while(!verteces.isEmpty()) {
			int ver = 0;
			for (int i = 0; i < dist.length; i++) {
				if(q[i] != null) {
					if(dist[i] != null && dist[i] < temp0) {
						temp0 = dist[i];
						ver = i;
					}
				}
			}
			
			Vertex u = verteces.get(ver);
			verteces.remove(u);
			q[ver] = null;

			for (Vertex v : graph.getAdjencencies(u)) {
				int temp = dist[list.indexOf(u)] == null ? 0 : dist[list.indexOf(u)] + graph.getWeight(u, v);
				if(dist[list.indexOf(v)] == null || temp < dist[list.indexOf(v)]) {
					dist[list.indexOf(v)] = temp;
					prev[list.indexOf(v)] = u;
				}
			}
		}
	}
	
	public void printRes() {
		String previous = null;
		for (int i = 0; i < dist.length; i++) {
			previous = prev[i] != null ? prev[i].getName() : "-";
			System.out.println(list.get(i).getName() + " "+ dist[i] + " " + previous);
		}
	}
	
}
