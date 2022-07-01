
from random import random


memo = {}


def L(nums, i):

    if i in memo:
        return memo[i]

    if i == len(nums) - i:
        return 1

    max_len = 1
    for j in range(i + 1, len(nums)):
        if nums[j] > nums[i]:
            max_len = max(max_len, L(nums, j) + 1)

    memo[i] = max_len
    return max_len


def length_of_LIS(nums):
    return max(L(nums, i) for i in range(len(nums)))


# nums = [random() for _ in range(100)]
# print(length_of_LIS(nums))


def L(nums, i):

    if i == len(nums) - i:
        return 1

    max_len = 1
    for j in range(i + 1, len(nums)):
        if nums[j] > nums[i]:
            max_len = max(max_len, L(nums, j) + 1)

    return max_len


print(L([1, 3, 2, 4], 0))
