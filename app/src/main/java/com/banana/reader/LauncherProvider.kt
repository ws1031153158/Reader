package com.banana.reader

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import android.os.Process
import android.util.Log

class LauncherProvider: ContentProvider() {
    companion object {
        private const val TAG = "LauncherProvider"
    }

    private val mHelper : DatabaseHelper by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        DatabaseHelper(context, null, null, 1, null)
    }

    override fun onCreate(): Boolean {
        mHelper.createItemsTable()

        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, contentValues: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(uri: Uri, contentValues: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    inner class DatabaseHelper(
        context: Context?,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int,
        errorHandler: DatabaseErrorHandler?
    ) : SQLiteOpenHelper(context, name, factory, version, errorHandler) {

        private val mDb: SQLiteDatabase = writableDatabase

        fun createItemsTable() {
            val db = mDb
            safelyExecSQL(db, "DROP TABLE IF EXISTS " + Constants.TABLE_ITEMS)

            safelyExecSQL(db, "CREATE TABLE items (" +
                    Constants.ID + " INTEGER PRIMARY KEY," +
                    Constants.TITLE + " TEXT," +
                    Constants.ORDER + " INTEGER NOT NULL DEFAULT -1," +
                    ");"
            )
        }

        private fun safelyExecSQL(db: SQLiteDatabase?, sql: String?) {
            if (db == null) {
                return
            }
            try {
                db.execSQL(sql)
            } catch (e: SQLiteException) {
                Log.d(TAG, "exec sql fail", e)
            } catch (e: IllegalStateException) {
                Log.d(TAG, "exec sql fail", e)
                Process.killProcess(Process.myPid())
            }
        }

        override fun onCreate(db: SQLiteDatabase?) {

        }

        override fun onUpgrade(db: SQLiteDatabase?, lastVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
    }
}