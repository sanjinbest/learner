package string;

public class KMPMatch {

    public void getNext(String T,Integer[] next){
        next[0] = 0 ;

        for(int i = 1; i < T.length(); i++){
            int j = 1;
            int k = 0;
            while(j < i){
                if(T.substring(0,j).equalsIgnoreCase(T.substring(i-j,i))){
                    k = j;
                }
                j++;
            }
            next[i] = k;
        }
    }

    public void getNextVal(String T,Integer[] nextVal){
        nextVal[0] = 0 ;

        for(int i = 1; i < T.length(); i++){
            int j = 1;
            int k = 0;
            while(j < i){
                if(T.substring(0,j).equalsIgnoreCase(T.substring(i-j,i))){
                    k = j;
                }
                j++;
            }
            if(T.charAt(i) == T.charAt(k)){
                nextVal[i] = nextVal[k];
            }else {
                nextVal[i] = k;
            }
        }
    }

    public int match(String S,String T){
        int i = 0;
        int j = 0;

        int num = 0;

        Integer[] next = new Integer[T.length()];
//        getNext(T,next);
        getNextVal(T,next);

        while(i < S.length() && j < T.length()){
            if(j == 0 || S.charAt(i) == T.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
            num++;
        }

        System.out.println("==========  "+num);

        if(j >= T.length()){
            return i - T.length();
        }else{
            return 0;
        }
    }



    public static void main(String[] args) {
        String S = "aaaabcde";
        String T = "aaaaaaaab";
        Integer[] next = new Integer[T.length()+5];
        new KMPMatch().getNextVal(T,next);
        for(Integer n : next){
            System.out.println(n);
        }
//
//        next = new Integer[T.length()+5];
//        new KMPMatch().getNext(T,next);
//        for(Integer n : next){
//            System.out.println(n);
//        }

//        System.out.println(new KMPMatch().match(S,T));
    }

}
