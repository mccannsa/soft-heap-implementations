package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import softheap.*;

import util.Point;

public class TestSoftHeap {

    @Test
    public void testOrderedInts() {

        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        for (int i = 0; i < 20; i++) {
            sh.insert(new Item<Integer>(i + 1));
        }

        int[] expected = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        ArrayList<Integer> actual = new ArrayList<>(20);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        System.out.println(sh);

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i).intValue(), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testUnorderedInts1() {

        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        int[] input = { 5, 9, 2, 1, 4, 15, 13, 3, 6, 18, 20, 19, 8, 7, 10, 12, 17, 11, 14, 16 };

        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        int[] expected = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        ArrayList<Integer> actual = new ArrayList<>(20);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i).intValue(), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testUnorderedInts2() {
        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        int[] input = { 13, 19, 5, 11, 9, 7, 4, 16, 15, 2, 1, 20, 12, 14, 6, 17, 3, 18, 10, 8 };

        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        int[] expected = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        ArrayList<Integer> actual = new ArrayList<>(20);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i).intValue(), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testUnorderedInts3() {
        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        int[] input = { 4, 7, 15, 20, 17, 1, 12, 9, 6, 13, 16, 14, 2, 3, 5, 19, 10, 8, 11, 18 };

        for (int i = 0; i < input.length - 1; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        Node<Integer> root = sh.insert(new Item<Integer>(18));

        assertEquals(2, root.getKey());
        assertEquals(4, root.getRank());
        assertEquals(8, root.getNext().getKey());
        assertEquals(2, root.getNext().getRank());

        int[] expected = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        ArrayList<Integer> actual = new ArrayList<>(20);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i).intValue(), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testStrings1() {

        SoftHeap<String> sh = new SoftHeap<>(1f / 2);
        String[] input = { "alpha", "beta", "charlie", "delta", "echo", "foxtrot", "gulf", "hotel", "india", "juliett",
                "kilo", "lima", "mike", "november", "oscar", "papa", "quebec", "romeo", "sierra", "tango", "uniform",
                "victor", "whiskey", "xray", "yankee", "zulu" };

        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<String>(input[i]));
        }

        String[] expected = { "beta", "alpha", "charlie", "delta", "echo", "foxtrot", "gulf", "hotel", "india", "juliett",
                "kilo", "lima", "mike", "november", "oscar", "papa", "quebec", "romeo", "sierra", "tango",
                "uniform", "victor", "whiskey", "xray", "yankee", "zulu" };
        ArrayList<String> actual = new ArrayList<>(input.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<String>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testStrings2() {
        SoftHeap<String> sh = new SoftHeap<>(1f / 2);
        String[] input = { "charlie", "echo", "zulu", "alpha", "papa", "sierra", "victor", "foxtrot", "gulf", "juliett",
                "lima", "november", "oscar", "quebec", "delta", "whiskey", "yankee", "bravo", "hotel", "india", "mike",
                "kilo", "romeo", "tango", "uniform", "xray" };

        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<String>(input[i]));
        }

        String[] expected = { "bravo", "charlie", "alpha", "delta", "echo", "foxtrot", "gulf", "hotel", "india", "juliett",
                "kilo", "lima", "mike", "november", "oscar", "papa", "quebec", "romeo", "sierra", "tango",
                "uniform", "victor", "whiskey", "xray", "yankee", "zulu" };
        ArrayList<String> actual = new ArrayList<>(input.length);

