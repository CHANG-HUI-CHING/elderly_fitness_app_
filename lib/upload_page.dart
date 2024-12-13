import 'package:flutter/material.dart';
import 'package:file_picker/file_picker.dart'; // 导入 file_picker 插件
import 'api_service.dart'; // 确保导入正确的 API 服务类

class UploadPage extends StatefulWidget {
  const UploadPage({super.key});

  @override
  _UploadPageState createState() => _UploadPageState();
}

class _UploadPageState extends State<UploadPage> {
  bool isUploading = false; // 上传时的状态指示

  // 上传和辨识图片的功能
  Future<void> uploadAndRecognize() async {
    // 使用 file_picker 选择文件
    String? filePath = await FilePicker.platform.pickFiles(
      type: FileType.custom,
      allowedExtensions: ['jpg', 'png'], // 限制只允许选择图片文件
    )?.then((result) => result?.files.single.path); // 获取文件路径

    if (filePath == null) {
      // 如果用户没有选择文件，返回
      return;
    }

    setState(() {
      isUploading = true; // 开始上传时显示加载状态
    });

    try {
      // 上传图片到服务器并获取结果
      var result = await ApiService.uploadImage(filePath);

      // 从返回的结果中提取分类和信心值
      int classId = result['class_id'];
      double confidence = result['confidence'];

      // 显示辨识结果
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: const Text('辨识结果'),
          content: Text('分类: $classId\n信心值: ${confidence.toStringAsFixed(2)}'),
          actions: [
            TextButton(
                onPressed: () => Navigator.pop(context),
                child: const Text('OK'))
          ],
        ),
      );
    } catch (e) {
      // 如果上传或辨识失败，显示错误信息
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: const Text('错误'),
          content: Text('辨识失败：$e'),
          actions: [
            TextButton(
                onPressed: () => Navigator.pop(context),
                child: const Text('OK'))
          ],
        ),
      );
    } finally {
      setState(() {
        isUploading = false; // 上传完成后恢复按钮状态
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("上传并辨识"),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: isUploading ? null : uploadAndRecognize, // 按钮点击事件
          child: isUploading
              ? const CircularProgressIndicator() // 如果正在上传，显示加载状态
              : const Text("上传并辨识"), // 否则显示按钮文本
        ),
      ),
    );
  }
}
