def create_phone_number(n: list):
    # your code here
    ans = "({0}) {1}-{2}"
    f1 = f2 = f3 = ''

    for index, item in enumerate(n):
        if 0 <= index <= 2:
            f1 += str(item)
        elif 3 <= index <= 5:
            f2 += str(item)
        elif 6 <= index <= 9:
            f3 += str(item)

    ans = ans.format(f1, f2, f3)
    return ans


ans = create_phone_number([1, 2, 3, 4, 5, 6, 7, 8, 9, 0])
print(ans)
