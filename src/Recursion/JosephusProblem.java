package Recursion;

public class JosephusProblem {
    public static int safePosition(int n, int k){
        if(n==1){
            return 1;
        }
        return ((safePosition(n-1,k)+(k-1))%n+1);
    }

    public static void main(String[] args) {
        System.out.println(safePosition(7,3));
    }
}
