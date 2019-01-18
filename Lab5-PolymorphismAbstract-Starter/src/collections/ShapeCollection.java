// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: Use of the javaDoc and powerpoint slides from previous lectures.
package collections;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

/**
 * A class that stores a collection of all different kinds of Shapes in a single array.
 * @author robin
 *
 */
public class ShapeCollection 
{
	/**
	 * Maximum number of shapes that can be stored in the collection. Determines size 
	 * of the array.Has the value of 6.
	 */
	private static final int MAXIMUM_SHAPES = 6;

	/**
	 * Array that stores the Shapes in the collection.
	 */
	private Shape[] allShapes;
	
	/**
	 * Count of how many shapes are currently in the array. Increased whenever a new 
	 * shape is add.Used to determine where new shapes should be placed in the array.
	 * Also used when traversing the array as the stopping point so unused elements are 
	 * not processed.
	 */
	private int currentNumberOfShapes;
	
	/**
	 * Records number of rectangles in a collection.
	 */
	private int numRectangles;
	
	/**
	 * Records number of Circles in a collection.
	 */
	private int numCircles;
	
	/**
	 * Records number of triangles in a collection.
	 */
	private int numTriangles;
	
	/**
	 * Constructor of ShapeCollection. Creates array of Shapes of size MAXIMUM_SHAPES.
	 * Initializes currentNumberOfShapes to zero.
	 */
	public ShapeCollection()
	{
		allShapes = new Shape[MAXIMUM_SHAPES];
		currentNumberOfShapes = 0;
		numRectangles = 0;
		numCircles = 0;
		numTriangles = 0;
	}
	
	/**
	 * Given the dimensions of a Rectangle, attempts to create a new Rectangle and places 
	 * it in the allShapes array.If possible, the new Rectangle is placed in the first 
	 * unused index.If there is not space for the new Rectangle no changes are made.
	 * @param dimensionsIn Dimensions of the Rectangle to be added.
	 * @return True if the new Rectangle is added, false if not.
	 */
	public boolean addNewRectangle(double[] dimensionsIn)
	{
		if (!atMaxLimit())
		{
			allShapes[currentNumberOfShapes] = new Rectangle(dimensionsIn);
			currentNumberOfShapes++;
			numRectangles++;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Given the dimensions of a Triangle, attempts to create a new Triangle and places it 
	 * in the allShapes array.If possible, the new Triangle is placed in the first unused 
	 * index.If there is not space for the new Triangle no changes are made.
	 * @param dimensionsIn Dimensions of the Triangle to be added.
	 * @return True if the new Triangle is added, false if not.
	 */
	public boolean addNewTriangle(double[] dimensionsIn)
	{
		if (!atMaxLimit())
		{
			allShapes[currentNumberOfShapes] = new Triangle(dimensionsIn);
			currentNumberOfShapes++;
			numTriangles++;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Given the radius of a Circle, attempts to create a new Circle and places it in the 
	 * allShapes array.If possible, the new Circle is placed in the first unused index.If 
	 * there is not space for the new Circle no changes are made.
	 * @param radius Radius of the Circle to be added.
	 * @return True if the new Circle is added, false if not.
	 */
	public boolean addNewCircle(double radius)
	{
		if (!atMaxLimit())
		{
			allShapes[currentNumberOfShapes] = new Circle(radius);
			currentNumberOfShapes++;
			numCircles++;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Given a Shape, attempts to place it in the allShapes array.If possible, the Shape is 
	 * placed in the first unused index as determined by currentNumberOfShapes.If there is 
	 * not space for the Shape or the reference passed is null no changes are made.
	 * @param shape Shape to be added.
	 * @return True if the Shape is added, false if not.
	 */
	public boolean addShape(Shape shape)
	{
		boolean added = false;
		if (!atMaxLimit())
		{
			if (shape instanceof Rectangle) 
			{
				allShapes[currentNumberOfShapes] = shape;
				currentNumberOfShapes++;
				numRectangles++;
				added = true;
			}
			else if (shape instanceof Triangle)
			{
				allShapes[currentNumberOfShapes] = shape;
				currentNumberOfShapes++;
				numTriangles++;
				added = true;
			}
			else if (shape instanceof Circle)
			{
				allShapes[currentNumberOfShapes] = shape;
				currentNumberOfShapes++;
				numCircles++;
				added = true;
			}
			else
			{
				added = false;
			}
		}
		else 
		{
			added = false;
		}
		return added;
	}
	
	/**
	 * Creates and returns a new array of size MAXIMUM_SHAPES containing all Shapes in the collection.
	 * Shapes appear in the same order they are in the local array. Unused elements will have the value of null.
	 * @return Array of all shapes in the collection.
	 */
	public Shape[] getAllShapes()
	{
		return allShapes;
	}

	/**
	 * Creates and returns a new array of size MAXIMUM_SHAPES containing all Rectangles in the collection.
	 * Rectangles appear in the same order they are in the local array. The returned array will be compact,
	 * meaning there are no unused elements between objects. Unused elements will have the value of null.
	 * @return  Array of Rectangles in the collection.
	 */
	public Rectangle[] getRectangles()
	{
		Rectangle[] array = new Rectangle[numRectangles];
		int countRectangles = 0;
		for (int i = 0; i < MAXIMUM_SHAPES; i++)
		{
			if (allShapes[i] instanceof Rectangle)
			{
				array[countRectangles] = (Rectangle) allShapes[i];
				countRectangles++;
			}
		}
		return array;
	}
	
	/**
	 * Creates and returns a new array of size MAXIMUM_SHAPES containing all Triangles in the collection.
	 * Triangles appear in the same order they are in the local array. The returned array will be compact,
	 * meaning there are no unused elements between objects. Unused elements will have the value of null.
	 * @return Array of Triangles in the collection.
	 */
	public Triangle[] getTriangles()
	{
		Triangle[] array = new Triangle[numTriangles];
		int countTriangles = 0;
		for (int i = 0; i < MAXIMUM_SHAPES; i++)
		{
			if (allShapes[i] instanceof Triangle)
			{
				array[countTriangles] = (Triangle) allShapes[i];
				countTriangles++;
			}
		}
		return array;
	}

	/**
	 * Creates and returns a new array of size MAXIMUM_SHAPES containing all Circles in the collection.
	 * Circles appear in the same order they are in the local array. The returned array will be compact,
	 * meaning there are no unused elements between objects. Unused elements will have the value of null.
	 * @return Array of Circles in the collection.
	 */
	public Circle[] getCircles()
	{
		Circle[] array = new Circle[numCircles];
		int countCircles = 0;
		for (int i = 0; i < MAXIMUM_SHAPES; i++)
		{
			if (allShapes[i] instanceof Circle)
			{
				array[countCircles] = (Circle) allShapes[i];
				countCircles++;
			}
		}
		return array;
	}
	
	/**
	 * Sums and returns the area of all Shapes.
	 * @return Area of all Shapes.
	 */
	public double totalAreaOfShapes()
	{
		double totalArea = 0;
		for (int i = 0; i < MAXIMUM_SHAPES; i++)
		{
			totalArea = totalArea + allShapes[i].getArea();
		}
		return totalArea;
	}
	
	/**
	 * Used to quickly determine if the array is at maximum capacity.
	 * @return True if at maximum limit, false if it is not.
	 */
	private boolean atMaxLimit()
	{
		return currentNumberOfShapes == MAXIMUM_SHAPES;
	}
}
