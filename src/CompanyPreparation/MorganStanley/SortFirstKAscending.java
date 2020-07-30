package CompanyPreparation.MorganStanley;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortFirstKAscending {
    public static void main(String[] args) {
        Integer[] arr = {5,4,6,2,1,3,8,9,-1};
        int k = 4;
        printOrder(arr,k);
        System.out.println(Arrays.toString(arr));


    }

    static void printOrder(Integer[] arr, int k){
        int n = arr.length;
        Arrays.sort(arr,0,k);
        Arrays.sort(arr,k,n,Collections.reverseOrder());
    }
}
