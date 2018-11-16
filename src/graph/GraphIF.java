package graph;

import java.util.ArrayList;
import java.util.List;

public interface GraphIF {
	void addVertex(Vertex ... v);
	boolean isEmpty();
	int getVertexCount();
	int getEdgeCount();
	int getSize();
	boolean containsVertex(Vertex v);
	void addEdge(Vertex from, Vertex to);
	boolean isAdjacent(Vertex from, Vertex to);
	List<Vertex> getAdjencencies(Vertex v);
	void unmarkAll();
	void markAll();
	void dfs(Vertex v);
	void bfs(Vertex v);
	void clear();
	boolean hasPredecesor(Vertex v);
	ArrayList<Vertex> getTopologicalOrder();
	List<Vertex> getVerteces();
	Vertex getUnvisited(Vertex v);
	boolean isAllAdjecentVisited(Vertex v);
	
}
