package cn.com.timeriver.myleetcode.bytedance;

import timber.log.Timber;

public class SetPart {

    public static void testPart() {
        int[] a = {10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};
        setParted(a);
    }

    public static void setParted(int[] a) {
        int temp;
        int border = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                temp = a[i];
                a[i] = a[border + 1];
                a[border + 1] = temp;
                border++;
            }
        }
        for (int j = 0; j < a.length; j++) {
            Timber.d(String.valueOf(a[j]));
        }
    }

    public void setParted1(int[] a, int left, int right) {
        if (left >= right || left == a.length || right == 0) {
            for (int anA : a) {
                System.out.println(anA);
            }
            return;
        }
        while (a[left] < 0) {
            left++;
        }
        while (a[right] >= 0) {
            right--;
        }
        if (left >= right || left == a.length || right == 0) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
            return;
        }
        swap(a, left, right);
        left++;
        right--;
        setParted1(a, left, right);
    }

    private void swap(int a[], int left, int right) {
        int temp = 0;
        temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
