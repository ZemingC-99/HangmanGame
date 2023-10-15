/**
 * References:
 * 1.https://developer.android.com/reference/android/widget/GridLayout
 * 2.https://developer.android.com/reference/android/widget/FrameLayout
 */
package com.cs501.hangmangame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_phone)
    }
}