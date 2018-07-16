package sort;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class Merge {
    private List<Integer> mergeList;

    public Merge() {
    }

    public Merge(List<Integer> mergeList) {
        this.mergeList = mergeList;
    }

    public List<Integer> getMergeList() {
        return mergeList;
    }

    public void setMergeList(List<Integer> mergeList) {
        this.mergeList = mergeList;
    }

    public List<Integer> merge(List<Integer> inputList){
        if(inputList.size()<=1){
            return inputList;
        }
        else{
            int mid = inputList.size()/2;

            List<Integer> left = inputList.subList(0,mid);

            List<Integer> right = inputList.subList(mid,inputList.size());
            left=merge(left);
            right=merge(right);
            int i=0,j=0;
            List<Integer> _mergeList = new ArrayList<>();
            while((i<left.size()) && (j <right.size())){
                if(left.get(i)<right.get(j)){
                    _mergeList.add(left.get(i));
                    i++;
                }
                else if(left.get(i)>=right.get(j)){
                    _mergeList.add(right.get(j));
                    j++;
                }

            }
            if(i<left.size()){
                while(i<left.size()){
                    _mergeList.add(left.get(i));
                    i++;
                }
            }
            if(j<right.size()){
                while(j<right.size()){
                    _mergeList.add(right.get(j));
                    j++;
                }
            }
            return _mergeList;
        }

    }
}
