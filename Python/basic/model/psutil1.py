import psutil

print(psutil.cpu_count(), psutil.cpu_count(logical=False))

print(psutil.cpu_times())


# for x in range(10):
#     print(psutil.cpu_percent(interval=1, percpu=True))

print(psutil.virtual_memory(), psutil.swap_memory())

# 网络接口
print(psutil.net_io_counters())


print(psutil.net_if_addrs())

print(psutil.net_if_stats())


print(psutil.pids())
