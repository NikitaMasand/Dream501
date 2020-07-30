package CompanyPreparation.MorganStanley;

import java.util.Arrays;

public class CountingInversions {
    public static void main(String[] args) {
        int[] arr = {15,5,24,8,1};
        System.out.println(Arrays.toString(arr));
        System.out.println("number of inversions..."+countInversions(arr,0,arr.length-1));
        System.out.println(Arrays.toString(arr));
    }

    public static long countInversions(int[] arr, int low, int high){
        if(arr.length<2)
            return 0;
        if(low<high){
            int mid = low + (high-low)/2;
            return countInversions(arr,low,mid)+countInversions(arr,mid+1,high)
                    +merge(arr,low,mid,high);
        }
        return 0;
    }

    public static long merge(int[] arr, int low, int mid, int high){
        long count =0;
        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=arr[i+low];
        }
        for(int j=0;j<n2;j++){
            right[j]=arr[mid+1+j];
        }

        int i=0;
        int j=0;
        int k=low;

        while (i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                count+=(n1-i);
                j++;
            }
            k++;
        }

        while (i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
        return count;
    }
}
