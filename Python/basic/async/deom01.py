import asyncio
import requests


async def download_image(url):
    print('开始下载:', url)

    loop = asyncio.get_event_loop()
    # requests 模块默认不支持异步操作, 所以用线程池来配合事项
    future = loop.run_in_executor(None, requests.get, url)

    # 发送网络请求
    response = await future

    # 保存到本地
    file_name = url.rsplit('/')[-1]
    with open(file_name, mode='wb') as file_object:
        file_object.write(response.content)
    print('下载完成')


if __name__ == '__main__':
    url_list = [
        'https://scpic.chinaz.net/files/pic/pic9/201910/zzpic20739.jpg',
        'https://www.keaidian.com/uploads/allimg/190424/24110307_8.jpg',
        'https://img.mianfeiwendang.com/pic/65133e4129b6446aa22c9f9f/1-810-jpg_6-1080-0-0-1080.jpg'
    ]

    tasks = [download_image(url) for url in url_list]

    loop = asyncio.get_event_loop()
    loop.run_until_complete(asyncio.wait(tasks))
