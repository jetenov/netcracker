package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        int[][] array = new int[5][8];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 8 ; j++) {
                array[i][j] = i * j;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

