package CompanyPreparation.MorganStanley;

import java.util.HashSet;

public class SubStringManipulation {
    HashSet<String> set = new HashSet<>();
    public void findUnique(String input1, String input2, String output){
        if(input2.length()==0){
            System.out.println("output: "+output);
            set.add(output);
            return;
        }
        String x = input1.replace(input1.charAt(0),input2.charAt(0));
        String output1 = output+x.charAt(0);
        String output2 = output+input1.charAt(0);
        input1 = input1.substring(1);
        input2 = input2.substring(1);
        findUnique(input1,input2,output1);
        findUnique(input1,input2,output2);

    }


    public static void main(String[] args) {

        SubStringManipulation subStringManipulation = new SubStringManipulation();
        System.out.println("find unique....");
        subStringManipulation.findUnique("abc","xyz","");
        System.out.println("count...");
        System.out.println(subStringManipulation.set.size());

    }
}
