package string;

public class GeneralMatch {

    public int match(String S,String T){
        int i = 0;
        int j = 0;

        while(i < S.length() && j < T.length()){
            if(S.charAt(i) == T.charAt(j)){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }

        if(j >= T.length()){
            return i - T.length();
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GeneralMatch().match("abcdefghigk","igk"));
    }
}
