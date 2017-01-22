package com.intive.mvponandroidstarter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Tips:
 * <p>
 * 1. Keep view as simple as possible. The best view is passive view.
 * <p>
 * 2. Create presenter and view interface to keep existing logic.
 * <p>
 * 3. Try to use Android classes only in the view layer.
 * <p>
 * 4. Create layer below presenter for the business logic.
 * <p>
 * 5. Create packages or modules to separate layers.
 */
public class MainActivity extends AppCompatActivity {

    private Button loadButton;
    private ProgressBar progress;
    private RecyclerView imagesRecyclerView;

    private ImagesAdapter imagesAdapter;
    private List<Image> images = new ArrayList<>();

    private ImagesService imagesService = new ImagesClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initImagesList();
    }

    private void initViews() {
        loadButton = (Button) findViewById(R.id.home_load_button);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImages();
            }
        });
        progress = (ProgressBar) findViewById(R.id.home_progress_bar);
    }

    private void initImagesList() {
        imagesRecyclerView = (RecyclerView) findViewById(R.id.home_images_container);
        imagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        imagesAdapter = new ImagesAdapter(images);
        imagesRecyclerView.setAdapter(imagesAdapter);
    }

    /**
     * Everything in this method is a BAD PRACTICE (!), memory leak, logic in view etc
     * This is the most important part to fix.
     */
    private void loadImages() {
        progress.setVisibility(View.VISIBLE);
        imagesService.getImages().enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                progress.setVisibility(View.INVISIBLE);
                showImagesList(response.body());
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {
                progress.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, R.string.home_load_images_error_message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showImagesList(final List<Image> loadedImaged) {
        images.clear();
        images.addAll(loadedImaged);
        imagesAdapter.notifyDataSetChanged();
    }
}
