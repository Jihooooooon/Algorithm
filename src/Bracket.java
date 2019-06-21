

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String _count = scan.nextLine();
        int count = Integer.parseInt(_count);
        int un=0;



        boolean correct[] = new boolean[count];

        while(un<count){
            String bracket=scan.nextLine();
            String tempBracket[] = bracket.split("");
            Stack stack = new Stack();
            boolean answer =false;
            for(String a :tempBracket){
                if(a.equals("}") || a.equals("]") || a.equals(")")){

                    if(stack.peek()==null){

                        answer=false;
                        break;
                    }
                    else {
                        Object s=stack.pop();
                        switch (a) {
                            case "}" :
                                answer =s.equals("{");
                                break;

                            case ")" :
                                answer = s.equals("(");
                                break;
                            case "]" :
                                answer = s.equals("[");
                                break;

                            default:
                                break;

                        }
                        if(!answer){
                            break;
                        }
                    }
                }
                else{
                    stack.push(a);
                }
            }

            correct[un++]=answer;
        }
        for(boolean b : correct){
            if(b) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

    }

}
