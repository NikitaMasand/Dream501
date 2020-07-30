package DynamicProgramming;
//# of insertions = # of deletions
public class MinimumDeletionsOrInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {
        String x = "agbcba";
        String y = new StringBuilder(x).reverse().toString();
        int lcslen = LongestCommonSubsequence.dpLCS(x,y,x.length(),y.length());
        int lpslen = lcslen;
        int mindeletions = x.length()-lpslen;

        System.out.println("min number of deletions can be found after getting lps");
        //len of lps formed is inversely proportional to number of deletions
        System.out.println(mindeletions);
    }
}