        while (!sh.isEmpty()) {
            actual.add(((Item<String>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testPoints1() {
        ArrayList<Point> input = new ArrayList<>(20);

        Point p1 = new Point(-5, 0);
        Point p2 = new Point(1, -37);
        Point p3 = new Point(1, 28);
        Point p4 = new Point(37, -12);
        Point p5 = new Point(13, 0);
        Point p6 = new Point(-7, 2);
        Point p7 = new Point(9, -17);
        Point p8 = new Point(-5, -3);
        Point p9 = new Point(-22, -23);
        Point p10 = new Point(3, -14);
        Point p11 = new Point(33, 13);
        Point p12 = new Point(-7, -40);
        Point p13 = new Point(-42, 20);
        Point p14 = new Point(-25, -9);
        Point p15 = new Point(9, 16);
        Point p16 = new Point(48, -19);
        Point p17 = new Point(33, -14);
        Point p18 = new Point(26, 13);
        Point p19 = new Point(-22, 2);
        Point p20 = new Point(9, -36);
        
        input.add(p1);
        input.add(p2);
        input.add(p3);
        input.add(p4);
        input.add(p5);
        input.add(p6);
        input.add(p7);
        input.add(p8);
        input.add(p9);
        input.add(p10);
        input.add(p11);
        input.add(p12);
        input.add(p13);
        input.add(p14);
        input.add(p15);
        input.add(p16);
        input.add(p17);
        input.add(p18);
        input.add(p19);
        input.add(p20);

        SoftHeap<Point> sh = new SoftHeap<>(1f / 2);
        for (Point p : input) {
            sh.insert(new Item<Point>(p));
        }
        
        Point[] expected = { p11, p5, p18, p15, p3, p13, p6, p19, p1, p14, p8, p9, p12, p2, p10, p20, p7, p17, p16, p4 };
        ArrayList<Point> actual = new ArrayList<>(20);

        while (!sh.isEmpty()) {
            actual.add(((Item<Point>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testPoints2() {
        ArrayList<Point> input = new ArrayList<>(20);

        Point p1 = new Point(16, -32);
        Point p2 = new Point(14, 22);
        Point p3 = new Point(25, 12);
        Point p4 = new Point(-5, 39);
        Point p5 = new Point(24, 4);
        Point p6 = new Point(-21, -9);
        Point p7 = new Point(28, 44);
        Point p8 = new Point(27, 6);
        Point p9 = new Point(18, -13);
        Point p10 = new Point(-26, 19);
        Point p11 = new Point(-2, 15);
        Point p12 = new Point(11, -7);
        Point p13 = new Point(2, 25);
        Point p14 = new Point(-13, -15);
        Point p15 = new Point(0, 7);
        Point p16 = new Point(-6, -9);
        Point p17 = new Point(6, -1);
        Point p18 = new Point(-24, -14);
        Point p19 = new Point(11, -29);
        Point p20 = new Point(-2, 22);
        
        Point[] expected = { p8, p5, p3, p2, p7, p13, p15, p20, p4, p11, p10, p6, p18, p14, p16, p19, p1, p9, p12, p17 };
        
        input.add(p1);
        input.add(p2);
        input.add(p3);
        input.add(p4);
        input.add(p5);
        input.add(p6);
        input.add(p7);
        input.add(p8);
        input.add(p9);
        input.add(p10);
        input.add(p11);
        input.add(p12);
        input.add(p13);
        input.add(p14);
        input.add(p15);
        input.add(p16);
        input.add(p17);
        input.add(p18);
        input.add(p19);
        input.add(p20);

        SoftHeap<Point> sh = new SoftHeap<>(1f / 2);
        for (Point p : input) {
            sh.insert(new Item<Point>(p));
        }

        ArrayList<Point> actual = new ArrayList<>(20);

        while (!sh.isEmpty()) {
            actual.add(((Item<Point>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testEmptiedHeap() {
        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        int[] input = { 18, 2, 4, 17, 20, 13, 9, 7, 14, 1, 16, 15, 5, 12, 3, 6, 11, 8, 19, 10 };
        int[] input2 = { 35, 39, 31, 36, 37, 32, 34, 33, 38, 30 };

        int[] expected = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 };
        ArrayList<Integer> actual = new ArrayList<>(30);

        for (int i = 0; i < 20; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        for (int i = 0; i < 10; i++) {
            sh.insert(new Item<Integer>(input2[i]));
        }

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i).intValue(), "Items removed in incorrect order.");
        }
    }

    @Test
    public void test100() {
        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        for (int i = 0; i < 100; i++) {
            sh.insert(new Item<Integer>(i + 1));
        }

        int[] expected = {  4,  3,  2,  1,  6,  5,  8,  7,  9, 10, 11, 12, 13, 14, 15, 16, 18, 17, 19, 20,
                           21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 34, 33, 36, 35, 37, 38, 39, 40,
                           41, 42, 43, 44, 45, 46, 47, 48, 50, 49, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                           61, 62, 63, 64, 66, 65, 68, 67, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                           82, 81, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };
        ArrayList<Integer> actual = new ArrayList<>(100);

        while (!sh.isEmpty()) {
            actual.add(((Item<Integer>) sh.findMin()[0]).getKey());
            sh.deleteMin();
        }

        assertEquals(expected.length, actual.size(), "Actual output length differs from expected output length");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i).intValue(), "Items removed in incorrect order.");
        }
    }

    @Test
    public void testNumCorrupted() {

        int n = (int) Math.pow(10, 6);
        int m = 0;
        int corrupt = 0;
        double eps = 1f / 12;
        
        SoftHeap<Integer> sh = new SoftHeap<>(eps);
        for (int i = 0; i < n; i++) {
            sh.insert(new Item<Integer>(i + 1));
            m++;
        }

        assertEquals(n, m);

        while (!sh.isEmpty()) {
            Object[] min = sh.findMin();
            int itemKey = ((Item<Integer>) min[0]).getKey().intValue();
            int nodeKey = ((Integer) min[1]).intValue();

            if (nodeKey > itemKey) {
                corrupt++;
            }
            sh.deleteMin();
        }

        assertTrue(corrupt <= (eps * m), String.format("Too many corrupt items! Epsilon: %.3f, Insertions: %d, Corruptions: %d", eps, m, corrupt));
    }

    @Test
    public void testMeld() {
        assertTrue(false, "not implemented");
    }

    @Test
    public void testKeySwap1() {
        int[] expected = { 1, 0 };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        sh.insert(new Item<Integer>(1));
        sh.insert(new Item<Integer>(2));
        Node<Integer> root = sh.insert(new Item<Integer>(3));

        assertEquals(expected[0], root.getRank());
        assertEquals(expected[1], root.getNext().getRank());
    }

    @Test
    public void testKeySwap2() {
        int[] expected = { 0, 1 };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        sh.insert(new Item<Integer>(3));
        sh.insert(new Item<Integer>(2));
        Node<Integer> root = sh.insert(new Item<Integer>(1));

        assertEquals(expected[0], root.getRank());
        assertEquals(expected[1], root.getNext().getRank());
    }

    @Test
    public void testKeySwap3() {
        int[] expected = { 6, 2, 5 };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        for (int i = 1; i <= 99; i++) {
            sh.insert(new Item<Integer>(i));
        }
        Node<Integer> root = sh.insert(new Item<Integer>(100));

        assertEquals(expected[0], root.getRank());
        assertEquals(expected[1], root.getNext().getRank());
        assertEquals(expected[2], root.getNext().getNext().getRank());
    }

    @Test
    public void testKeySwap4() {
        int[] expected = { 6, 2, 5, 7 };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        // Insert 128 items for a rank 7 tree
        for (int i = 999; i > 871; i--) {
            sh.insert(new Item<Integer>(i));
        }

        // Insert 100 items for trees rank 6, 2, 5
        for (int i = 1; i <= 99; i++) {
            sh.insert(new Item<Integer>(i));
        }
        Node<Integer> root = sh.insert(new Item<Integer>(100));

        assertEquals(expected[0], root.getRank());
        assertEquals(expected[1], root.getNext().getRank());
        assertEquals(expected[2], root.getNext().getNext().getRank());
        assertEquals(expected[3], root.getNext().getNext().getNext().getRank());
    }

    @Test
    public void testKeySwap5() {
        int[] expected = { 6, 2, 5, 8, 7 };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        // Insert 256 items for a rank 8 tree with 1 < min key < 872
        for (int i = 500; i > 244; i--) {
            sh.insert(new Item<Integer>(i));
        }

        // Insert 128 items for a rank 7 tree
        for (int i = 999; i > 871; i--) {
            sh.insert(new Item<Integer>(i));
        }

        // Insert 100 items for trees rank 6, 2, 5
        for (int i = 1; i <= 99; i++) {
            sh.insert(new Item<Integer>(i));
        }
        Node<Integer> root = sh.insert(new Item<Integer>(100));

        assertEquals(expected[0], root.getRank());
        assertEquals(expected[1], root.getNext().getRank());
        assertEquals(expected[2], root.getNext().getNext().getRank());
        assertEquals(expected[3], root.getNext().getNext().getNext().getRank());
        assertEquals(expected[4], root.getNext().getNext().getNext().getNext().getRank());
    }

    @Test
    public void testKeySwap6() {
        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        int[] input = { 4, 7, 15, 20, 17, 1, 12, 9, 6, 13, 16, 14, 2, 3, 5, 19, 10, 8, 11, 18 };

        for (int i = 0; i < input.length; i++) {
            sh.insert(new Item<Integer>(input[i]));
        }

        Node<Integer> root = null;
        for (int i = 0; i < 7; i++) {
            root = sh.deleteMin();
        }

        assertEquals(2, root.getRank());
        assertEquals(9, root.getNext().getKey());
        assertEquals(4, root.getNext().getRank());

        root = sh.deleteMin();
        
        assertEquals(4, root.getRank());
        assertEquals(10, root.getNext().getKey());
        assertEquals(2, root.getNext().getRank());
    }

    @Test
    public void testRankSwap1() {
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        sh.insert(new Item<Integer>(2));
        sh.insert(new Item<Integer>(3));
        Node<Integer> root = sh.insert(new Item<Integer>(1));

        root = sh.rankSwap(root);

        assertEquals(0, root.getRank());
        assertEquals(1, root.getNext().getRank());
    }

    @Test
    public void testRankSwap2() {
        int[] expected = { 2, 6, 5, 8, 7 };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        // Insert 256 items for a rank 8 tree with 1 < min key < 872
        for (int i = 500; i > 244; i--) {
            sh.insert(new Item<Integer>(i));
        }

        // Insert 128 items for a rank 7 tree
        for (int i = 999; i > 871; i--) {
            sh.insert(new Item<Integer>(i));
        }

        // Insert 100 items for trees rank 6, 2, 5
        for (int i = 1; i <= 99; i++) {
            sh.insert(new Item<Integer>(i));
        }
        Node<Integer> root = sh.insert(new Item<Integer>(100));

        root = sh.rankSwap(root);

        assertEquals(expected[0], root.getRank());
        assertEquals(expected[1], root.getNext().getRank());
        assertEquals(expected[2], root.getNext().getNext().getRank());
        assertEquals(expected[3], root.getNext().getNext().getNext().getRank());
        assertEquals(expected[4], root.getNext().getNext().getNext().getNext().getRank());
    }

    @Test
    public void testLink1() {
        Integer[] expected = { 1, 2, null };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        sh.insert(new Item<Integer>(1));
        Node<Integer> root = sh.insert(new Item<Integer>(2));

        assertEquals(expected[0], root.getKey());
        assertEquals(expected[1], root.getLeft().getKey());
        assertEquals(expected[2], root.getRight().getKey());
    }

    @Test
    public void testLink2() {
        Integer[] expected = { 1, 2, null };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        sh.insert(new Item<Integer>(2));
        Node<Integer> root = sh.insert(new Item<Integer>(1));

        assertEquals(expected[0], root.getKey());
        assertEquals(expected[1], root.getLeft().getKey());
        assertEquals(expected[2], root.getRight().getKey());
    }

    @Test
    public void testLink3() {
        Integer[] expected = { 1, 2, 3, 4, null };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        sh.insert(new Item<Integer>(1));
        sh.insert(new Item<Integer>(2));
        sh.insert(new Item<Integer>(3));
        Node<Integer> root = sh.insert(new Item<Integer>(4));

        assertEquals(expected[0], root.getKey());
        assertEquals(expected[1], root.getLeft().getKey());
        assertEquals(expected[2], root.getRight().getKey());
        assertEquals(expected[3], root.getRight().getLeft().getKey());
        assertEquals(expected[4], root.getRight().getRight().getKey());
    }

    @Test
    public void testLink4() {
        Integer[] expected = { 1, 3, 2, 4, null };
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        sh.insert(new Item<Integer>(1));
        sh.insert(new Item<Integer>(3));
        sh.insert(new Item<Integer>(2));
        Node<Integer> root = sh.insert(new Item<Integer>(4));

        assertEquals(expected[0], root.getKey());
        assertEquals(expected[1], root.getLeft().getKey());
        assertEquals(expected[2], root.getRight().getKey());
        assertEquals(expected[3], root.getRight().getLeft().getKey());
        assertEquals(expected[4], root.getRight().getRight().getKey());
    }

    @Test
    public void testLink5() {
        SoftHeap<Integer> sh = new SoftHeap<>(1f / 2);
        int[] input = { 4, 7, 15, 20, 17, 1, 12, 9, 6, 13, 16, 14, 2, 3, 5, 19 };

        Node<Integer> root = null;
        for (int i = 0; i < input.length; i++) {
            root = sh.insert(new Item<Integer>(input[i]));
        }

        assertEquals(9, root.getRight().getRight().getKey());
        assertEquals(12, root.getRight().getRight().getLeft().getKey());
        assertEquals(17, root.getRight().getRight().getRight().getKey());
    }

    @Test
    public void testMeldableInsert1() {
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        Node<Integer> root = null;
        for (int i = 0; i < 6; i++) {
            root = sh.insert(new Item<Integer>(i + 1));
        }

        root = sh.meldableInsert(sh.makeRoot(new Item<Integer>(7)), sh.rankSwap(root));

        assertEquals(7, root.getKey());
        assertEquals(0, root.getRank());
        assertEquals(2, root.getNext().getRank());
    }

    @Test
    public void testMeldableInsert2() {
        SoftHeap<Integer> sh = new SoftHeap<>(0.5);

        Node<Integer> root = null;
        for (int i = 0; i < 20; i++) {
            root = sh.insert(new Item<Integer>(i));
        }

        root = sh.meldableInsert(sh.makeRoot(new Item<Integer>(21)), sh.rankSwap(root));

        assertEquals(21, root.getKey());
        assertEquals(0, root.getRank());
        assertEquals(4, root.getNext().getRank());
        assertEquals(2, root.getNext().getNext().getRank());
    }

    @Test
    public void testMeldableMeld() {
        assertTrue(false, "not implemented");
    }
}
