package vn.fpoly.veganfood.activity.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.fpoly.veganfood.R;

public class EndowAdapter extends RecyclerView.Adapter<EndowAdapter.ItemViewHodel>{
    private List<Endow> mListItemEn;

    public EndowAdapter(List<Endow> mListItemEn) {
        this.mListItemEn = mListItemEn;
    }

    @NonNull
    @Override
    public EndowAdapter.ItemViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_endow,parent, false);
        return new EndowAdapter.ItemViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EndowAdapter.ItemViewHodel holder, int position) {
        Endow endow= mListItemEn.get(position);
        if(endow == null) {
            return;
        }

        holder.iv_endow.setImageResource(endow.getImageEndow());


    }


    @Override
    public int getItemCount() {
        if(mListItemEn != null) {
            return mListItemEn.size();
        }
        return 0;
    }

    public class ItemViewHodel extends RecyclerView.ViewHolder {
        private ImageView iv_endow;

        public ItemViewHodel(@NonNull View itemView) {
            super(itemView);
            iv_endow= itemView.findViewById(R.id.iv_endow);


        }


    }


}
