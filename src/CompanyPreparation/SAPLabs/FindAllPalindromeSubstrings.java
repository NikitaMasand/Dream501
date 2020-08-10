package CompanyPreparation.SAPLabs;

import java.util.HashSet;
import java.util.Iterator;

public class FindAllPalindromeSubstrings {
     static HashSet<String> set;
    public static int findPalindromes(String s){
        if(s==null || s.length()<1){
            return 0;
        }
        set = new HashSet<>();
        int start=0;
        int end=0;
        int leftrange=0;
        int rightrange=s.length()-1;
        for(int i=leftrange;i<=rightrange;i++){
            expandFrommMiddle(s,i,i,leftrange,rightrange);
            expandFrommMiddle(s,i,i+1,leftrange,rightrange);
        }

        Iterator i = set.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        return set.size();
    }

    public static void expandFrommMiddle(String s, int left, int right, int leftrange, int rightrange){
        if(s==null || right<left){
            return;
        }
//        System.out.println("hi");

        while (left>=leftrange && right<=rightrange && s.charAt(left)==s.charAt(right)){
            String ps = s.substring(left,right+1);
//            System.out.println("ps "+ ps);
            set.add(ps);
            left--;
            right++;
        }


    }

    public static void main(String[] args) {
        System.out.println(findPalindromes("geek"));
    }
}
