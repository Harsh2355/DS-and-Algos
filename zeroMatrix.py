# Write an algorithm such that if an element in a NxM matrix is zero, it
# sets the rows and columns to zero. 

from Tester import test

# 1 1 1      1 0 1
# 1 0 1 ---> 0 0 0
# 1 1 1      1 0 1

# 0 1 2 0      0 0 0 0
# 3 4 5 2 ---> 0 4 5 2
# 1 3 1 5      0 3 1 5 

# O(NM)
def zeroMatrix(matrix):
    N = len(matrix)
    M = len(matrix[0])
    hasChanged = []
    for i in range(N):
        hasChanged.append([])
        for _ in range(M):
            hasChanged[i].append(False)
    
    for i in range(N):
        for j in range(M):
            if matrix[i][j] == 0 and not hasChanged[i][j]:
                # set rows to zero
                for k in range(M):
                    if not matrix[i][k] == 0:
                        matrix[i][k] = 0
                        hasChanged[i][k] = True
                for l in range(N):
                    if not matrix[l][j] == 0:
                        matrix[l][j] = 0
                        hasChanged[l][j] = True
    
    return matrix

test(zeroMatrix([[1,1,1],[1,0,1],[1,1,1]]), [[1,0,1],[0,0,0],[1,0,1]])
test(zeroMatrix([[0,1,2,0],[3,4,5,2],[1,3,1,5]]), [[0,0,0,0],[0,4,5,0],[0,3,1,0]])