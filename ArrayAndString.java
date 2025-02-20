import java.util.HashMap;
import java.util.HashSet;

public class ArrayAndString {

    public static boolean isUnique(String s) {
        int len = s.length();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static boolean checkPermulation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, ++count);
            }
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            int count = map.get(c);
            map.put(c, --count);
            if (count < 0) {
                return false;
            }

        }

        return true;
    }

    public static void urlIfy(String s, int trueLength) {
        char[] arr = s.toCharArray();
        int countSpace = 0;
        for (int i = 0; i < trueLength; i++) {
            if (arr[i] == ' ') {
                countSpace++;
            }
        }

        int index = arr.length - 1;

        for (int i = trueLength - 1; i > 0; i--) {
            if (arr[i] == ' ') {
                arr[index - 2] = '%';
                arr[index - 1] = '2';
                arr[index] = '0';
                index = index - 3;

            } else {
                arr[index] = arr[i];
                index--;

            }

        }
        System.out.println("urlIfy1:" + String.valueOf(arr));

        // System.out.println("urlIfy:" + arr.);

    }

    public static void main(String[] args) {
        String input = "abca";
        boolean result = isUnique(input);
        boolean result1 = checkPermulation("abac", "bcaa");
        System.out.println("isUnique" + input + result);
        System.out.println("checkPermulation" + input + result1);
        urlIfy("Mr John Smith    ", 13);
    }
}