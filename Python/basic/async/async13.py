import asyncio
import threading

async def coro_example(name):
    print(f'正在执行name: {name}')
    print(threading.current_thread().ident)
    await asyncio.sleep(1)
    print('coro over')
    return f'over: {name}'


async def main():
    ret = await asyncio.gather(*[(coro_example(f'taks{i}')) for i in range(10)])
    return ret


# loop = asyncio.get_event_loop()

# loop.run_until_complete(coro_example())

# tasks = asyncio.gather(*[loop.create_task((coro_example(f'taks{i}'))) for i in range(10)])

# print(threading.current_thread().ident)

loop = asyncio.new_event_loop()
asyncio.set_event_loop(loop)
# loop = asyncio.get_event_loop()

print(threading.currentThread().ident)

task = loop.create_task(main())
# asyncio.run(task)
loop.run_until_complete(task)

print(task.result())

# loop.run_until_complete(tasks)
# loop.close()