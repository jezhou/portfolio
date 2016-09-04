=begin
Author         : Jesse Zhou
Date Completed : 9/4/2016
Difficulty     : Easy
Problem        : Given two strings that are permutations of each other EXCEPT
                 for the fact that the second string has any extra letter,
                 find out what the extra letter is.
Strategy       : First, combine strings. XOR each letter with each other
                 repeatedly.
Time           : O(n + m), n = length of the shorter string, m = other string
Space          : N/A
Dependencies   : N/A
Notes          : This is the most common way to do this problem, and probably
                 the most elegant. I think for this solution one needs to
                 understand that pairs of XOR will 'cancel' each other out:

                   10010
                 ^ 10010
                 _________
                   00000

                 Since the string is odd no matter what because of the extra
                 letter, the last XOR operation will reveal what the missing
                 letter is.
=end
def find_the_difference(s, t)
    c = 0
    (s+t).chars.each {|char| c ^= char.ord}
    c.chr
end
