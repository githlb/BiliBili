package com.bilibili.lingxiao.home.recommend.ui

import android.graphics.Color
import android.net.Uri

import com.bilibili.lingxiao.R
import com.bilibili.lingxiao.home.recommend.model.RecommendData
import com.bilibili.lingxiao.utils.StringUtil
import com.bilibili.lingxiao.utils.UIUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.facebook.drawee.view.SimpleDraweeView
import java.lang.Exception

class RecommendRecyAdapter(layoutResId: Int, data: List<RecommendData>?) :
    BaseQuickAdapter<RecommendData, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: RecommendData) {
        helper.setText(R.id.play_title,item.title)
        helper.setText(R.id.play_number,StringUtil.getBigDecimalNumber(item.play))
        helper.setText(R.id.comment_number,StringUtil.getBigDecimalNumber(item.reply))
        var category_name = item.tname
        if (category_name == null){
            category_name = "广告"
            helper.setBackgroundColor(R.id.category_name,
                mContext.resources.getColor(R.color.yellow_300))
                .setTextColor(R.id.category_name,Color.WHITE)
        }
        helper.setText(R.id.category_name,"" + category_name)

        helper.addOnClickListener(R.id.image_more)
        var image : SimpleDraweeView = helper.getView(R.id.play_image)
        try {
            image.setImageURI(Uri.parse(item.cover))
        }catch (ex:Exception){
            ex.printStackTrace()
        }

    }
}
