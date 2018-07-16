package sort;

import java.util.List;

public class Insert {
    private List<Integer> insertList;
    public Insert(){}
    public Insert(List<Integer> inputList){
        this.setInsertList(inputList);
    }

    public void setInsertList(List<Integer> insertList) {
        this.insertList = insertList;
    }

    public List<Integer> getInsertList() {
        return insertList;
    }

    public List<Integer> insertSort(){
        if(this.getInsertList().size()<=1){
            return this.getInsertList();
        }
        else{
            for(int index =1; index < this.getInsertList().size(); index++){
                int temp= this.getInsertList().get(index);
                int ux = index-1;
                while(this.getInsertList().get(ux)>temp){
                    this.getInsertList().set(ux+1,this.getInsertList().get(ux));
                    ux --;
                }
                this.getInsertList().set(ux+1, temp);
            }
            return this.getInsertList();
        }
    }

    public List<Integer> insertSort(List<Integer> inputList){
        this.setInsertList(inputList);
        return this.insertSort();
    }
}
