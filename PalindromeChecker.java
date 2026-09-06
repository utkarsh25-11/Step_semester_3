public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        int i=0, j=text.length()-1;
        while(i<j) {
            if(text.charAt(i)!=text.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return checkRec(text,0,text.length()-1);
    }
    static boolean checkRec(String text,int i,int j){
        if(i>=j) return true;
        if(text.charAt(i)!=text.charAt(j)) return false;
        return checkRec(text,i+1,j-1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    public static void main(String[] args) {
        String word = "madam";
        System.out.println("Iterative: " + (isPalindromeIterative(word)?"Palindrome":"Not Palindrome"));
        System.out.println("Recursive: " + (isPalindromeRecursive(word)?"Palindrome":"Not Palindrome"));
        System.out.println("Array Reversal: " + (isPalindromeArrayReversal(word)?"Palindrome":"Not Palindrome"));
    }
}
