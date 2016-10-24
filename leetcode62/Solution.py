class Solution(object):
    def uniquePaths(self, m, n):
        path = [[1 for col in range(n)] for row in range(m)]
        for row in range(1,m):
            for col in range(1,n):
                path[row][col] = path[row-1][col] + path[row][col-1]
        return path[m-1][n-1]
        """
        :type m: int
        :type n: int
        :rtype: int
        """