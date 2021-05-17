import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] solution(int area) {
         StringBuilder result = new StringBuilder();
        while(area>0){
            int closestSquareRoot = (int) Math.floor(Math.sqrt(area));
            int closestSquare = closestSquareRoot *closestSquareRoot;
            result.append(",").append(closestSquare);
            area = area - closestSquare;
        }
        String[] res = result.toString().split(",");
        int[] ans = new int[res.length-1];
        for(int i=1; i<res.length; i++){
            ans[i-1]=  Integer.parseInt(res[i]);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
