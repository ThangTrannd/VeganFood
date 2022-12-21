package vn.fpoly.veganfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.fpoly.veganfood.R;
import vn.fpoly.veganfood.model.product.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemViewHodel>{

    private List<Product> mListItem;
    Context context;

    public ProductAdapter(List<Product> mListItem,Context context) {
        this.mListItem = mListItem;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_cart,parent, false);
        return new ItemViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHodel holder, int position) {
        Product product = mListItem.get(position);
        if(product == null) {
            return;
        }
        Picasso.with(context).load(product.getImageProduct().get(0)).into(holder.img);
        holder.name.setText("Name :"+product.getName());
        holder.gam.setText("Gam : 123");
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
