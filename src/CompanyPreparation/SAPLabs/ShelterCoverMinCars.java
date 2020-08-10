package CompanyPreparation.SAPLabs;

/*
sliding window problem:
whenever you have an array and a group, fixed length, eg: k here. use sliding window problem
Given the locations of all the cars parked in an array and an integer k,
minimum no of cars to be covered by shelter,
return the minimum length of shelter needed to cover k cars.
Eg: [6 2 12 7] and k=3, min length is 6 (from 2 to 7)
 */

import java.util.Arrays;

public class ShelterCoverMinCars {
    public static void main(String[] args) {
        int carloc[] = {6,2,12,7};
        int k = 3;
        if(k>carloc.length){
            System.out.println(-1);
        }
        Arrays.sort(carloc);
        int left = 0;
        int right = k-1;
//        System.out.println(Arrays.toString(carloc));
        int min = Integer.MAX_VALUE;
        int current;
        while (right<carloc.length){
           current = carloc[right]-carloc[left] + 1;
//            System.out.println("left: "+carloc[left]);
//            System.out.println("right: "+carloc[right]);
//            System.out.println("current: "+current);
           min = Math.min(min,current);
           left++;
           right++;
        }
        System.out.println(min);
    }
}
