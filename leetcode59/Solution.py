class Solution(object):
    def generateMatrix(self, n):
        # Create the matrix with all 0s
        ret = []
        for i in range(n):
            ret.append([])
            for j in range(n):
                ret[i].append(0)
        up = -1
        down = n
        left = -1
        right = n
        row = 0
        col = 0
        flag = 0
        for i in range(n * n):
            ret[row][col] = i + 1
            if flag == 0:
                col += 1
                if col == right:
                    flag = 1
                    up += 1
                    row += 1
                    col -= 1
            elif flag == 1:
                row += 1
                if row == down:
                    flag = 2
                    right -= 1
                    row -= 1
                    col -= 1
            elif flag == 2:
                col -= 1
                if col == left:
                    flag = 3
                    down -= 1
                    col += 1
                    row -= 1
            elif flag == 3:
                row -= 1
                if row == up:
                    flag = 0
                    left += 1
                    row += 1
                    col += 1
        return ret
        """
        :type n: int
        :rtype: List[List[int]]
        """
        