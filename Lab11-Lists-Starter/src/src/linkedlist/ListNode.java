package linkedlist;

public class ListNode<E>
{
	private E data;
	private ListNode<E> next;
	
	public ListNode(E dataIn, ListNode<E> nextIn)
	{
		setData(dataIn);
		setNext(nextIn);
	}
	
	public void setData(E dataIn)
	{
		data = dataIn;
	}
	
	public E getData()
	{
		return data;
	}
	
	public void setNext(ListNode<E> nextIn)
	{
		next = nextIn;
	}
	
	public ListNode<E> getNext()
	{
		return next;
	}
}
