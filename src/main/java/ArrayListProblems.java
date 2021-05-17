
public class ArrayListProblems {
    
    public static String getMaxProduct(int[] xs){
        if(xs.length < 1)
            return "0";
        String maxProduct = "1";
        String largestNegative = "-1";
        boolean negativeFound =false;
        for(int currentEle: xs){
            if(currentEle == 0 || currentEle  ==1)
                continue;
            String currentElement = String.valueOf(currentEle);
            if(currentEle <1){
                if(!negativeFound){
                    largestNegative = currentElement;
                    negativeFound = true;
                }
                largestNegative = getMaxBw(largestNegative, currentElement);
            }
//            maxProduct = maxProduct.multiply(BigInteger.valueOf(currentEle));
        }
        System.out.println(largestNegative);
//        if(maxProduct.compareTo(BigInteger.ZERO) >0)
//            return String.valueOf(maxProduct);
//        return String.valueOf(maxProduct.divide(largestNegative));
        return "yo";
    }
    
    private String getProductOf(String number1, String number2){
        
    }
    
    private static String getMaxBw(String  number1, String number2){
        if(number1.length() > number2.length())
            return number1;
        else if (number1.length() < number2.length())
            return number2;
        for (int i = 0; i < number1.length(); i++) {
            if(number1.charAt(i) > number2.charAt(i))
                return number1;
        }
        return number2;
    }
}



