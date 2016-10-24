class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        path = [[0 for col in range(n)] for row in range(m)]
        for col in range(n):
            if obstacleGrid[0][col] == 1:
                break
            path[0][col] = 1
        for row in range(m):
            if obstacleGrid[row][0] == 1:
                break
            path[row][0] = 1
        for row in range(1,m):
            for col in range(1,n):
                if obstacleGrid[row][col] == 0:
                    path[row][col] = path[row - 1][col] + path[row][col - 1]
        return path[m-1][n-1]
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        