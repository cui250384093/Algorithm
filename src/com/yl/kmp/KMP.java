package com.yl.kmp;

import java.util.Arrays;

/**
 * @author candk
 * @Description KMP算法
 * @date 3/27/21 - 10:19 AM
 */
public class KMP {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        System.out.println(kmpSearch(str1, str2));

    }

    public static int[] kmpNext(String str) {
        int[] next = new int[str.length()];

        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j-1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }

    /**
     * kmp search algorithm
     * @param str1
     * @param str2
     * @return
     */
    public static int kmpSearch(String str1, String str2) {
        int[] next = kmpNext(str2);

        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }
}
