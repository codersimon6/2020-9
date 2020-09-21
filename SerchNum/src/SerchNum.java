import java.util.*;
public class SerchNum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("需要寻找指定数的区间(空格分隔)： ");
        int min = sc.nextInt();
        int max = sc.nextInt();
        System.out.println("需要查找指定数的区间为"+min+"~ " +max);
        System.out.println("需要寻找的指定数");
        int num = sc.nextInt();
        int k=0;
        for (int i = min; i <=max;i++)
        {
            if(i%10==num)k+=1; //
            if(i/10==num)k+=1;
        }
        System.out.println("区间内指定数个数为： "+k);
    }
}
