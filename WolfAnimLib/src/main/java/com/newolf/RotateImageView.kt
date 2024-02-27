package com.newolf

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.animation.LinearInterpolator
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
@SuppressLint("AppCompatCustomView")
class RotateImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr), LifecycleObserver {
    private var rotateAnim: ObjectAnimator =
        ObjectAnimator.ofFloat(this, PROPERTY_NAME_ROTATE, 0f, 360f * sRotate)

    companion object {
        const val TAG = "RotateImageView"
        const val PROPERTY_NAME_ROTATE = "rotation"
        var sDuration: Long = 1000L
        var sRotate: Float = 81F
        const val REPEAT_COUNT = Int.MAX_VALUE - 1
    }

    private var isLogEnable = false
    private var isAnimStart = false
    private val defaultImg = R.drawable.tj_y


    init {
        if (attrs != null) {
            val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.RotateImageView)
            sDuration = a.getFloat(R.styleable.RotateImageView_rotate_duration, sDuration.toFloat())
                .toLong()
            sRotate = a.getFloat(R.styleable.RotateImageView_rotate_count, sRotate)
            a.recycle()
        }
        rotateAnim.duration = sDuration
        rotateAnim.repeatCount = REPEAT_COUNT
        setImageResource(defaultImg)
        rotateAnim.interpolator = LinearInterpolator()
//        rotateAnim.interpolator = null
//        rotateAnim.interpolator = BounceInterpolator()
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
    fun updateDuration(duration: Long): RotateImageView {
        if (duration <= 0) {
            log("updateDuration: duration mast be > 0")
            return this
        }
        sDuration = duration
//        stop()
        rotateAnim.duration = sDuration
//        start()
        return this
    }

    fun updateRotate(count: Float): RotateImageView {
        if (count < 1) {
            return this
        }
        sRotate = count
        clearAnimation()
        rotateAnim = ObjectAnimator.ofFloat(this, PROPERTY_NAME_ROTATE, 0f, 360f * sRotate)
        rotateAnim.interpolator = LinearInterpolator()
//        rotateAnim.interpolator = null
//        rotateAnim.interpolator = BounceInterpolator()
        rotateAnim.duration = sDuration
        rotateAnim.repeatCount = REPEAT_COUNT
//        setImageResource(defaultImg)
        start()
        return this
    }

    fun getCurrentRotate(): Float {
        return sRotate
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

    fun getCurrentDuration(): Long {
        return sDuration
    }
}