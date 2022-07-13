# Given an image represented by an NXN Matrix, where each pixel in the image
# is 4 bytes, write a method to rotate the image by 90 degrees.

# [
#     [1, 2, 3, 4, 5],
#     [6, 7, 8, 9, 10],
#     [11, 12, 13, 14, 15],
#     [16, 17, 18, 19, 20],
#     [21, 22, 23, 24, 25]
# ]
# becomes
# [
#     [21, 16, 11, 6, 1],
#     [22, 17, 12, 7, 2],
#     [23, 18, 13, 8, 3],
#     [24, 19, 14, 9, 4],
#     [25, 20, 15, 10, 5]
# ]

import math
from Tester import *

# O(n)
# In Place
def rotateMatrix(matrix):
    i = 0
    j = 0
    N = len(matrix)
    finished = False
    while not finished:
        print(str(i) + " : " + str(j))
        count = 0
        temp_i = i
        temp_j = j
        temp = matrix[temp_i][temp_j]
        while count < 4:
            newtemp = matrix[temp_j][N - temp_i - 1]
            matrix[temp_j][N - temp_i - 1] = temp
            temp = newtemp
            a = temp_j
            temp_j = N - temp_i - 1
            temp_i = a
            count += 1
        
        if (i == math.floor(N / 2) and j == math.floor(N / 2)):
            finished = True
        if j < N - 2 - i :
            j += 1
        else:
            j = i + 1
            i += 1
    print(matrix)
    return matrix

test(rotateMatrix([
        [1, 2, 3, 4, 5],
        [6, 7, 8, 9, 10],
        [11, 12, 13, 14, 15],
        [16, 17, 18, 19, 20],
        [21, 22, 23, 24, 25]
    ]),
    [
        [21, 16, 11, 6, 1],
        [22, 17, 12, 7, 2],
        [23, 18, 13, 8, 3],
        [24, 19, 14, 9, 4],
        [25, 20, 15, 10, 5]
    ])
