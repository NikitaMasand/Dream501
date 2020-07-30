package Recursion;

public class PrintAllSubsequences {

    public static void printSubsequences(String input, String output) {
        if(input.length()==0){
//            if(output.length()==3)
                System.out.println(output);
            return;
        }

        //do not include current character
        String output1 = output;
        //include current character
        String output2 = output+input.charAt(0);
        //go to next character
        input = input.substring(1);
        printSubsequences(input,output1);
        printSubsequences(input,output2);

    }
    public static void main(String[] args) {
        String input = "einv";
        printSubsequences(input,"");

    }
}
