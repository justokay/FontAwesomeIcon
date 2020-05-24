package app.justokay.fontawesome.model

import android.graphics.Typeface

sealed class AwesomeFont {
    data class Regular(val font: Typeface, val data: RegularEnum): AwesomeFont()
    data class Solid(val font: Typeface, val data: SolidEnum): AwesomeFont()
    data class Brand(val font: Typeface, val data: BrandEnum): AwesomeFont()
    object Unknown: AwesomeFont()
}