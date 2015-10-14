/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/13/2015
 *  Difficulty     : Easy
 *  Problem        : Given a pattern and a string str, find if str follows the
 *  						     same pattern.
 *  Strategy       : Essentially, create a HashMap that maps all of the keys
 *                   (the pattern letters) to the values (the words in the
 *                   string). Then, check if the string array equals to what
 *                   you get in the HashMap.
 *  Time           : O(n), you have to go through the entire list at least once
 *                   to verify that the pattern matches the strings.
 *  Dependencies   : HashMap
 *  Notes          : None
 */

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        // iterate through the pattern and check which letters are being used
        char[] patternArray = pattern.toCharArray();
        String[] strArray = str.split(" ");
        HashMap map = new HashMap();

        if(strArray.length != patternArray.length) {
            return false;
        }

        // use a hashmap to map each letter to a word
        // check the value to ensure there is a one-to-one mapping
        // (as in there isn't multiple of the same value being put into
        // the hashmap)
        for(int i = 0; i < patternArray.length; i++){
            if(!map.containsValue(strArray[i]))
                map.put(patternArray[i], strArray[i]);
        }

        // iterate through the pattern array, and check if each letter that's mapped
        // to a word matches the word in the string array
        for(int i = 0; i < patternArray.length; i++) {
            if(!strArray[i].equals(map.get(patternArray[i])))
                return false;
        }

        return true;
    }
}
