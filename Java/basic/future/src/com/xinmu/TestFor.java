package com.xinmu;

import java.util.Scanner;

public class TestFor {
    public static void main(String[] args) {

        int[] arr = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int i : arr) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
