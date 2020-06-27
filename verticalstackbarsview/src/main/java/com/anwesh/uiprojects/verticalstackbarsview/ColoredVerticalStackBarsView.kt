package com.anwesh.uiprojects.verticalstackbarsview

/**
 * Created by anweshmishra on 27/06/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val colors : Array<String> = arrayOf("", "", "", "", "")
val scGap : Float = 0.02f
val wFactor : Float = 3f
val delay : Long = 20
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.sin(this * Math.PI).toFloat()
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()
