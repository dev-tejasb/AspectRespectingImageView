# AspectRespectingImageView
Android ImageView that respects aspect ratio

[![](https://jitpack.io/v/dev-tejasb/AspectRespectingImageView.svg)](https://jitpack.io/#dev-tejasb/AspectRespectingImageView)

## Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'com.github.dev-tejasb:AspectRespectingImageView:v0.1.0-alpha'
}
```

## Usage
```xml
 <com.tejasb.aspectrespectingimageview.AspectRespectingImageView
        android:id="@+id/aspectRespectingImageView"
        android:layout_width="80dp"
        android:layout_height="0dp"
        android:layout_margin="4dp"
        android:scaleType="fitXY"
        app:aspectRatio="1"
        app:aspectRatioEnabled="true"
        app:dominantMeasurement="width"
        app:srcCompat="@drawable/paper_plane" />
```
```java
AspectRespectingImageView aspectRespectingImageView = (AspectRespectingImageView) findViewById(R.id.aspectRespectingImageView);
aspectRespectingImageView.setImageResource(R.drawable.paper_plane);
aspectRespectingImageView.setAspectRatioEnabled(true); // Defaults to false
aspectRespectingImageView.setAspectRatio(1f);
aspectRespectingImageView.setDominantMeasurement(MEASUREMENT_WIDTH);
```
There is also a [sample](https://github.com/dev-tejasb/AspectRespectingImageView/tree/master/app) provided which shows how to use the library
That's it!

#### Spread Some :heart:

[![GitHub stars](https://img.shields.io/github/stars/dev-tejasb/AspectRespectingImageView.svg?style=social&label=Star)](https://github.com/dev-tejasb/AspectRespectingImageView) [![GitHub forks](https://img.shields.io/github/forks/dev-tejasb/AspectRespectingImageView.svg?style=social&label=Fork)](https://github.com/dev-tejasb/AspectRespectingImageView/fork) [![GitHub watchers](https://img.shields.io/github/watchers/dev-tejasb/AspectRespectingImageView.svg?style=social&label=Watch)](https://github.com/dev-tejasb/AspectRespectingImageView)[![GitHub followers](https://img.shields.io/github/followers/dev-tejasb.svg?style=social&label=Follow)](https://github.com/dev-tejasb)

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://opensource.org/licenses/Apache-2.0)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/dev-tejasb/AspectRespectingImageView/blob/master/LICENSE)


### :heart: Found this project useful?
If you found this project useful, then please consider giving it a :star: on Github and sharing it with your friends via social media.


## Project Maintained By

### Tejas Bhong

Android Developer.

<a href="https://play.google.com/store/apps/details?id=com.tejasb.arduinobluetooth"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Google_Play.svg/274px-Google_Play.svg.png" width="180"></a>
<a href="https://stackoverflow.com/users/14102903/dev-tejasb"><img src="https://upload.wikimedia.org/wikipedia/commons/e/ef/Stack_Overflow_icon.svg" width="60"></a>

## License

```
Copyright 2020 Tejas Bhong

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
