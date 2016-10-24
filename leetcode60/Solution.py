class Solution(object):
    def factorial(self,n):
        ret = 1
        for i in range(n):
            ret *= i + 1;
        return ret
    def getPermutation(self, n, k):
        num = []
        for i in range(n):
            num.append(str(i+1))
        ret = ''
        k -= 1
        for i in range(n):
            index = k // self.factorial(n - i - 1)
            ret += num[index]
            del num[index]
            k = k % self.factorial(n - i - 1)
        return ret
        """
        :type n: int
        :type k: int
        :rtype: str
        """