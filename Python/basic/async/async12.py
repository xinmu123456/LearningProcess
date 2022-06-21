import asyncio
import time


async def cal_later(name, delay):
    st = time.time()
    a = 100
    for _ in range(20000):
        for _ in range(1000):
            a *= 1
            a += 1
            a -= 1
    print(
        name, f'prepared {time.time() - st}s then await {name} sleep {delay}s')
    await asyncio.sleep(delay)
    print(name, "is been called and sleep over")
    b = 100
    st = time.time()
    for _ in range(20000):
        for _ in range(1000):
            b *= 1
            b += 1
            b -= 1
    print(name, f'calculate done takes {time.time() - st}s')
    return a

# st = time.time()
# a = 100
# for i in range(10000):
#     for j in range(1000):
#         a *= 1
#         a += 1
#         a -= 1
# print(time.time() - st)
# print(a)


async def task():
    t1 = asyncio.create_task(cal_later('t1', 0.1))
    t2 = asyncio.create_task(cal_later('t2', 0.1))
    t3 = asyncio.create_task(cal_later('t3', 1))
    await asyncio.gather(t1, t2, t3)

st = time.time()
asyncio.run(task())
print(time.time() - st)
