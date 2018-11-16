package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedGraph implements GraphIF{
	
	private List<Vertex> vertices;
	private List<LinkedList<Vertex>> adjList;
	
	public LinkedGraph(int initSize) {
		init(initSize);
	}
	
	public void init(int initSize) {
		vertices = new ArrayList<>(initSize);
		adjList = new ArrayList<LinkedList<Vertex>>(initSize);
	}
	
	@Override
	public void addVertex(Vertex ... v) {
		for (Vertex vertex : v) {
			vertices.add(vertex);
			adjList.add(new LinkedList<Vertex>());
		}
	}

	@Override
	public boolean isEmpty() {
		return getVertexCount() == 0;
	}

	@Override
	public int getVertexCount() {
		int res = 0;
		if (vertices != null) {
			res = vertices.size();
		}
		return res;
	}

	@Override
	public int getEdgeCount() {
		int res = 0;
		
		if(adjList != null) {
			for (int i = 0; i < adjList.size(); i++) {
				res += adjList.get(i).size();
			}
		}
		return res;
	}

	@Override
	public int getSize() {
		return getEdgeCount() + getVertexCount();
	}

	@Override
	public boolean containsVertex(Vertex v) {
		return vertices.indexOf(v) >= 0;
	}

	@Override
	public void addEdge(Vertex from, Vertex to) {
		int indexOf = vertices.indexOf(from);
		adjList.get(indexOf).add(to);
	}

	@Override
	public boolean isAdjacent(Vertex from, Vertex to) {
		int indexOf = vertices.indexOf(from);
		return adjList.get(indexOf).contains(to);
	}

	@Override
	public List<Vertex> getAdjencencies(Vertex v) {
		int index = vertices.indexOf(v);
		List<Vertex> res = null;
		if(index >= 0) {
			res = new LinkedList<Vertex>(this.adjList.get(index)); 
		}
		return res;
	}

	@Override
	public void unmarkAll() {
		for(Vertex vertex : vertices) {
			vertex.setMark(false);
		}
	}

	@Override
	public void markAll() {
		for(Vertex vertex : vertices) {
			vertex.setMark(true);
		}
	}

	@Override
	public void dfs(Vertex v) {
		System.out.println(v.getName());
		v.setMark(true);
		List<Vertex> verteces = getAdjencencies(v);
		for (Vertex vertex : verteces) {
			if(!vertex.isMark()) {
				dfs(vertex);
			}
		}
	}

	@Override
	public void bfs(Vertex v) {
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(v);
		while(!queue.isEmpty()) {
			Vertex curVertex = queue.poll();
			System.out.println(curVertex.getName());
			List<Vertex> adjecent = getAdjencencies(curVertex);
			for (Vertex vertex : adjecent) {
				if(!vertex.isMark()) {
					vertex.setMark(true);
					queue.add(vertex);
				}
			}
		}
		
	}

	@Override
	public void clear() {
		for (int i = 0; i < vertices.size(); i++) {
			adjList.get(i).clear();
		}
		vertices.clear();
		
	}

	@Override
	public boolean hasPredecesor(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Vertex> getTopologicalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vertex> getVerteces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex getUnvisited(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAllAdjecentVisited(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

}
