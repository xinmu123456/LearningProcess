import requests
# 需要安装requests 的模块

r = requests.get('https://www.baidu.com/')

print(r.status_code, r.text, r.encoding)
