
public class Square extends Rectangle {
	public Square(String id, double size) {
	    //parent class
		super(id, size, size);
		
	}
	
	public String getShapeType() {
	    //returns shape type
		return "Square";
	}

}
 