class Solution:
    def longestPalindrome(self, s: str) -> str:
        len = s.__len__()
        if len < 2:
            return s

        maxLen = 1  # 最大的长度
        begin = 0  # 起始的位置

        for i in range(0, len - 1):
            odd_len = self.expand_around_center(s, i, i)
            even_len = self.expand_around_center(s, i, i + 1)
            curMaxLen = max(odd_len, even_len)
            if curMaxLen > maxLen:
                maxLen = curMaxLen
                begin = i - int((maxLen - 1) / 2)

        return s[begin: begin + maxLen]

    def expand_around_center(self, s: str, left: int, right: int) -> int:
        len = s.__len__()
        i = left
        j = right
        while i >= 0 and j < len:
            if s[i] == s[j]:
                i -= 1
                j += 1
            else:
                break
        return j - i - 1


ans = Solution().longestPalindrome("glwhcebdjbdroiurzfxxrbhzibilmcfasshhtyngwrsnbdpzgjphujzuawbebyhvxfhtoozcitaqibvvowyluvdbvoqikgojxcefzpdgahujuxpiclrrmalncdrotsgkpnfyujgvmhydrzdpiudkfchtklsaprptkzhwxsgafsvkahkbsighlyhjvbburdfjdfvjbaiivqxdqwivsjzztzkzygcsyxlvvwlckbsmvwjvrhvqfewjxgefeowfhrcturolvfgxilqdqvitbcebuooclugypurlsbdfquzsqngbscqwlrdpxeahricvtfqpnrfwbyjvahrtosovsbzhxtutyfjwjbpkfujeoueykmbcjtluuxvmffwgqjgrtsxtdimsescgahnudmsmyfijtfrcbkibbypenxnpiozzrnljazjgrftitldcueswqitrcvjzvlhionutppppzxoepvtzhkzjetpfqsuirdcyqfjsqhdewswldawhdyijhpqtrwgyfmmyhhkrafisicstqxokdmynnnqxaekzcgygsuzfiguujyxowqdfylesbzhnpznayzlinerzdqjrylyfzndgqokovabhzuskwozuxcsmyclvfwkbimhkdmjacesnvorrrvdwcgfewchbsyzrkktsjxgyybgwbvktvxyurufsrdufcunnfswqddukqrxyrueienhccpeuqbkbumlpxnudmwqdkzvsqsozkifpznwapxaxdclxjxuciyulsbxvwdoiolgxkhlrytiwrpvtjdwsssahupoyyjveedgqsthefdyxvjweaimadykubntfqcpbjyqbtnunuxzyytxfedrycsdhkfymaykeubowvkszzwmbbjezrphqildkmllskfawmcohdqalgccffxursvbyikjoglnillapcbcjuhaxukfhalcslemluvornmijbeawxzokgnlzugxkshrpojrwaasgfmjvkghpdyxt")

print(ans)
