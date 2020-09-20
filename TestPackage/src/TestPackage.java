//1.编写一个类Calculator,有两个属性num1,num2,这两个数据的值不能在定义的同时初始化，最后实现加减乘除四种运算.



import java.util.Scanner;


public class TestPackage {
    public static void main(String[] args) {
        System.out.println ("输入数字num1 num2：");
        Scanner sc = new Scanner(System.in);
        int num1= sc.nextInt();
        int num2= sc.nextInt();
        Calculator calculator = new Calculator();//不构造方法，用setter初始化num1，num2
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        System.out.println("两个数字分别为："+calculator.getNum1()+"\t"+calculator.getNum2());
        calculator.add();
        calculator.sub();
        calculator.mul();
        calculator.div();
/*
        Calculator calculator2 = new Calculator(num1,num2);//构造方法，初始化num1，num2
        System.out.println("两个数字分别为："+calculator.getNum1()+"\t"+calculator.getNum2());
        calculator2.add();
        calculator2.sub();
        calculator2.mul();
        calculator2.div();
*/

    }
}

class Calculator{
    private int num1;//实例成员变量
    private int num2;
    /*
            public Calculator(int t1,int t2){  //构造方法初始化num1.num2
                this.num1 = t1;
                this.num2 = t2;
            }
    */
    public void setNum1(int num1) {//从键盘获取num1
        this.num1 = num1;
    }
    public int getNum1() {
        return num1;
    }

    public void setNum2(int num2) {//从键盘获取num2
        this.num2 = num2;
    }
    public int getNum2() {
        return num2;
    }

    public void add ( ){
        System.out.println("加法结果为："+(num1 + num2));
    }
    public void sub ( ){
        System.out.println("减法结果为："+(num1 - num2));
    }
    public void mul  ( ){
        System.out.println("乘法结果为："+(num1 * num2));
    }

    public void div ( ) {
        if (num2 == 0) {
            System.out.println("error！重新输入num2");
        } else
            System.out.println("除法结果为：" + ((float)num1 / (float)num2));
    }
}