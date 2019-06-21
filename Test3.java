import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Test3 {



    public int solution(String str1, String str2) {
        int answer = 0;
        String pattern = "^[a-zA-Z]*$";
        String input = "ab";
        int mulNum=65536;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        LinkedList<String> str1List=new LinkedList<>();
        LinkedList<String> str2List= new LinkedList<>();
        for(int i=0; i+2<=str1.length();i++){
            String temp = str1.substring(i,i+2);
            if(Pattern.matches(pattern,temp)){
                str1List.addLast(temp);
            }
        }
        for(int i=0; i+2<=str2.length();i++){
            String temp = str2.substring(i,i+2);
            if(Pattern.matches(pattern,temp)){
                str2List.addLast(temp);
            }

        }
        Iterator<String> iter = str1List.iterator();
        int intersection =0;
        int union = 0;

        while(iter.hasNext()){
            String temp = iter.next();
            boolean flag = false;
            Iterator<String> iter2 = str2List.iterator();
            while(iter2.hasNext()){
                String temp2 = iter2.next();
                if(temp.equals(temp2)){
                    flag=true;
                    str2List.remove(temp2);
                    break;
                }
            }
            if(flag){

                intersection++;
            }


        }
        union= str1List.size()+str2List.size();

        if(intersection==0&&union==0){
            return mulNum;
        }
        else{
            double tResult = ((double)intersection/(double)union)*mulNum;
            answer = (int)tResult;

        }








        return answer;
    }

    public static void main(String[] args) {
      new Test3().solution("FRANCE","french");
    }
}
