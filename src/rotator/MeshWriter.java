package rotator;
import java.util.HashSet;

public interface MeshWriter {
	public void write(String filename, HashSet<Polygon> polygons);
}
