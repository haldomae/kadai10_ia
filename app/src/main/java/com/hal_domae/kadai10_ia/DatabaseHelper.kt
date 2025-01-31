package com.hal_domae.kadai10_ia

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME = "menu.sqlite"
        private const val DATABASE_VERSION = 1
    }

    // 初期状態に1度だけ実行される
    // アプリをアンインストールしない限り、2度と実行されない
    // onCreateを修正しても再度実行されない
    override fun onCreate(p0: SQLiteDatabase?) {
        // テーブル作成
        p0?.let{db ->
            db.execSQL("CREATE TABLE menu_items(menu_name TEXT)")
            db.execSQL("CREATE TABLE order_history(menu_name TEXT, createdAt DATETIME DEFAULT CURRENT_TIMESTAMP)")

            // 初期データ
            // SQLを直接実行
            //db.execSQL("INSERT INTO menu_items VALUES('ビール')")
            //db.execSQL("INSERT INTO menu_items VALUES('焼酎')")
            //db.execSQL("INSERT INTO menu_items VALUES('日本酒')")

            // メンテナンスしやすい
            val menuNames = listOf("ビール","焼酎","日本酒","レモンサワー","ハイボール","カクテル","ワイン","梅酒")
            // トランザクション開始
            db.beginTransaction()
            try {
                // ループしてContentValuesを作成する
                menuNames.forEach {menuName ->
                    val value = ContentValues().apply {
                        put("menu_name",menuName)
                    }
                    // insert処理を実行
                    db.insert("menu_items", null, value)
                }
                // トランザクション終了(コミット)
                db.setTransactionSuccessful()
            } finally {
                // ロールバック
                db.endTransaction()
            }
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}