import java.util.*;
public class GuessNum {
    public static void main(String[] args){
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("随机数为1-100以内。请输入你猜测的答案：");
        int Guess = random.nextInt(100);
        while(true){
            int num = sc.nextInt();
            if(num<Guess){
                System.out.println("猜的数字比随机数小，请重猜");
            }else if(num>Guess){
                System.out.println("猜的数字比随机数大，请重猜");
            }else {
                System.out.println("恭喜你猜中了");break;
            }
        }
    }
}
