package org.example.arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayWrapperTest {

    int[] array = {34, 53, 87, 100, 98, 65};
    ArrayWrapper arrayWrapper = new ArrayWrapper(array);

    @Test
    public void test1(){
        int address = arrayWrapper.returnAddress(4);
        assertEquals(3016, address);
    }

    @Test
    public void test2(){
        int address = arrayWrapper.returnAddress(20);
        assertEquals(3000, address);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                ArrayWrapper arrayWrapper1 = new ArrayWrapper(array);
                arrayWrapper1.returnAddress(20);
        });
    }

    @Test
    public void test3(){
        int address = arrayWrapper.returnAddress(20);
        assertEquals(3401, address);
    }

}
