

class Stack:
    def __init__(self, data) -> None:
        self.data = data
        self.ptr = len(data) - 1
        if len(data) == 0:
            self.ptr = 0

    def pop(self):
        self.ptr -= 1

    def push(self, data):
        self.data.append(data)
        self.ptr += 1

    def peek(self):
        return self.data[self.ptr]

    def get_all(self):
        return self.data[:self.ptr + 1]


st = Stack([1, 2, 3])

print(st.peek(), st.get_all())

st.pop()

print(st.get_all())
