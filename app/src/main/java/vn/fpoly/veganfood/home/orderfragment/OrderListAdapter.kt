package vn.fpoly.veganfood.home.orderfragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vn.fpoly.veganfood.R
import vn.fpoly.veganfood.basekotlin.extensions.decimalFormatted
import vn.fpoly.veganfood.databinding.ItemOrderListBinding
import vn.fpoly.veganfood.model.UserOrderResult.UserOrderModel

class OrderListAdapter(
    private val onItemClick: (Int) -> Unit
) : ListAdapter<UserOrderModel, OrderListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<UserOrderModel>() {
        override fun areItemsTheSame(
            oldItem: UserOrderModel,
            newItem: UserOrderModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: UserOrderModel,
            newItem: UserOrderModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOrderListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.root.setOnClickListener {
            onItemClick(getItem(position).id)
        }
    }

    class ViewHolder(val binding: ItemOrderListBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: UserOrderModel) = binding.run {
            tvAddress.text = item.address
            tvMoney.text = item.total.toInt().decimalFormatted()
            tvStatus.text = item.status
            tvSoMon.text = "(${item.totalProduct} món) - ${item.provider}"
            tvDate.text = item.createat
            Glide
                .with(root.context)
                .load(item.displayImage)
                .centerCrop()
                .placeholder(R.drawable.img_tea)
                .dontAnimate()
                .into(appCompatImageView6)
        }
    }
}