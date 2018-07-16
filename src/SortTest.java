import sort.*;

import java.util.ArrayList;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Integer> testBubble = new ArrayList();
        testBubble.add(8);
        testBubble.add(15);
        testBubble.add(7);
        testBubble.add(3);
        testBubble.add(19);
        testBubble.add(12);
        testBubble.add(6);

        //Bubble x = new Bubble(testBubble);
        //x.bubbleSort();
        //Select x = new Select(testBubble);
        //x.selectSort();
        //Insert x = new Insert(testBubble);
        //x.insertSort();
        //Merge x = new Merge();
        //List<Integer> temp =x.merge(testBubble);
        Quick x = new Quick();
        //List<Integer> temp = x.quickSort(testBubble,0,5);
        x.quickSort(testBubble,0,6);
        for(Object i: testBubble){
            System.out.println(i);
        }
    }
}
