// COURSE: CSCI1620
// TERM: Fall 2018
//
// NAME: Robin Suda
// RESOURCES: The lab documentation and powerpoint.
package uno.collections.queues;

/**
 * Provides a standard definition of a circular queue (aka, a ring buffer)
 * with a maximum capacity.  All queue operations are guaranteed to complete
 * in constant time. 
 * 
 * @author 
 *
 * @param <E> The type of an individual element stored in the queue.
 */
public class BoundedCircularQueue<E> implements Queue<E>
{
	/**
	 * The default capacity of the queue.
	 */
	private static final int DEFAULTCAPACITY = 10;
	
	/**
	 * The array where we will store data in this queue.
	 */
	private E[] values;
	
	/**
	 * The index of the current front item in the queue.
	 */
	private int front;
	
	/**
	 * The index of the current rear item in the queue.	
	 */
	private int rear;
	
	/**
	 * The number of items currently stored in the queue.
	 */
	private int numberOfItems;
	
	/**
	 * Constructs a new, initially empty BoundedCircularQueue with 
	 * a default maximum capacity of 10.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCircularQueue()
	{
		values = (E[]) new Object[DEFAULTCAPACITY];
	}
	
	/**
	 * Constructs a new, initially empty BoundedCircularQueue.
	 * 
	 * @param capacity The maximum number of items that can be stored 
	 * in this queue.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCircularQueue(int capacity)
	{
		this();
		values = (E[]) new Object[capacity];
	}
	
	/**
	 * Check if the queue is empty.
	 * @return true if the queue contains no items, false otherwise.
	 */
	@Override
	public boolean isEmpty()
	{
		return numberOfItems == 0;
	}

	/**
	 * Retrieves the number of elements currently stored in the queue.
	 * @return The number of items stored.
	 */
	@Override
	public int size()
	{
		return numberOfItems;
	}

	/** 
	 * Retrieve the element at the front of the queue without removing it.
	 * @return The front element.
	 * @throws java.lang.IllegalStateException - when the queue is empty.
	 */
	@Override
	public E peek()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Cannot peek on an empty queue!");
		}
		return values[front];
	}

	/**
	 * Remove the front element from this queue and return it.
	 * @return The previous front element.
	 * @throws java.lang.IllegalStateException - when the queue is empty.
	 */
	@Override
	public E dequeue()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Cannot dequeue from an empty queue!");
		}
		E dequeuedItem = values[front];
		values[front] = null;
		front = (front + 1) % values.length;
		numberOfItems--;
		return dequeuedItem;
	}

	/**
	 * Add an item to the rear of this queue.
	 * 
	 * @param item The value to be added to the queue.
	 * @throws IllegalStateException when the queue is full.  The message will read 
	 * "Cannot enqueue because queue is already full!"
	 */
	@Override
	public void enqueue(E item)
	{
		if (isFull())
		{
			throw new IllegalStateException("Cannot enqueue because queue is already full!");
		}
		
		values[rear] = item;
		rear = (rear + 1) % values.length;
		numberOfItems++;
	}

	/**
	 * A method to test whether this BoundedCircularQueue is currently
	 * full.
	 * 
	 * @return true if this queue is full, false if at least one more item 
	 * can be enqueued.
	 */
	public boolean isFull()
	{
		return numberOfItems == values.length;
	}
	
	
	
}
