import pandas as pd;
import random as random
import csv

df = pd.read_csv("features.csv")
date = df["time"]
kurtosisx = df["kurtosisx"]
kurtosisy = df["kurtosisy"]
kurtosisz = df["kurtosisz"]
kurtosisf = df["kurtosisf"]
abs_kurtosisx = df["abs_kurtosisx"]
abs_kurtosisy = df["abs_kurtosisy"]
abs_kurtosisz = df["abs_kurtosisz"]
abs_kurtosisf = df["abs_kurtosisf"]
minx = df["minx"]
miny = df["miny"]
minz = df["minz"]
minf = df["minf"]
abs_minx = df["abs_minx"]
abs_miny = df["abs_miny"]
abs_minz = df["abs_minz"]
abs_minf = df["abs_minf"]
maxx = df["maxx"]
maxy = df["maxy"]
maxz = df["maxz"]
maxf = df["maxf"]
abs_maxx = df["abs_maxx"]
abs_maxy = df["abs_maxy"]
abs_maxz = df["abs_maxz"]
abs_maxf = df["abs_maxf"]
meanx = df["meanx"]
meany = df["meany"]
meanz = df["meanz"]
meanf = df["meanf"]
abs_meanx = df["abs_meanx"]
abs_meany = df["abs_meany"]
abs_meanz = df["abs_meanz"]
abs_meanf = df["abs_meanf"]
medianx = df["medianx"]
mediany = df["mediany"]
medianz = df["medianz"]
medianf = df["medianf"]
label = df["label"]
data = []
ran = []
data.append([date[0], kurtosisx[0], kurtosisy[0], kurtosisz[0], kurtosisf[0], abs_kurtosisx[0], abs_kurtosisy[0], abs_kurtosisz[0], abs_kurtosisf[0],
                        minx[0], miny[0], minz[0], minf[0], abs_minx[0], abs_miny[0], abs_minz[0], abs_minf[0],
                        maxx[0], maxy[0], maxz[0], maxf[0], abs_maxx[0], abs_maxy[0], abs_maxz[0], abs_maxf[0],
                        meanx[0], meany[0], meanz[0], meanf[0], abs_meanx[0], abs_meany[0], abs_meanz[0], abs_meanf[0],
                        medianx[0], mediany[0], medianz[0], medianf[0], label[0]])

for i in range(300):
        data.append([date[0], kurtosisx[0] + random.random()/100, kurtosisy[0]+ random.random()/100, kurtosisz[0]+ random.random()/100, kurtosisf[0]+ random.random()/100, abs_kurtosisx[0]+ random.random()/100, abs_kurtosisy[0]+ random.random()/100, abs_kurtosisz[0]+ random.random()/100, abs_kurtosisf[0]+ random.random()/100,
                        minx[0]+ random.random()/100, miny[0]+ random.random()/100, minz[0]+ random.random()/100, minf[0]+ random.random()/100, abs_minx[0]+ random.random()/100, abs_miny[0]+ random.random()/100, abs_minz[0]+ random.random()/100, abs_minf[0]+ random.random()/100,
                        maxx[0]+ random.random()/100, maxy[0]+ random.random()/100, maxz[0]+ random.random()/100, maxf[0]+ random.random()/100, abs_maxx[0]+ random.random()/100, abs_maxy[0]+ random.random()/100, abs_maxz[0]+ random.random()/100, abs_maxf[0]+ random.random()/100,
                        meanx[0]+ random.random()/100, meany[0]+ random.random()/100, meanz[0]+ random.random()/100, meanf[0]+ random.random()/100, abs_meanx[0]+ random.random()/100, abs_meany[0]+ random.random()/100, abs_meanz[0]+ random.random()/100, abs_meanf[0]+ random.random()/100,
                        medianx[0]+ random.random()/100, mediany[0]+ random.random()/100, medianz[0]+ random.random()/100, medianf[0]+ random.random()/100, label[0]])                    


for i in range(300):
        data.append([date[0], kurtosisx[0] - random.random()/100, kurtosisy[0]- random.random()/100, kurtosisz[0]- random.random()/100, kurtosisf[0]- random.random()/100, abs_kurtosisx[0]- random.random()/100, abs_kurtosisy[0]- random.random()/100, abs_kurtosisz[0]- random.random()/100, abs_kurtosisf[0]- random.random()/100,
                        minx[0]- random.random()/100, miny[0]- random.random()/100, minz[0]- random.random()/100, minf[0]- random.random()/100, abs_minx[0]- random.random()/100, abs_miny[0]- random.random()/100, abs_minz[0]- random.random()/100, abs_minf[0]- random.random()/100,
                        maxx[0]- random.random()/100, maxy[0]- random.random()/100, maxz[0]- random.random()/100, maxf[0]- random.random()/100, abs_maxx[0]- random.random()/100, abs_maxy[0]- random.random()/100, abs_maxz[0]- random.random()/100, abs_maxf[0]- random.random()/100,
                        meanx[0]- random.random()/100, meany[0]- random.random()/100, meanz[0]- random.random()/100, meanf[0]- random.random()/100, abs_meanx[0]- random.random()/100, abs_meany[0]- random.random()/100, abs_meanz[0]- random.random()/100, abs_meanf[0]- random.random()/100,
                        medianx[0]- random.random()/100, mediany[0]- random.random()/100, medianz[0]- random.random()/100, medianf[0]- random.random()/100, label[0]])                    


with open('600copies.csv', 'a+', newline='') as file:
    writer = csv.writer(file)

    for i in range(600):                 
        writer.writerow([data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], 
                        data[i][5], data[i][6], data[i][7], data[i][8], data[i][9], 
                        data[i][10], data[i][11], data[i][12], data[i][13], data[i][14], 
                        data[i][15], data[i][16], data[i][17], data[i][18], data[i][19], 
                        data[i][20], data[i][21], data[i][22], data[i][23], data[i][24], 
                        data[i][25], data[i][26], data[i][27], data[i][28], data[i][29],
                        data[i][30], data[i][31], data[i][32], data[i][33], data[i][34], 
                        data[i][35], data[i][36], data[i][37]])
