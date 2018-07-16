import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Chess {
    static int queenCount=0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String _inputCount = scan.nextLine();
        int inputCount = Integer.parseInt(_inputCount);
        int count=0;
        int finalCount[] = new int[inputCount];

        while(count<inputCount){
            String _arrSize = scan.nextLine();
            int arrSize = Integer.parseInt(_arrSize);

            back_tracking(0,arrSize, new int[arrSize]);
            finalCount[count]= queenCount;
            queenCount=0;
            count++;
        }
        for(int i : finalCount){
            System.out.println(i);
        }

    }

    public static void back_tracking(int level, int MaxLevel, int[] arr)
    {
        if(level==MaxLevel){
             queenCount++;
             return;
        }
        else{
            for(int i=0; i<MaxLevel;i++){
                arr[level] = i;
                if(isPossible(level,arr)) {

                    back_tracking(level+1,MaxLevel,arr);
                }
            }
        }
    }

    public static boolean isPossible(int level, int[] arr){
        for(int i=0; i<level;i++){
            if(arr[i]==arr[level] || Math.abs(level-i)==Math.abs(arr[level]-arr[i]))
                return false;

        }
        return true;
    }




}
