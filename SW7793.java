import java.util.Queue;
import java.util.Scanner;

public class SW7793 {

    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static char[][] map= new char[50][50];
    static int startX,startY;

    static int devilX,devilY;
    static  MyQueue queue;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int count;
    static boolean gameOver ;
    public static boolean canGo(int x, int y){
        if(x<0||y<0||x>=N||y>=M) return false;
        if(map[x][y]=='X') return false;
        return true;
    }

    public static void bfs(){


        queue.add(new Node(startX,startY));
        boolean visit[][] = new boolean[N][M];
        visit[startX][startY]=true;
        gameOver=false;
        count=0;
        while(!queue.isEmpty()){
            int queSize = queue.size();
            boolean flag = false;
            for(int i=0; i<queSize;i++){
                Node temp = queue.poll();
                for(int j=0; j<4;j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];

                    if(canGo(nx,ny)&& map[nx][ny]=='D'&&!temp.isDevil){
                        count++;
                        return;
                    }


                    if (canGo(nx, ny) && map[nx][ny] == '.' && !visit[nx][ny]) {

                        if (temp.isDevil) {
                            map[nx][ny] = '*';
                            queue.add(new Node(nx, ny, true));
                        } else {
                            visit[nx][ny]=true;
                            flag = true;
                            queue.add(new Node(nx, ny));
                        }
                    }

                }
            }
            if(flag) {
                count++;
            }
            else{
                gameOver=true;
                return;
            }
        }
        gameOver=true;
        return;
    }

    public static void main(String[] args) {
        int T=sc.nextInt();
        queue = new MyQueue();
        for(int test=1;test<=T;test++){
            N=sc.nextInt();
            M=sc.nextInt();


            for(int i=0;i<N;i++){
                map[i]=sc.next().toCharArray();
                for(int j=0; j<M;j++){
                    if(map[i][j]=='S'){
                        startX=i;
                        startY=j;
                    }
                    if(map[i][j]=='*'){
                        devilX=i;
                        devilY=j;
                        queue.add(new Node(devilX,devilY,true));
                    }
                }
            }
            bfs();
            queue.clear();
            if(gameOver){
                System.out.println("#" + test + " GAME OVER");
            }
            else {
                System.out.println("#" + test + " " + count);
            }
        }


    }

    static class Node{
        int x;
        int y;
        boolean isDevil;
        Node next;

        public void setDevil(boolean devil){
            isDevil= devil;
        }

        public Node(){
            this.next=null;
            isDevil=false;
        }

        public Node(int x, int y){
            this.x=x;
            this.y=y;
            this.next=null;
            isDevil=false;
        }

        public Node(int x, int y, boolean flag){
            this(x,y);
            isDevil = flag;
        }


    }

    static class MyQueue{
        private int size;
        private Node head;
        private Node tail;

        public MyQueue(){
            head=tail=new Node();
            size=0;
        }

        public int size(){
            return this.size;
        }

        public boolean isEmpty(){

            return this.size==0?true:false;
        }

        public void add(int x, int y){
            Node temp = new Node(x,y);
            this.add(temp);
            this.size++;
        }
        public void add(Node input){
            tail.next = input;
            tail=input;
            this.size++;
        }

        public Node peek(){
            if(size!=0){
                return head.next;
            }
            return null;
        }

        public void clear(){
            this.size=0;
            head.next=null;
            tail=head;
        }

        public Node poll(){
            if(size!=0){
                Node temp = head.next;
                if(size==1){
                    head.next=null;
                    tail=head;
                }
                else {
                    head.next = temp.next;
                }
                size--;
                return temp;
            }
            return null;

        }

    }
}
