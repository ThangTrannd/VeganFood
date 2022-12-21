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
import vn.fpoly.veganfood.model.home.Category;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemViewHodel> {

    private List<Category> mListItemCa;
    private Context context;

    public CategoryAdapter(List<Category> mListItemCa, Context context) {
        this.mListItemCa = mListItemCa;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryAdapter.ItemViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryAdapter.ItemViewHodel(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ItemViewHodel holder, int position) {
        Category category = mListItemCa.get(position);
        if (category == null) {
            return;
        }

        Picasso.with(context).load(category.getImagecategory().get(0)).into(holder.iv_Veget);
        holder.tv_cate.setText("" + category.getCategoryname());

    }


    @Override
    public int getItemCount() {
        if (mListItemCa != null) {
            return mListItemCa.size();
        }
        return 0;
    }

    public class ItemViewHodel extends RecyclerView.ViewHolder {
        private ImageView iv_Veget;
        private TextView tv_cate;


        public ItemViewHodel(@NonNull View itemView,CategoryAdapter.OnItemClickListener mListener) {
            super(itemView);
            iv_Veget = itemView.findViewById(R.id.iv_Veget);
            tv_cate = itemView.findViewById(R.id.tv_cate);
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
        }
    }

    private CategoryAdapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(CategoryAdapter.OnItemClickListener listener){
        mListener = listener;
    }
}
