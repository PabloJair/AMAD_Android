package com.s10plus.core_application.ui.horizontal_carrousel

import android.os.AsyncTask
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import com.s10plus.core_application.R
import com.s10plus.core_application.base_ui.BaseViewHolder
import com.s10plus.core_application.databinding.BasicHorizontalCarruselVhBinding
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class HorizontalCarruselViewHolder(viewGroup:ViewGroup):BaseViewHolder<BasicHorizontalCarruselVhBinding,BasicHorizontalCarruselModel>(
BasicHorizontalCarruselVhBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
) {
    var imageW =200
    var imageh =100

    override fun setup(item: BasicHorizontalCarruselModel) {

        setIsRecyclable(false)
        if(item.url_Image.isNotEmpty())
            Picasso.get().load(item.url_Image)
                .centerCrop()
                .fit()
                .placeholder(R.drawable.header)
                .into(binding.imageView)
        else{
            Picasso.get()
                .load(item.resourceId)
                .error(R.drawable.header)
                .placeholder(R.drawable.header)
                .fit()
                .into(binding.imageView)


            AsyncTask.execute {

                val observer = object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        // Thread.sleep(1000)


                        imageW = binding.imageView.width
                        imageh = binding.imageView.height

                        Picasso.get()
                            .load(item.resourceId)
                            .error(R.drawable.header)
                            .placeholder(R.drawable.header)
                            .resize(imageW,imageh)
                            .onlyScaleDown()
                            .into(binding.imageView)
                        binding.imageView.viewTreeObserver.removeOnGlobalLayoutListener(this)



                    }
                }
                binding.imageView.viewTreeObserver
                    .addOnGlobalLayoutListener(observer)
            }





        }

        binding.carrouselText.text = item.text





}


}