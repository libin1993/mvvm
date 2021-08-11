package com.synway.mvvm.base;

import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.LruCache;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import okhttp3.internal.cache.DiskLruCache;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Author：Libin on 2021/4/22 17:17
 * Email：1993911441@qq.com
 * Describe：
 */
class Test {
    private static final String TAG = "libin44444";

    public static void main(String[] args) {
//        System.out.println(romanToInt("II"));
//        System.out.println("llll;"+longestCommonPrefix(new String[]{"ab","dab"}));
//        System.out.println(fractionToDecimal(466,300));
//        removeDuplicates(new int[]{1,2,2,3,4});
//        test();
//        System.out.println(multiply(4, 5));
        rxJava();

        System.out.println(Arrays.toString(order(new int[]{1, 2, 3, 3, 4, 5, 6}, new int[]{1, 2, 2, 3, 4, 5, 5, 7, 8, 9, 10})));
    }

    public static void rxJava() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1111111");

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: "+s);
            }
        });
    }

    public static int[] order(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < c.length; i++) {
            if (index1 < a.length && index2 < b.length) {
                if (a[index1] <= b[index2]) {
                    c[i] = a[index1];
                    index1++;
                } else {
                    c[i] = b[index2];
                    index2++;
                }
            } else if (index1 < a.length) {
                c[i] = a[index1];
                index1++;
            } else {
                c[i] = b[index2];
                index2++;
            }
        }

        return c;
    }

    public static int multiply(int A, int B) {
        if (B == 0) {
            return 0;
        }
        return A + multiply(A, B - 1);
    }

    public static void test() {
        boolean[] arr = new boolean[16];
        arr[0] = true;
        arr[5] = true;
        arr[11] = true;

        while (true) {
            test1(arr);
            System.out.println(Arrays.toString(arr));
            if (arr[15] && arr[14]) {
                break;
            } else {
                arr[14] = true;
                arr[15] = false;
                arr[0] = false;
                arr[1] = true;
            }
            System.out.println("新的：" + Arrays.toString(arr));
        }


        System.out.println("最后的：" + Arrays.toString(arr));

    }

    public static void test1(boolean[] arr) {
        int i = 0;
        while (i < 14) {
            if (!arr[i]) {
                arr[i] = !arr[i];
                arr[i + 1] = !arr[i + 1];

                arr[i + 2] = !arr[i + 2];
            }
            i++;
        }
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }

            for (int num : nums) {
                System.out.println(num);
            }
        }
        Map<Character, Integer> map = new HashMap<>();

        return j + 1;
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static String fractionToDecimal1(int numerator, int denominator) {
        StringBuilder stringBuilder = new StringBuilder();
        int big = numerator / denominator;
        int small = numerator % denominator;
        if (small == 0) {
            return big + "";
        } else {
            stringBuilder.append(big).append(".");
            small *= 10;
        }

        int count = 0;
        while (small != 0 && count < 104) {
            if (small < denominator) {
                small *= 10;
            } else {
                if (small % (small % denominator) == 0) {
                    return stringBuilder.append("(").append(small / denominator).append(")").toString();
                } else {
                    stringBuilder.append(small / denominator);
                    small %= denominator;
                    count++;
                }

            }
        }

        System.out.println(stringBuilder.length() + "aa");
        return stringBuilder.toString();
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }

    public static int romanToInt(String s) {
        char[] valueArr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < valueArr.length; i++) {
            if (i == valueArr.length - 1) {
                sum += getValue(valueArr[i]);
            } else {
                if (getValue(valueArr[i]) < getValue(valueArr[i + 1])) {
                    sum += getValue(valueArr[i + 1]) - getValue(valueArr[i]);
                    i++;
                } else {
                    sum += getValue(valueArr[i]);
                }
            }
        }
        return sum;
    }

    private static int getValue(char value) {
        switch (value) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
