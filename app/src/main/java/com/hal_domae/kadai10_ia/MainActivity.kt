package com.hal_domae.kadai10_ia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Activityが生成されるときに実行される
    // 最初にしか実行されない
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // アプリのヘッダーを表示するかどうか
        // フルスクリーンで表示できる
        enableEdgeToEdge()
        // レイアウトの設定(どのXML使うか)
        setContentView(R.layout.activity_main)
        // アプリの画面がステータスバーやナビゲーションバーに重ならないようにする
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}