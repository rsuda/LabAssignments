package linkedlist;

public class LinkedList<E> implements List<E>
{
	private ListNode<E> firstNode;
	private ListNode<E> lastNode;
	private int numElements;
	
	public LinkedList()
	{
		clear();
	}
	
	public int size()
	{
		return numElements;
	}
	
	public boolean isEmpty()
	{
		return numElements == 0;
	}
	
	public void clear()
	{
		firstNode = lastNode = null;
		numElements = 0;
	}
	
	private ListNode<E> getNode(int index)
	{
		ListNode<E> temp = firstNode;
		for (int i = 0; i < index; i++)
		{
			temp = temp.getNext();
		}
		
		return temp;
	}
	
	public boolean add(E item)
	{
		ListNode<E> newNode = new ListNode<E>(item, null);
		
		if (firstNode == null)
		{
			firstNode = lastNode = newNode;
		}
		else
		{
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
		
		numElements++;
		return true;
			
	}
	
	public void add(int index, E item)
	{
		if (index == 0 && !isEmpty())
		{
			ListNode<E> newNode = new ListNode<E>(item, firstNode);
			firstNode = newNode;
			numElements++;
		}
		else if (index < numElements && !isEmpty())
		{
			ListNode<E> prev = getNode(index - 1);
			ListNode<E> newNode = new ListNode<E>(item, prev.getNext());
			prev.setNext(newNode);
			numElements++;
		}
		else
		{
			add(item);
		}
	}
	
	public E set(int index, E item)
	{
		ListNode<E> temp = getNode(index);
		E data = temp.getData();
		temp.setData(item);
		return data;
	}
	
	public E remove(int index)
	{
		E data;
		
		if (size() == 1)
		{
			data = firstNode.getData();
			firstNode = lastNode = null;
		}
		else if (index == 0)
		{
			data = firstNode.getData();
			firstNode = firstNode.getNext();
		}
		else
		{
			ListNode<E> prev = getNode(index - 1);
			data = prev.getNext().getData();
			prev.setNext(prev.getNext().getNext());
			if (index == size() - 1)
			{
				lastNode = prev;
			}
		}
		numElements--;
		return data;
	}
	
	public E get(int index)
	{
		return getNode(index).getData();
	}
	
	public int indexOf(E item)
	{
		int location = -1;
		ListNode<E> temp = firstNode;
		for (int i = 0; i < size(); i++)
		{
			if (temp.getData().equals(item))
			{
				location = i;
				break;
			}
			temp = temp.getNext();
		}
		return location;
	}

}
