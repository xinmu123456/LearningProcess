import asyncio
import re
from time import sleep
import time

# async def main():
#     print("hello")
#     await asyncio.sleep(1)
#     print('world')
    
# coro = main()

# asyncio.run(coro)

async def task1():
    await asyncio.sleep(2)
    return 100

async def main_task():
    ret = await asyncio.gather(task1(), task1())
    print(ret)

start = time.time()
time.sleep(1)

# coro = asyncio.wait(main_task())

loop = asyncio.get_event_loop()

tasks = [task1(), task1()]

loop.run_until_complete(asyncio.wait(tasks))


print(f"take time {time.time() - start}")