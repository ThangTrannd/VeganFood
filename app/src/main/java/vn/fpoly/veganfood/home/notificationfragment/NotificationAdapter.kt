package vn.fpoly.veganfood.home.notificationfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vn.fpoly.veganfood.databinding.ItemNotificationBinding
import vn.fpoly.veganfood.model.NotifiResult.NotifiModel

class NotificationAdapter(
    private val onItemClick: (NotifiModel) -> Unit
) : ListAdapter<NotifiModel, NotificationAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<NotifiModel>() {
        override fun areItemsTheSame(
            oldItem: NotifiModel,
            newItem: NotifiModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: NotifiModel,
            newItem: NotifiModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.root.setOnClickListener {
            onItemClick(getItem(position))
        }
    }

    class ViewHolder(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NotifiModel) = binding.run {
            tvNotification.text = item.title
            Glide
                .with(root.context)
                .load(item.image)
                .centerCrop()
                .dontAnimate()
                .into(imgNotification)
        }
    }
}