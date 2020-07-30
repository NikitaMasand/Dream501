package DynamicProgramming;

public class SeqPatternMatching {
    public static void main(String[] args) {
        String a = "AXY";
        String b = "ADXCPY";

        int lcslen = LongestCommonSubsequence.dpLCS(a,b,a.length(),b.length());
        if(lcslen==a.length()){
            System.out.println("a is contained in b as lcs(a,b)=a as seq");
        }
        else{
            System.out.println("a is not present in b as seq");
        }
    }
}
