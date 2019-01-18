package stack;

import linkedlist.LinkedList;

public class UnboundedStack<E> implements Stack<E>
{
	private LinkedList<E> list;

	public UnboundedStack()
	{
		list = new LinkedList<E>();
	}
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public E peek() {
		return list.get(0);
	}

	@Override
	public E pop() {
		return list.remove(0);
	}

	@Override
	public E push(E item) {
		list.add(0, item);
		return item;
	}

	@Override
	public int search(Object o) {
		@SuppressWarnings("unchecked")
		int location = list.indexOf((E)o);
		if (location != -1)
		{
			location = location + 1;
		}
		
		return location;
	}
}
