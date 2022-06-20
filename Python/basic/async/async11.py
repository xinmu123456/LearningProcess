import time
import asyncio


async def delay_say(delay, msg):
    await asyncio.sleep(delay)
    print(f"hello{msg}")


async def do_tasks():
    task1 = asyncio.create_task(delay_say(2, 'world'))
    task2 = asyncio.create_task(delay_say(1, 'xinmu'))
    await task1
    await task2

st = time.time()
asyncio.run(do_tasks())
print(time.time() - st)
