package com.newolf.animdemo

import androidx.lifecycle.LifecycleOwner
import com.newolf.RotateImageView
import com.newolf.library.adapt.base.BaseQuickAdapter
import com.newolf.library.adapt.base.viewholder.BaseViewHolder


/**
 *
 *
 * @author NeWolf
 * @since 2021-06-22
 */

class NineAdapter(private val lifecycleOwner: LifecycleOwner, data: MutableList<String>?) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.adapter_nine, data) {

    var itemWidth = 0

    init {
        itemWidth = ScreenUtils.getScreenWidth() / 3
    }


    override fun convert(holder: BaseViewHolder, item: String) {
        val rotateImageView =
            holder.getView<RotateImageView>(R.id.riv_show).addLifecycleObserver(lifecycleOwner)
        val layoutParams = rotateImageView.layoutParams
        layoutParams.height = itemWidth
        layoutParams.width = itemWidth
        rotateImageView.layoutParams = layoutParams

        holder.itemView.setOnClickListener {
            if (rotateImageView.isAnimStart()) {
                rotateImageView.stop()
            } else {
                rotateImageView.updateDuration(rotateImageView.getCurrentDuration() - 10)
                rotateImageView.start()
            }

            if (holder.adapterPosition == 8) {
                Navigater.startDurationActivity(context)
            }
        }
    }

}