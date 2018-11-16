package string;

import java.util.HashMap;

public class StringAutomaton {

    private HashMap<Integer, HashMap<Character, Integer>> jumpTable = new HashMap<Integer, HashMap<Character, Integer>>();
    String P = "";
    private final int alphaSize = 3;

    public StringAutomaton(String p) {
        this.P = p;
//        makeJumpTable();
    }

    private void makeJumpTable() {
        int m = P.length();
        for (int q = 0; q <= m; q++) {
            for (int k = 0; k < alphaSize; k++) {

                char c = (char)('a' + k);
                String Pq = P.substring(0, q) + c;


                int nextState = findSuffix(Pq);
                System.out.println("from state " + q + " receive input char " + c + " jump to state " + nextState);
                HashMap<Character, Integer> map = jumpTable.get(q);
                if (map == null) {
                    map = new HashMap<Character, Integer>();
                }

                map.put(c, nextState);
                jumpTable.put(q, map);
            }
        }
    }


    public int findSuffix(String Pq){
        int len = Pq.length();

        for(int i = 0; i< len && i < P.length();i++){
            int ti = i;
            int k = 0;
            for(int j = 0;j < len - i && j < P.length();j++){
                if(Pq.charAt(ti) != P.charAt(j)){
                    break;
                }
                ti++;
                k++;
            }

            if(k == len -i){
                return k;
            }
        }
        return 0;
    }

    public int match(String T) {
        Integer q = 0;
        System.out.println("Begin matching...");

        for (int n = 0; n <= T.length(); n++) {
            HashMap<Character, Integer> map = jumpTable.get(q);
            int oldState = q;
            q = map.get(T.charAt(n));
            if (q == null) {
                return -1;
            }

            System.out.println("In state " + oldState + " receive input " + T.charAt(n) + " jump to state " + q);

            if (q == P.length()) {
                return q;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        StringAutomaton stringAutomaton = new StringAutomaton("ababab");

        System.out.println(    stringAutomaton.findSuffix("abababa"));
    }

}
