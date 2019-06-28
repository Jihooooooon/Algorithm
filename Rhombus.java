import java.util.Scanner;

/**
 * Created by JIHOON on 2019-06-28.
 */
public class Rhombus {

    static Scanner sc = new Scanner(System.in);
    static int[][] map = new int[750][750];
    static int N,M;
    static int dx[]={1,1,-1,-1};
    static int dy[]={-1,1,1,-1};
    static int result;
    static int startX;
    static int startY;
    static boolean[][] visit;
    public static boolean canGo(int x, int y){
        if(x<0||y<0||x>=N||y>=M) return false;
        if(map[x][y]==0) return false;
        return true;
    }

    //아이디어 : 재귀는 dir이 0일때만
    //나머지는 한번에 검사

    public static void check(int x,int y, int count){
        int tempX=x;
        int tempY=y;
        int tX=startX;
        int tY=startY;
        for(int j=1;j<4;j++) {
            for (int i = 0; i < count - 1; i++) {
                tempX += dx[j];
                tempY += dy[j];
                if (canGo(tempX, tempY)) continue;
                else return;
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j < count-1; j++){
                tX+= dx[i];
                tY+=dy[i];
                visit[tX][tY]=true;

            }
        }
        result=count;
    }

    public static void dfs(int X,int Y,int count){
        int nextX=X+dx[0];
        int nextY=Y+dy[0];
        int tempCount=count;
        while(true) {
            if (canGo(nextX, nextY)) {
                tempCount++;
                if (canGo(nextX + dx[1], nextY + dy[1]) &&canGo(nextX + 1, nextY + 1) && tempCount > result) {
                    check(nextX, nextY, tempCount);
                }
                nextX+=dx[0];
                nextY+=dy[0];
                continue;
            }
            else break;

        }
        return;


    }

    public static void main(String[] args) {
        int T=sc.nextInt();
        for(int test=1;test<=T;test++){

            N=sc.nextInt();
            M=sc.nextInt();
            visit = new boolean[N][M];
            for(int i=0; i<N;i++){
                String temp = sc.next();
                char[] temp2 = temp.toCharArray();
                for(int j=0; j<M;j++){
                    map[i][j]=temp2[j]-'0';
                }
            }

            for(int i=0; i<N-result;i++){
                for(int j=0; j<M-result;j++){
                    if(map[i][j]==1&&!visit[i][j]){
                        if(result==0) result++;
                        startX=i;
                        startY=j;

                        dfs(i,j,1);

                    }
                }
            }

            System.out.println("#"+test+" "+result);
            result=0;
        }
    }
}
