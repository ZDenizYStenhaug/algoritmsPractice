import java.util.ArrayList;
import java.util.List;

public class IsUnique {

    public static void main(String[] args) {
        System.out.println(isUnique2("unique"));
        System.out.println(isUnique2("lobster"));
    }

    /*
    determines if a string has all unique chars.s
     */
    public static boolean isUnique(String str) {
        List<Character> usedChars = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (usedChars.contains(str.charAt(i))) {
                return false;
            }
            usedChars.add(str.charAt(i));
        }
        return true;
    }

    /*
    a better solution
     */
    public static boolean isUnique2(String str) {
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
}
