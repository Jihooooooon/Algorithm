import java.util.*;

public class Test {


    LinkedHashMap<Node, LinkedList<Node>> busTable;


    public void makeHashmapKey(int n, int t){
        int hour=9;
        int minute= 0;
        busTable.put(new Node(hour,minute),new LinkedList<Node>());
        for(int i=0; i<n-1;i++){
            minute+=t;
            hour+=minute/60;
            minute%=60;
            busTable.put(new Node(hour,minute), new LinkedList<Node>());
        }

    }

    public void canRide(int m, PriorityQueue<Node> priorityQueue){




        for(Map.Entry<Node, LinkedList<Node>> entry: busTable.entrySet()){
            int pivotTime = entry.getKey().hour;
            int pivotminute = entry.getKey().minute;
            LinkedList<Node> tempList = entry.getValue();

            while (priorityQueue.size()!=0){
                    if(tempList.size()==m){

                        break;
                    }
                Node passenger = priorityQueue.peek();
                    if(passenger.hour<pivotTime){

                        tempList.add(passenger);
                        priorityQueue.poll();
                    }
                    else if(passenger.hour==pivotTime){
                        if(passenger.minute<=pivotminute){

                            tempList.add(passenger);
                            priorityQueue.poll();

                        }
                        else{
                            break;
                        }

                    }
                    else{
                        break;
                    }
            }







        }

    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        busTable = new LinkedHashMap<>();
        makeHashmapKey(n,t);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for(String time:timetable){
            priorityQueue.add(new Node(time));

        }
        canRide(m,priorityQueue);
        List<Node> keyList = new ArrayList<Node>(busTable.keySet());




           Node key = keyList.get(keyList.size()-1);
           LinkedList<Node> value = busTable.get(key);
           if(value.size()<m){
               //버스시간에오면 됨
               String sHour = String.valueOf(key.hour);
               String sMin = String.valueOf(key.minute);
               if(sHour.length()==1){
                   sHour = "0"+sHour;
               }
               if(sMin.length()==1){
                   sMin = "0"+sMin;
               }
               answer = sHour +":"+sMin;

           }

           else {
               //맨마지막 사람 시간 -1
               Node temp = value.getLast();
               int tHour = temp.hour;
               int tMin = temp.minute;
               if(tMin==0){
                   tMin=59;
                   tHour--;

               }
               else {
                   tMin--;
               }
               String sHour = String.valueOf(tHour);
               String sMin = String.valueOf(tMin);
               if(sHour.length()==1){
                   sHour = "0"+sHour;
               }
               if(sMin.length()==1){
                   sMin = "0"+sMin;
               }
               answer = sHour +":"+sMin;

           }




        return answer;
    }

    public static void main(String[] args) {
        new Test().solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"});
    }

    class Node implements Comparable<Node>{

        int hour;
        int minute;

        Node(String input){

            this.hour = Integer.parseInt(input.substring(0,2));
            this.minute = Integer.parseInt(input.substring(3,5));


        }

        @Override
        public boolean equals(Object o) {

            Node node = (Node) o;
            return hour == node.hour &&
                    minute == node.minute;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hour, minute);
        }

        Node(int hour, int minute){
            this.hour=hour;
            this.minute = minute;
        }
        @Override
        public int compareTo(Node o) {
            if(this.hour>o.hour){
                return 1;
            }
            else if(this.hour==o.hour){
                if(this.minute>o.minute){
                    return 1;

                }
                else {
                    return -1;
                }

            }
            else return -1;
        }
    }
}
