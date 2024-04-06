package com.whatrushka.faetures.profile.api.profile.navigatoin

import androidx.navigation.NavController
import com.whatrushka.navigation.FeatureNavigation

interface ProfileNavigation : FeatureNavigation {

    fun navigate(navController: NavController)

}