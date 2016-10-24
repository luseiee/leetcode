Leetcode1 Two Sum
	先排序，再两边夹，O(NlogN)
	目前所知为最优解
Leetcode2 Add Two Numbers
	算法无难度，空的对象可以用 ==null 判断 O(N)
	为最优解
Leetcode3 Longest Substring Without Repeating Characters
	我想的是O(N2)的，先固定开始位置，再用空间换时间
	更优解：
	算法可以优化到O(N)，再开一个数组存储字母出现位置，然后一旦发现重复，就把start放在上次出现的后面，nice
Leetcode4 Median of Two Sorted Arrays
	非常有难度，边界条件很复杂，二分查找一个，然后放到另外一个数组中去判断大了还是小了 O(Log)
	时间复杂度上为最优解，逻辑上还可以改进
Leetcode5 Longest Palindromic Substring
	记得考虑奇偶，我想的办法还是O(N2)的，固定一个位置再向两边搜索
	确认已经为最优解
Leetcode6 ZigZag Conversion
	不用去考虑对应编号的换算，新建一个二维char把原来字符串放进去再一点点读出来 O(N)
	无时间复杂度问题
	该算法更加巧妙行数更少 http://www.cnblogs.com/sanghai/p/3632528.html
	下次记得创建一个string s，之后可以用s+char来直接扩展string。现在的解法想法没有问题，编程细节上很冗余。
Leetcode7 Reverse Integer
	考虑反过来了以后会超出int范围，此时应该返回0，不知道哪个无聊的傻逼想出来的
	其他无时间复杂度难度，只有逻辑简易程度区别
Leetcode9 Palindrome Number
	使用Leetcode7的算法得到reverse，然后判断是否相等，然后把负数情况全部去除
Leetcode11 Container With Most Water
	暴力的O(N2)方法不可行，证明leetcode平台还是考虑时间复杂度的不错
	还是使用两边逼近，挑小的那边往中间走一旦走到比原来大的就计算一次，如此循环，时间复杂度O(N)
	为最优解
Leetcode12 Integer to Roman
	由于不知道罗马字构成，直接参考网络代码，字符串操作
Leetcode13 Roman to Integer
	同12，字符串操作
Leetcode14 Longest Common Prefix
	字符串操作，记得考虑只有一个字符串的边界情况
Leetcode15 3Sum
	先排序，固定一个，然后用two sum方法，排除重复有点意思，O(N2)
Leetcode16 3Sum Closest
	和Three Sum思路差不多，固定一个再两边夹
	未确认是否有更优解
Leetcode17 Letter Combinations of a Phone Number
	仅仅为字符串操作
Leetcode18 4Sum
	我写了O(N3)方法，和3sum思路类似，注意防止重复情况（难点）
	应该有更优解法
	更优解：空间换时间，两两配对存入内存，然后相当于做2sum，最后为O(N2),不过不是很推荐
Leetcode19 Remove Nth Node From End of List
	边界条件考虑清楚即可，非常简单
Leetcode20 Valid Parentheses
	用栈，易
Leetcode21 Merge Two Sorted Lists
	易
Leetcode22 Generate Parentheses
	递归递归递归！string的传递也是复制传递！所以每个递归函数中的string都是独立的！
	Important！
Leetcode23 Merge k Sorted Lists
	利用Merge Two Sorted Lists，然后归并排序，记得修改merge2不让它破坏原来的lists
	Important！
Leetcode24 Swap Nodes in Pairs
	解法1：一定要非常非常小心改变了链接后的节点，宁可多开几个临时节点保存
	解法2：新建一个链表，保存后一个再保存前一个
Leetcode25
	做过24之后25就很容易
Leetcode26 Remove Duplicates from Sorted Array
	易
Leetcode27 Remove Element
	易
Leetcode28 Implement strStr()
	易
Leetcode29 Divide Two Integers
	考虑一下-MIN的各种边界情况
Leetcode30 Substring with Concatenation of All Words
	非常好的一道题，值得反复思考，S为待测字符长度，L为单个单词长度，N为单词个数
	1. 利用哈希表使得查找时间为常数
	2. 开始的位置，只有L种情况，复杂度一层L
	3. 开始点和末尾点同时移动，再开一个哈希表动态纪录找到单词个数，这层复杂度为S
	总的时间复杂度为 O(L*N)，远小于O（N2），之前几年O（N2）的程序是可以AC的
Leetcode31 Next Permutation
	算法有点意思
Leetcode32 Longest Valid Parentheses
	从左到右从右到左各扫一遍，两次O(N)，扫的时候不满足就直接start到end处再开始
Leetcode34 Search for a Range
	两次二分递归即可
Leetcode34 Search for a Range
	两次二分递归即可
Leetcode35 Search Insert Position
	易
Leetcode36 Valid Sudoku
	易
Leetcode37 Sudoku Solver
	回溯法学习范例
Leetcode38 Count and Say
	易
Leetcode39 Combination Sum
	DFS学习范例，List类的典型应用，值得学习
Leetcode40 Combination Sum II
	上题稍稍修改
Leetcode41 First Missing Positive
	注意下数字重复出现情况
Leetcode42 Trapping Rain Water
	函数调用越少越好，能写进一个函数就一个函数
Leetcode43 Multiply Strings
	对字符串型数的计算（远超int），一般放入int数组
Leetcode45 Jump Game II
	一开始用DFS，先是TLE，再是堆栈溢出
	后来发现10行搞定，一步步往后推最远跳跃距离即可
Leetcode46 Permutations 
	易，list及递归操作注意
Leetcode47 Permutations II
	同46
Leetcode48 Rotate Image
	易
Leetcode49 Group Anagrams
	Java中的api还是需要好好学习，很多方法和类都不了解，本题参考网上大神代码。
Leetcode50 Pow(x, n) 
	暴力循环会超时
	二分不会超时，千万不要写成myPow(x,n/2)*myPow(x,n/2)，这样和暴力循环没有区别哈哈
Leetcode51 N-Queens
	经典回溯法，八皇后问题
Leetcode52 N-Queens II
	同51
Leetcode53 Maximum Subarray
	这类问题两种解法，一种start=end=0一起往右找，另外一种startend在两边往中间夹。这种不行就换那种。
	然后都有特殊情况要考虑。
Leetcode54 Spiral Matrix
	易
Leetcode55 Jump Game
	同45
Leetcode56 Merge Intervals
	学习一下自定义class的ArrayList排序方法
Leetcode57 Insert Intervals
	用56的方法即可
Leetcode58 Length of Last Word
	易
Leetcode60 Permutation Sequence
	易
Leetcode61 Rotate List
	注意k比链表长的情况
Leetcode62 Unique Paths
Leetcode63 Unique Paths II
Leetcode64 Minimum Path Sum
	三道题思路类似不要用递归，用反向，从终点开始，构建每个点的最优解的函数。易