package app.justokay.fontawesome.sample

import android.content.Context
import android.graphics.drawable.Drawable
import app.justokay.fontawesome.glide.AwesomeFontModelLoaderFactory
import app.justokay.fontawesome.model.AwesomeFont
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class GlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        registry.prepend(AwesomeFont::class.java, Drawable::class.java, AwesomeFontModelLoaderFactory())
    }

}