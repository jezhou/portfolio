=begin
Author         : Jesse Zhou
Date Completed : 9/4/2016
Difficulty     : Easy
Problem        : Given two strings, see if the letters in the first string are
                 loosely contained in the second string. For example: "aa", "ab"
                 => false, "caba", "bcaa" => true
Strategy       : Use a data structure (I used a hashmap) to keep count of each
                 letter in the second string. Then go through the first string
                 and decrement the counts as necessary, returning false if you
                 are trying to decrement past 0 or if the letter doesn't exist
Time           : O(m+n), m = length of first string, n = length of second string
Space          : O(n) because of the hashmap
Dependencies   : Hash
Notes          : I don't think there's a better way to do this. There are a lot
                 of Python one liners, but every other answer seems to require
                 somem data structure. You could probably just prune each string
                 as necessary as well, but I like using Hash because it's more
                 organized
=end

def can_construct(ransom_note, magazine)
    hashmap = map_it(magazine)
    ransom_note.chars.each do |char|
        puts hashmap
        return false if hashmap[char.to_sym] == 0 || hashmap[char.to_sym] == nil
        hashmap[char.to_sym] -= 1 if hashmap.key? char.to_sym
    end
    true
end

def map_it(magazine)
    h = Hash.new
    magazine.chars.each do |char|
        if h.key? char.to_sym
            h[char.to_sym] += 1
        else
            h[char.to_sym] = 1
        end
    end
    h
end
