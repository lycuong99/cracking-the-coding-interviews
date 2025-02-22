import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

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

    static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i;

        // Đếm số lượng dấu cách trong phạm vi trueLength
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // Tính toán chỉ mục cuối cùng của chuỗi sau khi thay thế
        index = trueLength + spaceCount * 2;

        // Nếu có đủ chỗ trống ở cuối, cần đặt ký tự null tại vị trí mới
        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }

        // Đi từ cuối về đầu để thay thế dấu cách bằng "%20"
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        System.out.println("urlIfy2:" + String.valueOf(str));
    }

    public static void zeroMatrix(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        printMatrix(matrix);

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);

    }

    public static void zeroMatrixOptimize(int[][] matrix) {
        printMatrix(matrix);

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        boolean rowHasZero = false;
        boolean colHasZero = false;

        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                rowHasZero = true;
            }
        }
        for (int j = 0; j < colLength; j++) {
            if (matrix[0][j] == 0) {
                colHasZero = true;
            }
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    rowHasZero = true;
                    colHasZero = true;
                }
            }
        }

        if (rowHasZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    fillZeroToCol(matrix, i);
                }
            }
        }

        if (colHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    fillZeroToRow(matrix, i);
                }
            }
        }

        printMatrix(matrix);

    }

    private static void fillZeroToRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void fillZeroToCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // Duyệt từng hàng
            for (int j = 0; j < matrix[i].length; j++) { // Duyệt từng cột
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }

        System.out.println("\n--------"); //
    }

    public static int[][] randomMatrix(int m, int n) {

        int[][] matrix = new int[m][n];
        Random random = new Random();

        // Gán giá trị ngẫu nhiên từ 0 đến 99
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(10); // Random từ 0-99
            }
        }

        return matrix;
    }

    public static void test() {
        zeroMatrix(randomMatrix(500, 500));
        // zeroMatrixOptimize(randomMatrix(500, 500));
    }

    public static void main(String[] args) {

        // Get runtime instance
        Runtime runtime = Runtime.getRuntime();

        // Run garbage collector to get a cleaner memory measurement
        runtime.gc();

        // Get memory before function execution
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime(); // Start time

        // String input = "abca";
        // boolean result = isUnique(input);
        // boolean result1 = checkPermulation("abac", "bcaa");
        // System.out.println("isUnique" + input + result);
        // System.out.println("checkPermulation" + input + result1);
        // urlIfy("Mr John Smith ", 13);

        // replaceSpaces("Mr John Smith ".toCharArray(), 13);

        test();

        // Get memory after function execution
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long endTime = System.nanoTime(); // End time

        // Print memory usage
        System.out.println("Memory used by function: " + (memoryAfter - memoryBefore) + " bytes");
        System.out.println("Execution time: " + (endTime - startTime) / 1_000_000.0 + " ms");

    }
}
