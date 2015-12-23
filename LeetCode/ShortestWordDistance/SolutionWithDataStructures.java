public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {

        ArrayList<Integer> index1 = new ArrayList<Integer>();
        ArrayList<Integer> index2 = new ArrayList<Integer>();

        for(int i = 0; i < words.length; i++){
            System.out.println(i);
            if(word1.equals(words[i])){
                index1.add(i);
            }
            else if(word2.equals(words[i])){
                index2.add(i);
            }
        }

        int mindis = Integer.MAX_VALUE;

        for(Integer i : index1){
            for(Integer j : index2){

                mindis = Math.min(Math.abs(i.intValue() - j.intValue()), mindis);

            }
        }

        return mindis;

    }
}
