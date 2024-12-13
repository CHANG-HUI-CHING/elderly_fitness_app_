import 'package:flutter/material.dart';
import 'package:file_picker/file_picker.dart'; // 導入 file_picker 插件
import 'api_service.dart'; // 確保導入正確的API服務類

class UploadPage extends StatefulWidget {
  const UploadPage({super.key});

  @override
  _UploadPageState createState() => _UploadPageState();
}

class _UploadPageState extends State<UploadPage> {
  bool isUploading = false; //上傳時的狀態指示

  // 上傳和標註圖片的功能
  Future<void> uploadAndRecognize() async {
    // 使用 file_picker 選擇文件
    String? filePath = await FilePicker.platform.pickFiles(
      type: FileType.custom,
      allowedExtensions: ['jpg', 'png'], // 限制只允許選擇圖片文件
    )?.then((result) => result?.files.single.path); // 獲取文件路徑

    if (filePath == null) {
      // 如果使用者沒有選擇文件，返回
      return;
    }

    setState(() {
      isUploading = true; // 開始上傳時顯示載入狀態
    });

    try {
      // 上傳圖片到伺服器並取得結果
      var result = await ApiService.uploadImage(filePath);

      // 從傳回的結果中提取分類和準確值
      int classId = result['class_id'];
      double confidence = result['confidence'];

      // 顯示結果
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: const Text('辨識結果'),
          content: Text('分类: $classId\n準確值: ${confidence.toStringAsFixed(2)}'),
          actions: [
            TextButton(
                onPressed: () => Navigator.pop(context),
                child: const Text('OK'))
          ],
        ),
      );
    } catch (e) {
      // 如果上傳或提交失敗，顯示錯誤訊息
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: const Text('錯誤'),
          content: Text('辨識失敗：$e'),
          actions: [
            TextButton(
                onPressed: () => Navigator.pop(context),
                child: const Text('OK'))
          ],
        ),
      );
    } finally {
      setState(() {
        isUploading = false; // 上傳完成後恢復按鈕狀態
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("上傳並辨識"),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: isUploading ? null : uploadAndRecognize, // 按鈕點擊事件
          child: isUploading
              ? const CircularProgressIndicator() // 如果正在上傳，顯示載入狀態
              : const Text("上传并辨识"), // 否則按鈕顯示文字
        ),
      ),
    );
  }
}
