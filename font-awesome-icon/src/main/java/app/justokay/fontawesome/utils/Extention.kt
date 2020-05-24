package app.justokay.fontawesome.utils

import android.content.Context
import android.graphics.Typeface
import app.justokay.fontawesome.AwesomeFontFactory
import app.justokay.fontawesome.model.AwesomeFont

fun AwesomeFont.getTypeface(): Typeface? {
    return when(this) {
        is AwesomeFont.Regular -> {
            this.font
        }
        is AwesomeFont.Brand -> {
            this.font
        }
        is AwesomeFont.Solid -> {
            this.font
        }
        else -> {
            null
        }
    }
}

fun AwesomeFont.getUnicode(): Char {
    return when (this) {
        is AwesomeFont.Regular -> {
            this.data.unicod
        }
        is AwesomeFont.Brand -> {
            this.data.unicod
        }
        is AwesomeFont.Solid -> {
            this.data.unicod
        }
        else -> {
            '?'
        }
    }
}

fun String.toAwesomeFont(context: Context) = AwesomeFontFactory.getFont(context, this)