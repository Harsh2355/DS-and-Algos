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

# 00 -> 04
# 04 -> 44
# 40 -> 00
# 44 -> 40
# 01 -> 14
# 11 -> 
def rotateMatrix(matrix):
    