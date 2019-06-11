package com.sun.structure;

import java.util.Scanner;

/**
 * @Auther: swh
 * @Date: 2019/6/11 22:25
 * @Description: FixedCapacityStackOfString µƒ≤‚ ‘¿‡
 */
public class FixedCapacityStackOfStringTest {

    public static void main(String[] args) {
        FixedCapacityStackOfString stackOfString = new FixedCapacityStackOfString(100);

        Scanner scanner = new Scanner(System.in);
        String item;
        while (!(item = scanner.nextLine()).isEmpty()) {

            if (!item.equals("-")) {
                stackOfString.push(item);
            } else {
                System.out.println(stackOfString.pop()+" ");
            }
        }
    }
}
