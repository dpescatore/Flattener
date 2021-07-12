package it.example;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for Flattener. Some tests will log an exception for not integer
 * elements.
 * 
 * @author dpescatore
 */
public class FlattenerTest {

    @Test
    @DisplayName("Simple flattener of multidimentional arrays")
    public void testFlattener() {

        Integer[] arr = { 1, 4, 6 };
        Integer[] arr2 = { 1, 2, 3 };
        Integer[] arr3 = { 1, 6, 234 };
        Integer[] arr4 = { 1234, 432, 2 };
        Object[] arr5 = { arr, arr2 }; // basically an int[][]
        Object[] arr6 = { arr3, arr4 }; // basically an int[][]
        Object[] arr7 = { arr5, arr6 }; // basically an int[][][]

        Integer[] result = { 1, 4, 6, 1, 2, 3, 1, 6, 234, 1234, 432, 2 };
        try {
            assertArrayEquals(result, Flattener.flat(arr7), "Flattener should work");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Simple flattener of nested arrays")
    public void testFlattenerNested() {

        Integer[] arr = { 1, 4, 6 };
        Integer[] arr2 = { 1, 2, 3 };
        Integer[] arr3 = { 1, 6, 234 };
        Integer[] arr4 = { 1234, 432, 2 };
        Object[] arr5 = { arr, arr2 }; // basically an int[][]
        Object[] arr6 = { arr3, arr4 }; // basically an int[][]
        Object[] arr7 = { arr5, arr6 }; // basically an int[][][]
        Object[] arr8 = { 1, 2, 3, arr, 4, arr7, 13, 42, 43, arr6, 1 }; // a nested array of ints

        Integer[] result = { 1, 2, 3, 1, 4, 6, // flattened arr
                4, 1, 4, 6, 1, 2, 3, 1, 6, 234, 1234, 432, 2, // flattened arr7
                13, 42, 43, 1, 6, 234, 1234, 432, 2, // flattened arr6
                1 };
        try {
            assertArrayEquals(result, Flattener.flat(arr8), "Flattener should work");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Simple flattener of nested arrays with strings to skip")
    public void testFlattenerNestedWithStrings() {

        Integer[] arr = { 1, 4, 6 };
        Integer[] arr2 = { 1, 2, 3 };
        Integer[] arr3 = { 1, 6, 234 };
        Integer[] arr4 = { 1234, 432, 2 };
        Object[] arr5 = { arr, arr2 }; // basically an int[][]
        Object[] arr6 = { arr3, arr4 }; // basically an int[][]
        Object[] arr7 = { arr5, arr6 }; // basically an int[][][]
        Object[] arr8 = { 1, "pippo", 2, 3, arr, 4, arr7, 13, 42, "pluto", 43, arr6, 1, "paperino" };

        assertThrows(Exception.class, () -> Flattener.flat(arr8), "Flattener should not work");
    }

    @Test
    @DisplayName("Simple flattener of nested arrays with objects ")
    public void testFlattenerNestedWithObjects() {

        Integer[] arr = { 1, 4, 6 };
        Integer[] arr2 = { 1, 2, 3 };
        Integer[] arr3 = { 1, 6, 234 };
        Integer[] arr4 = { 1234, 432, 2 };
        Object[] arr5 = { arr, arr2 }; // basically an int[][]
        Object[] arr6 = { arr3, arr4 }; // basically an int[][]
        Object[] arr7 = { arr5, arr6 }; // basically an int[][][]

        Object aTestObject = new Object();
        double aDouble = 123.2321;
        Object[] arr8 = { aDouble, 1, "pippo", 2, 3, arr, 4, arr7, 13, aTestObject, 42, "pluto", 43, arr6, 1,
                "paperino" };

        assertThrows(Exception.class, () -> Flattener.flat(arr8), "Flattener should not work");

    }

    @Test
    @DisplayName("Simple flattener of array with no elements")
    public void testFlattenerWithNoElements() throws Exception {

        Object[] arr = {};
        Integer[] result = {};
        assertArrayEquals(result, Flattener.flat(arr), "Flattener should work");

    }

    @Test
    @DisplayName("Simple flattener of array of null")
    public void testFlattenerWithNull() {

        Object[] arr = { null };

        assertThrows(Exception.class, () -> Flattener.flat(arr), "Flattener should not work");
    }

}
