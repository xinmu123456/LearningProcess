import functools
import requests
import asyncio

url = 'https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&ext=&cityid=&city='
# ret = requests.get(url)
# d = eval(ret.text)
# print(d['nums'])


async def get_weather(url, city):
    future = asyncio.get_event_loop().run_in_executor(
        None, functools.partial(requests.get, url + city))
    response = await future
    # if city == '北京':
    #     await asyncio.sleep(5)
    # return eval(requests.get(url + city).text)['city']
    print(eval(response.text)['city'])
    return eval(response.text)['city']


async def main():
    t1 = asyncio.create_task(get_weather(url, '宜宾'))
    t2 = asyncio.create_task(get_weather(url, '北京'))
    t3 = asyncio.create_task(get_weather(url, '上海'))

    ret = await asyncio.gather(t1, t2, t3)
    print(ret)

asyncio.run(main())
