import com.bimabk.mynode.build_logic.convention.implementation
import com.bimabk.mynode.build_logic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("mynode.android.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                implementation(project(":common"))
                implementation(project(":component"))
                implementation(project(":navigation"))
            }
        }
    }
}
