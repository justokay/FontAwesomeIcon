package app.justokay.fontawesome.glide

import android.graphics.drawable.Drawable
import app.justokay.fontawesome.graphics.FontAwesomeDrawable
import app.justokay.fontawesome.model.AwesomeFont
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.data.DataFetcher
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.signature.ObjectKey
import java.util.*

class AwesomeFontModelLoaderFactory: ModelLoaderFactory<AwesomeFont, Drawable> {

    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<AwesomeFont, Drawable> {
        return object : ModelLoader<AwesomeFont, Drawable> {
            override fun buildLoadData(model: AwesomeFont, width: Int, height: Int, options: Options): ModelLoader.LoadData<Drawable>? {
                return ModelLoader.LoadData(ObjectKey("awesomefont:${model.getName()}"), object :
                    DataFetcher<Drawable> {
                    override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in Drawable>) {
                        try {
                            callback.onDataReady(FontAwesomeDrawable(model))
                        } catch (e: Exception) {
                            callback.onLoadFailed(e)
                        }
                    }

                    override fun getDataClass(): Class<Drawable> = Drawable::class.java

                    override fun cleanup() {
                    }

                    override fun getDataSource(): DataSource = DataSource.LOCAL

                    override fun cancel() {
                    }

                })
            }

            override fun handles(model: AwesomeFont): Boolean {
                return true
            }
        }
    }

    override fun teardown() {

    }
}

private fun AwesomeFont.getName() = when (this) {
    is AwesomeFont.Brand -> this.data.name.toLowerCase(Locale.getDefault())
    is AwesomeFont.Regular -> this.data.name.toLowerCase(Locale.getDefault())
    is AwesomeFont.Solid -> this.data.name.toLowerCase(Locale.getDefault())
    else -> "Unknown"
}