package lesson3;

import java.lang.reflect.Array;

public class Stack<T> {
    private int maxSize;
    private T[] array;
    private int nElem;

    public Stack(Class<T> type, int size) {
        this.maxSize = size;
        array = (T[]) Array.newInstance(type, size);
        nElem = -1;
    }

    public void insert(T value) {
        array[++nElem] = value;
    }

    public T remove() {
        return array[nElem--];
    }

    public boolean isEmpty() {
        return nElem == -1;
    }

    public boolean isFull() {
        return nElem == maxSize;
    }


}
