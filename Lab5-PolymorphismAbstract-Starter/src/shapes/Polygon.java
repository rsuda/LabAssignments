// COURSE: CSCI1620
// TERM: Fall 2018
// 
// NAME: Robin Suda
// RESOURCES: Use of the javaDoc and powerpoint slides from previous lectures.
package shapes;
/**
 * Polygon is a more specific type of Shape. Polygons have multiple 
 * dimensions that can differ in numberand meaning depending on the 
 * specific polygon.
 * @author robin
 *
 */
public abstract class Polygon extends Shape 
{
	/**
	 * Collection of the Polygon's dimensions.
	 */
	protected double[] dimensions;
	
	/**
	 * Number of dimensions.
	 */
	protected int numDimensions;
	
	/**
	 * Constructor of Polygon, creates dimension array based upon number 
	 * of dimensions of the Polygonand sets the dimensions of the Polygon.
	 * @param dimensionsIn The requested dimensions of the Polygon.
	 * @param numDimensionsIn Number of dimensions the Polygon has.
	 */
	public Polygon(double[] dimensionsIn, int numDimensionsIn)
	{
		dimensions = dimensionsIn;
		setDimensions(dimensions);
		numDimensions = numDimensionsIn;
		
	}

	/**
	 * Sets the dimensions of the Polygon.
	 * @param dimensionsIn The requested dimensions of the Polygon.
	 */
	public abstract void setDimensions(double[] dimensionsIn);
}
