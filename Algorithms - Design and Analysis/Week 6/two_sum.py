import sys

target_numbers = range(-10000,10001) # [-10000,10000] (inclusive)
numbers_to_use = {}
valid_targer_number_count = 0

for line in sys.stdin:
    numbers_to_use[int(line)] = True

for target_number in target_numbers:
    for number in numbers_to_use:
        if target_number - number != number and target_number - number in numbers_to_use :
            valid_targer_number_count+=1
            print("Find targer number {}".format(target_number))
            break

print(valid_targer_number_count)