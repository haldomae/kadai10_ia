package com.hal_domae.kadai10_ia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Activityが生成されるときに実行される
    // 最初にしか実行されない
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifeCycle", "MainActivityのonCreateが実行")
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
        val button: Button = findViewById(R.id.menu_1)
        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, ResultActivity::class.java))
        }
    }

    // Activityがユーザに見える状態になった時に実行される
    // 操作可能になるまでの間実行される
    // 遷移して、元に戻った時にも実行される
    // 位置情報の更新、カメラ、音声の準備
    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle", "MainActivityのonStartが実行")
    }

    // Activityが前面に表示され、ユーザとのやり取りが可能になる直前に実行される
    // Activityをユーザが操作可能になる為の必要な情報の処理や初期化を行う(DBからデータ取得、必要な情報を画面にセットする)
    // 割り込み処理(アプリ使用中に電話が来るなど)により、アプリが一時停止した後、再開するとonResumeが実行される
    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle", "MainActivityのonResumeが実行")
    }

    // アプリがバックグラウンドに移動したことを示す為に実行される
    // Activityが一時停止状態
    // 処理を停止しておくときなどに使用
    // 非常に短いのでデータの保存等は行わない
    override fun onPause() {
        super.onPause()
        Log.i("LifeCycle", "MainActivityのonPauseが実行")
    }

    // アプリが完全にバックグラウンドに移動した時に実行される
    // Activityは非表示になり、停止する
    // 不要なリソースを解放したり、アニメーションの停止などの処理の負荷を抑えるような事をする
    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle", "MainActivityのonStopが実行")
    }

    // Activityの再表示の際に実行される
    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycle", "MainActivityのonRestartが実行")
    }

    // Activityが破棄される前に実行される
    // 画面構成の変更(回転やテーマ変更)されたときも実行される
    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle", "MainActivityのonDestroyが実行")
    }
}