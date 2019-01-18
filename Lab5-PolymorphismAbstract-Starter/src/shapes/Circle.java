// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: Use of the javaDoc and powerpoint slides from previous lectures.
package shapes;
/**
 * Represents a Circle which inherits from the abstract Shape class.
 * @author robin
 *
 */
public class Circle extends Shape
{
	/**
	 * There are no sides to a circle.
	 */
	private static final int CIR_SIDES = 0;
	
	/**
	 * Radius of the Circle.
	 */
	private double radius;
	
	/**
	 * Circle constructor, accepts radius of the Circle.
	 * @param radiusIn Radius of the Circle.
	 */
	public Circle(double radiusIn)
	{
		area = 0;
		setRadius(radiusIn);
		setArea();
	}
	
	/**
	 * Sets the radius and area of the Circle.
	 * @param radiusIn Radius of the Circle.
	 */
	public void setRadius(double radiusIn)
	{
		radius = radiusIn;
		area = 0;
		setArea();
	}
	
	/**
	 * Retrieves the radius of the Circle.
	 * @return Radius of the Circle.
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * Retrieves number of sides of a Circle.
	 * @return Returns the number of sides of a Circle.
	 */
	public int getNumSides()
	{
		return CIR_SIDES;
	}
	
	/**
	 * Returns a formatted String representation of the Circle, 
	 * formatted to two decimal places;see example output for format.
	 * @return String representation of the Circle.
	 */
	public java.lang.String toString()
	{
		return String.format("This Circle has a radius of %.2f", getRadius());
	}
	
	/**
	 * Sets the area of the Circle based upon current radius.
	 */
	protected void setArea()
	{
		area = Math.pow(radius, 2);
		area = Math.PI * area;
	}
}
