import java.util.HashMap;

public class StringPermutation {

    static boolean isPermuation(String s1, String s2) {
        return (s1.length()>s2.length())?helper(s1, s2):helper(s2, s1);
    }

    static boolean helper(String s1, String s2){
        HashMap<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if(charMap.containsKey(c)){
                int freq = charMap.get(c);
                charMap.put(c, freq+1);
            }
            else{
                charMap.put(c, 1);
            }
        }
        for(int i=0; i<s2.length(); i++){
            char c = s2.charAt(i);
            if(charMap.containsKey(c)){
                int freq = charMap.get(c);
                if(freq == 0){return false;}
                freq --;
                charMap.put(c,freq);
            }
            else return false;
        }
        return true;
    }

    public static void main(String ... args){
        System.out.println(isPermuation("funnypage", "pgne"));
    }
}
