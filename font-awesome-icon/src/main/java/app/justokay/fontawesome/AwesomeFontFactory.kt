package app.justokay.fontawesome

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import app.justokay.fontawesome.model.AwesomeFont
import app.justokay.fontawesome.model.BrandEnum
import app.justokay.fontawesome.model.RegularEnum
import app.justokay.fontawesome.model.SolidEnum
import app.justokay.fontawesome.utils.getUnicode
import java.util.*

object AwesomeFontFactory {

    /**
     * @param context
     * @param name - name of awesome font char.
     *
     * @return awesome font char.
     */
    fun getUnicode(context: Context, name: String): Char {
        return getFont(context, name)
            .getUnicode()
    }

    /**
     * @param context
     * @param name - name of awesome font char.
     *
     * @return instance of awesome font.
     */
    fun getFont(context: Context, name: String): AwesomeFont {
        val enum = "AF_${name.replace("-", "_").toUpperCase(Locale.getDefault())}"

        return getRegularUnicode(
            context,
            enum
        ) ?: getSolidUnicode(
            context,
            enum
        )
        ?: getBrandUnicode(
            context,
            enum
        )
        ?: AwesomeFont.Unknown
    }

    /**
     * @param context
     * @param name
     *
     * @return instance of AwesomeFont.Regular or null if doesn't exist char with following name.
     */
    fun getRegularUnicode(context: Context, name: String): AwesomeFont.Regular? {
        return try {
            AwesomeFont.Regular(
                ResourcesCompat.getFont(context, R.font.awesome_5_free_regular_400)!!,
                RegularEnum.valueOf(name)
            )
        } catch (e: Exception) {
            null
        }
    }

    /**
     * @param context
     * @param name
     *
     * @return instance of [AwesomeFont.Solid] or null if doesn't exist char with following name.
     */
    fun getSolidUnicode(context: Context, name: String): AwesomeFont.Solid? {
        return try {
            AwesomeFont.Solid(
                ResourcesCompat.getFont(context, R.font.awesome_5_free_solid_900)!!,
                SolidEnum.valueOf(name)
            )
        } catch (e: Exception) {
            null
        }
    }

    /**
     * @param context
     * @param name
     *
     * @return instance of [AwesomeFont.Brand] or null if doesn't exist char with following name.
     */
    fun getBrandUnicode(context: Context, name: String): AwesomeFont.Brand? {
        return try {
            AwesomeFont.Brand(
                ResourcesCompat.getFont(context, R.font.awesome_5_brands_regular_400)!!,
                BrandEnum.valueOf(name)
            )
        } catch (e: Exception) {
            null
        }
    }
}