from itertools import groupby
from typing import Iterable


def unique_in_order(iterable: Iterable):
    ans = []
    pre = iterable.__iter__
    for i in iterable:
        if i != pre:
            ans.append(i)
        pre = i
    return ans


l = 'ABBCcAD'
ans = unique_in_order(l)
print(ans)


def unique_in_order(iterable: Iterable):
    return [k for (k, _) in groupby(iterable)]


l = 'ABBCcAD'
ans = unique_in_order(l)
print(ans)
