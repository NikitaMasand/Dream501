package Recursion;
//unsupported operation exception. will see the issue later
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAnArray {
    static void sort(List<Integer> list){
        if(list.size()==1)
            return;

        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(list,temp);
    }

    static void insert(List<Integer>list, int temp) {
        if(list.size()==0 || list.get(list.size()-1)<=temp){
            list.add(temp);
            return;
        }
        int value = list.remove(list.size()-1);
        insert(list,temp);
        list.add(value);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,0,5,2};
        List<Integer> list = Arrays.asList(arr);
        sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
