package vn.fpoly.veganfood.activity.notification.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.model.notify.ListNotification;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.ViewHolder> {
    public List<ListNotification.Data.Notification> notifyList;
    private Context context;
    private IItemClick mListener;

    public NotifyAdapter(List<ListNotification.Data.Notification> notifyList, Context context) {
        this.notifyList = notifyList;
        this.context = context;
    }

    public void setClickItem(IItemClick mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notify, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.binData(notifyList.get(position));
    }

    public void addItems(List<ListNotification.Data.Notification> items) {
        notifyList.clear();
        notifyList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return notifyList.size();
    }

    public interface OnItemClickListener {
        void onCLickItem(ListNotification listNotifycation);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }




    public interface IItemClick {
        void detailNotifyCation(ListNotification.Data.Notification notify);

        void detailProduct(String productId);

        void gotoOrder(String orderId);
    }
}
