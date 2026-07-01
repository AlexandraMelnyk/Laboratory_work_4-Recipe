plugins {

    id("com.android.application")

    id("org.jetbrains.kotlin.android")

    id("org.jetbrains.kotlin.plugin.compose")

    id("com.google.devtools.ksp")

}

android {

    namespace = "com.example.laboratorywork3"

    compileSdk = 36

    defaultConfig {

        applicationId = "com.example.laboratorywork3"

        minSdk = 24

        targetSdk = 36

        versionCode = 1

        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {

        release {

            isMinifyEnabled = false

        }

    }

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_11

        targetCompatibility = JavaVersion.VERSION_11

    }

    kotlinOptions {

        jvmTarget = "11"

    }

    buildFeatures {

        compose = true

    }

}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2025.02.00"))

    implementation("androidx.core:core-ktx:1.16.0")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")

    implementation("androidx.activity:activity-compose:1.10.1")

    implementation("androidx.compose.ui:ui")

    implementation("androidx.compose.ui:ui-graphics")

    implementation("androidx.compose.ui:ui-tooling-preview")

    implementation("androidx.compose.material3:material3")

    implementation("androidx.compose.material:material-icons-extended")

    implementation("androidx.navigation:navigation-compose:2.8.9")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    implementation("androidx.room:room-runtime:2.6.1")

    implementation("androidx.room:room-ktx:2.6.1")

    ksp("androidx.room:room-compiler:2.6.1")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation(platform("androidx.compose:compose-bom:2025.02.00"))

    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    androidTestImplementation("androidx.test.ext:junit:1.2.1")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    debugImplementation("androidx.compose.ui:ui-tooling")

    debugImplementation("androidx.compose.ui:ui-test-manifest")

}