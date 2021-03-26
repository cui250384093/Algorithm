package com.yl.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 3/26/21 - 4:15 PM
 */
public class ClassTest {

    @Test
    public void test1() {
        int[] arr = {1, 3, 8, 10, 11, 67, 100,0};
        int index = BinarySearch.binarySearch(arr, 11);
        System.out.println(index);
    }

}
