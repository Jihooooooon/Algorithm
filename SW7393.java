import java.util.Scanner;

/**
 * Created by JIHOON on 2019-06-28.
 */
public class SW7393 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int dp[][][] = new int[101][10][1024];
        int mod =1000000000;
        for(int i=1; i<10;i++){
            dp[1][i][1<<i]=1;

        }

        for(int i=2; i<101;i++){
            for(int j=0; j<10;j++){
                for(int k=0;k<1024;k++){
                    int bit = k|(1<<j);
                    if(j>0){
                        dp[i][j][bit]+= dp[i-1][j-1][k];
                        dp[i][j][bit]%=mod;
                    }
                    if(j<9){
                        dp[i][j][bit]+=dp[i-1][j+1][k];
                        dp[i][j][bit]%=mod;
                    }

                }
            }
        }

        int T=sc.nextInt();
        int result;
        for(int test=1;test<=T;test++){
            int len=sc.nextInt();
            result=0;
            for(int i=0; i<10;i++){
                result+=dp[len][i][1023];
                result%=mod;
            }
            System.out.println("#"+test+" "+result);
        }

    }
}
