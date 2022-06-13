import chardet


print(chardet.detect(b'hello, world'))


data = '你好, 世界'.encode('utf-8')

print(chardet.detect(data))
