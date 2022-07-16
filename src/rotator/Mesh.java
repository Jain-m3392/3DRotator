package rotator;

import java.util.HashSet;
import java.util.regex.*;

import java.io.FileNotFoundException;

public class Mesh extends GraphicalObject {
	public HashSet<Polygon> polygons;
	public MeshReader reader;
	public MeshWriter writer;
	
	public void setReader(MeshReader r) {
		reader = r;
	}
	public void setWriter(MeshWriter w) {
		writer = w;
	}
	
	public void readFromFile(String filename) throws FileNotFoundException {
		//Determine file type & set reader/writer accordingly
		Pattern pattern = Pattern.compile(".ply");
		Matcher matcher = pattern.matcher(filename);
		boolean found = matcher.find();
		if (found) {
			MeshReader r = new PLYMeshReader();
			setReader(r);
		}
		else {
			pattern = Pattern.compile(".obj");
			matcher = pattern.matcher(filename);
			found = matcher.find();
			if (found) {
				MeshReader r = new OBJMeshReader();
				setReader(r);
			}
			else {
				pattern = Pattern.compile(".off");
				matcher = pattern.matcher(filename);
				found = matcher.find();
				if (found) {
					MeshReader r = new OFFMeshReader();
					setReader(r);
				}
			}
		}
		
		//Read file & set polygons
		try {
			polygons = reader.read(filename);
		} catch(Exception FileNotFoundException) {
			System.out.println("File not found.");
		} 

	}
	
	public void writeToFile(String filename) {
		
	}
	
	public boolean equals(Mesh mesh) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public void transform(double[][] matrix) {

	}

}
