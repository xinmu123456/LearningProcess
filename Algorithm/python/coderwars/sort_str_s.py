import re


def order(sentence: str):
    # code here
    pattern = '[1-9]'
    s = sentence.split()
    print(s)
    s.sort(key=lambda x: re.search(pattern, x).group(0))
    return ' '.join(s)


s = "is2 Thi1s T4est 3a"
ans = order(s)
print(ans)
