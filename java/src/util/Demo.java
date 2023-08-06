package util;

import java.util.ArrayList;
import softheap.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    private static final String TEST_DIR = "test/";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ERR_COLOR = "\u001B[31m";
    private static final String FAIL_COLOR = "\u001B[31m";
    private static final String PASS_COLOR = "\u001B[32m";

    public static void main(String[] args) throws FileNotFoundException {
        testOrderedInts();
        testUnorderedInts1();
        testUnorderedInts2();
        testUnorderedInts3();
        test100();
        testEmptiedHeap();
        testStrings1();
        testStrings2();
        testPoints1();
        testPoints2();
        testKeySwap1();
        testKeySwap2();
        testKeySwap3();
        testKeySwap4();
        testKeySwap5();
        testKeySwap6();
        testRankSwap1();
        testRankSwap2();
        testLink1();
        testLink2();
        testLink3();
        testLink4();
        testLink5();
    }

    public static String getFileContents(String filename) {
        try {
            File file = new File(TEST_DIR + filename);
            Scanner sc = new Scanner(file);

            String contents = "";
            while (sc.hasNextLine()) {
                contents += sc.nextLine();
            }
            sc.close();

            return contents;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    public static String[] getTestData(String content) {
        String[] data = content.split(":");
        
        if (data.length != 3) {
            return null;
        }

        return data;
    }

    public static String[] validateTest(String filename) {
        String contents = getFileContents(filename);

        if (contents == null) {
            System.err.printf("%sERROR: File \"%s\" not found.\n%s", ERR_COLOR,
                              filename, ANSI_RESET);
            return null;
        }

        String[] data = getTestData(contents);

        if (data == null) {
            System.err.printf("%sERROR: Missing or incorrect test data in \"%s\".%s\n",
                              ERR_COLOR, filename, ANSI_RESET);
            return null;
        }

        return data;
    }

    public static void testOrderedInts() {
        String filename = "testOrderedInts.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testUnorderedInts1() {
        String filename = "testUnorderedInts1.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testUnorderedInts2() {
        String filename = "testUnorderedInts2.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testUnorderedInts3() {
        String filename = "testUnorderedInts3.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void test100() {
        String filename = "test100.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testEmptiedHeap() {
        String filename = "testEmptiedHeap.txt";
        String contents = getFileContents(filename);

        if (contents == null) {
            System.err.printf("File \"%s\" not found.", filename);
            return;
        }

        String[] data = contents.split(":");

        if (data.length != 4) {
            System.err.printf("Missing or incorrect test data in \"%s\"", filename);
            return;
        }

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString1 = data[1].split(",");
        int[] input1 = new int[inString1.length];
        for (int i = 0; i < inString1.length; i++) {
            input1[i] = Integer.parseInt(inString1[i].trim());
        }

        String[] inString2 = data[2].split(",");
        int[] input2 = new int[inString2.length];
        for (int i = 0; i < inString2.length; i++) {
            input2[i] = Integer.parseInt(inString2[i].trim());
        }

        String[] exString = data[3].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input1.length; i++) {
            sh.insert(new Item<Integer>(input1[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        for (int i = 0; i < input2.length; i++) {
            sh.insert(new Item<Integer>(input2[i]));
        }

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testStrings1() {
        String filename = "testStrings1.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] input = data[1].split(",");
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }

        String[] expected = data[2].split(",");
        for (int i = 0; i < expected.length; i++) {
            expected[i] = expected[i].trim();
        }

        /* Perform test */
        SoftHeap<String> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<String>(input[i]));
        }

        ArrayList<String> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<String>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual.get(i))) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %s\n", expected[i], actual.get(i));
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testStrings2() {
        String filename = "testStrings2.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] input = data[1].split(",");
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }

        String[] expected = data[2].split(",");

        for (int i = 0; i < expected.length; i++) {
            expected[i] = expected[i].trim();
        }
        
        /* Perform test */
        SoftHeap<String> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<String>(input[i]));
        }

        ArrayList<String> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<String>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual.get(i))) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %s\n", expected[i], actual.get(i));
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testPoints1() {
        String filename = "testPoints1.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(";");
        Point[] input = new Point[inString.length];
        for (int i = 0; i < inString.length; i++) {
            String[] coords = inString[i].split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            Point p = new Point(x, y);
            input[i] = p;
        }

        String[] exString = data[2].split(";");
        Point[] expected = new Point[exString.length];
        for (int i = 0; i < exString.length; i++) {
            String[] coords = exString[i].split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            Point p = new Point(x, y);
            expected[i] = p;
        }

        /* Perform test */
        SoftHeap<Point> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Point>(input[i]));
        }

        ArrayList<Point> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Point>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual.get(i))) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %s\n", expected[i], actual.get(i));
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testPoints2() {
        String filename = "testPoints2.txt";
        
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(";");
        Point[] input = new Point[inString.length];
        for (int i = 0; i < inString.length; i++) {
            String[] coords = inString[i].split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            Point p = new Point(x, y);
            input[i] = p;
        }

        String[] exString = data[2].split(";");
        Point[] expected = new Point[exString.length];
        for (int i = 0; i < exString.length; i++) {
            String[] coords = exString[i].split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            Point p = new Point(x, y);
            expected[i] = p;
        }

        /* Perform test */
        SoftHeap<Point> sh = new SoftHeap<>(eps);
        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Point>(input[i]));
        }

        ArrayList<Point> actual = new ArrayList<>(expected.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<Point>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual.get(i))) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %s\n", expected[i], actual.get(i));
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testKeySwap1() {
        String filename = "testKeySwap1.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (root != sh.nil) {
            actual.add(root.getRank());
            root = root.getNext();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testKeySwap2() {
        String filename = "testKeySwap2.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (root != sh.nil) {
            actual.add(root.getRank());
            root = root.getNext();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testKeySwap3() {
        String filename = "testKeySwap3.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (root != sh.nil) {
            actual.add(root.getRank());
            root = root.getNext();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testKeySwap4() {
        String filename = "testKeySwap4.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (root != sh.nil) {
            actual.add(root.getRank());
            root = root.getNext();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testKeySwap5() {
        String filename = "testKeySwap5.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exString = data[2].split(",");
        int[] expected = new int[exString.length];
        for (int i = 0; i < exString.length; i++) {
            expected[i] = Integer.parseInt(exString[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = new ArrayList<>(expected.length);

        while (root != sh.nil) {
            actual.add(root.getRank());
            root = root.getNext();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tActual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testKeySwap6() {
        String filename = "testKeySwap6.txt";
        String contents = getFileContents(filename);

        if (contents == null) {
            System.err.printf("File \"%s\" not found.", filename);
            return;
        }

        String[] data = contents.split(":");

        if (data.length != 6) {
            System.err.printf("Missing or incorrect test data in \"%s\"", filename);
            return;
        }

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] rankStrings1 = data[2].split(",");
        int[] expectedRanks1 = new int[rankStrings1.length];
        for (int i = 0; i < rankStrings1.length; i++) {
            expectedRanks1[i] = Integer.parseInt(rankStrings1[i].trim());
        }

        int expectedKey1 = Integer.parseInt(data[3]);

        String[] rankStrings2 = data[4].split(",");
        int[] expectedRanks2 = new int[rankStrings2.length];
        for (int i = 0; i < rankStrings2.length; i++) {
            expectedRanks2[i] = Integer.parseInt(rankStrings2[i].trim());
        }
        
        int expectedKey2 = Integer.parseInt(data[5]);

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        /* Remove enough keys so that one more deletion after these ones
         * will cause the root list to be reordered.
         */
        for (int i = 0; i < 7; i++) {
            root = sh.deleteMin();
        }

        ArrayList<Integer> actualRanks1 = new ArrayList<>(expectedRanks1.length);

        Node<Integer> ptr = root;
        while (ptr != sh.nil) {
            actualRanks1.add(ptr.getRank());
            ptr = ptr.getNext();
        }

        int actualKey1 = root.getNext().getKey();

        /* Delete another key to cause root list reordering */
        root = sh.deleteMin();

        ArrayList<Integer> actualRanks2 = new ArrayList<>(expectedRanks1.length);

        ptr = root;
        while (ptr != sh.nil) {
            actualRanks2.add(ptr.getRank());
            ptr = ptr.getNext();
        }

        int actualKey2 = root.getNext().getKey();

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expectedRanks1.length != actualRanks1.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks1.length, actualRanks1.size());
            return;
        }

        for (int i = 0; i < expectedRanks1.length; i++) {
            if (expectedRanks1[i] != actualRanks1.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks1[i], actualRanks1.get(i).intValue());
                return;
            }
        }

        if (expectedKey1 != actualKey1) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual key differs from expected key.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expectedKey1, actualKey1);
            return;
        }

        if (expectedRanks2.length != actualRanks2.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tAfter final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks2.length, actualRanks2.size());
            return;
        }

        for (int i = 0; i < expectedRanks2.length; i++) {
            if (expectedRanks2[i] != actualRanks2.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks2[i], actualRanks2.get(i).intValue());
                return;
            }
        }

        if (expectedKey2 != actualKey2) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tAfter final deletion, actual key differs from expected key.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expectedKey2, actualKey2);
            return;
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testRankSwap1() {
        String filename = "testRankSwap1.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] rankStrings = data[2].split(",");
        int[] expectedRanks = new int[rankStrings.length];
        for (int i = 0; i < rankStrings.length; i++) {
            expectedRanks[i] = Integer.parseInt(rankStrings[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actualRanks = new ArrayList<>(expectedRanks.length);

        root = sh.rankSwap(root);

        Node<Integer> ptr = root;
        while (ptr != sh.nil) {
            actualRanks.add(ptr.getRank());
            ptr = ptr.getNext();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expectedRanks.length != actualRanks.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks.length, actualRanks.size());
            return;
        }

        for (int i = 0; i < expectedRanks.length; i++) {
            if (expectedRanks[i] != actualRanks.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks[i], actualRanks.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testRankSwap2() {
        String filename = "testRankSwap2.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] rankStrings = data[2].split(",");
        int[] expectedRanks = new int[rankStrings.length];
        for (int i = 0; i < rankStrings.length; i++) {
            expectedRanks[i] = Integer.parseInt(rankStrings[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actualRanks = new ArrayList<>(expectedRanks.length);

        root = sh.rankSwap(root);

        Node<Integer> ptr = root;
        while (ptr != sh.nil) {
            actualRanks.add(ptr.getRank());
            ptr = ptr.getNext();
        }

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expectedRanks.length != actualRanks.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks.length, actualRanks.size());
            return;
        }

        for (int i = 0; i < expectedRanks.length; i++) {
            if (expectedRanks[i] != actualRanks.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expectedRanks[i], actualRanks.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static ArrayList<Integer> getTreeKeys(Node<Integer> node, ArrayList<Node<Integer>> q) {
        q.add(node);
        ArrayList<Integer> actual = new ArrayList<>();

        while (!q.isEmpty()) {
            if (q.get(0).getRank() == Integer.MAX_VALUE) {
                q.remove(0);
                actual.add(null);
            } else {
                node = q.remove(0);
                actual.add(node.getKey());
                q.add(node.getLeft());
                q.add(node.getRight());
            }
        }

        return actual;
    }

    public static void testLink1() {
        String filename = "testLink1.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exStrings = data[2].split(",");
        int[] expected = new int[exStrings.length];
        for (int i = 0; i < exStrings.length; i++) {
            expected[i] = Integer.parseInt(exStrings[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = getTreeKeys(root, new ArrayList<Node<Integer>>());

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (actual.get(i) == null && expected[i] != -1) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %s\n", expected[i], "null");
                return;
            } else if (expected[i] == -1 && actual.get(i) != null) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %d\n", "null", actual.get(i).intValue());
                return;
            } else if (actual.get(i) != null && expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testLink2() {
        String filename = "testLink2.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exStrings = data[2].split(",");
        int[] expected = new int[exStrings.length];
        for (int i = 0; i < exStrings.length; i++) {
            expected[i] = Integer.parseInt(exStrings[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = getTreeKeys(root, new ArrayList<Node<Integer>>());

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (actual.get(i) == null && expected[i] != -1) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %s\n", expected[i], "null");
                return;
            } else if (expected[i] == -1 && actual.get(i) != null) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %d\n", "null", actual.get(i).intValue());
                return;
            } else if (actual.get(i) != null && expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testLink3() {
        String filename = "testLink3.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exStrings = data[2].split(",");
        int[] expected = new int[exStrings.length];
        for (int i = 0; i < exStrings.length; i++) {
            expected[i] = Integer.parseInt(exStrings[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = getTreeKeys(root, new ArrayList<Node<Integer>>());

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (actual.get(i) == null && expected[i] != -1) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %s\n", expected[i], "null");
                return;
            } else if (expected[i] == -1 && actual.get(i) != null) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %d\n", "null", actual.get(i).intValue());
                return;
            } else if (actual.get(i) != null && expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testLink4() {
        String filename = "testLink4.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exStrings = data[2].split(",");
        int[] expected = new int[exStrings.length];
        for (int i = 0; i < exStrings.length; i++) {
            expected[i] = Integer.parseInt(exStrings[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = getTreeKeys(root, new ArrayList<Node<Integer>>());

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (actual.get(i) == null && expected[i] != -1) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %s\n", expected[i], "null");
                return;
            } else if (expected[i] == -1 && actual.get(i) != null) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %d\n", "null", actual.get(i).intValue());
                return;
            } else if (actual.get(i) != null && expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    public static void testLink5() {
        String filename = "testLink5.txt";
        String[] data = validateTest(filename);

        if (data == null) return;

        /* Parse test data */
        double eps = Double.parseDouble(data[0]);

        String[] inString = data[1].split(",");
        int[] input = new int[inString.length];
        for (int i = 0; i < inString.length; i++) {
            input[i] = Integer.parseInt(inString[i].trim());
        }

        String[] exStrings = data[2].split(",");
        int[] expected = new int[exStrings.length];
        for (int i = 0; i < exStrings.length; i++) {
            expected[i] = Integer.parseInt(exStrings[i].trim());
        }

        /* Perform test */
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        Node<Integer> root = null;

        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        ArrayList<Integer> actual = getTreeKeys(root, new ArrayList<Node<Integer>>());

        /* Trim file extension if it exists */
        String testName = null;
        if (filename.contains(".")) {
            testName = filename.substring(0, filename.lastIndexOf('.'));
        } else {
            testName = filename;
        }
        
        /* Output test results */
        System.out.print(testName + ": ");

        if (expected.length != actual.size()) {
            System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                "\tBefore final deletion, actual output length differs from expected output length.\n" +
                "\tEXPECTED: %d, ACTUAL: %d\n", expected.length, actual.size());
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (actual.get(i) == null && expected[i] != -1) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %s\n", expected[i], "null");
                return;
            } else if (expected[i] == -1 && actual.get(i) != null) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %s, ACTUAL: %d\n", "null", actual.get(i).intValue());
                return;
            } else if (actual.get(i) != null && expected[i] != actual.get(i).intValue()) {
                System.out.printf(FAIL_COLOR + "FAILED\n" + ANSI_RESET +
                    "\tEXPECTED: %d, ACTUAL: %d\n", expected[i], actual.get(i).intValue());
                return;
            }
        }

        System.out.println(PASS_COLOR + "PASSED" + ANSI_RESET);
    }

    
}
