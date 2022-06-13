import asyncio
import aioredis


async def execute(address, password):
    print('start', address)
    # 创建redis连接
    redis = await aioredis.create_redis(address, password=password)

    # 网络io操作
    result = await redis.hmset_dict('car', key1=1, key2=2, key3=3)
    print(result)

    redis.close()

    await redis.wait_close()

    print('end', address)


asyncio.run(execute('43.138.46.100:6379', ''))
