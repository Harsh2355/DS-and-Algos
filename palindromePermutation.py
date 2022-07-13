# Write a function that checks whether any permutation of a string is a palindrome.

# Ex:
# palPerm("Tact Coa") => True 
# Taco Cat is a palindrome

from Tester import *

# O(n)
def palPerm(str):
    char_store = [0 for _ in range(128)]
    for ch in str.lower().replace(' ', ''):
        char_store[ord(ch)] += 1
    
    num_odds = 0
    i = 0
    for num in char_store:
        if num % 2 == 1:
            num_odds += 1
        i += 1

    return num_odds in [0, 1]


test(palPerm("Tact Coa"), True)
test(palPerm("rcaepca"), False)
test(palPerm("racecap"), False)
test(palPerm("rcaerca"), True)
test(palPerm("racecar"), True)

test(palPerm("jhsabckuj ahjsbckj"), True)
test(palPerm("Able was I ere I saw Elba"), True)
test(palPerm("So patient a nurse to nurse a patient so"), False)
test(palPerm("Random Words"), False)
test(palPerm("Not a Palindrome"), False)
test(palPerm("no x in nixon"), True)
test(palPerm("azAZ"), True)