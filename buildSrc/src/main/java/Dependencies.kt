object ApplicationId {
    val id = "com.mdualeh.flickrApp"
}

object Modules {
    val app = ":app"
    val navigation = ":navigation"
    val cache = ":common:cache"
    val network = ":common:network"
    val presentation = ":common:presentation"
    val imageGallery = ":imageGallery"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val gradle = "3.5.1"
    val compileSdk = 28
    val minSdk = 21
    val targetSdk = 28
    val appcompat = "1.0.2"
    val design = "1.2.0-alpha01"
    val cardview = "1.0.0"
    val recyclerview = "1.0.0"
    val kotlin = "1.3.50"
    val rxjava = "2.2.10"
    val rxkotlin = "2.3.0"
    val retrofit = "2.6.0"
    val loggingInterceptor = "4.0.0"
    val glide = "4.9.0"
    val rxpaper = "1.4.0"
    val lifecycle = "2.0.0"
    val leakCanary = "2.0-alpha-2"
    val koin = "2.0.0-beta-1"
    val playCore = "1.6.1"
    val junit = "4.12"
    val assertjCore = "3.12.2"
    val mockitoKotlin = "2.1.0"
    val mockitoInline = "3.0.0"
    val swipeRefresh = "1.0.0"
    val searchableSpinner = "1.3.1"
}

object Libraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val rxpaper = "com.github.pakoito:RxPaper2:${Versions.rxpaper}"

    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    val leakCanaryAndroid = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"


    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    val searchableSpinner = "com.toptoche.searchablespinner:searchablespinnerlibrary:${Versions.searchableSpinner}"

}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val design = "com.google.android.material:material:${Versions.design}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val viewPager2 = "androidx.viewpager2:viewpager2:"
    val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
}

object GoogleLibraries {
    val playCore = "com.google.android.play:core:${Versions.playCore}"
}


object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
}
