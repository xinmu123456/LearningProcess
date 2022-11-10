import pandas as pd
import numpy as np

if __name__ == '__main__':
    # d = {'数量' : pd.Series([2, 3, 4, 1, 3]), '时间' : pd.Series(['2:00' , "3:00", "2:00", "3:00", "3:00"]), '日期': pd.Series(['11.1', '11.1', '11.1', '11.2', '11.2']), '天气': pd.Series(['晴', '晴', '阴', '雨', '雨'])}
    # df = pd.DataFrame(d)
    # df = df.pivot_table(values=['数量'], columns=['日期'], index=['时间'], aggfunc=max, margins=True, fill_value=0)
    # print(df)
    
    arr = np.array([1, 2, 3, 4, 5, 6])
    print(arr)
    print(arr.reshape(2, 3).reshape(6))