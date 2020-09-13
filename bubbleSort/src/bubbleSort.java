import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7,8,4,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length-1; bound++) {
            for (int cur = 0; cur < arr.length-1; cur++) {
                if (arr[cur] > arr[cur+1]) {
                    int tmp = arr[cur+1];
                    arr[cur + 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        } // end for
    } // end bubbleSort
}
