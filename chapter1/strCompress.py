
# aaabcccccdd -> a3b1c5d2
# abcd -> abcd
# aabb -> a2b2
# O(n)
from Tester import test

def strnCompress(strn):
    char_count = [0 for _ in range(52)]
    lnth = len(strn)
    for i in range(lnth):
        char_count[getIndex(ord(strn[i]))] += 1
    newstrn = ""
    for i in range(52):
        if char_count[i] > 0:
            newstrn += chr(returnIndex(i)) + str(char_count[i])
    return strn if lnth < len(newstrn) else newstrn

def getIndex(index):
    if index >= 65 and index <= 90:
        return index - 65
    elif index >= 97 and index <= 122:
        return index - 71

def returnIndex(index):
    if index < 26:
        return index + 65
    else:
        return index + 71

# tests
test(strnCompress("aaabcccccdd"), "a3b1c5d2")
test(strnCompress("abcd"), "abcd")
test(strnCompress("aabb"), "a2b2")
    