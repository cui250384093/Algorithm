package com.yl.divideandconquer;

/**
 * @author candk
 * @Description
 * @date 3/26/21 - 4:33 PM
 */
public class HanoiTower {

    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
            return;
        }

        //如果有n >= 2情况，我么可以总是可以看做是两个盘 1.最下面的一个盘，2. 上面的所有盘
        //1. 先把上面的所有盘A->B, 移动过程会遇到c
        hanoiTower(num - 1, a, c, b);
        //2. 把最下面的盘A->C
        System.out.println("第" + num + "个盘从" + a + "->" + c);
        //3. 先把上面的所有盘B->C, 移动过程会遇到A
        hanoiTower(num - 1, b, a, c);
    }

    public static void main(String[] args) {
        HanoiTower.hanoiTower(4, 'A', 'B', 'C');
    }
}
