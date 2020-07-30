package Recursion;

public class EuclidGCD {
    public static int findGCD(int a, int b) {
        int dividend = a>b ? a:b;
        int divisor = a<b ? a:b;
        int remainder;
        while (divisor!=0){
            remainder = dividend%divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }

    public static int findGCDRecursive(int dividend, int divisor){
        return divisor==0 ? dividend : findGCDRecursive(divisor, dividend%divisor);
    }

    public static void main(String[] args) {
        System.out.println(findGCD(9,30));
        System.out.println(findGCDRecursive(3,1));
    }
}
