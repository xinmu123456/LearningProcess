import asyncio
import time


async def fetch(msg):
    await asyncio.sleep(2)
    print(f'{msg}已经ok')
    return "hello" + msg


async def save():
    await asyncio.sleep(1)
    return "save successfully"


async def fetch_and_save(msg):
    ret1 = await fetch(msg)
    ret2 = await save()
    return [ret1, ret2]


async def do_task():
    tasks = [fetch_and_save(str(m)) for m in range(10)]
    ret = await asyncio.gather(*tasks)
    print(ret)


def main():

    start = time.time()
    asyncio.run(do_task())
    print(time.time() - start)


main()
