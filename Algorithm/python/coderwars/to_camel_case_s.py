import re



def to_camel_case(text):
    pattern = '[-|_][a-zA-Z]'
    # your code here
    ans = re.sub(pattern, lambda x: x.group()[1].upper(), text)
    return ans


text = 'the_stealth-Warrior'
ans = to_camel_case(text)
print(ans)
