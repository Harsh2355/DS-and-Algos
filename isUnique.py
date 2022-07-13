# Implement an algorithm to determine if a string has all unique characters.
# What if you cant use any more data structures.

# Ex:
# isUnique("jhbsfgk") => True
# isUnique("hdgvhdg") => False

from Tester import *

# O(n)
# Can use additional data structures
def isUnique(str):
    char_store = {}
    for ch in str:
        try:
            if char_store[ch]:
                return False
        except KeyError:
            char_store[ch] = True
    return True

# To solve this problem without the use of data structures we need to sort the string
# using merge sort. This would take O(nlogn) time in the worst case. Now, after sorting the
# the string, we get a new string where duplicate characters are placed one after the other.
# Hence, we just need to iterate the array once and check if the characters next to it is the same
# as the character itself. 

test(isUnique("jhajgfsgsfg"), False)
test(isUnique("oqwhojjingio"), False)
test(isUnique("qwertyuiop"), True)
test(isUnique("aaaa"), False)
test(isUnique("asdfghjkla"), False)
test(isUnique("n"), True)