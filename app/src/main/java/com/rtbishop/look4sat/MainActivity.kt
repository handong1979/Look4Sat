/*
 * Look4Sat. Amateur radio satellite tracker and pass predictor.
 * Copyright (C) 2019-2022 Arty Bishop (bishop.arty@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.rtbishop.look4sat

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rtbishop.look4sat.presentation.MainScreen
import com.rtbishop.look4sat.presentation.MainTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent { MainTheme { MainScreen() } }
    }

    override fun attachBaseContext(newBase: Context?) {
        val newConfig = Configuration(newBase?.resources?.configuration).apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                densityDpi = DisplayMetrics.DENSITY_DEVICE_STABLE
            }
            fontScale = 1.0f
        }
        applyOverrideConfiguration(newConfig)
        super.attachBaseContext(newBase)
    }
}
