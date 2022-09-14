
while True:
    w = eval(input("请输入体重(kg): "))
    h = eval(input("请输入身高(m) : "))
    if 0 <= w <= float('inf') and  0 <= h <= float('inf'):
        break
    else:
        print("输入不符合逻辑")

BMI = w / h ** 2

if BMI < 20:
    print("您偏瘦")
elif 20 <= BMI <= 25:
    print("正常")
elif 25 < BMI <= 30:
    print("超重")
elif BMI > 30:
    print("肥胖")


