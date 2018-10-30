interface ICompute{
    int computer(int n,int m);
}
class UseCompute{
    private int n;
    private int m;
    public void useCom(ICompute com,int one,int two){
        this.n=one;
        this.m=two;
        com.computer(n,m);
    }
}
class Add implements ICompute{
        private int n;
        private int m;
        private int result;
        public int computer(int n,int m){
            this.m=m;
            this.n=n;
            this.result=n+m;
            System.out.println("n+m is" + result);
            return result;
        }
}
class Minus implements ICompute{
    private int n;
    private int m;
    private int result;
    public int computer(int n,int m){
        this.m=m;
        this.n=n;
        this.result=n-m;
        System.out.println("n-m is" +result);
        return result;
    }
}
class Mul implements ICompute{
    private int n;
    private int m;
    private int result;
    public int computer(int n,int m){
        this.m=m;
        this.n=n;
        this.result=n*m;
        System.out.println("n*m is" +result);
        return result;
    }
}
class Div implements ICompute{
    private int n;
    private int m;
    private int result;
    public int computer(int n,int m){
        this.m=m;
        this.n=n;
        this.result=n/m;
        System.out.println("n/m is" +result);
        return result;
    }
}
public class Test {
    public static void main(String[] args) {
        UseCompute a=new UseCompute();
        a.useCom(new Add(),8,2);
        a.useCom(new Minus(),8,2);
        a.useCom(new Mul(),8,2);
        a.useCom(new Div(),8,2);
    }
}