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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemViewHodel>{
    private List<Product> mListItem;

    public ProductAdapter(List<Product> mListItem) {
        this.mListItem = mListItem;
    }
    @NonNull
    @Override
    public ItemViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product,parent, false);
        return new ItemViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHodel holder, int position) {
        Product product = mListItem.get(position);
        if(product == null) {
            return;
        }

        holder.img.setImageResource(product.getImage());
        holder.name.setText("Name :"+product.getName());
        holder.gam.setText("Gam :"+product.getGam());
        holder.price.setText("Price :"+product.getPrice());
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
        private TextView name;
        private TextView gam;
        private TextView price;

        public ItemViewHodel(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            gam = itemView.findViewById(R.id.gam);
            price = itemView.findViewById(R.id.price);
        }
    }
}
