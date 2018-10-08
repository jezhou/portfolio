# @param {String} s
# @param {Integer} num_rows
# @return {String}

# spacer rows = 1..num_rows-1
# full rows = 0
def construct(converted_rows, index)
    converted_rows.reduce('') do |result, row|
        result += row[index].to_s
    end
end

def convert(s, num_rows)
    if s.length <= 1 || num_rows == 1
        return s
    end
    num_rows -= 1 # because ruby is inclusive
    row_tracker = 0
    converted_rows = []
    while s.length > 0
        current_slice = []
        if row_tracker == 0
            current_slice = s.slice!(0..num_rows).chars # slice a full row
        else
            current_slice[num_rows - row_tracker] = s.slice! 0 # shift a char
        end
        converted_rows.push(current_slice)
        row_tracker = (row_tracker + 1) % num_rows
    end
    
    # Now, convert the zigzag
    result = ''
    for index in 0..num_rows do
        result += construct(converted_rows, index)
    end
    result
end