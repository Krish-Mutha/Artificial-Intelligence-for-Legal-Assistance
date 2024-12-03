// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
//    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply true
    id("com.google.dagger.hilt.android") version "2.49" apply false
    kotlin("kapt") version "1.9.10" apply false
}
