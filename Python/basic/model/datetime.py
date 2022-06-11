import imp
from datetime import datetime

now = datetime.now()

print(now, type(now), now.timestamp())

print(datetime.utcfromtimestamp(1654956435.055584))

cday = datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')
print(cday)
