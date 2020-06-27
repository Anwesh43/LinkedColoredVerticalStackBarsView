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
val bars : Int = 5
val hFactor : Float = 2f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.sin(this * Math.PI).toFloat()
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawVerticalStackBar(i : Int, w : Float, h : Float, scale : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sfi : Float = sf.divideScale(i, bars)
    val totalH = h / hFactor
    val currH = totalH / bars
    val y : Float = h - currH * i
    val wSize : Float = w / wFactor
    save()
    translate(-wSize / 2 + (w / 2 + wSize / 2) * sfi, y - currH)
    drawRect(RectF(-wSize / 2, 0f, wSize / 2, currH), paint)
    restore()
}

fun Canvas.drawVSBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    save()
    for (j in 0..(bars - 1)) {
        drawVerticalStackBar(i, w, h, scale, paint)
    }
    restore()
}

class ColorVertivalStackBarView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}