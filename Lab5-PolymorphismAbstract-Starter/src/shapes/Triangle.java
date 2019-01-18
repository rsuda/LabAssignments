// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: Use of the javaDoc and powerpoint slides from previous lectures.
package shapes;

/**
 * Represents a Triangle which inherits from the abstract Polygon 
 * class. Stores a triangle shape in terms oftwo dimensions, base 
 * base length and height.
 * @author robin
 *
 */
public class Triangle extends Polygon
{
	/**
	 * Constant value for the number of sides of a rectangle.
	 */
	private static final int TRI_SIDES = 3;
	
	/**
	 * Index location of Triangle base size in dimensions array; base size 
	 * is to be stored in index 0.
	 */
	private static final int BASE_INDEX = 0;
	
	/**
	 * Index location of Triangle height in dimensions array; height is to be 
	 * stored in index 1.
	 */
	private static final int HEIGHT_INDEX = 1;

	/**
	 * Measured length of triangle.
	 */
	private double base;
	
	/**
	 * Measured width of triangle.
	 */
	private double height;
	/**
	 * Constructor of Triangle, accepts array containing base size and height of the Triangle.
	 * @param dimensionsIn dimensions of the triangle.
	 */
	public Triangle(double[] dimensionsIn)
	{
		super(dimensionsIn, TRI_SIDES);
	}
	
	/**
	 * Retrieves number of sides of a Triangle.
	 * @return Returns the number of sides of a Triangle.
	 */
	public int getNumSides()
	{
		return TRI_SIDES;
	}
	
	/**
	 * Sets Triangle's Base.
	 * @param baseIn base of the triangle.
	 */
	private void setBase(double baseIn)
	{
		base = baseIn;
	}
	
	/**
	 * Sets Triangle's Height.
	 * @param heightIn Height of the Triangle.
	 */
	private void setHeight(double heightIn)
	{
		height = heightIn;
	}
	
	/**
	 * Retrieves the base size of the Triangle.
	 * @return Base size of the Triangle.
	 */
	public double getBase()
	{
		return base;
	}
	
	/**
	 * Retrieves the height of the Triangle.
	 * @return Height of the Triangle.
	 */
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * Returns a formatted String representation 
	 * of the Triangle, base size by height formatted 
	 * to two decimal places;see example output for format.
	 * @return String representation of the Triangle.
	 */
	public java.lang.String toString()
	{
		return String.format("This Triangle is %.2f x %.2f", getBase(), getHeight());
	}
	
	/**  
	 * Sets base size and height of the Triangle, then sets the 
	 * area of the Triangle.
	 * @param dimensionsIn Input dimensions of the Triangle.
	 */
	public void setDimensions(double[] dimensionsIn)
	{
		setBase(dimensions[BASE_INDEX]);
		setHeight(dimensions[HEIGHT_INDEX]);
		setArea();
	}
	
	/**
	 * Sets the area of the Triangle based upon current dimensions.
	 */
	protected void setArea()
	{
		area = base * height;
		area = area / 2;
	}
}
