=begin
Author         : Jesse Zhou
Date Completed : 9/4/2016
Difficulty     : Easy
Problem        : Given two strings that are permutations of each other EXCEPT
                 for the fact that the second string has any extra letter,
                 find out what the extra letter is.
Strategy       : For each letter in the shorter string, find it in the longer
                 string and then remove it. After pruning the longer string,
                 return it.
Time           : O(n), n = length of the shorter string
Space          : N/A
Dependencies   : N/A
Notes          : This is a pretty ruby way to do this. The 'best' answers upon
                 closer examination assume there is a char primitive type, but
                 I personally think it's harder to do that in Ruby? That may
                 just be an opinion (there is a .ord function for strings that
                 returns the ASCII number).
=end
def find_the_difference(s, t)
    c = 0
    s.chars.each do |char|
        t[t.index(char)] = ''
    end
    t
end
