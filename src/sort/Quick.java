package sort;

import java.util.List;

public class Quick {

    public Quick() {
    }

    public void quickSort(List<Integer> inputList,int start, int end){
        if(start>=end){
            return ;
        }
        else{
            int pivot = inputList.get(start);
            int left = start+1;
            int right = end;
            do{
                while(left<inputList.size() && inputList.get(left)<pivot) left++;
                while(right>0 && inputList.get(right)>pivot) right--;

                if(left<right){
                    swap(inputList,left++,right--);
                }
            }
            while(left<=right);
            if(left>right){
                swap(inputList,start,right);
            }

            quickSort(inputList,start,right);
            quickSort(inputList,left,end);

        }

    }

    private void swap(List<Integer> inputList,int start, int end){
        int temp = inputList.get(end);
        inputList.set(end,inputList.get(start));
        inputList.set(start, temp);
    }
}
