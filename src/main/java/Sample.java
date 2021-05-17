import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    
    public int getCoinChange(int[] coins, int sum){
//        int[] coins = {2,4};
//        int[] coins = {4, 2, 3};
//        int sum = 4;
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int[] table=new int[sum+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<coins.length; i++){
            System.out.println("====");
            for(int j=coins[i]; j<=sum; j++) {  // 2
                System.out.println(j + "-----");
                
                
                table[j] = table[j] +  table[j - coins[i]];  // 2 + table [2-1
            }}
        System.out.println(Arrays.toString(table));
        

        return table[sum];
        
    }

    public  List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        ArrayList<Integer> noOfInventory = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            String subStr= s.substring(startIndices.get(i) -1, endIndices.get(i));
            int startOfCompartment = subStr.indexOf('|');
            int endOfCompartment = subStr.lastIndexOf('|');
            int currentInventoryCount = 0;
            System.out.println(subStr + "--------");

            for (int j = startOfCompartment; j < endOfCompartment; j++) {
                if(subStr.charAt(j) == '*')
                    currentInventoryCount++;
            }
            if(currentInventoryCount > 0)
                noOfInventory.add(currentInventoryCount);

        }
        return noOfInventory;

        // Write your code here

    }
    
//    public boolean isPalindrome(int x) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        boolean isJeansPurchased, isShirtPurchased, isShoesPurchased, isTopPurchased = false;
////        System.out.println(isJeansPurchased + "----");
//        if(isJeansPurchased)
//        String s = String.valueOf(x);
//        if(s.length() <2) return true;
//        for (int i=0,j=s.length()-1; i<s.length()/2; i++, j--){
//            if(s.charAt(i) != s.charAt(j))
//                return false;
//        }
//
//        return true;
//    }

    public long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {
        int numberOfOptions = 0;
        int maxSize = Math.max(priceOfJeans.size(), priceOfShoes.size());
        maxSize = Math.max(maxSize, priceOfSkirts.size());
        maxSize = Math.max(maxSize, priceOfTops.size());
        for (int i = 0; i < maxSize; i++) {
            int remainingDollars = dollars;
            int noOfDistinctItems= 0;

            for (int j = 0; j < priceOfJeans.size(); j++) {
                if(remainingDollars - priceOfJeans.get(j) > -1){
                    remainingDollars = remainingDollars - priceOfJeans.get(j);
                    noOfDistinctItems++;
                    break;
                }
            }
            for (int j = 0; j < priceOfShoes.size(); j++) {
                if(remainingDollars - priceOfShoes.get(j) > -1){
                    remainingDollars = remainingDollars - priceOfShoes.get(j);
                    noOfDistinctItems++;
                    break;
                }
            }
            for (int j = 0; j < priceOfSkirts.size(); j++) {
                if(remainingDollars - priceOfSkirts.get(j) > -1){
                    remainingDollars = remainingDollars - priceOfSkirts.get(j);
                    noOfDistinctItems++;
                    break;
                }
            }
            for (int j = 0; j < priceOfTops.size(); j++) {
                if(remainingDollars - priceOfTops.get(j) > -1){
                    remainingDollars = remainingDollars - priceOfTops.get(j);
                    noOfDistinctItems++;
                    break;
                }
            }
            if(noOfDistinctItems == 4)
                numberOfOptions++;


        }


        return numberOfOptions;
        


    }
    
    public int[] mergeSortedArray(int[] arr1, int[] arr2){
        int i, j;
        int k=0;
        int[] res = new int[arr1.length + arr2.length];
        for (i = 0, j=0; i <arr1.length && j <arr2.length;) {
            if(arr1[i] > arr2[j]){
                res[k] = arr2[j];
                j++;
            }
            else{
                res[k] = arr1[i];
                i++;
            }
            k++;
        }
        while(j < arr2.length){
            res[k] = arr2[j];
            j++;
            k++;
        }
        while(i < arr1.length){
            res[k] = arr2[i];
            i++;
            k++;
        }
        return res;
    }
 
    public int removeDuplicates(int[]arr) {
//        int[] input = {1, 2, 3, 3, 4, 5};

        int newSize = 0;
        
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] != arr[i+1])
                newSize++;
        }
        newSize++;
        return newSize;
    }

    public  String minWindowSubstring(String[] strArr) {
        StringBuilder currentStr = new StringBuilder();
        String str =  strArr[0];
        String strToSearch = strArr[1];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strToSearch.length(); i++) {
            int charCount = 0;
            if(map.containsKey(strToSearch.charAt(i)))
                charCount  =  map.get(strToSearch.charAt(i)) + 1;
            map.put(strToSearch.charAt(i), charCount);
        }
                

