package graph;

public class Vertex {
	private boolean mark;
	private String name;
	
	public Vertex(String name) {
		this.name = name;
		mark = false;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
