// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: Use of the javaDoc and powerpoint slides from previous lectures.
package shapes;

/**
 * Represents a Rectangle which inherits from the abstract Polygon class. 
 * Stores a rectangle shape in terms oftwo dimensions, length and width.
 * @author robin
 *
 */
public class Rectangle extends Polygon
{
	/**
	 * Constant value for the number of sides of a rectangle.
	 */
	private static final int RECT_SIDES = 4;
	
	/**
	 * Index location of Rectangle length in dimensions array; length is to 
	 * be stored in index 0.
	 */
	private static final int LENGTH_INDEX = 0;
	
	/**
	 * Index location of Rectangle width in dimensions array; width is to 
	 * be stored in index 1.
	 */
	private static final int WIDTH_INDEX = 1;
	
	/**
	 * Length of the rectangle.
	 */
	private double length;
	
	/**
	 * Width of the rectangle.
	 */
	private double width;
	
	/**
	 * Constructor of Rectangle, accepts array containing length and width 
	 * of the Rectangle.
	 * @param dimensionsIn Input dimensions of the Rectangle.
	 */
	public Rectangle(double[] dimensionsIn)
	{
		super(dimensionsIn, RECT_SIDES);
	}

	/**
	 * Sets Rectangle's Length.
	 * @param lengthIn rectangles length.
	 */
	private void setLength(double lengthIn)
	{
		length = lengthIn;
	}
	
	/**
	 * Sets Rectangle's Width.
	 * @param widthIn Width of the Rectangle.
	 */
	private void setWidth(double widthIn)
	{
		width = widthIn;
	}
	
	/**
	 * Sets length and width of the Rectangle, then sets the 
	 * area of the Rectangle.
	 * @param dimensionsIn Input dimensions of the Rectangle.
	 */
	public void setDimensions(double[] dimensionsIn)
	{
		setLength(dimensionsIn[LENGTH_INDEX]);
		setWidth(dimensionsIn[WIDTH_INDEX]);
		setArea();
	}
	
	/**
	 * Retrieves the length of the Rectangle.
	 * @return Length of the Rectangle.
	 */
	public double getLength()
	{
		return length;
	}
	
	/**
	 * Retrieves the width of the Rectangle.
	 * @return Width of the Rectangle.
	 */
	public double getWidth()
	{
		return width;
	}
	
	/**
	 * Retrieves number of sides of a Rectangle.
	 * @return Returns the number of sides of a Rectangle.
	 */
	public int getNumSides()
	{
		return RECT_SIDES;
	}
	
	/**
	 * Returns a formatted String representation of the Rectangle, 
	 * length by width formatted to two decimal places;see example 
	 * output for format.
	 * @return String representation of the Rectangle.
	 */
	public java.lang.String toString()
	{
		return String.format("This Rectangle is %.2f x %.2f", getLength(), getWidth());
	}
	
	/**
	 * Sets the area of the Rectangle based upon current dimensions.
	 */
	protected void setArea()
	{
		area = length * width;
	}
}
