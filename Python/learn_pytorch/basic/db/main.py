
import pymysql

dblink = pymysql.connect(host='localhost', user='root',
                         password='123456', database='mybatis')

dbin = dblink.cursor()

ret = dbin.execute('select * from user')

u = dbin.fetchall

print(ret)

dbin.close()

dblink.close()
