package linkedlist;

public interface List<E>
{
	   boolean add(E item);
	   void add(int index, E item);
	   E set(int index, E item);
	   E get(int index);
	   E remove(int index);
	   int indexOf(E item);
	   boolean isEmpty();
	   int size();
	   void clear();
}

