package dataStructure;

public class Stack {
    private final int SIZE = 10000;
    private Object[] _stack;
    private int point;
    public Stack(){
        this.set_stack(SIZE);
        this.setPoint(0);
    }
    public Stack(int inputSize) {
        this.set_stack(inputSize);
        this.setPoint(0);
    }

    private int getPoint() {
        return point;
    }

    private void setPoint(int point) {
        this.point = point;
    }

    private Object[] get_stack() {
        return this._stack;
    }

    private void set_stack(int inputSize) {
        this._stack= new Object[inputSize];
    }

    public int size(){
        return this.get_stack().length;
    }

    public void push(Object inputV){
        if(this.getPoint()<this.size()) {
            this.get_stack()[this.getPoint()] = inputV;
            this.setPoint(this.getPoint() + 1);
        }
        else{
            //System.out.println("full stack");
        }
    }

    public Object peek(){
        if(this.getPoint()!=0){
            return this.get_stack()[this.getPoint()-1];
        }
        else{
            //System.out.println("stack is empty");
            return null;
        }
    }

    public Object pop(){
        if(this.getPoint()!=0){
            Object temp = this.get_stack()[this.getPoint()-1];
            this.get_stack()[this.getPoint()-1]=null;
            this.setPoint(this.getPoint()-1);

            return temp;
        }
        else{
            //System.out.println("stack is empty");
            return null;
        }
    }


}
