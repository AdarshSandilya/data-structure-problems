import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    private Sample sample;

    @BeforeEach
    void setUp() {
        sample = new Sample();
    }

    @Test
    void test_getCoinChange() {
        int[] coins = {4, 2};
        int sum = 4;
        int res = sample.getCoinChange(coins, sum);
        assertEquals(4, res);
    }

    @Test
    void name1() {
        ArrayList<Integer> j = new ArrayList<>();
        j.add(2);
        j.add(4);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        long res = sample.getNumberOfOptions(j, a, b, c, 10);
        assertEquals(4, res);
    }

    @Test
    void name() {
        ArrayList<Integer> i = new ArrayList<>();
        String s = "*|*|";
        s.substring(1, -3);
        i.add(1);
//        i.add(1);
        ArrayList<Integer> j = new ArrayList<>();
//        j.add(5);
        j.add(3);
        List<Integer> res = sample.numberOfItems(s, i, j);
        System.out.println("---------" + res.size());
        System.out.println(res.get(0));
        System.out.println("---------" + res.size());
        System.out.println(res.get(1));
    }

    @Test
    void test_mergeSortedArray() {
        int[] input1 = new int[]{1,2,2};
        int[] input2 = new int[]{3, 4, 6};
        int[] res = sample.mergeSortedArray(input1, input2);
        assertArrayEquals(new int[]{1,2,2,3, 4, 6}, res);
    }

    @Test
    void test_removeDuplicates() {
        int[] input = {1, 2, 3, 3, 4, 5,6,7};
        int res = sample.removeDuplicates(input);
        assertEquals(5, res);
    }

    @Test
    void test_minWindowSubstring() {
        String[] input = {"ahffaksfajeeubsne", "jefaa"};
        String res = sample.minWindowSubstring(input);
        assertEquals("aksfaje", res );
    }

    @Test
    void test_reverse() {
        String res = sample.reverse("abc");
        assertEquals("cba", res);
    }

    @Test
    void test_fibonacci() {
        int res = sample.fibonacci(2);
        assertEquals(2, res);
    }

    @Test
    void test_factorial() {
        int res = sample.factorial(5);
        assertEquals(120, res);
    }

    @Test
    void test_LongestWord() {
        String input = "fun&!! time";
        String res = sample.longestWord(input);
        assertEquals("time", res);
    }

    @Test
    void test_getMaxProfit() {
        
        int[] input = {10, 20, 1, 20, 500, 300,301};
        int[] maxProfit = sample.getMaxProfit(input);
        assertArrayEquals(new int[]{2, 4}, maxProfit);
    }

    @Test
    void test_longestCommonSubsequence() {
        String text1 = "abcbe";
        String text2 = "defababcbd";
        int res = sample.longestCommonSubsequence(text1, text2);

        assertEquals(4, res);
    }

    @Test
    void test_findLIS() {
//        int[] input = {1,2,2,3,1,6};
        int[] input = { 6,2,4,3,7,4,5};
//        int[] input = {-2,3,-3,-1,5};
        int res = sample.findLIS(input);
        assertEquals(3, res);
                
    }

    @Test
    void rotate() {
        int[] input = {1,2,3,4,5,6,7};
        int[] expected = {2,3,4,5,6,7,1};
        int[] res = sample.rotate(input, 13);
        assertArrayEquals(expected, res);
    }

    @Test
    void containsDuplicate() {
        int[] input = {0, 0, 1};
        boolean res = sample.containsDuplicate(input);
        assertTrue(res);
    }

    @Test
    void moveZeroes() {
        int[] input = {0, 0, 1};
        int[] res = sample.moveZeroes(input);
        assertArrayEquals(new int[]{1, 0, 0}, res);
    }

    @Test
    void twoSum() {
        int[] input = {3,2,4};
        int[] res = sample.twoSum(input, 6);
        assertArrayEquals(new int[]{1, 2}, res);
    }

    @Test
    void maximumOfSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = sample.maximumOfSubArray(nums);
        assertEquals(6, res);

        int[] nums1 = { 4, -1, 7};
        int res1 = sample.maximumOfSubArray(nums1);
        assertEquals(10, res1);
    }

    @Test
    void is_match(){
        boolean res = sample.isMatch("abcd", ".*");
        assertTrue(res);
    }
//
//    @Test
//    void isPalindrome() {
//        boolean res = sample.isPalindrome(0125421);
//        assertTrue(res);
//    }

    @Test
    void test_convert() {
        String s = sample.convert("PAYPALISHIRING", 3);
        assertEquals("PAHNAPLSIIGYIR", s);
    }

    @Test
    void reverse_integer() {
        int s = sample.reverseInteger(-123);
        assertEquals(-321, s);
    }
    
    @Test
    void atoi_func() {
        int s = sample.atoi("9223372036854775808");
        assertEquals(
                2147483647, s);
    }

    }