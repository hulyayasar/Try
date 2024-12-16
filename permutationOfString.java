import java.util.HashSet;
import java.util.Set;

public class permutationOfString {

    public static boolean checkInclusion(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        boolean flag = true;

        if(s1.length() ==0) return true;
        if(s1.length()> s2.length()) return false;

        for (int index = 0; index < s1.length()-1; index++) {
            set.add(s2.charAt(index));
        }

        //System.out.println("set before" + set);
        
        for(int i =0; i<s2.length()-s1.length() ; i++){

            set.add(s2.charAt(i+s1.length()-1));
            flag = true;

            for (int index = 0; index < s1.length(); index++) {

                if(!set.contains(s1.charAt(index))){
                    flag = false;
                    break;
                }
            }
            if(flag) return flag;

            set.remove(s2.charAt(i)); 
            //System.out.println("set end of loop" + set);    
        }

        return flag;
        
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(testCheckInclusion("abc", "lecabee", true)); // Expected: true
        System.out.println(testCheckInclusion("abc", "lecaabee", false)); // Expected: false
        System.out.println(testCheckInclusion("a", "a", true)); // Expected: true
        System.out.println(testCheckInclusion("abc", "ab", false)); // Expected: false
        System.out.println(testCheckInclusion("ab", "eidbaooo", true)); // Expected: true
        System.out.println(testCheckInclusion("adc", "dcda", true)); // Expected: true
        System.out.println(testCheckInclusion("xyz", "abcdefg", false)); // Expected: false
        System.out.println(testCheckInclusion("", "abcdefg", true)); // Expected: true (empty string is a permutation of any string)
        System.out.println(testCheckInclusion("abc", "", false)); // Expected: false
        System.out.println(testCheckInclusion("aaa", "aaaaaa", true)); // Expected: true
    }

    public static String testCheckInclusion(String s1, String s2, boolean expected) {
        boolean result = checkInclusion(s1, s2);
        return result == expected ? "PASS" : "FAIL: got " + result + " but expected " + expected;
    }

    
}
