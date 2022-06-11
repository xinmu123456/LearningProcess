import pickle

d = dict(name='xinmu', age=20, score=80)

print(d)

p = pickle.dumps(d)

print(p)

f = open('dump.txt', 'wb')

pickle.dump(d, f)

f.close()

f = open('dump.txt', 'rb')
d1 = pickle.load(f)

print(d1)
