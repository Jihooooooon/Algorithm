package sort;

import java.util.ArrayList;
import java.util.List;

public class Bubble {
    private List<Integer> bubbleList ;

    public Bubble(){
    }

    public Bubble(List<Integer> inputList){
        this.setBubbleList(inputList);

    }

    private List<Integer> getBubbleList() {
        return bubbleList;
    }

    private void setBubbleList(List<Integer> bubbleList) {
        this.bubbleList = bubbleList;
    }

    public List<Integer> bubbleSort(){
        if(getBubbleList().size()<=1){
            return this.getBubbleList();
        }
        else{
            int length = this.getBubbleList().size()-1;
            for(int i =0; i < length ; i++){
                for(int j=0; j<length-i ; j++){
                    if(this.getBubbleList().get(j)>this.getBubbleList().get(j+1)){
                        int temp = this.getBubbleList().get(j);
                        this.getBubbleList().set(j,this.getBubbleList().get(j+1));
                        this.getBubbleList().set(j+1,temp);
                    }
                }
            }
            return this.getBubbleList();
        }

    }

    public List<Integer> bubbleSort(List<Integer> inputList){
        this.setBubbleList(inputList);
        return bubbleSort();
    }

}
