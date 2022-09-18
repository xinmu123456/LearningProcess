import sys
import os

sys.path.append("E:\\Sync\\work\\LearningProcess\\Python\\test_module")
# sys.path.append("E:\\Sync\\work\\LearningProcess\\Python\\test_module\\sub")
# sys.path[0] = "E:\\Sync\\work\\LearningProcess\\test_module"
# sys.path.append(os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))
print(sys.path)
# from sub import m1

from sub.m1 import show_m1

# m1.show_m1()

