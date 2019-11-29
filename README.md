Currency Converter App   [![CircleCI](https://circleci.com/gh/mufasa08/CurrencyConvertor-Clean-Architecture-Sample/tree/master.svg?style=svg)](https://circleci.com/gh/mufasa08/CurrencyConvertor-Clean-Architecture-Sample/tree/master)
=


## Setup Instructions
- For smooth development ensure latest Android Studio Version. 

## Contribution
All PR's must pass CircleCI before being merged into Master Branch. Please verify the following:
- Unit Tests pass
- ktlint passes with:
```gradlew ktlint```
- [detekt passes](https://github.com/arturbosch/detekt)


## Architecture

The architecure for this project is Clean Architecture with MVVM using Android Lifecycle ViewModel.



<img src="https://i.imgur.com/u63VEpH.png " width="70%" align="middle">

#### Some Key Points on the architecture
- Clean Architecture: Decoupled and using interfaces to allow testing, maintainence and hot swapping of presentation layer and data layer without changing domain layer.
- MVVM: Utilizing Jetpack Lifecycle we can have ViewModels that behave as an overseer of the views and shares a lifecycle with the application. One benefit of this is data isn't lost on screen rotation.
- Modular: The app is structured in a way that common functionality is in a library module which can be utilized across projects. Such as networking setup. For every new feature we create a new model and add it to the app. One of the nice benefits of this include faster build times but also supports instant apps and [dynamic features](https://developer.android.com/studio/projects/dynamic-delivery)
- Kotlin First: We all love Kotlin! Let's prioritize libraries that are made for Kotlin like [koin ](https://github.com/InsertKoinIO/koin) (Sorry Dagger). 




### Resources
- [Google Architecture Components Samples](https://github.com/android/architecture-components-samples)
- [Clean Architecture](https://antonioleiva.com/clean-architecture-android/)
- [Clean Architecture + MVVM Tutorial](https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started#toc-anchor-017)
- [Modularization Discussion](https://www.youtube.com/watch?v=PZBg5DIzNww)


## Libraries and Frameworks

### Testing
- [Mockito Kotlin](https://github.com/nhaarman/mockito-kotlin)
- [JUnit](https://github.com/junit-team/junit4)

### Networking
- [Retrofit](https://square.github.io/retrofit/) 
- [OkHttp](https://square.github.io/okhttp/)
- [Moshi](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) [Moshi Retrofit Convertor only]

### Code Structure
- [RxJava](https://github.com/ReactiveX/RxJava) [Reactive programming]
- [koin ](https://github.com/InsertKoinIO/koin) [Kotlin Dependency Injection framework]
- [RxPaper](https://github.com/pakoito/RxPaper) [Rx Wrapper for Paper a NoSQL DB. Used for caching.]

### Code Style and Tools
- [ktlint (Kotlin Style Guide Static Code Analysis Tool)](https://github.com/shyiko/ktlint) [Kotlin Style Guide]
- [CircleCI](https://circleci.com/gh/sanogueralorenzo/Android-Kotlin-Clean-Architecture)
- [detekt (Kotlin Static Code Analysis Tool)](https://github.com/arturbosch/detekt)
- [Leak Canary](https://github.com/square/leakcanary) [Memory leak detection library for Android]

### UI
- [Glide](https://github.com/bumptech/glide)
- [Custom FAB Button](https://github.com/robertlevonyan/customFloatingActionButton)

### General
- [Jetpack- Lifecycle components](https://developer.android.com/jetpack/docs/getting-started/)

### Discussions
 [Koin vs Dagger2](https://medium.com/@egek92/koin-di-comparison-of-android-dependency-injection-frameworks-236a6909bc3e)
 

