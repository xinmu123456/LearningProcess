import math
from time import time
import threading
import requests as req # 需要安装第三方库 pip install requests 速度慢的话自己找镜像
import turtle as t

class ReqThread(threading.Thread):
    
    def __init__(self, func, args):
        super().__init__()
        self.func = func
        self.args = args

    def run(self):
        self.result = self.func(*self.args)
        
    def get_ret(self):
        try:
            return self.result
        except Exception as e:
            return None

# 网络请求
def get_local_from_tx_api(addr):
    url = "https://apis.map.qq.com/jsapi?"
    
    param = {
        "qt": "geoc",
        "addr": addr, #地址
        "output": "json",
        "key": "xxxxx-xxxxx-xxxxx-xxxxx-xxxxx-xxxxx", # 申请的腾讯地图API的key 自行百度, 不予提供, 但好像不写也可以
        "pf": "jsapi",
        "ref": "jsapi"
    } # 参数
    
    resp = req.get(url, param)
    ans = resp.json()
    msg = ans["detail"]
    geo = f"{msg['pointx']}, {msg['pointy']}"
    return geo

# 计算方位角 ( 先经度再维度 )
def degree(Alongitude, Alatitude, Blongitude, Blatitude):
    radLatA = math.radians(Alatitude)
    radLonA = math.radians(Alongitude)
    radLatB = math.radians(Blatitude)
    radLonB = math.radians(Blongitude)
    dLon = radLonB - radLonA
    y = math.sin(dLon) * math.cos(radLatB)
    x = math.cos(radLatA) * math.sin(radLatB) - math.sin(radLatA) * math.cos(radLatB) * math.cos(dLon)
    brng = math.degrees(math.atan2(y, x))
    brng = (brng + 360) % 360
    return brng

# 计算距离 ( 先经度再维度 )
def distance(Alongitude, Alatitude, Blongitude, Blatitude):
    AEarth = 6378137.0
    DEG_TO_RAD = 1.7453292519943e-2
    startLat = Alatitude * DEG_TO_RAD
    endLat = Blatitude * DEG_TO_RAD
    dLat = (Blatitude - Alatitude) * DEG_TO_RAD
    dLon = (Blongitude - Alongitude) * DEG_TO_RAD
    a = math.sin(dLat / 2) * (math.sin(dLat / 2)) + math.sin(dLon / 2) * math.sin(dLon / 2) * math.cos(
        startLat) * math.cos(endLat)
    c = 2 * math.asin(min(1.0, math.sqrt(a)))
    return AEarth * c / 1000

# turtle画图
def draw_distance(source: str, dist: str, distance: int, angle: int):
    t.pu()
    t.setpos(-100, -100)
    t.pd()
    t.dot(8, "black")
    t.write(source)
    t.setheading(90)
    t.color('red')
    t.width(2)
    t.right(angle)
    t.forward(distance / 4)
    t.color('black')
    t.write(f'距离 {distance} km | 方位角 {angle} °')
    t.color('red')
    t.forward(distance / 4)
    t.dot(8, 'black')
    t.color('black')
    t.write(dist)
    
    t.ht()
    t.done()

if __name__ == '__main__':

    start = time()
    
    # 多线程网络请求速度能提高一倍 参数自调
    t1 = ReqThread(get_local_from_tx_api, args = ("成都市理工东苑38栋",))
    t2 = ReqThread(get_local_from_tx_api, args = ("湖北省十堰市郧阳区",))
    
    t1.start(), t2.start(), t1.join(), t2.join()
    
    ret_1 = t1.get_ret()
    ret_2 = t2.get_ret()

    print(ret_1, ret_2, sep=" | ")
    
    # 得到经纬度结果坐标
    x_1, y_1 = eval(ret_1) 
    x_2, y_2 = eval(ret_2)
    
    # 直接取整处理
    dis = int(distance(x_1, y_1, x_2, y_2)) 
    angle = int(degree(x_1, y_1, x_2, y_2))
    
    print(f"距离: {dis} | 方位角: {angle}")
    print(f"take time : {time() - start}")
    
    draw_distance("成都市理工东苑38栋", "湖北省十堰市郧阳区", dis, angle)
