public class NewArray {
    private int lenght = 0;
    private int[] array;

    public NewArray(int size) {
        this.array = new int[size];
    }

    public NewArray(int size, boolean generate) {
        this.array = new int[size];
        lenght = size;
        generate(array);
    }

    private void generate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * lenght);
        }
    }

    public void add(int value) {
        array[lenght++] = value;
    }

    public boolean find(int value) {
        for (int i : array) {
            if (i == value) return true;
        }
        return false;
    }

    public boolean delete(int value) {
        int i = 0;
        for (; i < lenght; i++) {
            if (array[i] == value) break;
        }
        if (i == lenght) return false;
        for (int j = i; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }
        lenght--;
        return true;
    }

    public void display() {
        for (int i = 0; i < lenght; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void bubbleSort() {
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                if (array[i] < array[j]) {
                    swap(i, j, array);
                }
            }
        }
    }

    public void selectSort() {
        int min;
        for (int i = 0; i < lenght; i++) {
            min = i;
            for (int j = i; j < lenght; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(i, min, array);
        }
    }

    public void sortInsert() {
        int key;
        for (int i = 1; i < lenght; i++) {
            key = array[i];
            int j = i - 1;
            while (j > 0 && array[j - 1] >= key) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = key;
        }
    }

    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
