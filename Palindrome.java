public class Palindrome {
    private static boolean palindromer(String original){
        /**
         * Remove all the spaces, make it tight
         * Find out it is odd or even
         * Split it at the mid point.
         * Take the second half and reverse that
         * Compare the first half and the second half. If they are the same return TRUE, else FALSE
         */
        char[] cArray = original.toLowerCase().toCharArray();
        String first = null;
        String second = null;
        boolean result = false;
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<cArray.length;i++){
            if (cArray[i] != ' '){
                sb.append(cArray[i]);
            }
        }
        int midPoint = sb.toString().length() / 2;
        first = sb.substring(0, midPoint);
        if (sb.toString().length() %2 == 0){
            //Even
             second = sb.substring(midPoint, sb.length());
        }else{
            //Odd
            second = sb.substring(midPoint+1, sb.length());
        }

        //System.out.println("First Half : "+first);
        //System.out.println("Second Half : "+second);
        int j = second.length()-1;

        for (int i=0;i<first.length();i++){
            if(first.charAt(i) != second.charAt(j)){
                result = false;
                break;
            }
            j--;
            result = true;
        }
        return result;

    }
    public static void main(String[] args) {
        boolean r1 = palindromer("race car");
        System.out.println("r1 : " + r1);

        boolean r2 = palindromer("noon");
        System.out.println("r2 : " + r2);

        boolean r3 = palindromer("We panic in a pew");
        System.out.println("r3 : " + r3);

        boolean r4 = palindromer("civric");
        System.out.println("r4 : " + r4);

        boolean r5 = palindromer("pilot");
        System.out.println("r5 : " + r5);
    }
}
