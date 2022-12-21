package vn.fpoly.veganfood.activity.home.adapter;

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

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ItemViewHodel>{

    private List<Product> mListItem;
    private Context context;

    public ListProductAdapter(List<Product> mListItem, Context context) {
        this.mListItem = mListItem;
        this.context = context;
    }
    @NonNull
    @Override
    public ListProductAdapter.ItemViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent, false);
        return new ListProductAdapter.ItemViewHodel(view,mListener,mClickAdd);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductAdapter.ItemViewHodel holder, int position) {
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
        private ImageView btn_add;

        public ItemViewHodel(@NonNull View itemView,ListProductAdapter.OnItemClickListener mListener,ListProductAdapter.OnItemClickAddListener clickAddListener) {
            super(itemView);
            img = itemView.findViewById(R.id.ivProduct);
            name = itemView.findViewById(R.id.tvTitle);
            gam = itemView.findViewById(R.id.tvGR);
            price = itemView.findViewById(R.id.tvPrice);
            btn_add = itemView.findViewById(R.id.ivButton_add);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickAddListener != null){
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION){
                            clickAddListener.onItemClickAdd(position);
                        }
                    }
                }
            });
        }
    }


    private ListProductAdapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(ListProductAdapter.OnItemClickListener listener){
        mListener = listener;
    }


    private ListProductAdapter.OnItemClickAddListener mClickAdd;
    public interface OnItemClickAddListener{
        void onItemClickAdd(int position);
    }
    public void setOnItemClickAddListener(ListProductAdapter.OnItemClickAddListener listener){
        mClickAdd = listener;
    }
}
