package lesson3;

public class Queue {
    private int[] array;
    private int rear;
    private int front;
    private int maxSize;
    private int nElems;

    public Queue(int size) {
        nElems = 0;
        front = 0;
        rear = -1;
        maxSize = size;
        array = new int[size];
    }

    public boolean isFull() {
        return nElems == maxSize;
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

    public void insert(int value) {
        array[++rear] = value;
        if (rear == maxSize) {
            rear = 0;
        }
        nElems++;
    }

    public int remove() {
        int temp = array[front++];
        if (front == maxSize) {
            front = 0;
        }
        nElems--;
        return temp;
    }
}
