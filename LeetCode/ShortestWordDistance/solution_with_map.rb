# @param {String[]} words
# @param {String} word1
# @param {String} word2
# @return {Integer}
def shortest_distance(words, word1, word2)

    i1 = 1.0 / 0
    i2 = -1.0 / 0

    # If the distance doesn't exist, put infinity in place
    # of the array
    words.map.with_index {
        |word, i|
        i1 = i if word == word1
        i2 = i if word == word2
        (i1 - i2).abs
    }.min

end
