f = open('E:\cloud\OneDrive - stu.cdut.edu.cn\桌面\Work\hello.txt', 'r')

s = f.read()

print(s)

f.close()


try:
    f = open('E:\cloud\OneDrive - stu.cdut.edu.cn\桌面\Work\hello.txt', 'r')
    print(f.read())
finally:
    if f:
        f.close()


with open('E:\cloud\OneDrive - stu.cdut.edu.cn\桌面\Work\hello.txt', 'r') as f:
    print(f.read())

with open('E:\cloud\OneDrive - stu.cdut.edu.cn\桌面\Work\hello.txt', 'r') as f:
    for line in f.readlines():
        print(line.strip())


f = open('E:\cloud\OneDrive - stu.cdut.edu.cn\桌面\Work\hello.txt', 'rb')
print(f.read())
f.close()

# 传入'a' 代表追加文件
f = open('E:\cloud\OneDrive - stu.cdut.edu.cn\桌面\Work\hello.txt', 'a')
f.write('hello, world')
f.close()

# 传入'w'代表写文件, 如果文件存在会重写
f = open('E:\cloud\OneDrive - stu.cdut.edu.cn\桌面\Work\hello.txt', 'w')
f.write('hello, world')
f.close()
