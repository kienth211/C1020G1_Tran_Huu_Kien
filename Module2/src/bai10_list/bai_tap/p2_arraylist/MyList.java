package bai10_list.bai_tap.p2_arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapa(int minCapa) {
        if(minCapa  >= 0){
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
        else {
            throw new IllegalArgumentException("min Capa" + minCapa);
        }
    }

    public int size(){
        return this.size;
    }

    public void clear(){
        size = 0;
        for (int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
    }


    public void add(E e) {
        if (size == elements.length) {
            ensureCapa(5);
        }
        elements[size++] = e;
    }

    public void add(E element, int index){
        if (index > elements.length){
            throw new IllegalArgumentException("index: " + index);
        }
        else if (elements.length == size){
            this.ensureCapa(5);
        }
        if (elements[index] == null){
            elements[index] = element;
            size++;
        }else {
            for (int i = 0; i < elements.length; i++){
                elements[i] = elements[i+1];
            }
            elements[index] = element;
            size++;
        }
    }

    public int indexOf(E element){
       int index = -1;
       for (int i = 0; i < elements.length; i++){
           if (this.elements[i].equals(element)){
               return i;
           }
       }
       return index;
    }

    public boolean contain(E element){
        return this.indexOf(element) >= 0;
    }

    public MyList<E> clone(){
        MyList<E> v = new MyList<E>();
        v.elements = Arrays.copyOf(this.elements,this.size);
        v.size = this.size;
        return v;
    }

    public E remove(int index){
        if(index < 0 || index > elements.length){
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for(int i = 0; i < size - 1; i++){
            elements[i] = elements[i+1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}
