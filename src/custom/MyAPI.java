package custom;

public class MyAPI {
    public static int findIndex(long arr[], long n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

}
