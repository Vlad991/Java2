package array;

import java.util.Arrays;

class ArrayException extends Exception {
}

public class Array {
    private int[] array;

    public Array() {
        this.array = new int[10];
    }

    public Array(int n) throws ArrayException {
        if (n < 1) {
            throw new ArrayException();
        }
        array = new int[n];
    }

    public int size() {
        return array.length;
    }

    public boolean checkElement(int i) {
        if (i < 0 || i > size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    public int getElement(int i) throws ArrayException {
        if (checkElement(i)) {
            return array[i];
        }
        throw new ArrayException();
    }

    public void setElement(int i, int value) throws ArrayException {
        if (checkElement(i)) {
            array[i] = value;
        }
        throw new ArrayException();
    }

    public void Add(int element) {
        array = Arrays.copyOf(array, size() + 1);
        array[size() - 1] = element;
    }

    public void FillRandom(int start, int end) {
        for (int i = 0; i < size(); i++) {
            array[i] = (int) (Math.random() * (end - start) + start);
        }
    }

    public void BubbleSort() {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size() - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
        }
    }

    public void ShakerSort() {
        int left = 0, right = size() - 1; // левая и правая границы сортируемой области массива
        int flag = 1;  // флаг наличия перемещений
        // Выполнение цикла пока левая граница не сомкнётся с правой
        // или пока в массиве имеются перемещения
        while ((left < right) && flag > 0) {
            flag = 0;
            for (int i = left; i < right; i++) { //двигаемся слева направо
                if (array[i] > array[i + 1]) // если следующий элемент меньше текущего,
                {             // меняем их местами
                    int buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                    flag = 1;      // перемещения в этом цикле были
                }
            }
            right--; // сдвигаем правую границу на предыдущий элемент
            for (int i = right; i > left; i--)  //двигаемся справа налево
            {
                if (array[i - 1] > array[i]) // если предыдущий элемент больше текущего,
                {            // меняем их местами
                    int buf = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buf;
                    flag = 1;    // перемещения в этом цикле были
                }
            }
            left++; // сдвигаем левую границу на следующий элемент
        }
    }

    public void ChoiseSort() {
        for (int i = 0; i < size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size(); j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int buf = array[i];
            array[i] = array[min];
            array[min] = buf;
            min = i;
        }
    }

    public void InsertSort() {
        for (int i = 1; i < size(); i++) {
            int cur = array[i];
            int j = i;
            while (j > 0 && cur < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = cur;
        }
    }

    public void ShellSort() {
        int increment = size() / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(array, startIndex, increment);
            }
            increment = increment / 2;
        }
    }

    private void insertionSort(int[] arr, int startIndex, int increment) {
        for (int i = startIndex; i < arr.length - 1; i = i + increment) {
            for (int j = Math.min(i + increment, arr.length - 1); j - increment >= 0; j = j - increment) {
                if (arr[j - increment] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - increment];
                    arr[j - increment] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    public void negativeAfterPositive() {
        for (int i = 0; i < size(); i++) {
            for (int j = size() - 1; j > i; j++) {
                int k = 0;
                if (array[i] < 0 && array[j] > 0) {
                    int buf = array[i];
                    array[i] = array[k + 1];
                    array[k + 1] = buf;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(array[i] + " ");
        }
    }


}
