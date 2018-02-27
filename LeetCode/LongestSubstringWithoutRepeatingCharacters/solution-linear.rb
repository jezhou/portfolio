# Completed 2/27/2018
# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
# Solution: Same as 2n except save indices instead to jump ahead (we only need to skip to
# the next none dup index closest to where the start_char currently is). See leetcode
# explanation for detailed info

# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
    longest_length = 0
    start_char = 0
    end_char = 0
    char_map = {}
    
    while end_char < s.length
        unless char_map[s[end_char]]
            char_map[s[end_char]] = end_char
            end_char += 1
        else
            current_length = end_char - start_char
            longest_length = current_length if current_length > longest_length
            start_char = [char_map[s[end_char]] + 1, start_char].max
            char_map[s[end_char]] = nil
        end
    end
    
    current_length = end_char - start_char
    longest_length = current_length if current_length > longest_length 
    longest_length
end
