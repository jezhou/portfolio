=begin
Author         : Jesse Zhou
Date Completed : 9/4/2016
Difficulty     : Easy
Problem        : Find the intersection between two arrays (each number must be
                 unique)
Strategy       : For each number in the second array, add it to a final array
                 if it exists in the first array and is not already included
                 in the answer
Time           : O(n)
Space          : O(n) if using a Set (I'm not because arr has includes? fxn)
Notes          : I would've used a Set but it turns out arrays have a
                 includes? function. I would use a set if I didn't want
                 duplicate keys
=end
def intersection(nums1, nums2)
    arr = []
    nums2.each {|num| arr += [num] if nums1.include?(num) && !arr.include?(num)}
    arr
end
