from keras.models import Sequential
from keras.layers import LSTM
from keras.layers import Dense, Dropout
from numpy import genfromtxt
from flask import Flask, request
from flask_restful import Resource, Api, reqparse
import numpy
import codecs
import csv
from sklearn.metrics import confusion_matrix,roc_auc_score,roc_curve,auc,accuracy_score
from sklearn.metrics import precision_score,recall_score,classification_report
import matplotlib.pyplot as plt
from keras.utils import np_utils
import numpy as np
import socket
import pandas as pd
import ast
import json

import os
import io
import requests


# classification instance
def get_sequence(steps,time):
    x = [data[index] for index in range((time*10)+1 ,(time*10)+10+1)]
    x = numpy.delete(x, (data.shape[1]-1), axis=1)
    x= numpy.array(x)
    y = [Y[index] for index in range((time*10) ,(time*10)+10)]
    y=numpy.array(y)
    X = x.reshape(1, steps, (data.shape[1]-1))
    y = y.reshape(1, steps, y.shape[1])
    return X, y

def singleSequence():
    x = [single[1]]
    x = numpy.delete(x, (single.shape[1] - 1), axis=1)
    x = numpy.array(x)


data = genfromtxt('data.csv', delimiter=',')
m =[data[i][-1] for i in range(1,7671)]
Y = np_utils.to_categorical(m)



