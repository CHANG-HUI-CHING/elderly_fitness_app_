import 'package:http/http.dart' as http;
import 'dart:convert';

class ApiService {
  static Future<Map<String, dynamic>> uploadImage(String filePath) async {
    final request = http.MultipartRequest(
        'POST', Uri.parse('http://10.0.2.2:5000/predict'));
    request.files.add(await http.MultipartFile.fromPath('file', filePath));

    final response = await request.send();
    final responseData = await http.Response.fromStream(response);

    if (response.statusCode == 200) {
      return json.decode(responseData.body);
    } else {
      throw Exception('Failed to connect to API: ${responseData.body}');
    }
  }
}
