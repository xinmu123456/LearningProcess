import asyncio 


async def set_after(fut):
    await asyncio.sleep(2)
    fut.set_result('666')


async def main():
    # 获取当前的事件循环
    loop = asyncio.get_running_loop()

    # 创建一个任务(future对象),这个任务什么都不干
    fut = loop.create_future(set_after(fut))

    # 等待任务结果
    data = await fut
    print(data)

asyncio.run( main() )