//        HashSet<Character> characters = new HashSet<>();
//        
//        // putting all character into hashset
//        for (int i = 0; i < strArr[1].length(); i++) {
//            characters.add(strArr[1].charAt(i));
//        }
        String smallest = "";
        for (int i = 0; i < str.length(); i++) {
            if(strToSearch.contains(String.valueOf(str.charAt(i)))){
                HashMap<Character, Integer> newMap = map;
                currentStr.append(strArr[0].charAt(i));
                newMap.put(strToSearch.charAt(i), newMap.get(strToSearch.charAt(i)) -1);
                for (int j = 1; j < str.length(); j++) {
                    if(strToSearch.contains(String.valueOf(str.charAt(j)))) {
                        
                    }
                }
            }
            if(currentStr.length() < smallest.length())
                    smallest = currentStr.toString();
            currentStr.setLength(0);
        }
        // code goes here  
        return smallest;
    }
    
    public String reverse(String s){
        int[] ints = new int[3];
        if(s.length() == 1)
            return s;
        return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
    }
    public int fibonacci(int idx){
        if (idx <2)
            return idx;
        return fibonacci(idx-1) + fibonacci(idx-2);
    }
    
    public int factorial(int num) {
        if(num == 2)
            return 2;
        return num * factorial(num-1);
        
    }

    public String longestWord(String s) {
//        String input = "fun&!! time";
        StringBuilder currentWord = new StringBuilder();
        String longestWord = currentWord.toString();
        for(int i =0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                currentWord.append(s.charAt(i));
                if(longestWord.length()  <  currentWord.length())
                    longestWord = currentWord.toString();
            }
            else 
                currentWord.setLength(0);
        }
        return longestWord;
    }
    
    public int[] getMaxProfit(int[] shares){
        int[] res = new int[2];
        int largestInd=0, smallestInd=0, tmpSmallest=0, tmpLargest;

        
        for (int i = 1; i < shares.length; i++) {
            if(shares[tmpSmallest] < shares[i]){
                tmpLargest=i;
                int currentProfit = shares[tmpLargest] - shares[tmpSmallest];
                int profit =  shares[largestInd] - shares[smallestInd]; 
                if(currentProfit > profit){
                    smallestInd = tmpSmallest;
                    largestInd = tmpLargest;
                }
            }
            else {
                tmpSmallest=i;
            }
        }
        res[0] = smallestInd;
        res[1] = largestInd;
        System.out.println(Arrays.toString(res));
        return res;
    }

    public int longestCommonSubsequence(String text1, String text2) {
//        String text1 = "abcde";
//        String text2 = "abc";
        int longestCommonSeq = 0;
        int currentCommonSeq = 0;
        for (int i = 0; i < text1.length(); i++) {
            currentCommonSeq=0;
            int charFoundAt = text2.indexOf(text1.charAt(i));
            
            if(charFoundAt <0){
                continue;
            }
            currentCommonSeq++;
            for (int j = charFoundAt+1, k = i+1; j < text2.length() && k<text1.length(); j++, k++) {
                if(text2.charAt(j) == text1.charAt(k))
                    currentCommonSeq++;
                else
                    break;
            }
            System.out.println(text1.charAt(i) + "  -  " + currentCommonSeq );
            longestCommonSeq = Math.max(longestCommonSeq, currentCommonSeq);
        }
        return longestCommonSeq;
    }

    public int findLIS(int[] s) {
//        int[] input = { 6,2,4,3,7,4,5};
        int currentSequenceElements=0;
        int largestSequence = 0;
        
        HashSet<Integer> visitedNumbers = new HashSet<>();
        for (int i=0; i<s.length; i++){
            int previousElement = s[i];
            for (int j = i; j < s.length; j++) {
                if(visitedNumbers.contains(s[j]) || previousElement > s[j])
                    continue;
                visitedNumbers.add(s[j]);
                currentSequenceElements++;
                previousElement = s[j];
                
            }
            largestSequence  = Math.max(largestSequence, currentSequenceElements);
            currentSequenceElements=0;
            visitedNumbers.clear();
        }
        return largestSequence;
    }   

    public int[] rotate(int[] nums, int k) {
//        int[] a = new int[nums.length];
//        for (int i = n; i < nums.length; i++) {
//            a[(i + k) % nums.length] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = a[i];
        
        for(int i =k; i >0; i-- ){
            int lastEle = nums[nums.length-1];
            int currentEle = nums[0];
            int newEle;

            for (int j = 1; j < nums.length; j++) {
                newEle = nums[j];
                nums[j] = currentEle;
                currentEle = newEle;
            }
            nums[0]= lastEle;
        }
        
        return nums;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> distinct_values = new HashSet<>();
        for (int num : nums) {
            if (distinct_values.contains(num))
                return true;
            distinct_values.add(num);
        }
        return false;

    }


    public int[] moveZeroes(int[] nums) {
        int lastZeroFound =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[lastZeroFound] = nums[i];
                lastZeroFound++;
            }
        }
        while(lastZeroFound < nums.length){
            nums[lastZeroFound] = 0;
            lastZeroFound++;
                    
        }
        return nums;

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int  i=0; i<nums.length; i++){
            if(complementMap.containsKey(nums[i])){
                return new int[]{complementMap.get(nums[i]), i};
            }
            complementMap.put(target - nums[i], i);
        }
        return new int[]{};
    }
    
    public int  maximumOfSubArray(int[] nums){
        if(nums.length <1) return 0;
        if(nums.length == 1) return nums[0];
        int sum=nums[0];
        int previousLargest = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            int currentSum = previousLargest + nums[i];
            if (currentSum < 0 && currentSum < previousLargest ) {
                previousLargest = nums[i];
                sum = Math.max(previousLargest, sum);
            } 
            else if(currentSum < nums[i] && previousLargest <0){
                previousLargest = nums[i];
                sum = Math.max(previousLargest, sum);
            }
            else{
                previousLargest = currentSum;
                sum = Math.max(previousLargest, sum);
            }

        }
        return sum;
    }

    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean firstCharMatched = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if(p.length()>=2 && p.charAt(1) == '*')
            return (isMatch(s, p.substring(2)) ||
                    (firstCharMatched && isMatch(s.substring(1), p)));
        else
            return firstCharMatched && isMatch(s.substring(1), p.substring(1));
        
        
    }
    
    public int atoi(String s){
        s  =  s.trim();
        if(s.isEmpty()) return 0;
        int sign =1;
        int i=0;
        int res=0;
        if(s.charAt(0) == '+' || s.charAt(0)  == '-'){
            sign  = (s.charAt(0) =='+') ? +1 :  -1;
            i++;
        }

        while(i<s.length() && (s.charAt(i)>= '0' && s.charAt(i) <= '9' )){
        
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {


                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i)  - '0');
            i++;
        }

        return res *sign;
    }
    
    public int reverseInteger(int x){
        boolean isNegative = false;
        if(x<0) {
            isNegative = true;
            x = -1 * x;
        }
        long reversed = 0;
        while(x>0){
            reversed = reversed *10  + x%10;
            x = x/10;
        }
        if(reversed > Integer.MAX_VALUE)
            return 0;
        if(isNegative && -reversed < Integer.MIN_VALUE)
            return 0;
        return (int) (isNegative ? -reversed: reversed);
    }


    public String convert(String s, int numRows) {
        if(numRows <2 || numRows >= s.length()) return s;
        int row = 0;
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i=0; i < numRows; i++){
            res[i] = new StringBuilder();
        }
        int directionDelta = -1; // upward
        for(int i=0; i <s.length(); i++){
            if(row==0 || row==numRows-1)
                directionDelta =(-1) * directionDelta;
            // else if(row==numRows-1)
            //     directionDelta = -1;
            res[row].append(s.charAt(i));
            row += directionDelta;
        }
        return String.join("", res);
    }
}
