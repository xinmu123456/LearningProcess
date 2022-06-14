import matplotlib.pyplot as plt

y = [x**2 for x in range(1, 9)]
x1 = [1, 16, 30, 42, 55, 68, 77, 88]
x2 = [1, 6, 12, 18, 28, 40, 52, 65]


fig = plt.figure()
ax = fig.add_axes([0, 0, 1, 1])

line1 = ax.plot(x1, y, 'ys-')
line2 = ax.plot(x2, y, 'go--')

ax.legend(labels=('tv', 'Smartphone'), loc='lower right')
ax.set_title("Advertisement effect on sales")
ax.set_xlabel('medium')
ax.set_ylabel('sales')
plt.show()
