package vn.fpoly.veganfood.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.fpoly.veganfood.R;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ItemViewHodel>{
    private List<Item> mListItem;

    public itemAdapter(List<Item> mListItem) {
        this.mListItem = mListItem;
    }
    @NonNull
    @Override
    public ItemViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent, false);
        return new ItemViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHodel holder, int position) {
        Item item = mListItem.get(position);
        if(item == null) {
            return;
        }

        holder.img.setImageResource(item.getImage());
        holder.tv.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        if(mListItem != null) {
            return mListItem.size();
        }
        return 0;
    }

    public class ItemViewHodel extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;

        public ItemViewHodel(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.ivProduct);
            tv = itemView.findViewById(R.id.tvTitle);
        }
    }
}
