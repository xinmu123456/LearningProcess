from time import time

def gen_table():
    table = [[f'{x + 1} * {i + 1} = {(x + 1)*(i + 1)}' for i in range(x + 1)] for x in range(9)]
    return table

def print_table(table):
    for item in table:
        for sub_item in item:
            print(sub_item, end="\t")
        print()
            
if __name__ == '__main__':
    start = time()
    table = gen_table()
    for _ in range(100):
        print_table(table)
    print(f'take time: {time() - start}')