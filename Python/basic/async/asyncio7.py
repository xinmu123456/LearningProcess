import asyncio
import time


# demo1
"""
async def say_after(delay, what):
    await asyncio.sleep(delay)
    print(what)


async def main():
    print(f"started at {time.strftime('%X')}")  

    await say_after(1, 'hello')
    await say_after(2, 'world')

    print(f"finished at {time.strftime('%X')}")

asyncio.run(main())
"""

# demo2
'''
async def say_after(delay, what):
    await asyncio.sleep(delay)
    print(what)


async def main():
    
    task1 = asyncio.create_task(say_after(1, 'hello'))
    task2 = asyncio.create_task(say_after(2, 'world'))
    
    print(f"started at {time.strftime('%X')}")

    await task1
    await task2
    
    print(f"finished at {time.strftime('%X')}")

asyncio.run(main())
'''

# demo3
'''
async def say_after(delay, what):
    await asyncio.sleep(delay)
    return f"{what} - {delay}"


async def main():

    print(f"started at {time.strftime('%X')}")

    ret1 = await say_after(1, 'hello')
    ret2 = await say_after(2, 'world')

    print(ret1, ret2)

    print(f"finished at {time.strftime('%X')}")

asyncio.run(main())
'''

# demo4


async def say_after(delay, what):
    await asyncio.sleep(delay)
    return f"{what} - {delay}"


async def main():

    print(f"started at {time.strftime('%X')}")

    ret = await asyncio.gather(say_after(1, 'hello'), say_after(2, 'world'))

    print(ret)

    print(f"finished at {time.strftime('%X')}")

asyncio.run(main())
