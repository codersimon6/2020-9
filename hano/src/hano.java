//实现代码: 递归求 N 的阶乘
import java.io.Console;
import java.util.*;
public class hano {
    public static void main(String[] args) {
        System.out.println("输入汉诺塔阶数（默认为A，B，C三个塔柱），最底下盘子为1号：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hano(n, "A", "B", "C");
    }

    public static void hano(int x, String from, String enter, String to) {
        if (x == 1) {
            System.out.println("盘子 1 从 " + from + " 到 " + to); //一号盘子从A移动到C
        } else {
            hano(x - 1, from, to, enter); //将A上的X-1个盘子移动到B上
            System.out.println("盘子 " + x + " 从 " + from + " 到 " + to);
            hano(x - 1, enter, from, to); //将B上的X-1个盘子移动到C上
        }
    }
}