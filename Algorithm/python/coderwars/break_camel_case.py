
import re


def solution(s: str):
    pattern = '[A-Z]'
    return re.sub(pattern, lambda x: " " + x.group(0), s)


s = 'abC'
ans = solution(s)
print(ans)
