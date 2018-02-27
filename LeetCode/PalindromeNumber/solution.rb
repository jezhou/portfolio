# Date Completed: 2/26/2018
# https://leetcode.com/problems/palindrome-number/description/
# Solution: Self-explanatory

# @param {Integer} x
# @return {Boolean}
def is_palindrome(x)
    return false if x < 0 || (x % 10 == 0 && x != 0)
    
    reflect = 0
    while reflect < x do
        reflect *= 10
        remainder = x % 10
        reflect += remainder
        x /= 10
    end
    
    reflect == x || (reflect / 10) == x
end
