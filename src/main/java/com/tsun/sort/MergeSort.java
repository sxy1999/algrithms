package com.tsun.sort;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.StringJoiner;

/**
 * @author xiaoyu.swun
 */
public class MergeSort {


    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int l = 0; l < a.length; l++) {
            aux[l] = a[l];
        }

        try {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                } else if (j > hi) {
                    a[k] = aux[i++];
                } else if (aux[j].compareTo(aux[i]) < 0) {
                    a[k] = aux[j++];
                } else {
                    a[k] = aux[i++];
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void main(String[] args) {
        Integer[] a = generateRandomArrayOfInteger(15);
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (Integer i : a) {
            sj.add(i + "");
        }
        System.out.println(sj.toString());

        Integer[] aux = (Integer[]) Array.newInstance(Integer.class, a.length);

        sort(a, aux, 0, a.length - 1);
        StringJoiner sj1 = new StringJoiner(",", "[", "]");
        for (Integer i : a) {
            sj1.add(i + "");
        }
        System.out.println(sj1.toString());
    }

    public static Integer[] generateRandomArrayOfInteger(int len) {
        Random random = new Random();
        Integer[] array = new Integer[len];
        for (int i = 0; i < len; i++) {
            array[i] = random.nextInt(len * 3);
        }

        return array;
    }
}
