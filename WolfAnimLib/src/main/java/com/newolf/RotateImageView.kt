package com.ewolf.wolfanim

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent


/**
 * RotateTaiJi
 * 旋转的太极图
 *
 * @author NeWolf
 * @since 2021-06-21
 */
class RotateImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr), LifecycleObserver {
    private val rotateAnim: ObjectAnimator =
        ObjectAnimator.ofFloat(this, PROPERTY_NAME_ROTATE, 0f, 360f)

    companion object {
        const val TAG = "RotateImageView"
        const val PROPERTY_NAME_ROTATE = "rotation"
        var sDuration = 99L
        const val REPEAT_COUNT = -1
    }

    private var isLogEnable = false
    private var isAnimStart = false
    private val defaultImg = R.drawable.tj_y


    init {
        rotateAnim.duration = sDuration
        rotateAnim.repeatCount = REPEAT_COUNT
        setImageResource(defaultImg)
    }

    /**
     * addLifecycleObserver
     * 添加 LifecycleObserver
     */
    fun addLifecycleObserver(lifecycleOwner: LifecycleOwner?): RotateImageView {
        lifecycleOwner?.lifecycle?.addObserver(this)
        return this
    }

    /**
     * 开启log
     */
    fun enableLog(): RotateImageView {
        isLogEnable = true
        return this
    }

    fun start(): RotateImageView {
        rotateAnim.start()
        isAnimStart = true
        return this
    }

    fun stop(): RotateImageView {
        rotateAnim.cancel()
        isAnimStart = false
        return this
    }

    fun isAnimStart(): Boolean {
        return isAnimStart
    }

    /**
     * 关闭log
     */
    fun disableLog(): RotateImageView {
        isLogEnable = false
        return this
    }

    /**
     * 更新动画时长，可以调节旋转的快慢
     */
    fun updateDuration(duration: Int): RotateImageView {
        sDuration = duration
        stop()
        rotateAnim.duration = sDuration
        start()
        return this
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        log("onResume: rotateAnim.start ")
        rotateAnim.start()
        isAnimStart = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause() {
        log("onPause: rotateAnim.cancel ")
        rotateAnim.cancel()
        isAnimStart = false
    }

    private fun log(msg: String) {
        Log.d(TAG, msg)
    }
}