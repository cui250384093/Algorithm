package com.yl.dynamicprogramming;

/**
 * @author candk
 * @Description 背包问题
 * @date 3/27/21 - 9:37 AM
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weight = {1, 4, 3};
        int[] value = {1500, 3000, 2000};
        //背包重量
        int mou = 4;

        int[][] v = new int[weight.length + 1][mou + 1];
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (weight[i-1] > j) {
                    v[i][j] = v[i-1][j];
                } else {
                    if (v[i-1][j] < value[i-1] + v[i-1][j-weight[i-1]]) {
                        v[i][j] = value[i-1] + v[i-1][j-weight[i-1]];
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                System.out.println(j);
                System.out.print(v[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }

    }
}
