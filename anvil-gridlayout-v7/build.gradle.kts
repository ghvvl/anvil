plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
	id("dev.inkremental.module")
}

android {
	defaultConfig {
		missingDimensionStrategy("api", "sdk17")
	}
}

val gridVersion = "1.0.0"

inkremental {
	androidLibrary("gridlayout-v7", gridVersion) {
		camelCaseName = "GridLayoutv7"
        srcPackage = "androidx.gridlayout"
        modulePackage = "dev.inkremental.dsl.androidx.gridlayout"
	}
}

dependencies {
	val junit_version: String by project.extra
	val mockito_version: String by project.extra

	implementation(project(":anvil"))
	inkremental(project(":anvil", "inkrementalDefSdk17"))

	inkrementalGen("androidx.gridlayout:gridlayout:$gridVersion")

	testImplementation("junit:junit:$junit_version")
	testImplementation("org.mockito:mockito-core:$mockito_version")
}