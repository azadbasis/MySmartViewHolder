package com.smartviewholder;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SuperChillAdapter extends RecyclerView.Adapter {
    private List<ExcellentAdventure> items;
    private LayoutInflater inflater;
    private SmartViewHolder.ExcellentAdventureListener adventureListener;

    public SuperChillAdapter(LayoutInflater inflater, SmartViewHolder.ExcellentAdventureListener adventureListener) {
        this.inflater = inflater;
        this.adventureListener = adventureListener;
        items = new ArrayList<>();
    }

    public void updateItems(final List<ExcellentAdventure> newItems) {
        final List<ExcellentAdventure> oldItems = new ArrayList<>(this.items);
        this.items.clear();
        if (newItems != null) {
            this.items.addAll(newItems);
        }
        DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return oldItems.size();
            }

            @Override
            public int getNewListSize() {
                return items.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return oldItems.get(oldItemPosition).equals(newItems.get(newItemPosition));
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return oldItems.get(oldItemPosition).equals(newItems.get(newItemPosition));
            }
        }).dispatchUpdatesTo(this);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_excellent_adventure, parent, false);
        return new SmartViewHolder(v,adventureListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SmartViewHolder vh = (SmartViewHolder) holder;
        vh.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
