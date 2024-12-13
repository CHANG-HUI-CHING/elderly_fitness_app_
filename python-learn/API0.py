from flask import Flask, request, jsonify
import tensorflow as tf
import numpy as np
from PIL import Image

app = Flask(__name__)

# 載入模型
model = tf.keras.models.load_model('path_to_your_model.h5')

@app.route('/predict', methods=['POST'])
def predict():
    file = request.files['file']
    img = Image.open(file).resize((128, 128))  # 調整尺寸
    img_array = np.array(img) / 255.0
    img_array = np.expand_dims(img_array, axis=0)

    predictions = model.predict(img_array)
    class_id = np.argmax(predictions)
    confidence = np.max(predictions)

    return jsonify({'class_id': int(class_id), 'confidence': float(confidence)})

if __name__ == '__main__':
    app.run(debug=True)
