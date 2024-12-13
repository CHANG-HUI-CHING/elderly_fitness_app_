import 'package:flutter/material.dart';
import 'package:video_player/video_player.dart';
import 'api_service.dart';
import 'upload_page.dart';
//import 'exercise_recommendation_page.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

//import 'dart:io';

void main() {
  runApp(MyFitnessApp());
}

class MyFitnessApp extends StatelessWidget {
  const MyFitnessApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('老年人健身App'),
      ),
      body: ListView(
        children: [
          ExpansionTile(
            title: const Text(
              '大腿訓練',
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
            ), // 大腿訓練分類
            children: [
              _buildExerciseButton(
                  context,
                  '輕微深蹲', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=188d8GP7fCKbw1j5JRyhuubS2fRu-M5Wk', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1x29TIYjJ3U-vqzPwv6JYkbnnI2gHByNP', // 側面視角影片

                  // 介紹部分
                  '輕微深蹲是一個基本的下半身訓練動作，有助於強化大腿和臀部肌肉，同時提升核心穩定性。',

                  // 動作要點部分
                  '1. 站立時雙腳與肩同寬，腳尖略微朝外。\n'
                      '2. 慢慢下蹲，保持背部挺直，膝蓋在腳尖上方，臀部向後坐。\n'
                      '3. 下蹲到膝蓋90度後緩慢站起回到起始位置。',

                  // 注意事項部分
                  '1. 避免膝蓋過度前移超過腳尖。\n'
                      '2. 保持背部挺直，避免駝背。\n'
                      '3. 深蹲過程中全腳掌用力，避免只用前腳掌支撐。'),
              _buildExerciseButton(
                  context,
                  '弓箭步左右腳交替', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1UPvPnjEjqcI3lk1UL8k1tGbSZ8sYlVAZ', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1CYTP1rU-pfmWHN2DqlgTw4xM76XsGQ2w', // 側面視角影片
                  // 介紹部分
                  '弓箭步主要鍛鍊大腿和臀部的力量，還有助於提升平衡和穩定性。',

                  // 動作要點部分
                  '1. 站立時雙腳與肩同寬，核心收緊，手自然放置兩側。\n'
                      '2. 向前跨出一大步，後腳膝蓋慢慢下降至接近地面，前腿膝蓋保持在腳尖上方。\n'
                      '3. 推動前腳站回起始位置，並交替另一隻腳進行動作。',

                  // 注意事項部分
                  '1. 保持上半身挺直，避免前傾。\n'
                      '2. 後腿膝蓋不要碰地，保持一點距離。\n'
                      '3. 前腳膝蓋不要超過腳尖，以保護膝關節。'),
              _buildExerciseButton(
                  context,
                  '大腿上抬及左右側伸展', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1HeH-p8lZb63af6WHi7a_6C19lzKW41yN', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1coIVrUWEuWpPMBN1jgwyJdpX9r9mDBlA', // 側面視角影片
                  // 介紹部分
                  '這個動作有助於加強大腿和臀部肌肉，同時提升身體的側向靈活性和力量。',

                  // 動作要點部分
                  '1. 站立時核心收緊，雙腳與肩同寬。\n'
                      '2. 抬起一隻腿，使膝蓋抬至臀部高度，然後向左右兩側伸展。\n'
                      '3. 每側伸展後回到起始位置，換腿進行。',

                  // 注意事項部分
                  '1. 確保核心收緊，避免身體左右晃動。\n'
                      '2. 動作要平穩且控制，不要過快完成。\n'
                      '3. 保持膝蓋不鎖死，動作應該自然流暢。'),
              _buildExerciseButton(
                  context,
                  '大腿上抬', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1gSGexsyFQNLByXpl5h78WXEjv5Ff0jsM', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=19aM0Y79Ydz4dgS4mQTQMKeochgO_WFIM', // 側面視角影片
                  // 介紹部分
                  '這個動作有助於提升大腿前側肌肉的力量，同時加強核心穩定性。',

                  // 動作要點部分
                  '1. 站立時核心收緊，雙腳與肩同寬，雙手放置兩側。\n'
                      '2. 抬起一隻腿，使膝蓋往上到與臀部同高，保持核心穩定。\n'
                      '3. 保持抬腿姿勢約1-2秒後放下，然後換另一隻腿重複。',

                  // 注意事項部分
                  '1. 上半身保持挺直，避免向後仰。\n'
                      '2. 抬腿時保持核心收緊，以避免骨盆傾斜。\n'
                      '3. 動作應該流暢，避免過於快速或僵硬。'),
              _buildExerciseButton(
                  context,
                  '坐姿側舉腿', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1huuZpSyPEhoZJE7k114T89AJtgfXqbA_', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=17TN1MY0wJECk40PM4CILiQbR_k7n1FJn', // 側面視角影片
// 介紹部分
                  '這個動作針對臀部外側肌群，可以有效增強臀部力量和穩定性。',

// 動作要點部分
                  '1. 坐在地上，身體側向支撐一隻手，另一手放在腰部或支撐在地面上。\n'
                      '2. 兩腿併攏，然後抬起上方的那條腿，保持腳尖朝前。\n'
                      '3. 緩慢抬起至與髖部同高，然後慢慢放下，重複動作。',

// 注意事項部分
                  '1. 確保上半身穩定，不要左右晃動。\n'
                      '2. 抬腿時腳尖保持朝前，避免腳尖向上或向下。\n'
                      '3. 保持動作控制，避免過快抬起或放下。'),
              _buildExerciseButton(
                  context,
                  '坐姿抬腿', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1hTX_rFrC12QHxPxH2AmHuKhXKfbFlSfy', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1pvu9ibEwsjnRNi9uT_dbWCU8TiK1qf9L', // 側面視角影片
// 介紹部分
                  '這個動作有助於強化大腿前側的股四頭肌，提升腿部力量，適合初學者和恢復性訓練。',

// 動作要點部分
                  '1. 坐在椅子上，雙腳平放在地面上，雙手放在身體兩側。\n'
                      '2. 抬起一隻腿，使膝蓋伸直並與地面平行，保持腳尖朝上。\n'
                      '3. 保持抬腿姿勢1-2秒，然後慢慢放下，換另一隻腿進行動作。',

// 注意事項部分
                  '1. 上半身保持挺直，避免後仰。\n'
                      '2. 動作過程中應該緩慢且控制，避免過快。\n'
                      '3. 保持膝蓋不鎖死，動作應該自然流暢。'),
            ],
          ),
          ExpansionTile(
            title: const Text(
              "小腿訓練",
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
            ), // 小腿訓練分類
            children: [
              _buildExerciseButton(
                  context,
                  '坐姿腳跟背屈下做膝伸直', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1f71QYYJaX3d7hL8GrSH2bo3vC1-B_5w9', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1f71QYYJaX3d7hL8GrSH2bo3vC1-B_5w9', // 側面視角影片

// 介紹部分
                  '這個動作可以強化小腿肌肉，並有助於提升腳踝的靈活性與穩定性。',

// 動作要點部分
                  '1. 坐在椅子上，雙腳平放在地面，雙手自然放在兩側。\n'
                      '2. 抬起腳後跟，保持腳尖向上，進行腳踝背屈動作。\n'
                      '3. 同時伸直膝蓋，並保持這個姿勢1-2秒，然後慢慢放下。',

// 注意事項部分
                  '1. 保持上半身挺直，避免向前傾。\n'
                      '2. 動作應該緩慢且控制，避免過快過猛。\n'
                      '3. 確保膝蓋伸直但不鎖死，保持自然動作。'),
              _buildExerciseButton(
                  context,
                  '坐姿踮腳', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1AAI3TxbQzQ4nR9Ejidmimd4OaI_Ld6ge', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1lX1RuT77RBW6YKQiAiDiO_YsGKQHIxTH', // 側面視角影片

// 介紹部分
                  '這個動作主要針對小腿肌肉群，提升下肢的穩定性與耐力。',

// 動作要點部分
                  '1. 坐在椅子上，雙腳平放在地面，雙手自然放置。\n'
                      '2. 腳掌貼地，抬起腳跟至最高點，保持腳尖向前。\n'
                      '3. 保持姿勢約1-2秒後放下，然後重複動作。',

// 注意事項部分
                  '1. 動作過程中保持核心穩定，避免身體晃動。\n'
                      '2. 腳跟抬起時，確保全腳掌都參與發力。\n'
                      '3. 動作應該平穩，避免急速完成。'),
              _buildExerciseButton(
                  context,
                  '坐姿小腿拉伸', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1LjBLVQYjBPTdL0NOI1k9uYv4my_HiCce', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=129GMfCf2jLUfZAOdjoP57fXGTmJShX-e', // 側面視角影片

// 介紹部分
                  '這個動作幫助提升小腿的柔韌性，適合進行運動前的拉伸或放鬆。',

// 動作要點部分
                  '1. 坐在地上，雙腿伸直，保持上半身挺直。\n'
                      '2. 用雙手抓住腳趾，輕輕向身體方向拉伸，保持膝蓋伸直。\n'
                      '3. 保持拉伸姿勢約20-30秒，然後放鬆。',

// 注意事項部分
                  '1. 保持膝蓋伸直，避免彎曲。\n'
                      '2. 拉伸時應該感到輕微的緊繃感，但不要過度用力。\n'
                      '3. 保持呼吸均勻，避免憋氣。'),
              _buildExerciseButton(
                  context,
                  '併腳及勾腳底板', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1GYfw67nOY9P8fPSFCABWby_mWU571Byw', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1qRo2IOQodP7XXR2wySWMGb-sQH112FnZ', // 側面視角影片

// 介紹部分
                  '這個動作幫助強化小腿和足部肌肉，並提升腳踝的靈活性。',

// 動作要點部分
                  '1. 站立時雙腳併攏，雙手自然放置兩側。\n'
                      '2. 提起腳趾，保持腳掌穩定。\n'
                      '3. 保持腳趾上勾的姿勢約1-2秒後放下，重複動作。',

// 注意事項部分
                  '1. 保持平衡，避免身體晃動。\n'
                      '2. 控制腳趾的動作，避免過猛用力。\n'
                      '3. 動作應該平穩，避免過快完成。'),
              _buildExerciseButton(
                  context,
                  '左右腳抬膝交替併腳', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=10lcytMdz5Xqz_kVtoWwtQ_oM3Vsvg3tT', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1bmoQPVM6tsVRvy7LZyNVKREv3edluZHi', // 側面視角影片

// 介紹部分
                  '這個動作主要針對小腿和大腿肌肉，幫助增強下肢的耐力和靈活性。',

// 動作要點部分
                  '1. 站立時核心收緊，雙腳與肩同寬，雙手自然放置兩側。\n'
                      '2. 抬起一隻腿至膝蓋與臀部同高，然後放下。\n'
                      '3. 重複另一隻腿進行動作，左右交替。',

// 注意事項部分
                  '1. 保持上半身挺直，避免身體左右晃動。\n'
                      '2. 抬腿時保持核心穩定，避免膝蓋超過腳尖。\n'
                      '3. 動作應平穩，避免過快完成。'),
              _buildExerciseButton(
                  context,
                  '小腿前傾伸展', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=13pD3SWxBvWZLnaXzL3XEsRVka4DnyNqB', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=16zQkTIn_zxGnvYb65TMpGJhw4vzsCLNX', // 側面視角影片
// 介紹部分
                  '這個動作有助於拉伸小腿和提升腳踝的靈活性，適合運動前的熱身。',

// 動作要點部分
                  '1. 站立時雙腳與肩同寬，雙手放在身體兩側。\n'
                      '2. 向前傾身，使膝蓋微彎，腳掌保持平穩。\n'
                      '3. 保持這個姿勢約20-30秒，然後回到起始位置。',

// 注意事項部分
                  '1. 保持膝蓋微彎，避免過度伸展。\n'
                      '2. 控制傾身動作，避免過猛。\n'
                      '3. 動作過程中保持呼吸均勻。'),
              _buildExerciseButton(
                  context,
                  '左右腳小腿交替勾腳後跟', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1G6Lhgsoq68RLunivOfYqAXbY8eNGaonU', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1MaHugbHvWj4AWS_3U1_7ZDNDCwBUfcXY', // 側面視角影片

// 介紹部分
                  '這個動作幫助提升腳踝的靈活性，並增強小腿後側的肌肉力量。',

// 動作要點部分
                  '1. 站立時雙腳與肩同寬，雙手自然放置兩側。\n'
                      '2. 一隻腳抬起並勾起腳趾，保持腳跟接觸地面。\n'
                      '3. 保持姿勢約1-2秒，然後換另一隻腳進行動作，左右交替。',

// 注意事項部分
                  '1. 保持平衡，避免身體左右晃動。\n'
                      '2. 勾腳時避免過度用力，保持自然動作。\n'
                      '3. 動作應該平穩流暢，避免過快。'),
              _buildExerciseButton(
                  context,
                  '來回伸展小腿前傾後點腳', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1vBCErdmur_uzfn6yJsa-8heCdw7ojh8s', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1sQ-pn6ckFD3uPxli1SkupfWZ_cyTRleA', // 側面視角影片

// 介紹部分
                  '這個動作有助於同時拉伸小腿前後側肌肉，並提升腳踝的靈活性。',

// 動作要點部分
                  '1. 站立時雙腳與肩同寬，雙手自然放置。\n'
                      '2. 向前傾身，同時抬起一隻腳並點腳，然後回到起始位置。\n'
                      '3. 重複另一隻腳，左右交替進行動作。',

// 注意事項部分
                  '1. 保持膝蓋微彎，避免過度伸展。\n'
                      '2. 動作過程中保持核心穩定，避免前傾過度。\n'
                      '3. 保持動作平穩，避免過快完成。'),
            ],
          ),
          ExpansionTile(
            title: const Text(
              "肩頸訓練",
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
            ), // 肩頸訓練分類
            children: [
              _buildExerciseButton(
                  context,
                  '坐姿肩胛轉圈', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1G8GO2_KHwCl4oQVVXpv44ldxn29nIseO', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1Kwkr2JdVQCDv-XtOz1A7-UhHqMfzB8Ne', // 側面視角影片

// 介紹部分
                  '這個動作有助於提升肩部的靈活性，並幫助放鬆肩胛骨區域。',

// 動作要點部分
                  '1. 坐姿，雙手自然放置兩側，保持背部挺直。\n'
                      '2. 以肩胛骨為主，進行肩膀畫圈的動作。\n'
                      '3. 向前和向後各做10次，保持動作平穩。',

// 注意事項部分
                  '1. 動作過程中保持上半身穩定，避免晃動。\n'
                      '2. 動作幅度應該適中，不要過大或過快。\n'
                      '3. 控制呼吸，保持均勻。'),
              _buildExerciseButton(
                  context,
                  '坐姿肩胛下壓', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1OYcBrnDUYGfqIh2iSz2pjqJgQEqj_z14', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1hQrsS1vEmFinBD0Cukqw_8DtKRQb_Hwj', // 側面視角影片

// 介紹部分
                  '這個動作幫助強化肩胛的控制力，適合增強肩部穩定性。',

// 動作要點部分
                  '1. 坐姿，雙手放置於大腿上，保持肩部放鬆。\n'
                      '2. 逐漸下壓肩胛骨，保持肩膀下沉。\n'
                      '3. 保持姿勢2-3秒，然後放鬆，重複動作。',

// 注意事項部分
                  '1. 動作過程中保持核心穩定，避免彎腰。\n'
                      '2. 確保肩部放鬆，避免過度用力。\n'
                      '3. 動作應該緩慢控制，避免過快完成。'),
              _buildExerciseButton(
                  context,
                  '反向飛鳥（肩部後側）', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1iPMlyXvJeotu-_bh3JjNpnnDJzGeiqMf', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1RwaGgL0tVOWMUc55T2Kwe07NrrTIQjoy', // 側面視角影片

// 介紹部分
                  '這個動作主要針對肩部後側的三角肌，有助於提升肩部力量。',

// 動作要點部分
                  '1. 站立時雙腳與肩同寬，雙手握住輕重量啞鈴。\n'
                      '2. 雙手打開至肩膀高度，保持肘部微彎。\n'
                      '3. 向後擺動雙臂，直到肩膀後側感到緊繃，然後回到起始位置。',

// 注意事項部分
                  '1. 動作過程中保持核心收緊，避免過度彎腰。\n'
                      '2. 避免使用過重的重量，導致肩部壓力過大。\n'
                      '3. 動作應該平穩，避免過快或突然的動作。'),
              _buildExerciseButton(
                  context,
                  '站姿肩胛轉圈', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1Yf97EwOm79jB2AdOjnvq8YR2eCypqDTr', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1_zEZwxjtDSVRmLX1idHxutXyi7TovzVW', // 側面視角影片

// 介紹部分
                  '這個動作幫助放鬆肩部區域並增強肩胛的靈活性。',

// 動作要點部分
                  '1. 站立時雙腳與肩同寬，雙手自然放置兩側。\n'
                      '2. 以肩胛骨為軸，進行肩膀的轉圈動作，向前和向後各做10次。\n'
                      '3. 保持身體穩定，動作平穩。',

// 注意事項部分
                  '1. 保持上半身穩定，避免左右晃動。\n'
                      '2. 動作過程中避免過度用力，保持自然。\n'
                      '3. 動作應平穩，避免過快。'),
              _buildExerciseButton(
                  context,
                  '啞鈴上舉肩推', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=10jWPt2YnXl0YozYlYzW04G5GwtoeOcIo', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=192b_ZzHJTDXu2nCnCheIHOpY1bgK3hCX', // 側面視角影片

// 介紹部分
                  '這個動作主要針對肩部前側和中側的三角肌，幫助提升肩部力量。',

// 動作要點部分
                  '1. 站立或坐姿，雙手握住啞鈴，手臂彎曲，將啞鈴抬至肩膀高度。\n'
                      '2. 向上推舉啞鈴，直到手臂完全伸直，然後慢慢放下。\n'
                      '3. 保持姿勢穩定，重複動作。',

// 注意事項部分
                  '1. 保持核心穩定，避免腰部過度彎曲。\n'
                      '2. 確保肩膀放鬆，避免聳肩。\n'
                      '3. 動作應該平穩流暢，避免過快。'),
              _buildExerciseButton(
                  context,
                  '啞鈴下壓肩推', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1Ma48HyMubTVQYUdCWNdGcytdME46thIn', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=147iZLpLnYZ1Zu9A_XVK2te9DRmHi4JEI', // 側面視角影片

// 介紹部分
                  '這個動作有助於提升肩部的穩定性和力量，針對肩部前側和中側的三角肌。',

// 動作要點部分
                  '1. 站立或坐姿，雙手握住啞鈴，手臂彎曲，啞鈴放在肩膀兩側。\n'
                      '2. 向下壓啞鈴至大腿兩側，保持核心穩定。\n'
                      '3. 慢慢返回肩膀位置，重複動作。',

// 注意事項部分
                  '1. 保持肩膀放鬆，避免過度用力。\n'
                      '2. 核心保持收緊，避免過度彎腰。\n'
                      '3. 動作應平穩流暢，避免過快或突然的動作。'),
              _buildExerciseButton(
                  context,
                  '啞鈴肩推交叉式', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1yTT0ciXMGs40diWwsHts8H-wu1HhmxY4', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1mVIOb062-7HJVu2p646pJBUdJCMS6n_B', // 側面視角影片

// 介紹部分
                  '這個動作主要訓練肩部前側和中側的三角肌，幫助提升肩部力量。',

// 動作要點部分
                  '1. 站立或坐姿，雙手握住啞鈴，手臂彎曲，啞鈴在肩膀兩側。\n'
                      '2. 向上推舉右手的啞鈴，同時保持左手啞鈴在肩膀位置。\n'
                      '3. 交替推舉左右手的啞鈴，保持動作流暢。',

// 注意事項部分
                  '1. 保持核心收緊，避免身體左右晃動。\n'
                      '2. 每次推舉時，確保肩膀不聳肩，動作應該自然。\n'
                      '3. 動作過程中避免過快，保持均勻節奏。'),
              _buildExerciseButton(
                  context,
                  '啞鈴肩推從前往上舉', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1xuj4oG0qSQ1UBqci2k2VuHnsVx28kiXx', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=199B9eYoZcQJ_vYZccijpuxnk3w-MBYxP', // 側面視角影片

// 介紹部分
                  '這個動作有助於提升肩部的力量，特別是針對三角肌的前側和中側。',

// 動作要點部分
                  '1. 站立或坐姿，雙手握住啞鈴，手臂放置在大腿兩側。\n'
                      '2. 向前舉起啞鈴，直到手臂到肩膀高度。\n'
                      '3. 慢慢放下啞鈴，回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持上半身穩定，避免左右晃動。\n'
                      '2. 每次抬起時，避免聳肩，保持肩膀放鬆。\n'
                      '3. 動作應該平穩，避免過快或過猛。'),
              _buildExerciseButton(
                  context,
                  '啞鈴肩推從前抬高', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1fI0DL-9jzz9BZoq2Kv9EkKGP_h2CHVfq', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1bGB-bfuIM1Gn4XCIC8hndm_5yQJRj7fA', // 側面視角影片

// 介紹部分
                  '這個動作主要針對肩部的力量訓練，幫助強化肩部前側和中側肌群。',

// 動作要點部分
                  '1. 站立或坐姿，雙手握住啞鈴，手臂自然下垂。\n'
                      '2. 向前抬起啞鈴至肩膀高度，保持肘部微彎。\n'
                      '3. 慢慢放下啞鈴，回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持核心穩定，避免身體過度前傾。\n'
                      '2. 抬起啞鈴時，避免過度用力或聳肩。\n'
                      '3. 動作應該控制好節奏，避免過快完成。'),
              _buildExerciseButton(
                  context,
                  '啞鈴肩推往後轉臂', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1Kgx0kKoH8UFRvFc52rmw01O7H5coinB_', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1QF5rQyIOnd9M_Pz__5GIzZ_QD79HKu0o', // 側面視角影片

// 介紹部分
                  '這個動作有助於增加肩部的靈活性和力量，特別是對三角肌的後側有很大幫助。',

// 動作要點部分
                  '1. 站立或坐姿，雙手握住啞鈴，手臂自然下垂。\n'
                      '2. 向後旋轉肩膀，同時帶動啞鈴向後舉起。\n'
                      '3. 慢慢回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持肩膀放鬆，避免過度聳肩。\n'
                      '2. 動作應該緩慢控制，避免過快完成。\n'
                      '3. 核心保持穩定，避免身體晃動。'),
              _buildExerciseButton(
                  context,
                  '啞鈴肩推左右前側置胸前', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1P8hvVr0qsRgmRSPEAO77bZYT4Z2UT8tX', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=16Hzl2Kpj8IR2n1nY44bpBASNptvStYW5', // 側面視角影片

// 介紹部分
                  '這個動作主要訓練肩部前側和中側的三角肌，並能提升肩部的穩定性和力量。',

// 動作要點部分
                  '1. 站立或坐姿，雙手握住啞鈴，手臂自然垂下，啞鈴置於胸前。\n'
                      '2. 左右手交替向前舉起啞鈴，直到手臂與肩膀同高。\n'
                      '3. 慢慢放下啞鈴，回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持核心收緊，避免身體前傾或晃動。\n'
                      '2. 每次舉起啞鈴時，保持肩膀放鬆，避免聳肩。\n'
                      '3. 動作應該平穩流暢，避免過快或過猛。'),
            ],
          ),
          ExpansionTile(
            title: const Text(
              "核心訓練",
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
            ), // 核心訓練分類
            children: [
              _buildExerciseButton(
                  context,
                  '坐姿雙手推磨', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1VR7UxXjG55K_CInptOBIDi6YPYa9b3xI', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=15_fw2reP-fRhsQccvX_o3J5gLhlB-VgM', // 側面視角影片

// 介紹部分
                  '這個動作主要針對上半身和核心肌群，幫助提升肩部、手臂及腰腹部的力量和穩定性。',

// 動作要點部分
                  '1. 坐姿，雙手放於胸前，手掌相對，保持核心收緊。\n'
                      '2. 雙手向前做圓形推磨動作，保持肩膀穩定。\n'
                      '3. 重複10次後，反方向畫圓進行推磨動作。',

// 注意事項部分
                  '1. 保持上半身穩定，避免過度晃動。\n'
                      '2. 核心保持收緊，防止腰部過度前傾或後仰。\n'
                      '3. 控制動作速度，保持平穩流暢，避免過快。'),
              _buildExerciseButton(
                  context,
                  '大腿上抬及左右側伸展', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=19hwytyDMs4vPgE0vvWCQxJjmC1gyvjLo', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=13juprwhjAMFpO5pSv6JcITpunkHeko7-', // 側面視角影片

// 介紹部分
                  '這個動作幫助強化大腿、臀部以及核心穩定性，並提升身體的靈活性。',

// 動作要點部分
                  '1. 站立時核心收緊，雙腳與肩同寬，雙手可以叉腰或保持平衡。\n'
                      '2. 抬起一隻腿至膝蓋與臀部同高，然後向左右兩側伸展。\n'
                      '3. 保持伸展後，回到起始位置，換另一條腿重複動作。',

// 注意事項部分
                  '1. 保持核心收緊，避免身體左右晃動。\n'
                      '2. 控制腿部動作，避免過快完成。\n'
                      '3. 動作應平穩，避免膝蓋過度伸展或鎖死。'),
            ],
          ),
          ExpansionTile(
            title: const Text(
              "髖關節訓練",
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
            ), // 髖關節訓練分類
            children: [
              _buildExerciseButton(
                  context,
                  '坐姿深蹲', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=17OV8kXZ0I_TjQsV6HJcCtpXcHt_BQAze', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1dAfxaTEcOOGk9r_SThV7COmQ5w9wlrNX', // 側面視角影片

// 介紹部分
                  '這個動作主要針對下半身肌肉，特別是大腿和臀部，並能增強膝關節的靈活性。',

// 動作要點部分
                  '1. 坐在椅子前端，雙腳與肩同寬，雙手自然放置兩側。\n'
                      '2. 慢慢站起，同時保持膝蓋與腳尖方向一致，並保持背部挺直。\n'
                      '3. 站立後慢慢回坐，重複動作。',

// 注意事項部分
                  '1. 保持背部挺直，避免駝背。\n'
                      '2. 膝蓋不要超過腳尖，以免增加關節壓力。\n'
                      '3. 動作應緩慢控制，避免過快。'),
              _buildExerciseButton(
                  context,
                  '深蹲', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1qOAPX6Afp56UPvZJQBJ9wXRglD49xT0S', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1q1aZEUL83TUJe_VSAtYuCmBnoFFh2CvZ', // 側面視角影片

// 介紹部分
                  '這個動作主要針對下半身和核心的穩定性，並幫助鍛鍊骨盆底肌。',

// 動作要點部分
                  '1. 站立時雙腳與肩同寬，腳尖稍微朝外，雙手自然垂放或放在胸前。\n'
                      '2. 慢慢下蹲，臀部向後，保持膝蓋與腳尖一致，背部挺直。\n'
                      '3. 下蹲至大腿與地面平行後慢慢站起，重複動作。',

// 注意事項部分
                  '1. 保持膝蓋與腳尖方向一致，避免膝蓋內扣。\n'
                      '2. 保持背部挺直，避免弓背。\n'
                      '3. 動作應該緩慢控制，避免過快或過猛。'),
              _buildExerciseButton(
                  context,
                  '小手臂部及手臂的伸展', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1NSFYyEsskFuG-ar2y_qpfnv3ptpMXMKE', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1sgW-6IKBiLg-HUhvTjMvVhWB7YBZqXwu', // 側面視角影片

// 介紹部分
                  '這個動作有助於提升手臂的靈活性和柔韌性，並幫助放鬆手腕及關節。',

// 動作要點部分
                  '1. 坐姿或站姿均可，雙手伸直，手掌向前。\n'
                      '2. 慢慢將手指向下彎曲，使用另一隻手輕輕拉伸，保持伸展約10-20秒。\n'
                      '3. 重複動作並進行反向伸展，保持姿勢。',

// 注意事項部分
                  '1. 拉伸時不要過度用力，應保持輕柔拉力。\n'
                      '2. 保持手腕與手臂在一條直線上，避免過度彎曲。\n'
                      '3. 動作應該緩慢進行，保持呼吸均勻。'),
            ],
          ),
          ExpansionTile(
            title: const Text(
              "三頭肌訓練",
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
            ), // 三頭肌訓練分類
            children: [
              _buildExerciseButton(
                  context,
                  '坐姿三頭肌伸展-1', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1ezAR9chuj7ZVfHIKo2C_6ZTfDfnXXx1E', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1Dvnjs90a-1BLjQ2vt8TgBHGZ8WHKSsE9', // 側面視角影片

// 介紹部分
                  '這個動作主要針對上臂後側的三頭肌，幫助增強手臂力量和穩定性。',

// 動作要點部分
                  '1. 坐姿，雙手握住啞鈴，將啞鈴舉過頭部，手肘彎曲。\n'
                      '2. 慢慢將啞鈴放下至頭部後方，保持肘部穩定不動。\n'
                      '3. 完全伸展手臂後，將啞鈴慢慢回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持核心收緊，避免身體前傾或後仰。\n'
                      '2. 確保肘部穩定，避免晃動。\n'
                      '3. 動作過程中應該控制速度，避免過快。'),
              _buildExerciseButton(
                  context,
                  '坐姿三頭肌伸展-2', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1_RwUVhFnLVdBVx3L2xcNjE9KjWSGudwC', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1_xVPBpFvU7_oMv7qFYsDiZNhCy8TsthH', // 側面視角影片

// 介紹部分
                  '這個動作與三頭肌伸展-1相似，專注於鍛鍊三頭肌並提升手臂後側的力量。',

// 動作要點部分
                  '1. 坐姿，雙手握住啞鈴，手臂伸直，啞鈴舉過頭部。\n'
                      '2. 慢慢將啞鈴放下至頭部後方，保持肘部穩定。\n'
                      '3. 完全伸展手臂後，再將啞鈴抬起至起始位置，重複動作。',

// 注意事項部分
                  '1. 保持上半身穩定，避免身體晃動。\n'
                      '2. 手臂伸展時不要過度快速，保持平穩。\n'
                      '3. 肘部應保持靠近頭部，避免向外張開。'),
              _buildExerciseButton(
                  context,
                  '坐姿啞鈴側擺', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=11dGr1nY0ATQ46ttX_6qvowbEkYToSyJ4', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1mnBdnWm4cGUk2B5zjP3Ky0wYUAcCRVK4', // 側面視角影片

// 介紹部分
                  '這個動作主要針對三頭肌的外側，幫助增強手臂後側的肌肉力量。',

// 動作要點部分
                  '1. 坐姿，雙手握住啞鈴，手臂向兩側伸展，肘部微彎。\n'
                      '2. 慢慢將雙手向上抬起至與肩膀同高，保持動作流暢。\n'
                      '3. 將啞鈴放回起始位置，重複動作。',

// 注意事項部分
                  '1. 保持核心穩定，避免身體左右晃動。\n'
                      '2. 抬起啞鈴時保持手肘微彎，避免過度伸直。\n'
                      '3. 動作應該平穩，避免過快。'),
              _buildExerciseButton(
                  context,
                  '坐姿俯身划船', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1g0GX3Stv0Fxxrhrk_FzqsZrsPQVdkIf-', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1CAztEjw1bJBp4xSLP-JdDpkm__3bl2Gg', // 側面視角影片

// 介紹部分
                  '這個動作有助於鍛鍊三頭肌及肩膀的力量，特別針對手臂後側的肌群。',

// 動作要點部分
                  '1. 坐姿，身體前傾，雙手握住啞鈴放在膝蓋下方。\n'
                      '2. 慢慢將雙手向後拉至腰部位置，保持肘部靠近身體。\n'
                      '3. 將啞鈴放回起始位置，重複動作。',

// 注意事項部分
                  '1. 保持核心穩定，避免背部過度拱起。\n'
                      '2. 確保肘部靠近身體，避免向外張開。\n'
                      '3. 動作應該平穩流暢，避免過快。'),
              _buildExerciseButton(
                  context,
                  '啞鈴手臂上下舉伸展', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1LYRXwXC_aHGLW7pfviVmQoSlR7gQJ75b', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1oe4p0RErdnmrUIZAvdu74B_op22ROqQ-', // 側面視角影片

// 介紹部分
                  '這個動作專注於鍛鍊三頭肌，幫助提升手臂的力量與穩定性。',

// 動作要點部分
                  '1. 站姿或坐姿，雙手握住啞鈴，將啞鈴舉過頭部，手臂伸直。\n'
                      '2. 慢慢將啞鈴放下至頭部後方，保持肘部穩定。\n'
                      '3. 完全伸展手臂後，將啞鈴慢慢抬回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持核心收緊，避免身體前傾或後仰。\n'
                      '2. 確保肘部穩定，避免向外張開。\n'
                      '3. 動作過程中應該平穩，避免過快或突然的動作。'),
            ],
          ),
          ExpansionTile(
            title: const Text(
              "二頭肌訓練",
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
            ), // 二頭肌訓練分類
            children: [
              _buildExerciseButton(
                  context,
                  '坐姿二頭肌彎舉', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=17lakKnPAUfWGe4BEP4HpCur52a3kZlnO', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1U_0pntaInnNBFWr_98TVyHMMAPS5JFx4', // 側面視角影片

// 介紹部分
                  '這個動作主要針對上臂前側的二頭肌，幫助提升手臂的力量與肌肉形狀。',

// 動作要點部分
                  '1. 坐姿，雙手握住啞鈴，手臂垂直放置於身體兩側。\n'
                      '2. 慢慢彎曲手肘，將啞鈴舉至肩膀高度，保持肘部穩定不動。\n'
                      '3. 放下啞鈴，回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持上半身穩定，避免身體晃動。\n'
                      '2. 確保肘部穩定，避免肘部向外張開。\n'
                      '3. 動作應平穩流暢，避免過快或過猛。'),
              _buildExerciseButton(
                  context,
                  '坐姿雙手肩部推壓', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1z3tBHI2yvJolOQ3A6NbaYRQdcM-jAKYN', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1z3tBHI2yvJolOQ3A6NbaYRQdcM-jAKYN', // 側面視角影片

// 介紹部分
                  '這個動作幫助鍛鍊上臂的二頭肌和肩部力量，提升手臂與肩部的穩定性。',

// 動作要點部分
                  '1. 坐姿，雙手握住啞鈴，將啞鈴抬至肩膀高度，手臂彎曲。\n'
                      '2. 向上推舉啞鈴，直到手臂完全伸直，保持動作流暢。\n'
                      '3. 慢慢放下啞鈴，回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持核心穩定，避免過度後仰。\n'
                      '2. 確保肘部不向外張開，保持靠近身體。\n'
                      '3. 動作應該平穩，避免過快或突然的動作。'),
              _buildExerciseButton(
                  context,
                  '坐姿肩推', // 中文名稱顯示在App上
                  'https://drive.google.com/uc?export=download&id=1to_z-9JQl3jhFO1VoVIErBLR33UnmQph', // 正面視角影片
                  'https://drive.google.com/uc?export=download&id=1ad28zQWFrukL8ZN1BMbX6UcaON4rXOR_', // 側面視角影片

// 介紹部分
                  '這個動作針對肩部和二頭肌，幫助提升上半身力量與肩部穩定性。',

// 動作要點部分
                  '1. 坐姿，雙手握住啞鈴，將啞鈴抬至肩膀高度，手肘彎曲。\n'
                      '2. 向上推舉啞鈴，直到手臂完全伸直，保持肩膀穩定。\n'
                      '3. 慢慢放下啞鈴，回到起始位置，重複動作。',

// 注意事項部分
                  '1. 保持上半身挺直，避免過度後仰。\n'
                      '2. 核心保持收緊，避免身體晃動。\n'
                      '3. 動作應該平穩流暢，避免過快完成。'),
            ],
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => const UploadPage(),
                ),
              );
            },
            child: const Text("評分"),
          ),
        ],
      ),
    );
  }

  Widget _buildExerciseButton(
    BuildContext context,
    String title,
    String frontVideoPath,
    String sideVideoPath,
    String description,
    String points,
    String precautions,
  ) {
    return ListTile(
      title: Text(title), // 在App中顯示中文名稱
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => ExercisePage(
              title: title,
              frontVideoPath: frontVideoPath,
              sideVideoPath: sideVideoPath,
              description: description,
              points: points,
              precautions: precautions,
            ),
          ),
        );
      },
    );
  }
}

