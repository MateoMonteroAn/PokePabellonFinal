package com.mateomontero.pokepabellon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mateomontero.pokepabellon.modelo.Producto;

import java.util.List;

public class ListAdapter  extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private Context context;
    private List<Producto> mData;
    private LayoutInflater mInflater;

    public ListAdapter.OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(Producto producto);
    }

    public ListAdapter(List<Producto> itemList, Context context, ListAdapter.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {

        public ViewHolder( View itemView) {
            super(itemView);
        }


    }
}
