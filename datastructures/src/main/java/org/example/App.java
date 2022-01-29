package org.example;

import org.example.arrays.ArrayWrapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] array = {34, 53, 87, 100, 98, 65};
        int addressOfIndexToBeChecked = 20;
        ArrayWrapper arrayWrapper = new ArrayWrapper(array);
        System.out.println(arrayWrapper.returnAddress(addressOfIndexToBeChecked));
    }
}
