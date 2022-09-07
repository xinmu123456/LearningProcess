import binascii

rect = [[] * 16 for x in range(16)]

rect_list = [] * 16

for _ in range(16):
    rect_list.append([] * 16)

text = '何'

gb2312 = text.encode('gb2312')
hex_str = binascii.b2a_hex(gb2312)
result = str(hex_str, encoding='utf-8')

print(result)