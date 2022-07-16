package rotator;
import java.util.LinkedHashSet;

public class Polygon extends GraphicalObject {
	public LinkedHashSet<Vertex> vertices;
	
	@Override
	public void transform(double[][] matrix) {
		
	}
	
	public Polygon(LinkedHashSet<Vertex> v) {
		for (Vertex element : v) {
			vertices.add(element);
		}
	}
	
	public boolean equals(Polygon polygon) {
		// We assume that order does not matter; polygon [a, b, c] = [c, a, b]
		for (Vertex polyVertex : polygon.vertices) {
			boolean matches = false;
			for (Vertex thisVertex : this.vertices) {
				if (thisVertex == polyVertex) {
					matches = true;
				}
			}
			if (matches == false) {
				return matches;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 0;
		return result;
	}
}
