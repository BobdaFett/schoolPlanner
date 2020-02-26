package util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {

    public static void bubble() {
        int[][] temp = new int[12][12];
        for(int i = 0; i <= 11; i++) {
            temp[i][i] = 1;
        }
    }

    public static void shell(int[] a) {

    }

    public static void insert(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int k = i;
            for(int j = i; j > 0; j--) {

            }
        }
    }

    public static void swap(int[] a) {

    }

    public static void quick(int[] a) {

    }

    public static ArrayList<Integer> select(ArrayList<Integer> a) {
            for(int i = 0; i < a.size(); i++) { // goes through each index in the list.
                Integer temp = a.get(i);
                if(a.get(i - 1) < temp) {
                    Collections.swap(a, i, i - 1); // changed to ArrayList because of easy swap method.
                }
            }

        // This should happen only after the list is sorted.
        return a;

    }

}
