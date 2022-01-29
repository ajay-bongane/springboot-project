package org.example.arrays;

public class ArrayWrapper {
    private final static int BASE_ADDRESS = 3000;
    private int[] array;

    public ArrayWrapper(int[] array){
        this.array = array;
    }

    public int returnAddress(int index){
        System.out.println(array.length);
        if(array.length < index+1){
            throw new ArrayIndexOutOfBoundsException();
        }
        return ArrayWrapper.BASE_ADDRESS + Integer.valueOf(index).byteValue() * index;
    }
}
