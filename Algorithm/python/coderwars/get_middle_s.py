def get_middle(s):
    # your code here
    print(len(s)/2, len(s)/2)
    return s[int(len(s)/2 - 1):int(len(s)/2) + 1] if len(s) % 2 == 0 else s[int(len(s)/2)]


s = 'tes'
ans = get_middle(s)
print(ans)


def get_middle(s):
    return s[(len(s)-1)/2:len(s)/2+1]
