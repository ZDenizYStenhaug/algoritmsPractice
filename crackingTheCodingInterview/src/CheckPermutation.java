import java.util.Arrays;

public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(checkPermutation("abcdefg", "acbdfeg"));
    }
    /*
    takes in two strings and decides if one is the permutation of the other.
     */
    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String str1Ordered = sortString(str1);
        String str2Ordered = sortString(str2);
        return str1Ordered.equals(str2Ordered);
    }

    public static String sortString(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return String.valueOf(content);
    }

}
