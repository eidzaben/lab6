
public class Rectangle extends Polygon{
		private double height, width;
		
		public Rectangle (String id, double height, double width) {
			super(id);
			this.height = height;
			this.width = width;
			sideLengths.add(height);
			sideLengths.add(width);
			sideLengths.add(height);
			sideLengths.add(width);
			
		}
		
		public String getShapeType() {
				return "Rectangle";
}
		public double getArea() {
			return width*height;
		}
}
