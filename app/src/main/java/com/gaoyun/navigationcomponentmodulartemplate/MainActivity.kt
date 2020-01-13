package com.gaoyun.navigationcomponentmodulartemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.gaoyun.android.navigationadvancedsample.R
import gaoyun.com.core_utils.ComponentDependenciesProvider
import gaoyun.com.core_utils.HasComponentDependencies
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main), GlobalNavigator, HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    @Inject
    lateinit var globalNavigator: GlobalNavigator

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerMainComponent.builder()
                .globalNavigatorModule(GlobalNavigatorModule(this))
                .build()
                .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun openDestinationGlobally() {
        findNavController(R.id.global_nav).navigate(R.id.action_tabsFragment_to_global_destination)
    }

}