package com.intive.mvponandroidstarter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private final List<Image> images;

    public ImagesAdapter(final List<Image> images) {
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_image_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.thumbnail.getContext();
        Image image = images.get(position);
        holder.title.setText(image.getTitle());
        int imageSize = context.getResources().getDimensionPixelSize(R.dimen.home_image_item_thumbnail_size);
        Picasso.with(context)
                .load(image.getImageUrl())
                .resize(imageSize, imageSize)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnail;

        ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.home_image_item_title);
            thumbnail = (ImageView) itemView.findViewById(R.id.home_image_item_thumbnail);
        }
    }
}
