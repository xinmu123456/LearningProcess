import imp


import asyncio


async def main():
    # 获取当前的事件循环
    loop = asyncio.get_running_loop()

    # 创建一个任务(future对象),这个任务什么都不干
    fut = loop.create_future()

    # 等待任务结果
    await fut

asyncio.run(main())
