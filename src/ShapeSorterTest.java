import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter. Implicitly tests that the comparators are
 * implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
    /**
     * Test that shapes are added correctly.
     */
    @Test
    public void AddShapeTest()
    {
        //creates a shape sorter
        ShapeSorter sorter = new ShapeSorter();
        
        //creating four shapes
        Shape a = new Rectangle("test", 3, 3);
        Shape b = new EquilateralTriangle("test2", 4);
        Shape c = new Square("test3", 3);
        Shape d = new Circle("test4", 1.5);
        
        //adding shapes to array list
        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);

        //Assert Equal tests
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
    }

    /**
     * Tests sorting via the default ordering.
     */
    @Test
    public void SortShapesDefaultTest()
    {

        ShapeSorter sort = new ShapeSorter();

        Shape a = new Rectangle("test", 20, 5); // 100, 50
        Shape b = new EquilateralTriangle("test2", 2); // 1.73, 6
        Shape c = new Square("test3", 10); // 100, 40
        Shape d = new Circle("test4", 5); // 78.4, 31.42

        // Adding shapes to sort
        sort.addShape(a);
        sort.addShape(b);
        sort.addShape(c);
        sort.addShape(d);
        
        // Sorting the order
        sort.sortShapes();

        //Assert Equal tests
        Assert.assertEquals("Order Incorrect", b, sort.shapes.get(0)); 
        Assert.assertEquals("Order Incorrect", d, sort.shapes.get(1));
        Assert.assertEquals("Order Incorrect", c, sort.shapes.get(2));
        Assert.assertEquals("Order Incorrect", a, sort.shapes.get(3));

    }

    /**
     * Tests sorting by area ordering.
     */
    @Test
    public void SortShapesAreaTest()
    {
        // TODO: complete this...
        ShapeSorter sort = new ShapeSorter();

        Shape a = new Rectangle("test", 20, 5); // 100, 50
        Shape b = new EquilateralTriangle("test2", 2); // 1.73, 6
        Shape c = new Square("test3", 9); // 81, 40
        Shape d = new Circle("test4", 5); // 78.4, 31.42
      
        //adds shapes to sort
        sort.addShape(a);
        sort.addShape(b);
        sort.addShape(c);
        sort.addShape(d);
        
        //sorts the shapes by area
        sort.sortShapes(new ShapeAreaComparator());

        //Assert Equal tests
        Assert.assertEquals("Order Incorrect", b, sort.shapes.get(0));
        Assert.assertEquals("Order Incorrect", d, sort.shapes.get(1));
        Assert.assertEquals("Order Incorrect", c, sort.shapes.get(2));
        Assert.assertEquals("Order Incorrect", a, sort.shapes.get(3));

    }

    /**
     * Tests sorting by perimeter ordering.
     */
    @Test
    public void SortShapesPerimeterTest()
    {
        // TODO: complete this...
        ShapeSorter sort = new ShapeSorter();

        Shape a = new Rectangle("test", 20, 5); // 100, 50
        Shape b = new EquilateralTriangle("test2", 2); // 1.73, 6
        Shape c = new Square("test3", 10); // 100, 40
        Shape d = new Circle("test4", 5); // 78.4, 31.42
        
        //adding shapes to sort
        sort.addShape(a);
        sort.addShape(b);
        sort.addShape(c); 
        sort.addShape(d);
        
        //sorts the shapes by perimeter
        sort.sortShapes(new ShapePerimeterComparator());

        //Assert Equal tests
        Assert.assertEquals("Order Incorrect", b, sort.shapes.get(0));
        Assert.assertEquals("Order Incorrect", d, sort.shapes.get(1));
        Assert.assertEquals("Order Incorrect", c, sort.shapes.get(2));
        Assert.assertEquals("Order Incorrect", a, sort.shapes.get(3));

    }

    /**
     * Tests the toString.
     */
    @Test
    public void ToStringTest()
    {
       //creating a shape sorter
    ShapeSorter sort = new ShapeSorter();
    
    //creating two shapes
    Shape a = new Rectangle("test", 20, 5); // 100, 50
    Shape b = new EquilateralTriangle("test2", 2); // 1.73, 6
    
    //adding the shapes
    sort.addShape(a);
    sort.addShape(b);
    
    //What it should be
    String expected = sort.shapes.get(0).toString() + " " + sort.shapes.get(1).toString() + " ";
    //Assert Equal tests
    Assert.assertEquals("ToString incorrect", expected, sort.toString());
    
        
        
    }
}
