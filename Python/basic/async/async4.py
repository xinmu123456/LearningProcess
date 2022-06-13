import asyncio
from cProfile import run
from urllib import response

from regex import R


async def func():
    print('xie cheng')


asyncio.run(func())


async def func():
    print('来玩')
    response = await asyncio.sleep(2)
    print('结束', response)

asyncio.run(func())


async def others():
    print('start')
    await asyncio.sleep(2)
    print('end')
    return 'return'


async def func():
    print('执行 协程 函数内部的代码')

    # 遇到io操作挂起当前的协程, 等io操作完成之后再继续往下执行, 当协程挂起时, 事件循环可以去指向其他的协程
    response1 = await others()
    print('io 请求结束, 结果是:', response1)

    response2 = await others()
    print('io 请求结束, 结果是:', response2)

    response3 = await others()
    print('io 请求结束, 结果是:', response3)


asyncio.run(func())
