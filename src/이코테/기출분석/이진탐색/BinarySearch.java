package 이코테.기출분석.이진탐색;

import java.util.Arrays;

public class BinarySearch {
    static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            else if (target < arr[mid]) {
                end = mid - 1;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;


    }
    public static void main(String[] args) {
        int[] ints1 = {3, 1, 0, 2, 4, 5, 19};
        Arrays.sort(ints1);
        System.out.println(Arrays.toString(ints1));
        int target = 3;
        System.out.println(binarySearch(ints1, target, 0, ints1.length-1)+"번 인덱스에 0이 존재");

    }
}
