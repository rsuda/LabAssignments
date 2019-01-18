// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: Use of the javaDoc and powerpoint slides from previous lectures.
package shapes;

/**
 * Abstract class for the minimal requirements of a Shape.
 * @author robin
 *
 */
public abstract class Shape 
{
	/**
	 * Area of a two-dimensional shape.
	 */
	protected double area;
	
	/**
	 * Constructs 2-dimensional shape.
	 */
	public Shape()
	{
		area = 0;
	}
	
	/**
	 * Retrieves the area of the Shape.
	 * @return Retrieves the area of the Shape.
	 */
	public double getArea()
	{
		return area;
	}

	/**
	 * Retrieves the number of sides of the shape.
	 * @return Sides of the shape.
	 */
	public abstract int getNumSides();
	
	/**
	 * Calculates and sets the area of the Shape.
	 */
	protected abstract void setArea();
}
