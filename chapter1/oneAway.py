# Given two strings word1 and word2, return the minimum number of 
# operations required to convert word1 to word2.
# You have the following three operations permitted on a word:
# Insert a character
# Delete a character
# Replace a character

# Ex:
# one_away("pale", "ples") => True
# one_away("pale", "palle") => True
# one_away("pale", "paly") => True
# one_away("pale", "bala") => False

def one_away(s1, s2):
    '''Check if a string can converted to another string with a single edit'''
    count = 0
    # pale -> palea
    
    i = 0
    j = 0
    while i < len(s1) and j < len(s2):
        if (not i == len(s1) - 1 and not s1[i] ==  s2[j] and ((len(s1) - 1 == len(s2)) or s1[i + 1] == s2[i])):
            s1 = one_edit_insert(s2, s1)
            print(s1)
            i = 0
            j = 0
            count += 1
        elif (not i == len(s2) - 1 and not s1[i] ==  s2[j] and ((len(s1) == len(s2) - 1) or s1[i] == s2[i + 1])):
            s1 = one_edit_insert(s1, s2)
            i = 0
            j = 0
            count += 1
        elif (not s1[i] ==  s2[j] and (not i == len(s1) - 1 or not s1[i + 1] == s2[i + 1])):
            s1 = one_edit_replace(s1, s2)
            i = 0
            j = 0
            count += 1
        else:
            if i == len(s1) - 1 and j == len(s2) - 1:
                print("HERE")
                break
            if i < len(s1) - 1:
                i += 1
            if j < len(s2) - 1:
                j += 1


            # print(s1)

        # if len(s1) == len(s2):
        #     s1 = one_edit_replace(s1, s2)
        # elif len(s1) + 1 == len(s2):
        #     s1 = one_edit_insert(s1, s2)
        # elif len(s1) - 1 == len(s2):
        #     s1 = one_edit_insert(s2, s1)
        # count += 1

    return count

# "pale", "ples"
def one_edit_replace(s1, s2):
    edited = False
    # print(s1)
    word1 = list(s1)
    word2 = list(s2)
    for i in range(len(s1)):
        if s1[i] != s2[i]:
            word1[i] = word2[i]
            return "".join(word1)
    return "".join(word1)

# "pale", "ples"
def one_edit_insert(s1, s2):
    i, j = 0, 0
    word1 = list(s1)
    word2 = list(s2)
    while i < len(s1) and j < len(s2):
        if word1[i] != word2[j]:
            word1[i] = word2[j] + word1[i]
            return "".join(word1)
        else:
            i += 1
            j += 1
    if len(s1) < len(s2):
        word1[len(s1) - 1] += word2[len(s2) - 1]
    else:
        word1[len(s1) - 1] = ""
    return "".join(word1)

print(one_away("pale", "ples"))