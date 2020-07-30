package CompanyPreparation.MorganStanley;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public int[][] merge(int[][] intervals) {
        //        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        //        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2)
            {
                return o1[0]-o2[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        if(intervals.length==0 || intervals[0]==null)
            return intervals;
        stack.push(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            int[] compareWithInterval = stack.peek();
            if(interval[0]>compareWithInterval[1]){
                stack.push(interval);
            }
            else {
                if(compareWithInterval[1]<interval[1]){
                    int[] newinterval = new int[2];
                    newinterval[0]=compareWithInterval[0];
                    newinterval[1]=interval[1];
                    stack.pop();
                    stack.push(newinterval);
                }
            }
        }
        int[][] result = new int[stack.size()][2];
        for(int i=result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }

}
