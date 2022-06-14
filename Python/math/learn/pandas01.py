import pandas as pd
a = [1, 2, 3]
var = pd.Series(a)

print(var)


sites = {1: "Google", 2: "Runoob", 3: "Wiki"}
var = pd.Series(sites)
print(var)

var = pd.Series(sites, index=[1, 2])
print(var)
