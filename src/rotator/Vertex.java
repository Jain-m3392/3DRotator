package rotator;

public class Vertex extends GraphicalObject{
	public double xCoord;
	public double yCoord;
	public double zCoord;
	
	public Vertex(double x, double y, double z) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}
	
	@Override
	public void transform(double[][] matrix) {
		
	}
	
	public boolean equals(Vertex vertex) {
		if (this.xCoord != vertex.xCoord) {
			return false;
		} else if (this.yCoord != vertex.yCoord) {
			return false;
		} else if (this.zCoord != vertex.zCoord) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public int hashCode() {
		double result = this.xCoord * 2;
		result = result * 1000 + this.yCoord * 3;
		result = result * 1000 + this.zCoord * 5;
		int intResult = (int)result;
		return intResult;
	}
	
	@Override
	public String toString() {
		return this.xCoord + " " + this.yCoord + " " + this.zCoord;
	}
}
