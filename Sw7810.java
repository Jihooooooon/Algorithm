import java.util.Scanner;

public class Sw7810 {
    static Scanner sc = new Scanner(System.in);
    static int[] count= new int[500001];
    static int[] count2= new int[500001];
    public static void main(String[] args) {
        int T=sc.nextInt();
        int result;
        int N;
        for(int test=1; test<=T;test++){
            N=sc.nextInt();
            int max=0;
            int temp;
            for(int i=0; i<N;i++){
                temp=sc.nextInt();
                max=max<temp?temp:max;
                count[temp]++;
            }
            count2[max]=count[max];
            for(int i=max-1;i>0;i--){
                count2[i]+=count2[i+1]+count[i];
            }
            result=1;
            for(int i=2; i<=max;i++){
               if(count2[i]>=i){
                   result=i;
               }
            }

            System.out.println("#"+test+" "+result);

            for(int i=1; i<max+1;i++){
                count[i]=0;
                count2[i]=0;
            }
        }
    }
}
