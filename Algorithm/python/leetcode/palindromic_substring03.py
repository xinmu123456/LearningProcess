from xmlrpc.client import Boolean


class Solution:
    def longestPalindrome(self, s: str) -> str:
        len = s.__len__()
        if len < 2:
            return s
        max_len = 1
        begin = 0

        dp = [[i == j for j in range(len)] for i in range(len)]

        for j in range(1, len):
            for i in range(j):
                if s[i] != s[j]:
                    dp[i][j] = False
                else:
                    if j - i < 3:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]

                if (dp[i][j]) and (j - i + 1 > max_len):
                    max_len = j - i + 1
                    begin = i
        return s[begin:begin + max_len]


s = Solution()

ans = s.longestPalindrome("aba")
print(ans)
