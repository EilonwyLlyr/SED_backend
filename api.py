 
from flask import Flask, request
from flask_restful import Resource, Api, reqparse
import pandas as pd
import ast

app = Flask(__name__)
api = Api(app)

@app.route('/test', methods=['POST'])
def test():
    request_data = request.get_json()
    return {'HELLO': request_data['test']}, 200

if __name__ == "__main__":
    app.run(host='192.168.1.22')
