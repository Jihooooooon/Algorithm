import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String count = scan.nextLine();
        int _count = Integer.parseInt(count);
        int temp=0;
        String[] input = new String[_count];
        while(temp<_count){
            String sentence = scan.nextLine();
            input[temp]= sentence;
            temp++;
        }
        for(int i=0; i<_count;i++){
            String s = input[i];
            char[] cs = new char[s.length()];
            for(int j=0; j<s.length();j++){
                cs[j]= s.charAt(j);
            }
            for(int k=0; 2*k<s.length();k++){
                System.out.print(cs[2*k]);
            }
            for(int j=0; (2*j+1)<s.length();j++){
                System.out.print(cs[2*j+1]);
            }
            System.out.println();

        }

    }

}
