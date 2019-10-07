package lesson3;

public class DeQue {
    private int[] array;
    private int rear;
    private int front;
    private int maxSize;
    private int nElems;

    public DeQue(int size) {
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

    public void insertRight(int value) {
        array[++rear] = value;
        if (rear == maxSize) {
            rear = 0;
        }
        nElems++;
    }

    public void insertLeft(int value) {
        int frontNew = --front;
        if (frontNew < 0) {
            front = maxSize - 1;
        }
        array[front] = value;
        nElems++;

    }

    public int removeLeft() {
        int temp = array[front++];
        if (front == maxSize) {
            front = 0;
        }
        nElems--;
        return temp;
    }

    public int removeRight() {
        int temp = array[rear--];
        if (rear < 0) {
            rear = maxSize - 1;
        }
        nElems--;
        return temp;
    }
}
