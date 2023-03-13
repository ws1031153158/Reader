package com.banana.reader

class Constants {
    companion object {
        const val SYSTEM_SCREEN_ON = "android.intent.action.SCREEN_ON"

        const val TABLE_ITEMS = "items"
        const val ID = "id"
        const val TITLE = "title"
        const val ORDER = "order"

        private const val AUTHORITY = "com.banana.reader"

        const val CONTENT_URI_STRING = "content://$AUTHORITY/$TABLE_ITEMS"
    }

}