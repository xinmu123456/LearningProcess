# def f(x):
#     return x*x

# def f(x): return x*x

# def g(x, y): return x+y

# print(f(5))
# print(g(4, 6))

import re


def get_populuation(country):
    return country[2]


def get_populuation(country): return country


countries = []

file = open("E:\\Code\\learn_pytorch\\basic\\helloworld\\countries_zh.csv",
            "r", encoding="utf-8")

for line in file:
    line = line.strip()
    arr = line.split(",")
    name = arr[1]
    capt = arr[3]
    popu = int(arr[4])
    countries.append((name, capt, popu))

countries.sort(key=lambda country: country[2])

for country in countries:
    print(country)


def quadratic(a, b, c):
    return lambda x: a*x*x + b*x + c


f = quadratic(1, -1, 2)
print(f(5))
