import java.util.Scanner;

public class binarySearch {
    public static void main (String [] args){
        int [] arr = makearry();
        System.out.println("需要寻找的指定数： ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        binarySearch(arr,num);
    }

    public static int binarySearch(int[] arr, int toFind) {
        int flag = 0;
        int left=0,right=arr.length-1;
        while(left<=right) {
            int mid=(left+right)/2;
            flag++;
            if (toFind < arr[mid]) {
                right = mid - 1;
            } else if (toFind > arr[mid]) {
                left = mid + 1;
            } else{
                System.out.println("要找的数为：" + mid);
                System.out.print("查找次数：" + flag);
                break;
            }
        }
        return -1;
    }


    public static int[] makearry(){
        int []arr =new int[10000];
        for(int i = 0;i<10000;i++){
            arr[i]=i;
        }
        System.out.println("数列生成成功！共有元素： "+arr.length+"个");
        return arr;
    }
}