class ExercisePage extends StatefulWidget {
  final String title;
  final String frontVideoPath;
  final String sideVideoPath;
  final String description;
  final String points; // 動作要點
  final String precautions; // 注意事項

  const ExercisePage({
    super.key,
    required this.title,
    required this.frontVideoPath,
    required this.sideVideoPath,
    required this.description,
    required this.points,
    required this.precautions,
  });

  @override
  _ExercisePageState createState() => _ExercisePageState();
}

class _ExercisePageState extends State<ExercisePage> {
  late VideoPlayerController _frontController;
  late VideoPlayerController _sideController;

  @override
  void initState() {
    super.initState();
    _frontController = VideoPlayerController.network(widget.frontVideoPath)
      ..initialize().then((_) {
        setState(() {});
      });
    _sideController = VideoPlayerController.network(widget.sideVideoPath)
      ..initialize().then((_) {
        setState(() {});
      });
  }

  @override
  void dispose() {
    _frontController.dispose();
    _sideController.dispose();
    super.dispose();
  }

  Widget _buildVideoPlayer(VideoPlayerController controller, String title) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Text(
            title,
            style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
        ),
        GestureDetector(
          onTap: () {
            setState(() {
              controller.value.isPlaying
                  ? controller.pause()
                  : controller.play();
            });
          },
          child: AspectRatio(
            aspectRatio: controller.value.isInitialized
                ? controller.value.aspectRatio
                : 16 / 9,
            child: controller.value.isInitialized
                ? VideoPlayer(controller)
                : const CircularProgressIndicator(),
          ),
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            _buildVideoPlayer(_frontController, '正面視角'),
            const SizedBox(height: 16),
            _buildVideoPlayer(_sideController, '側面視角'),
            const SizedBox(height: 16),
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  // 介紹部分
                  const Text(
                    '介紹：',
                    style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    widget.description,
                    style: const TextStyle(fontSize: 16),
                  ),
                  const SizedBox(height: 16),
                  // 動作要點部分
                  const Text(
                    '動作要點：',
                    style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    widget.points,
                    style: const TextStyle(fontSize: 16),
                  ),
                  const SizedBox(height: 16),
                  // 注意事項部分
                  const Text(
                    '注意事項：',
                    style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    widget.precautions,
                    style: const TextStyle(fontSize: 16),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
