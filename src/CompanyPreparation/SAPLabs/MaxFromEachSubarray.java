package CompanyPreparation.SAPLabs;

import java.util.LinkedList;

public class MaxFromEachSubarray {
    public static void printMax(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<k; i++){
            while (!list.isEmpty() && arr[list.getLast()]<arr[i]){
                list.removeLast();
            }
            list.addLast(i);
        }

        for(int i=k; i<arr.length; i++){
            System.out.print(arr[list.getFirst()]+ " ");
            while (!list.isEmpty() && (list.getFirst()<(i-k+1))){
                list.removeFirst();
            }
            while (!list.isEmpty() && arr[list.getLast()]<arr[i]){
                list.removeLast();
            }
            list.addLast(i);
        }
        System.out.print(arr[list.getFirst()]);
    }

    public static void main(String[] args) {
        int[] array = {9,6,11,8,10,5,14,13,93,14};
        int k = 4;

        System.out.println("Maximum elements from each sub-array of specified size are - ");
        printMax(array,k);
    }
}
