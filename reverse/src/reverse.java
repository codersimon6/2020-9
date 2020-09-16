import java.util.*;

public class reverse {

    public static void main(String[] args) {
        int []a={2,4,6,8,5,1,3};
        System.out.println("原数列为："+Arrays.toString(a));
        reverse(a);
    }


    public static void reverse(int []arr){
        int left=0,right=arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("反转后数列为"+Arrays.toString(arr));
    }
}