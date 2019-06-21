package sort;

import java.util.List;

public class Select {
    private List<Integer> selectList ;
    public Select(){

    }

    public Select(List<Integer> inputList){
        this.setSelectList(inputList);
    }

    public void setSelectList(List<Integer> selectList) {
        this.selectList = selectList;
    }

    public List<Integer> getSelectList() {
        return selectList;
    }

    public List<Integer> selectSort(){
        int listSize=this.getSelectList().size()-1;
        for(int i=0; i<listSize ; i++){
            int min= this.getSelectList().get(i);
            for(int j=i+1; j<this.getSelectList().size() ;j++){
                if(min>this.getSelectList().get(j)){
                    int temp = this.getSelectList().get(j);
                    this.getSelectList().set(j, min);
                    this.getSelectList().set(i, temp);
                    min=temp;

                }

            }
        }
        return this.getSelectList();
    }

    public List<Integer> selectSort(List<Integer> inputList){
        this.setSelectList(inputList);
        return this.selectSort();

    }
}
