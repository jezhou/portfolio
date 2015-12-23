//Solved 10/19/2015
public class Solution {
    public String reverseWords(String s) {
        String[] array = s.trim().split(" ");
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < array.length; i++){

            String word = array[array.length - 1 - i];

            if(!word.equals("")){
                buffer.append(word);
                buffer.append(" ");
            }

        }

        return buffer.toString().trim();
    }
}
