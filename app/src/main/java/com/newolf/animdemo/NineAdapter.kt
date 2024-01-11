package com.ewolf.wolfanimdemo

import androidx.lifecycle.LifecycleOwner
import com.ewolf.wolfanim.RotateImageView
import com.newolf.library.adapt.base.BaseQuickAdapter
import com.newolf.library.adapt.base.viewholder.BaseViewHolder


/**
 *
 *
 * @author NeWolf
 * @since 2021-06-22
 */

class NineAdapter(val lifecycleOwner: LifecycleOwner, data: MutableList<String>?) : BaseQuickAdapter<String,BaseViewHolder>(R.layout.adapter_nine,data) {


    override fun convert(holder: BaseViewHolder, item: String) {
        val rotateImageView =
            holder.getView<RotateImageView>(R.id.riv_show).addLifecycleObserver(lifecycleOwner)
        holder.itemView.setOnClickListener {
            if (rotateImageView.isAnimStart()){
                rotateImageView.stop()
            }else{
                rotateImageView.start()
            }
        }
    }

}