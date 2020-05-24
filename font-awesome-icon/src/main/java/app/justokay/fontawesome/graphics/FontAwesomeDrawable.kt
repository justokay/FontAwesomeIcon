package app.justokay.fontawesome.graphics

import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import app.justokay.fontawesome.model.AwesomeFont
import app.justokay.fontawesome.utils.getTypeface
import app.justokay.fontawesome.utils.getUnicode
import kotlin.math.max

class FontAwesomeDrawable(
    font: AwesomeFont
) : Drawable() {

    private val paint: TextPaint = TextPaint()
    private val char: String = font.getUnicode().toString()
    private var textBounds = Rect()

    init {
        paint.typeface = font.getTypeface()
        paint.style = Paint.Style.FILL
        paint.textAlign = Paint.Align.CENTER
        paint.isUnderlineText = false
        paint.color = Color.BLACK
        paint.isAntiAlias = true
    }

    override fun draw(canvas: Canvas) {
        val bounds = bounds
        val height = bounds.height()
        val width = bounds.width()

        paint.textSize = (height * 1).toFloat()
        paint.getTextBounds(char, 0, 1, textBounds)

        // fix text size if character out of bound.
        if (textBounds.height() > height || textBounds.width() > width) {
            val diff = max(textBounds.height() - height, textBounds.width() - width)

            paint.textSize = (height - diff).toFloat()
            paint.getTextBounds(char, 0, 1, textBounds)
        }

        val textHeight = textBounds.height()
        val textBottom =
            bounds.top + (height - textHeight) / 2f + textHeight - textBounds.bottom
        canvas.drawText(char, bounds.exactCenterX(), textBottom, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

}