steps = 10
#LSTM
model = Sequential()
model.add(LSTM(30,input_shape = (None, (data.shape[1]-1)),return_sequences=True))
model.add(Dropout(0.25))
model.add(Dense(6, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['acc'])

print(model.summary())


# train LSTM
for epoch in range(0,50):
	X,y = get_sequence(steps,epoch)
	model.fit(X, y,batch_size=1, verbose=0)


countp=0
countn=0

ypredicted =  []
yactual = []

for d in range(534,575):
        X,y = get_sequence(steps,d)
        #yactual[] = [y[i] for i in range(len(y))]
        yhat = model.predict(X,verbose=0)[0]
        for index1 in range(10):
            i = np.where(yhat[index1] == yhat[index1].max())
            hin = i[0]
            for index2 in range(6):
                if(index2==hin):
                    yhat[index1][index2]=1
                else:
                    yhat[index1][index2]=0
        j= yhat
        k= y[0]
        for index1 in range(10):
            ypredicted.append(j[index1])
            yactual.append(k[index1])

ya = []
yp = []
for index1 in range(len(ypredicted)):
            if (ypredicted[index1][0]==1 and ypredicted[index1][1]==0 and ypredicted[index1][2]==0 and ypredicted[index1][3]==0 and ypredicted[index1][4]==0 and ypredicted[index1][5]==0):
                yp.append(0)
            if (ypredicted[index1][0]==0 and ypredicted[index1][1]==1 and ypredicted[index1][2]==0 and ypredicted[index1][3]==0 and ypredicted[index1][4]==0 and ypredicted[index1][5]==0):
                yp.append(1)
            if (ypredicted[index1][0]==0 and ypredicted[index1][1]==0 and ypredicted[index1][2]==1 and ypredicted[index1][3]==0 and ypredicted[index1][4]==0 and ypredicted[index1][5]==0):
                yp.append(2)
            if (ypredicted[index1][0]==0 and ypredicted[index1][1]==0 and ypredicted[index1][2]==0 and ypredicted[index1][3]==1 and ypredicted[index1][4]==0 and ypredicted[index1][5]==0):
                yp.append(3)
            if (ypredicted[index1][0]==0 and ypredicted[index1][1]==0 and ypredicted[index1][2]==0 and ypredicted[index1][3]==0 and ypredicted[index1][4]==1 and ypredicted[index1][5]==0):
                yp.append(4)
            if (ypredicted[index1][0]==0 and ypredicted[index1][1]==0 and ypredicted[index1][2]==0 and ypredicted[index1][3]==0 and ypredicted[index1][4]==0 and ypredicted[index1][5]==1):
                yp.append(5)
            
for index1 in range(len(yactual)):
            if (yactual[index1][0]==1 and yactual[index1][1]==0 and yactual[index1][2]==0 and yactual[index1][3]==0 and yactual[index1][4]==0 and yactual[index1][5]==0):
                ya.append(0)
            if (yactual[index1][0]==0 and yactual[index1][1]==1 and yactual[index1][2]==0 and yactual[index1][3]==0 and yactual[index1][4]==0 and yactual[index1][5]==0):
                ya.append(1)
            if (yactual[index1][0]==0 and yactual[index1][1]==0 and yactual[index1][2]==1 and yactual[index1][3]==0 and yactual[index1][4]==0 and yactual[index1][5]==0):
                ya.append(2)
            if (yactual[index1][0]==0 and yactual[index1][1]==0 and yactual[index1][2]==0 and yactual[index1][3]==1 and yactual[index1][4]==0 and yactual[index1][5]==0):
                ya.append(3)
            if (yactual[index1][0]==0 and yactual[index1][1]==0 and yactual[index1][2]==0 and yactual[index1][3]==0 and yactual[index1][4]==1 and yactual[index1][5]==0):
                ya.append(4)   
            if (yactual[index1][0]==0 and yactual[index1][1]==0 and yactual[index1][2]==0 and yactual[index1][3]==0 and yactual[index1][4]==0 and yactual[index1][5]==1):
                ya.append(5)
print(len(ya))
print(len(yp))


for i in range(len(ya)):
    if(ya[i] == yp[i]):
                countp = countp+1
    else:
        if(i!=len(ya)-1):
            if((ya[i+1]!=0 and yp[i]!=0) or (ya[i-1]!=0 and yp[i]!=0)):
                countp=countp+1
            else:
                countn = countn+1
        else:
            countn = countn+1


yaa=[]
ypp=[]
for i in range(len(ya)-1):
    if(ya[i]==yp[i]):
        yaa.append(ya[i])
        ypp.append(yp[i])
    else:
        if(ya[i]!=yp[i]):
            if((ya[i]==2 and yp[i+1]==2) or (ya[i-1]==2 and yp[i]==2) or (ya[i]==2 and yp[i-1]==2) or (ya[i+1]==2 and yp[i]==2)):
                yaa.append(2)
                ypp.append(2)
            elif((ya[i]==3 and yp[i+1]==3) or (ya[i-1]==3 and yp[i]==3) or (ya[i]==3 and yp[i-1]==3) or (ya[i+1]==3 and yp[i]==3)):
                yaa.append(3)
                ypp.append(3)
            elif((ya[i]==4 and yp[i+1]==4) or (ya[i-1]==4 and yp[i]==4) or (ya[i]==4 and yp[i-1]==4) or (ya[i+1]==4 and yp[i]==4)):
                yaa.append(4)
                ypp.append(4)
            elif((ya[i]==5 and yp[i+1]==5) or (ya[i-1]==5 and yp[i]==5) or (ya[i]==5 and yp[i-1]==5) or (ya[i+1]==5 and yp[i]==5)):
                yaa.append(5)
                ypp.append(5)
            else:
                yaa.append(ya[i])
                ypp.append(yp[i])



conf_arr = confusion_matrix(yaa, ypp)
conf_ar_1 = confusion_matrix(ya, yp)


print(classification_report(yaa, ypp))
print(classification_report(ya, yp))
print(accuracy_score(yaa,ypp))
print(accuracy_score(ya,yp))


test_data = [65.71663828,2.000559697,0.927509588,1.367263894,28.9932391,-1.43680042,3.233846317,1.390503227,-0.003797961,-0.009765845,-0.001452424,-0.006051978,-0.006581628,-0.008367425,-0.007925678,-0.000485979,0.991099664,0.993213923,0.99992176,0.99450799,0.992888764,0.995900923,0.994969843,0.997058683,0.652125548,0.201729356,0.237883894,0.455559514,0.652909188,0.201363975,0.24440563,0.459197528,0.646552844,0.003788574,0.114773499,0.420182046]
test_data2 = np.array(test_data)
test_data3 = test_data2.reshape(1, 1, 36)

resultnewTest = model.predict(test_data3, verbose=0)[0]

print(resultnewTest)


for index1 in range(1):
    i = np.where(resultnewTest[index1] == resultnewTest[index1].max())
    hin = i[0]
    for index2 in range(6):
        if(index2==hin):
            resultnewTest[index1][index2]=1
        else:
            resultnewTest[index1][index2]=0


print(resultnewTest)
test_data = [3.496975571,5.23133881,2.969923024,1.403945156,2.586841992,3.263263203,3.875656459,1.427367267,-0.00310496,-0.008150457,-0.004602477,-0.008577343,-0.001675536,-0.005400046,-0.005581164,-0.003245549,0.993325865,0.991415445,0.996473748,0.998845225,0.996452155,0.995826012,0.994582555,0.995877992,0.679476704,0.227064595,0.321708889,0.436399674,0.683794901,0.228052776,0.326327732,0.439317916,0.697691169,0.190961651,0.31343034,0.423416975]
test_data2 = np.array(test_data)
test_data3 = test_data2.reshape(1, 1, 36)

resultnewTest = model.predict(test_data3, verbose=0)[0]

print(resultnewTest)


for index1 in range(1):
    i = np.where(resultnewTest[index1] == resultnewTest[index1].max())
    hin = i[0]
    for index2 in range(6):
        if(index2==hin):
            resultnewTest[index1][index2]=1
        else:
            resultnewTest[index1][index2]=0


print(resultnewTest)

app = Flask(__name__)
api = Api(app)

@app.route('/predict', methods=['POST'])
def predict():
    request_data = request.get_json()

    test_data = [request_data['kurtosisx'],request_data['kurtosisy'],request_data['kurtosisz'],request_data['kurtosisf'],request_data['abs_kurtosisx'],request_data['abs_kurtosisy'],request_data['abs_kurtosisz'],request_data['abs_kurtosisf'],request_data['minx'],request_data['miny'],request_data['minz'],request_data['minf'],request_data['abs_minx'],request_data['abs_miny'],request_data['abs_minz'],request_data['abs_minf'],request_data['maxx'],request_data['maxy'],request_data['maxz'],request_data['maxf'],request_data['abs_maxx'],request_data['abs_maxy'],request_data['abs_maxz'],request_data['abs_maxf'],request_data['meanx'],request_data['meany'],request_data['meanz'],request_data['meanf'],request_data['abs_meanx'],request_data['abs_meany'],request_data['abs_meanz'],request_data['abs_meanf'],request_data['medianx'],request_data['mediany'],request_data['medianz'],request_data['medianf']]

    #test_data = [3.496975571,5.23133881,2.969923024,1.403945156,2.586841992,3.263263203,3.875656459,1.427367267,-0.00310496,-0.008150457,-0.004602477,-0.008577343,-0.001675536,-0.005400046,-0.005581164,-0.003245549,0.993325865,0.991415445,0.996473748,0.998845225,0.996452155,0.995826012,0.994582555,0.995877992,0.679476704,0.227064595,0.321708889,0.436399674,0.683794901,0.228052776,0.326327732,0.439317916,0.697691169,0.190961651,0.31343034,0.423416975]
    test_data2 = np.array(test_data)
    test_data3 = test_data2.reshape(1, 1, 36)
    resultnewTest = model.predict(test_data3, verbose=0)[0]
    for index1 in range(1):
        i = np.where(resultnewTest[index1] == resultnewTest[index1].max())
        hin = i[0]
        for index2 in range(6):
            if(index2==hin):
                resultnewTest[index1][index2]=1
            else:
                resultnewTest[index1][index2]=0
    return {"t1": str(resultnewTest[0][0]), "t2": str(resultnewTest[0][1]), "t3": str(resultnewTest[0][2]), "t4": str(resultnewTest[0][3]), "t5": str(resultnewTest[0][4]), "t6": str(resultnewTest[0][5])}, 200

if __name__ == "__main__":
    app.run()
