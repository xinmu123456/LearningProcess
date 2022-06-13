import mysql.connector

conn = mysql.connector.connect(
    user='root', password='123456', database='mybatis')
cursor = conn.cursor()

cursor.execute('select * from user')

data = cursor.fetchall()

print(data)

cursor.close()
