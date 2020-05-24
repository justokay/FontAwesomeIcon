

## **FontAwesomeIcon**
The main purpuse of the library is to provide easy way to show free awesome font glyph as icon for image view. [https://fontawesome.com/cheatsheet/free](https://fontawesome.com/cheatsheet/free)

[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

## **Usage**
Add it in your root `build.gradl`e at the end of repositories:

    allprojects {
	    repositories {
    		...
    		maven { url 'https://jitpack.io' }
    	}
    }


Add the dependency to your module `build.gradle`.


    dependencies {
	    ...
	    implementation 'com.github.justokay.FontAwesomeIcon:font-awesome-icon:1.0.1'
	    // optiaonal if you want to use via Glide
	    implementation 'com.github.justokay.FontAwesomeIcon:font-awesome-glide:1.0.1'
    }

**sample**

    val mode: AwesomeFont = AwesomeFontFactory.getFont(context, "android")
    imageView.setImageDrawable(FontAwesomeDrawable(model))

![example](https://github.com/justokay/FontAwesomeIcon/blob/master/screenshot/Screenshot_1590327974.png?raw=true)

**Optional:**
if you want to set image via [Glide](https://github.com/bumptech/glide) you you have to register `ModelLoaderFactory` in your `AppGlideModule`

    @GlideModule
    class GlideModule : AppGlideModule() {

	    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
            super.registerComponents(context, glide, registry)
            // register ModelLoaderFactory for awesome font
		    registry.prepend(AwesomeFont::class.java, Drawable::class.java, AwesomeFontModelLoaderFactory())
	    }
    }

after that Glide will start to work with `AwesomeFont` calss

    GlideApp.with(this)
        .load(AwesomeFontFactory.getFont(context, "google"))
        .into(imageView)


## **Developed By**

Yurii Misiats (Justokay) - <yuri.misyac@gmail.com>

License
-------

    Copyright 2020 Justokay

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.