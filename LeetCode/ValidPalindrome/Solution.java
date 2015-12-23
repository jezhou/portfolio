public class Solution {
    public boolean isPalindrome(String s) {

        // Massage data so that it only considers alphanumeric characters
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);

        // Convert string to character array
        char[] letters = s.toCharArray();
        int marker = letters.length - 1;

        // Have two different markers, starting at each end of an array, an compare
        for(int i = 0; i < letters.length / 2; i++) {

            if(i == marker - i)
                break;

            if(letters[i] != letters[marker - i])
                return false;

        }

        return true;

    }
}
