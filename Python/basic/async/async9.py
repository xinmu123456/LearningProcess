import asyncio
import time


async def say_after(delay, what):
    await asyncio.sleep(delay)
    print(what)
    return f"{what} => {delay}"


async def main():
    print(f"start at {time.strftime('%X')}")

    task1 = asyncio.create_task(
        say_after(3, 'hello')
    )
    task2 = asyncio.create_task(
        say_after(2, 'world2')
    )
    task3 = asyncio.create_task(
        say_after(2, 'world1')
    )

    ret = await asyncio.gather(task1, task2, task3)

    print(f"finished at {time.strftime('%X')}")

    print(ret)
asyncio.run(main())
