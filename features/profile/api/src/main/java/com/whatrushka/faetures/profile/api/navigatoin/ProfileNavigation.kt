package com.whatrushka.faetures.profile.api.navigatoin

import androidx.navigation.NavController
import com.whatrushka.navigation.FeatureNavigation

interface ProfileNavigation : FeatureNavigation {

    fun navigate(navController: NavController)

}