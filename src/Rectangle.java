
public class Rectangle extends Polygon{
		private double height, width;
		
		public Rectangle (String id, double height, double width) {
		    //parent class
			super(id);
			//sets equal to instance variables
			this.height = height;
			this.width = width;
			
			//adds lengths to an array list
			sideLengths.add(height); 
			sideLengths.add(width);
			sideLengths.add(height);
			sideLengths.add(width);
			
		}
		
		public String getShapeType() {
		    //returns shape type
				return "Rectangle";
}
		public double getArea() {
		    //calculates and returns area
			return width*height;
		}
}
