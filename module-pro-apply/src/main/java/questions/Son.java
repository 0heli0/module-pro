package questions;

public class Son extends Father {


    public static void main(String[] args) {
        System.out.println();
        System.err.println(f(9));
    }

    public static int f(int n){
        int i = 0;
        if(n>2){
            i = f(n-1) + f(n-2);
        }else if (n == 2){
            i = 2;
        }else {
            i = 1;
        }
        return i;
    }
}
