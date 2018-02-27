# Completed 2/27/2018
# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
# Solution: Use sliding window to slide an end pointer to the right until a dup is hit.
# Then, move the start pointer until the dup is considered gone. Repeat. It works because we
# can guarantee that everything from [i, j) where j is the first dup is unique. We must
# move i to the right until the dup is gone to guarantee that the next window is also a
# set of unique characters. 2n because i,j might hit every character once.

# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
    longest_length = 0
    start_char = 0
    end_char = 0
    char_map = {}
    
    while end_char < s.length
        unless char_map[s[end_char]] == 1
            char_map[s[end_char]] = 1
            end_char += 1
        else
            current_length = end_char - start_char
            longest_length = current_length if current_length > longest_length
            
            char_map[s[start_char]] -= 1 
            start_char += 1
        end
    end
    
    current_length = end_char - start_char
    longest_length = current_length if current_length > longest_length 
    longest_length
end
