import asyncio
from time import sleep, time

async def fn_1():
    await asyncio.sleep(1)
    print("协程1")
    
async def fn_2():
    await asyncio.sleep(2)
    print("协程2")

async def main():
    task = asyncio.gather(fn_1(), fn_2())
    await asyncio.sleep(3)
    print('main over')
    await task
    print(task.result())

async def mission():
    await asyncio.gather(fn_1(), fn_2())

start = time()
loop = asyncio.new_event_loop()
asyncio.set_event_loop(loop)

tasks = loop.create_task(mission())
    
loop.run_until_complete(tasks)

# task = [fn_1(), fn_2()]

# asyncio.run(main())


print(f'take time {time() - start}')