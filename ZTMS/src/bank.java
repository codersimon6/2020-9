import java.util.Scanner;


    //银行账户：环境类
    class Account {
        private AccountState state; //维持一个对抽象状态对象的引用
        private String owner; //开户名
        private double balance = 0; //账户余额
        public Account(String owner,double init) {
            this.owner = owner;
            this.state = new GreenState (this); //设置初始状态
            System.out.println(this.owner + "开户成功，初始金额为" + init);
            System.out.println("---------------------------------------------");
        }

        public double getBalance() {
            return this.balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void setState(AccountState state) {
            this.state = state;
        }


        public void deposit(double amount) {
            System.out.println(this.owner + "存款" + amount);
            state.deposit(amount);  //调用状态对象的deposit()方法
            System.out.println("现在余额为"+ this.balance);
            System.out.println("现在帐户状态为"+(this.state.getClass().getName()).substring(this.state.getClass().getName().lastIndexOf('.')+1));
            System.out.println("---------------------------------------------");
        }

        public void withdraw(double amount) {
            System.out.println(this.owner + "取款" + amount);
            state.withdraw(amount); //调用状态对象的withdraw()方法
            System.out.println("现在余额为"+ this.balance);
            System.out.println("现在帐户状态为"+ (this.state.getClass().getName()).substring(this.state.getClass().getName().lastIndexOf('.')+1));
            System.out.println("---------------------------------------------");
        }
    }


    //抽象状态类
    abstract class AccountState {
        protected Account acc;
        public abstract void deposit(double amount);
        public abstract void withdraw(double amount);
        public abstract void stateCheck();
    }

    //正常状态：具体状态类
    class GreenState extends AccountState {
        public GreenState(Account acc) {
            this.acc = acc;
        }

        public GreenState(AccountState state) {
            this.acc = state.acc;
        }

        public void deposit(double amount) {
            acc.setBalance(acc.getBalance() + amount);
            stateCheck();
        }

        public void withdraw(double amount) {
            acc.setBalance(acc.getBalance() - amount);
            stateCheck();
        }



        //状态转换
        public void stateCheck() {
            if (acc.getBalance() >= -1000 && acc.getBalance() < 0) {
                acc.setState(new YelloState(this));
            }
            else if (acc.getBalance() < -1000) {
                acc.setState(new RedState(this));
            }
            else if (acc.getBalance() < -1000) {
                System.out.println("账户冻结！");
            }
        }
    }

    //透支状态：具体状态类
    class YelloState extends AccountState
    {
        public YelloState(AccountState state) {
            this.acc = state.acc;
        }

        public void deposit(double amount) {
            acc.setBalance(acc.getBalance() + amount);
            stateCheck();
        }

        public void withdraw(double amount) {
            acc.setBalance(acc.getBalance() - amount);
            stateCheck();
        }



        //状态转换
        public void stateCheck() {
            if (acc.getBalance() > 0) {
                acc.setState(new GreenState(this));
            }
            else if (acc.getBalance() < -1000) {
                acc.setState(new RedState(this));
            }
            else if (acc.getBalance() < -1000) {
                System.out.println("账户冻结！");
            }
        }
    }

    //受限状态：具体状态类
    class RedState extends AccountState {
        public RedState(AccountState state) {
            this.acc = state.acc;
        }

        public void deposit(double amount) {
            acc.setBalance(acc.getBalance() + amount);
            stateCheck();
        }

        public void withdraw(double amount) {
            System.out.println("账户冻结，取款失败");
        }



        //状态转换
        public void stateCheck() {
            if(acc.getBalance() > 0) {
                acc.setState(new GreenState(this));
            }
            else if(acc.getBalance() >= -1000) {
                acc.setState(new YelloState(this));
            }
        }
    }



    class bank {   //客户端测试代码
        public static void main(String args[]) {
            System.out.println("请先开户！输入您的用户名：");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            Account acc = new Account(str+"",0);

            acc.deposit(1000);
            acc.withdraw(1000);
            acc.withdraw(1000);
            acc.withdraw(1);
            acc.deposit(2000);
            acc.withdraw(1000);

        }
    }


