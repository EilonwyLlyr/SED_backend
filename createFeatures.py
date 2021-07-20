import sys
import numpy as np
import pandas as pd
from scipy.stats import kurtosis
import csv

def onlyUseData(t, x, y, z, f):

    data=[]
    time = t[10]
    for i in range(len(x) - 10):
        data.append((time, x[i], y[i], z[i], f[i]))

    return data

def normalize(d):
    data = d
    for i in range(len(data)):
        data[i] = (data[i] - min(d))/(max(d) - min(d))
    return data

def normalizeKurtosis(k):
    normal  = (k - 3)/6
    return data


df = pd.read_csv(sys.argv[1]+".csv")
t = df['time']
f = df['force']
x = df['x']
y = df['y']
z = df['z']

data = onlyUseData(t, x, y, z, f)

x_data = []
y_data = []
z_data = []
f_data = []

for a_tuple in data:
    x_data.append(a_tuple[1])
    y_data.append(a_tuple[2])
    z_data.append(a_tuple[3])
    f_data.append(a_tuple[4])

kurtosisx = kurtosis(x_data)
kurtosisy = kurtosis(y_data)
kurtosisz = kurtosis(z_data)
kurtosisf = kurtosis(f_data)
abs_kurtosisx = kurtosis(np.abs(x_data))
abs_kurtosisy = kurtosis(np.abs(y_data))
abs_kurtosisz = kurtosis(np.abs(z_data))
abs_kurtosisf = kurtosis(np.abs(f_data))

x_data = normalize(x_data)
y_data = normalize(y_data)
z_data = normalize(z_data)
f_data = normalize(f_data)

x_data.sort()
y_data.sort()
z_data.sort()
f_data.sort()

minx = min(x_data)
miny = min(y_data)
minz = min(z_data)
minf = min(f_data)
abs_minx = min(np.abs(x_data))
abs_miny = min(np.abs(y_data))
abs_minz = min(np.abs(z_data))
abs_minf = min(np.abs(f_data))
maxx = max(x_data)
maxy = max(y_data)
maxz = max(z_data)
maxf = max(f_data)
abs_maxx = max(np.abs(x_data))
abs_maxy = max(np.abs(y_data))
abs_maxz = max(np.abs(z_data))
abs_maxf = max(np.abs(f_data))
meanx = sum(x_data)/len(x_data)
meany = sum(y_data)/len(y_data)
meanz = sum(z_data)/len(z_data)
meanf = sum(f_data)/len(f_data)
abs_meanx = sum(np.abs(x_data))/len(x_data)
abs_meany = sum(np.abs(y_data))/len(y_data)
abs_meanz = sum(np.abs(z_data))/len(z_data)
abs_meanf = sum(np.abs(f_data))/len(f_data)
medianx = x_data[round(len(x_data)/2)]
mediany = y_data[round(len(y_data)/2)]
medianz = z_data[round(len(z_data)/2)]
medianf = f_data[round(len(f_data)/2)]

with open(sys.argv[1] + "_features.csv", 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(["time", "kurtosisx", "kurtosisy", "kurtosisz", "kurtosisf", "abs_kurtosisx", "abs_kurtosisy", "abs_kurtosisz", "abs_kurtosisf",
                     "minx", "miny", "minz", "minf", "abs_minx", "abs_miny", "abs_minz", "abs_minf", 
                     "maxx", "maxy", "maxz", "maxf", "abs_maxx", "abs_maxy", "abs_maxz", "abs_maxf", 
                     "meanx", "meany", "meanz", "meanf", "abs_meanx", "abs_meany", "abs_meanz", "abs_meanf", 
                     "medianx", "mediany", "medianz", "medianf"])
    writer.writerow([data[0][0], kurtosisx, kurtosisy, kurtosisz, kurtosisf, abs_kurtosisx, abs_kurtosisy, abs_kurtosisz, abs_kurtosisf,
                    minx, miny, minz, minf, abs_minx, abs_miny, abs_minz, abs_minf,
                    maxx, maxy, maxz, maxf, abs_maxx, abs_maxy, abs_maxz, abs_maxf,
                    meanx, meany, meanz, meanf, abs_meanx, abs_meany, abs_meanz, abs_meanf,
                    medianx, mediany, medianz, medianf])
