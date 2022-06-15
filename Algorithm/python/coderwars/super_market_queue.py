

def queue_time(customers, n):
    q = [0] * n
    for i in customers:
        q = sorted(q)
        q[0] += i
    return max(q)


ans = queue_time([10, 2, 3, 3], 2)
print(ans)
