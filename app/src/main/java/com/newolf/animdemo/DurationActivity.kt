package com.newolf.animdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatSeekBar
import com.newolf.RotateImageView

class DurationActivity : AppCompatActivity() {

    companion object {
        const val TAG = "DurationActivity"
        var currentDuration = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duration)

        initView()
    }

    private fun initView() {
        val rivShow = findViewById<RotateImageView>(R.id.riv_show)
        rivShow.updateDuration(currentDuration)
        rivShow.updateRotate(1F)
        rivShow.addLifecycleObserver(this)
        val seekBar = findViewById<AppCompatSeekBar>(R.id.seek_bar)
        val seekBarRotate = findViewById<AppCompatSeekBar>(R.id.seek_bar_rotate)
        val tvShow = findViewById<TextView>(R.id.tv_show)
        updateShowInfo(tvShow, currentDuration)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val duration = currentDuration - progress
                rivShow.updateDuration(duration)
                rivShow.updateRotate(1F)
                updateShowInfo(tvShow, progress.toLong())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekBarRotate.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                rivShow.updateDuration(currentDuration)
                rivShow.updateRotate(progress.toFloat())
                tvShow?.text = "1s ${progress}转"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

    }

    @SuppressLint("SetTextI18n")
    private fun updateShowInfo(tvShow: TextView?, duration: Long) {
        tvShow?.text = "duration:$duration\n1s ${1000.00 / duration}转"
    }
}