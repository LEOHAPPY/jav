import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String s = "abdcd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if(map.containsKey(s.charAt(i))){

            }
            map.put(s.charAt(i), i);
            map.
        }

    }


}
