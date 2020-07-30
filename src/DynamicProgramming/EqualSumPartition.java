package DynamicProgramming;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        if(sum%2!=0){
            System.out.println("not possible as sum is odd");
            return;
        }
        boolean b = SubsetSumProblem.checkIfsubsetSumExists(arr,sum/2);
        if(b){
            System.out.println("equal sum partition can be done");
        }
        else {
            System.out.println("equal sum partition does not exist");
        }

    }
}
