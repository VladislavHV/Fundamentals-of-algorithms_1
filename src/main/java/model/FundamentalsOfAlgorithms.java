package model;

import exception.IndexOutOfBoundException;
import exception.NullItemException;

import java.util.Arrays;


public class FundamentalsOfAlgorithms implements StringList {

    private String[] array;
    private int size;

    public FundamentalsOfAlgorithms(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Значение не может быть меньше нуля");
        }
        array = new String[capacity];
        size = 0;
    }

    private void checkNull(String item) {
        if (item == null) {
            throw new NullItemException("Содержит null");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс не корректен");
        }
    }

    private void resizeIfNeeded() {
        if (size == array.length) {
            String[] newArray = new String[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    @Override
    public String add(String item) {
        checkNull(item);
        resizeIfNeeded();
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkNull(item);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundException("Неправильный индекс");
        }
        resizeIfNeeded();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkNull(item);
        checkIndex(index);
        String oldItem = array[index];
        array[index] = item;
        return oldItem;
    }

    @Override
    public String remove(String item) {
        checkNull(item);
        int index = indexOf(item);
        if (index == -1) {
            return null;
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String removeItem = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removeItem;
    }

    @Override
    public boolean contains(String item){
        checkNull(item);
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        checkNull(item);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (this == otherList) {
            return true;
        }
        if (otherList == null || this.size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

}

