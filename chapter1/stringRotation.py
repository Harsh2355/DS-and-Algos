# GIven two string s1 and s2, Write code to check if s2 is a roation of s1
# using only one call to isSubstrinng

from Tester import test

# can get O(n) running time with Karp-Rabin Algorithm
def is_substring(string, sub):
    return sub in string


def stringRotation(s1, s2):
    if len(s1) == len(s2) != 0:
        return is_substring(s1 + s1, s2)
    return False

# tests
test(stringRotation("waterbottle", "erbottlewat"), True)
test(stringRotation("waterbottle", "waterbottle"), True)
test(stringRotation("waterbottle", "erbottlewata"), False)
test(stringRotation("waterbottle", "aserbottlewat"), False)
test(stringRotation("waterbottle", "erbotstlewat"), False)
test(stringRotation("aa", "a"), False)
test(stringRotation("bbbacddceeb","ceebbbbacdd"), True)
test(stringRotation("vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg", "fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf"), True)