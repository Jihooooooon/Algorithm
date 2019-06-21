import java.util.Scanner;

public class HoneyPot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputV = scan.nextLine();
        int input= Integer.parseInt(inputV);

        //1,6,12,18,24
        //1,7,19,37,61
        //6(n-1)+1
        System.out.println(findLocate(input));

    }

    public static int findLocate(int input){
        int n=1;
        if(input==1){
            return 1;
        }
        else{
            while(true) {
                if(input<=(3 * (n - 1) * (n - 1) + 3 * (n - 1)+1)){
                    break;
                }
                else{
                    n++;
                    continue;
                }
            }
            return n;
        }


    }
}
