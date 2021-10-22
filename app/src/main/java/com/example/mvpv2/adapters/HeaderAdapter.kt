package uz.dastyor.arzonkassa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpv2.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import org.imaginativeworld.whynotimagecarousel.ImageCarousel


class HeaderAdapter:RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var carouselCount: Int = 0
    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val carousel: CarouselView = view.findViewById(R.id.carousel)

        fun bind(carouselCount: Int) {
            carousel.pageCount = carouselCount

            val imageListener = ImageListener { position, imageView ->
                imageView.setImageResource(R.drawable.trash_back);
            }
            carousel.setImageListener(imageListener)
            carousel.setImageClickListener { position ->

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.header_lauout, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(3)
    }

    override fun getItemCount(): Int {
        return 1
    }
    fun updateFlowerCount(updatedCarouselCount: Int) {
        carouselCount = updatedCarouselCount
        notifyDataSetChanged()
    }
}