import org.jetbrains.kotlin.gradle.internal.kapt.incremental.UnknownSnapshot

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    //a mano
    //NECESARIO PARA QUE SE GENERE CÓDIGO CANDO TIRO FLECHITAS EN UN NAV
    id("androidx.navigation.safeargs.kotlin")

}

android {
    namespace = "diego.dev.ort.tp3.kotlin_challenges"
    compileSdk = 34

    defaultConfig {
        applicationId = "diego.dev.ort.tp3.kotlin_challenges"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //RETROFIT
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    //GLIDE para imagenes
    val glide_version = "4.16.0"
    implementation("com.github.bumptech.glide:glide:${glide_version}")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}