# Write a method to replace all the spaces in a string with ‘%20’. You may 
# assume that the string has sufficient space at the end to hold the additional 
# characters and that you are given the “true” length of the string.

from Tester import *

def urlifyEasy(str):
    return str.replace(' ', "%20")

# To Do:
def urlify(str):
    result = ""
    flag = 0
    lnth = len(str)
    for i in range(lnth):
        if str[i] == ' ':
            result += str[flag:i] + "%20"
            flag = i + 1
    result += str[flag: lnth]
    return result

teststr1 = "hashf hfdh udfgah huidf"
teststr2 = "hashf "
teststr3 = " hashf hfdh"
teststr4 = "  hashf  hfdh "
teststr5 = "hashfhfdhudfgahhuidf"
teststr6 = "h a s h f"

test(urlify(teststr1), urlifyEasy(teststr1)),
test(urlify(teststr2), urlifyEasy(teststr2)),
test(urlify(teststr3), urlifyEasy(teststr3)),
test(urlify(teststr4), urlifyEasy(teststr4)),
test(urlify(teststr5), urlifyEasy(teststr5)),
test(urlify(teststr6), urlifyEasy(teststr6)),