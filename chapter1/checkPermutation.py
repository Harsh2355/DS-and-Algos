# Given two strings, write a method to decide if one is a permuation
# of the other.

# Ex:
# checkPermuation("abcjd", "jbadb") => True
# checkPermuation("abcjd", "jbaeb") => False

from Tester import *

# O(n)
def checkPermuation(str1, str2):

    # improvement
    if not len(str1) == len(str2):
        return False

    char_set = [0 for _ in range(128)]
    for ch in str1:
        char_set[ord(ch)] += 1
    for ch in str2:
        char_set[ord(ch)] -= 1
    for ch in char_set:
        if not ch == 0:
            return False
    return True

test(checkPermuation("abcjd", "jdacb"), True)
test(checkPermuation("loft", "folt"), True)
test(checkPermuation("afujkbh", "ahfgfed"), False)
test(checkPermuation("delivery", "delivera"), False)
test(checkPermuation("a", "a"), True)
test(checkPermuation("b", "c"), False)
