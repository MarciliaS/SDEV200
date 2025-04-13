
public interface MyList<E> extends java.util.Collection<E> {
    public void add(int index, E e);
    public E get(int index);
    public int indexOf(Object e);
    public int lastIndexOf(E e);
    public E remove(int index);
    public E set(int index, E e);
}
