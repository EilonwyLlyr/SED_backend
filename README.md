# SmartEyeDropServer_Machinelearning

Recommended to use a unix based OS


## Order of Setup
- First setup MongoDB
- Second setup LSTM_API
- Third setup the Java API

## Mongodb
- Download Docker onto your machine [Docker](https://docs.docker.com/get-docker/)
- Run docker and check if it is running by running the following in the command line. `docker images`
- Run the following commands to get a mongodb image:
    - `docker pull mongo` gets a Mongodb image from dockerhub
    - `docker images` check to see if the image was downloaded
- Create a directory where all the the data for Mongodb will be stored.
    - `sudo mkdir -p /mongodata`
- Run the docker image, bind the directory just created and Mongodb's default port with the following command:
    - `docker run -it -v /mongodata:/data/db -p 27017:27017 --name mongodb -d mongo`
- You can stop and start the container anytime you want with the following commands:
    - `docker stop mongodb`
    - `docker start mongodb`

## LSTM API
- Have python version:3.9.x and pip version:20.3.x
- Run the following commands to install the packages required to run the API:
    - `pip install keras`
    - `pip install tensorflow`
    - `pip install sklearn`
    - `pip install matplotlib`
    - `pip install pandas`
    - `pip install flask`
- Run the following command to run the LSTM API:
    - `python LSTM_API.py`
- To stop just do "ctrl + c" to terminate the process

## Java API
- Have java installed (at least JAVA 8) and have the environment variable JAVA_HOME configured correctly.
- Configure the application.properties file found in the src/main/resources folder. Change the ip address to the ip address of the machine running the Mongodb container.
- To debug you may want to download the STS IDE [Download](https://spring.io/tools)
    - To import the project File > Import > Maven > Existing Maven Projects
    - Browser to the root directory of this project (same location where the pom.xml file is at)
    - Once the project has been imported wait a few minutes until it has been completely imported. This can be checked by looking at the progress at the bottom right progress bar.
    - To run the project right click the folder. Run As > Spring Boot App.
- To create the runnable application run the following commands:
    - `chmod +x mvnw` to make the wrapper executable.
    - `./mvnw clean package` create the jar file
- A jar file should be created in the target folder. To run the application do the following:
    - `java -jar SmartEyeDrops-0.1.jar`
    - `java -jar SmartEyeDrops-0.1.jar &` to run in the background
- To stop either "ctrl + c" or find the PID and terminate it.

## Endpoint Examples

curl -X POST -H "Content-Type: application/json" -d '{"email":"{email}","password":"{password}","firstName":"{firstname}","lastName":"{lastname}"}' http://{host}:{port}/user/register

curl -X DELETE http://{host}:{port}/user/deleteALL

curl -X GET http://{host}:{port}/user/all

curl -X POST -H "Content-Type: application/json" -d '{"email":"{email}","password":"{password}"}' http://{host}:{port}/user/info

curl -X PUT -H "Content-Type: application/json" -d '{"email":"{email}","password":"{password}","data":"{data}"}' http://{host}:{port}/user/data




request_data['kurtosisx],request_data['kurtosisy],request_data['kurtosisz'],request_data['kurtosisf'],request_data['abs_kurtosisx'],request_data['abs_kurtosisy'],request_data['abs_kurtosisz'],request_data['abs_kurtosisf'],request_data['minx'],request_data['miny'],request_data['minz'],request_data['minf'],request_data['abs_minx'],request_data['abs_miny'],request_data['abs_minz'],request_data['abs_minf'],request_data['maxx'],request_data['maxy'],request_data['maxz'],request_data['maxf'],request_data['abs_maxx'],request_data['abs_maxy'],request_data['abs_maxz'],request_data['abs_maxf'],request_data['meanx'],request_data['meany'],request_data['meanz'],request_data['meanf'],request_data['abs_meanx'],request_data['abs_meany'],request_data['abs_meanz'],request_data['abs_meanf'],request_data['medianx'],request_data['mediany'],request_data['medianz'],request_data['medianf']

{"kutrosisx": 3.496975571, "kurtosisy": 5.23133881, "kurtosisz": 2.969923024, "kurtosisf": 1.403945156, "abs_kurtosisx": 2.586841992, "abs_kurtosisy": 3.263263203, "abs_kurtosisz": 3.875656459, "abs_kurtosisf": 1.427367267, "minx": -0.00310496, "miny": -0.008150457, "minz": -0.004602477, "minf": -0.008577343, "abs_minx": -0.001675536, "abs_miny": -0.005400046, "abs_minz": -0.005581164, "abs_minf": -0.003245549, "maxx": 0.993325865, "maxy": 0.991415445, "maxz": 0.996473748, "maxf": 0.998845225, "abs_maxx": 0.996452155, "abs_maxy": 0.995826012, "abs_maxz": 0.994582555, "abs_maxf": 0.995877992, "meanx": 0.679476704, "meany": 0.227064595, "meanz": 0.321708889, "meanf": 0.436399674, "abs_meanx": 0.683794901, "abs_meany": 0.228052776, "abs_meanz": 0.326327732, "abs_meanf": 0.439317916, "medianx": 0.697691169, "mediany": 0.190961651, "medianz": 0.31343034, "medianf": 0.423416975}


curl -X POST -H "Content-Type:application/json" -d '{"kurtosisx": 3.496975571, "kurtosisy": 5.23133881, "kurtosisz": 2.969923024, "kurtosisf": 1.403945156, "abs_kurtosisx": 2.586841992, "abs_kurtosisy": 3.263263203, "abs_kurtosisz": 3.875656459, "abs_kurtosisf": 1.427367267, "minx": -0.00310496, "miny": -0.008150457, "minz": -0.004602477, "minf": -0.008577343, "abs_minx": -0.001675536, "abs_miny": -0.005400046, "abs_minz": -0.005581164, "abs_minf": -0.003245549, "maxx": 0.993325865, "maxy": 0.991415445, "maxz": 0.996473748, "maxf": 0.998845225, "abs_maxx": 0.996452155, "abs_maxy": 0.995826012, "abs_maxz": 0.994582555, "abs_maxf": 0.995877992, "meanx": 0.679476704, "meany": 0.227064595, "meanz": 0.321708889, "meanf": 0.436399674, "abs_meanx": 0.683794901, "abs_meany": 0.228052776, "abs_meanz": 0.326327732, "abs_meanf": 0.439317916, "medianx": 0.697691169, "mediany": 0.190961651, "medianz": 0.31343034, "medianf": 0.423416975}' http://localhost:5000/predict



curl -X PUT -H "Content-Type:application/json" -d '{"email": "test@test.com", "password": "password", "data": "time,x,y,z,force\n12:30,10,10,10,10\n12:31,1,1,1,100\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20\n12:44,3,3,3,20"}' http://localhost:8080/user/data
