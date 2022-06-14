import matplotlib.pylab as plt

plt.rcParams["font.sans-serif"] = ["SimHei"]  # 设置字体
plt.rcParams["axes.unicode_minus"] = False  # 该语句解决图像中的“-”负号的乱码问题

x = [100, 300, 600, 1000, 1300, 1600, 1900, 2200, 2500, 2960]

vi = [8.8 for x in range(10)]

vo = [8.8, 8.6, 8.4, 8.0, 7.8, 7.4, 7.2, 7, 6.8, 6.2]

plt.plot(x, vi, 'b', markersize=10)
plt.plot(x, vo, 'r', marker='*', markersize=10)
plt.title('低通滤波器')
plt.xlabel('频率(HZ)')
plt.ylabel('电压(V)')


a = [1, 2, 3]
b = [4, 5, 6]

z = zip(a, b)
print(list(z))

c, d = zip(*zip(a, b))
print(c, d)

for a, b in zip(x, vi):
    plt.text(a, b, b, ha='center', va='bottom', fontsize=10)


for a, b in zip(x, vo):
    plt.text(a, b, b, ha='center', va='bottom', fontsize=10)

plt.legend(['输入', '输出'])
plt.show()
