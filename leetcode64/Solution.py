class Solution(object):
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        minPath = [[0 for col in range(n)] for row in range(m)]
        minPath[0][0] = grid[0][0]
        for row in range(1,m):
            minPath[row][0] = minPath[row - 1][0] + grid[row][0]
        for col in range(1,n):
            minPath[0][col] = minPath[0][col - 1] + grid[0][col]
        for row in range(1,m):
            for col in range(1,n):
                if minPath[row][col - 1] < minPath[row - 1][col]:
                    minPath[row][col] = minPath[row][col - 1] + grid[row][col]
                else:
                    minPath[row][col] = minPath[row - 1][col] + grid[row][col]
        return minPath[m - 1][n - 1]
            
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        