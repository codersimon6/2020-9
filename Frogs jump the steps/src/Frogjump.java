import java.util.Scanner;

public class Frogjump {
    public static void main(String[] args) {
        System.out.println("台阶总数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(""+jump(n));
    }


    public static int jump(int n) {
        if(n==0||n==1){
            return 1;
        }
        return jump(n-1)+jump(n-2);
    }
}
