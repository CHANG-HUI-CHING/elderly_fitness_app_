
from flask import Flask, request, jsonify
import os

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    # 這是您的 API 邏輯
    return jsonify({'message': 'API is working!'})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
