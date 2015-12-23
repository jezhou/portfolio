public class Solution {
    public List<String> generatePossibleNextMoves(String s) {

        char[] sarr = s.toCharArray();
        List<String> possibleMoves = new ArrayList<String>();

        for(int i = 1; i < sarr.length; i++){

            if(sarr[i] == '+' && sarr[i] == sarr[i - 1]){
                sarr[i] = flip(sarr[i]);
                sarr[i-1] = flip(sarr[i-1]);
                possibleMoves.add(new String(sarr));
                sarr = s.toCharArray();
            }

        }

        return possibleMoves;

    }

    public char flip(char c){
        if(c == '+'){
            return '-';
        }

        return 0;
    }
}
