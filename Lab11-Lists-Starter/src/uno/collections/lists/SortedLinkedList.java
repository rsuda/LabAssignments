package uno.collections.lists;


/**
 * This class is a specialized form of linked list that maintains sortedorder for all inserted items.
 * @author robin
 *
 * @param <E> The type of an individual item stored in the list.
 */
public class SortedLinkedList<E extends java.lang.Comparable<E>> extends LinkedList
{
	/**
	 * The sorted list.
	 */
	private LinkedList<E> list;
	
	/**
	 * First node in sorted list.
	 */
	private ListNode first;
	
	/**
	 * The size of the list.
	 */
	private int size;
	
	/**
	 * Creates a new empty SortedLinkedList.
	 */
	public SortedLinkedList()
	{
		size = 0;
	}
	
	/**
	 * Adds the specified item to the list while preserving the global sorted order of the list.
	 * This method guarantees no worse than linear runtime performance for each add operation.
	 * @param item The new item to be inserted.
	 * @return true when the item was successfully added (which is always)
	 */
	public boolean add(E item)
	{
		if (item == null)
		{
			throw new NullPointerException();
		}
		if (firstNode != null)
		{
			ListNode<E> prev = null;
			ListNode<E> current = firstNode;
			for (int i = 0; i < size; i++)
			{
				if (item.compareTo((E) current) > 0)
				{
					prev = current;
					current = current.getNext();
				}
				else if (current.getNext() == null)
				{
					current.setNext((ListNode<E>) item);
				}
			}
			ListNode<E> node = new ListNode<E>(item, null); 
			if (prev != null)
			{
				prev.setNext(node);
				node.setNext(current);
			}
			else
			{
				node.setNext(firstNode);
				firstNode = node;
			}
		}
		else
		{
			firstNode = new ListNode<E>(item, null);
		}
		return true;
	}
	
	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an exception.
	 * @param index The index where an item is to be added in the list.
	 * @param item The item to be added to the list.
	 * @throws java.lang.UnsupportedOperationException is thrown any time this method gets called 
	 * as it would violate sorted ordering requirements of SortedLinkedList.
	 */
	public void add(int index, E item) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an exception.
	 * @param index The index where an item is to be added in the list.
	 * @param item The item to be added to the list.
	 * @return the element previously stored at the specified index.
	 * @throws java.lang.UnsupportedOperationException is thrown any time this method gets called as 
	 * it would violatesorted ordering requirements of SortedLinkedList.
	 */
	public E set(int index, E item) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
}
