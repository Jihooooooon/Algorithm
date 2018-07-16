import java.util.Arrays;
import java.util.Scanner;


//직사각형 알고리즘 문제
public class Hello{
    public static void main(String[] args) {
        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        scan.nextLine();
        int[][] recVertex = new int[4][2];
        int[][] newVertex= new int[input][2];
        for(int i=0; i<input;i++){
            int count=0;
            String line;
            while(count !=3) {

                line = scan.nextLine();
                String[] vertex = line.split(" ");
                for(int j=0; j<2;j++) {
                    recVertex[count][j] = Integer.parseInt(vertex[j]);
                }
                count++;
            }


            if(((recVertex[0][0]==recVertex[1][0]) | (recVertex[0][0]==recVertex[2][0]))&&((recVertex[0][1]==recVertex[1][1]) | (recVertex[0][1]==recVertex[2][1])) )
            {
                int temp1;
                int temp2;
                if(recVertex[0][0]==recVertex[1][0]){
                    temp1=recVertex[1][1]-recVertex[0][1];
                    temp2=recVertex[2][0]-recVertex[0][0];

                    recVertex[3][0]=recVertex[0][0]+temp2;
                    recVertex[3][1]=recVertex[0][1]+temp1;
                }
                else{
                    temp1= recVertex[2][1]-recVertex[0][1];
                    temp2= recVertex[1][0]-recVertex[0][0];
                }
                recVertex[3][0]=recVertex[0][0]+temp2;
                recVertex[3][1]=recVertex[0][1]+temp1;

            }
            else if(((recVertex[1][0]==recVertex[0][0]) | (recVertex[1][0]==recVertex[2][0]))&&((recVertex[1][1]==recVertex[0][1]) | (recVertex[1][1]==recVertex[2][1])) )
            {
                int temp1;
                int temp2;
                if(recVertex[1][0]==recVertex[0][0]){
                    temp1=recVertex[0][1]-recVertex[1][1];
                    temp2=recVertex[2][0]-recVertex[1][0];

                    recVertex[3][0]=recVertex[1][0]+temp2;
                    recVertex[3][1]=recVertex[1][1]+temp1;
                }
                else{
                    temp1= recVertex[2][1]-recVertex[1][1];
                    temp2= recVertex[0][0]-recVertex[1][0];
                }
                recVertex[3][0]=recVertex[1][0]+temp2;
                recVertex[3][1]=recVertex[1][1]+temp1;
            }
            else{
                int temp1;
                int temp2;
                if(recVertex[2][0]==recVertex[0][0]){
                    temp1=recVertex[0][1]-recVertex[2][1];
                    temp2=recVertex[1][0]-recVertex[2][0];

                    recVertex[3][0]=recVertex[2][0]+temp2;
                    recVertex[3][1]=recVertex[2][1]+temp1;
                }
                else{
                    temp1= recVertex[1][1]-recVertex[2][1];
                    temp2= recVertex[0][0]-recVertex[2][0];
                }
                recVertex[3][0]=recVertex[2][0]+temp2;
                recVertex[3][1]=recVertex[2][1]+temp1;
            }

            newVertex[i][0]=recVertex[3][0];
            newVertex[i][1]=recVertex[3][1];


        }
        for(int u=0; u<newVertex.length; u++){
            System.out.println(newVertex[u][0]+" "+newVertex[u][1]);
        }


        }

    }


