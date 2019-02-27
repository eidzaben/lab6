import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest {
	// ==================================================================================================================
	// Basic Shape Testing:
	// ==================================================================================================================
	/**
	 * Tests for the square class.
	 */
	@Test
	public void SquareTest() {
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
	 * Tests for the rectangle class.
	 */
	@Test
	public void RectangleTest() {
	    //creating a rectangle
		Shape rect = new Rectangle("rect1", 3.0, 2.0);
		//testing the methods of rectangle
		Assert.assertEquals("Rectangle area incorrect.", 6.0, rect.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 10.0, rect.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rect.getShapeType());
		Assert.assertEquals("Rectangle ID incorrect.", "rect1", rect.getId());
	}

	/**
	 * Tests for the EquilateralTriangle class.
	 */
	@Test
	public void TriangleTest() {

		Shape tri = new EquilateralTriangle("tri1", 3.0);
		
		//testing the methods of triangle
		Assert.assertEquals("Triangle area incorrect.", 3.89711, tri.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 9.0, tri.getPerimeter(), 0.0001);
		Assert.assertEquals("Triangle type incorrect.", "EquilateralTriangle", tri.getShapeType());
		Assert.assertEquals("Triangle's ID incorrect.", "tri1", tri.getId());

	}

	/**
	 * Tests for the trapezoid class. Also test that IDs are done correctly.
	 */
	@Test
	public void TrapezoidTest() { 

		Shape trap = new Trapezoid("trap1", 11.0, 11.0, 7.0, 12.0);
		
		//testing the methods of trapezoid
		Assert.assertEquals("Trapezoid area incorrect.", 101.76535, trap.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 41.0, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trap.getShapeType());
		Assert.assertEquals("Trapezoid's ID incorrect.", "trap1", trap.getId());
	}

	/**
	 * Tests for the ellipse class. Also test that IDs are done correctly.
	 */
	@Test
	public void EllipseTest() { 
	    
	    //creating an ellipse
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		
		//testing ellipse
		Assert.assertEquals("Ellipse area incorrect.", Math.PI * 3.0 * 3.0, circ.getArea(), 0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2), circ.getPerimeter(), 0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse", circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());
		
		//creating a new ellipse
		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		
		//testing ellipse even more
		Assert.assertEquals("Ellipse area incorrect.", Math.PI * 3 * 5, circs.getArea(), 0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2), circs.getPerimeter(), 0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse", circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
	 * Tests for the circle class. Also test that IDs are done correctly.
	 */ 
	@Test
	public void CircleTest() {
	    //creating a circle
		Shape circ = new Circle("circle1", 3.0);
		
		//testing the methods of circle
		Assert.assertEquals("circle1 area incorrect.", 28.27433, circ.getArea(), 0.0001);
		Assert.assertEquals("circle1 perimeter incorrect.", 18.84956, circ.getPerimeter(), 0.0001);
		Assert.assertEquals("circle1 type incorrect.", "Circle", circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "circle1", circ.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest() {
		// creating a rectangle
		Shape rect = new Rectangle("R1", 3.0, 3.0);
		
		//Comparable strings
		String correct = "Rectangle:\t ID = R1\t area = 9.000\t perimeter = 12.000";
		String incorrect = "yo";
		 
		//testing toString
		Assert.assertEquals("ToStrings should be equal", correct, rect.toString());
		Assert.assertFalse("Should not match", incorrect.equals(rect.toString()));
		
		
	}

	// ==================================================================================================================
	// Comparisons:
	// ==================================================================================================================
	/**
	 * Tests for the Shape Area Comparator class.
	 */
	@Test
	public void CompareAreaTest() {
		// Test equals:
		Shape rect = new Rectangle("R1", 3.0, 3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
		Shape rect2 = new Rectangle("R2", 1.0, 9.0);
		Shape sqr2 = new Square("S2", 5.0);
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

		// Test unequal perimeter and area:
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
		Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
		Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
	 * Tests for the Shape Perimter Comparator class.
	 */
	@Test 
	public void ComparePerimeterTest() {

		// Test equals:
		Shape rect = new Rectangle("R1", 3.0, 3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test unequal perimeter
		Shape rect2 = new Rectangle("R2", 1.0, 2.0); // Perim: 6
		Shape sqr2 = new Square("S2", 5.0); // Perim: 20
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

		// Test unequal perimeter and area:
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));

	} 

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test 
	public void NaturalCompareTest() {
		// Test equals:
		Shape rect = new Rectangle("R1", 3.0, 3.0);
		Shape sqr = new Square("S1", 3.0);
		//ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("CompareTo Check", 0, rect.compareTo(sqr));
		

		// Test equal perimeter, different area:
		Shape rect2 = new Rectangle("R2", 1.0, 9.0); // Perim: 20
		Shape sqr2 = new Square("S2", 5.0); // Perim: 20
		Assert.assertEquals("CompareTo Check", -1, rect2.compareTo(sqr2));
		

		// Test unequal perimeter and area:
		Shape rect3 = new Rectangle("R2", 1.0, 3.0); 
        Shape sqr3 = new Square("S2", 5.0); 
		Assert.assertEquals("CompareTo Check", -1, rect3.compareTo(sqr3));
		

	}
}
