package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MatrixGraph implements GraphIF{

	private Vertex[][] matrix;
	private List<Vertex> verteces;
	private int size;
	
	public MatrixGraph(int size) {
		matrix = new Vertex[size][size];
		verteces = new ArrayList<Vertex>();
		this.size = size;
	}
	
	@Override
	public void addVertex(Vertex ... v) {
		for (Vertex vertex : v) {
			verteces.add(vertex);
		}	
	}

	@Override
	public boolean isEmpty() {
		return verteces.size() <= 0;
	}

	@Override
	public int getVertexCount() {
		return verteces.size();
	}

	@Override
	public int getEdgeCount() {
		int res = 0;
		for(int i = 0; i < size; i++) 
			for(int j = 0; j < size; j++) 
				if(matrix[i][j] != null) 
					res++;
		return res;
	}

	@Override
	public int getSize() {
		return getVertexCount() + getEdgeCount();
	}

	@Override
	public boolean containsVertex(Vertex v) {
		return verteces.contains(v);
	}

	@Override
	public void addEdge(Vertex from, Vertex to) {
		int indexFrom = verteces.indexOf(from);
		int indexTo = verteces.indexOf(to);
		matrix[indexFrom][indexTo] = to;	
	}
	
	@Override
	public boolean isAdjacent(Vertex from, Vertex to) {
		int indexFrom = verteces.indexOf(from);
		int indexTo = verteces.indexOf(to);
		return matrix[indexFrom][indexTo] != null;
	}

	@Override
	public List<Vertex> getAdjencencies(Vertex v) {
		List<Vertex> res = new ArrayList<>();
		int indexOf = verteces.indexOf(v);
		for (int i = 0; i < size; i++) {
			Vertex curVertex = matrix[indexOf][i];
			if(curVertex != null) {
				res.add(curVertex);
			}
		}
		return res;
	}

	@Override
	public void unmarkAll() {
		verteces.forEach(i -> i.setMark(false));
	}

	@Override
	public void markAll() {
		verteces.forEach(i -> i.setMark(true));
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
		while (!queue.isEmpty()) {
			Vertex curVer = queue.poll();
			List<Vertex> adjecent = getAdjencencies(curVer);
			System.out.println(curVer.getName());
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
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = null; 
			}
		}
		verteces.clear();
	}
	
	@Override
	public boolean hasPredecesor(Vertex v) {
		int indexOf = verteces.indexOf(v);
		boolean res = false;
		for(int i = 0; i < size; i++) {
			if(matrix[i][indexOf] != null) {
				res = true;
			}
		}
		return res;
	}
	
	@Override
	public boolean isAllAdjecentVisited(Vertex v) {
		boolean res = true;
		
		for (Vertex vertex : getAdjencencies(v)) {
			if(!vertex.isMark()) {
				res = false;
			}
		}
		return res;
	}
	
	@Override
	public Vertex getUnvisited(Vertex v) {
		Vertex res = null;
		for (Vertex vertex : getAdjencencies(v)) {
			if(!vertex.isMark()) {
				res = vertex;
			}
		}
		return res;
	}
	
	@Override
	public ArrayList<Vertex> getTopologicalOrder() {
		ArrayList<Vertex> res = new ArrayList<>();
		Stack<Vertex> s = new Stack<>();
		for (Vertex vertex : verteces) {
			if(!hasPredecesor(vertex)) {
				s.push(vertex);
				vertex.setMark(true);
			}
		}
		while(!s.isEmpty()) {
			Vertex top = s.peek();
			if(isAllAdjecentVisited(top)) {
				res.add(0, s.pop());
			}
			else {
				Vertex v = getUnvisited(s.peek());
				s.push(v);
				v.setMark(true);
			}
		}
		return res;
	}

	@Override
	public List<Vertex> getVerteces() {
		return verteces;
	}
}
