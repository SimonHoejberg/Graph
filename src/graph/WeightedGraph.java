package graph;

public class WeightedGraph extends MatrixGraph{

	private int[][] weight; 
	private boolean directed;
	
	
	public WeightedGraph(int size, boolean directed) {
		super(size);
		weight = new int[size][size];
		this.directed = directed;
	}
	
	public void addEdge(Vertex from, Vertex to, int weight) {
		int indexFrom = getVerteces().indexOf(from);
		int indexTo = getVerteces().indexOf(to);
		
		addEdge(from, to);
		this.weight[indexFrom][indexTo] = weight;
		if(!directed) {
			addEdge(to, from);
			this.weight[indexTo][indexFrom] = weight;
		}
	}
	
	public int getWeight(Vertex from, Vertex to) {
		return weight[getVerteces().indexOf(from)][getVerteces().indexOf(to)];
	}
}
