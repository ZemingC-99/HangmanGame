/**
 * References:
 * 1.https://developer.android.com/reference/android/widget/GridLayout
 * 2.https://developer.android.com/reference/android/widget/FrameLayout
 * 3.https://developer.android.com/topic/libraries/view-binding
 * 4.https://stackoverflow.com/questions/68124726/what-is-the-difference-between-binding-and-binding
 * 5.https://developer.android.com/reference/android/text/Selection
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