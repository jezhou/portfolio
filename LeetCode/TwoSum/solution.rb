# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)

    check = Hash.new
    two_sums = [0, 0]

    for i in 0..nums.length - 1

        print i

        if check[target - nums[i]] then
            index = check[target - nums[i]] + 1
            two_sums[0] = [index, i + 1].min
            two_sums[1] = [index, i + 1].max

        end

        check[nums[i]] = i

    end

    return two_sums

end
