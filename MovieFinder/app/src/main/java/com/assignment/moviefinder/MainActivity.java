package com.assignment.moviefinder;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.moviefinder.Uitilities.CommonUtils;
import com.assignment.moviefinder.db.bean.MovieBean;
import com.assignment.moviefinder.db.utils.AADataManager;
import com.assignment.moviefinder.net.apis.APIMovieData;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author jayesh
 * @Since 29/7/16.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.image_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final EditText editText = (EditText) findViewById(R.id.mySearchView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!CommonUtils.hasActiveInternetConnection(MainActivity.this)) {
                    Snackbar.make(view, R.string.error_network, Snackbar.LENGTH_LONG)
                            .show();
                    return;
                }
                if (editText.getText().toString().length() > 0) {
                    getMovieData(editText.getText().toString());
                } else {
                    Snackbar.make(view, R.string.enter_movie_name, Snackbar.LENGTH_LONG)
                            .show();
                }

            }
        });
    }


    /**
     * call API to get the given movie information
     *
     * @param movieName
     */
    private void getMovieData(String movieName) {

        final ProgressDialog progressDialog = new ProgressDialog(this, R.style.DialogTheme);
        progressDialog.show();

        if (movieName != null) {
            APIMovieData apiMovieData = new APIMovieData() {
                @Override
                protected void onGetMovieFinderAPISuccess(MovieBean movieBean) {

                    progressDialog.dismiss();
                    AADataManager.add(movieBean);

                    imageView.setVisibility(View.GONE);

                    MovieAdapter mAdapter = new MovieAdapter(AADataManager.getAll(MovieBean.class));
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(mAdapter);
                }

                @Override
                protected void onGetMovieFinderAPIFailure(Throwable t) {
                    progressDialog.dismiss();
                    Log.d("TAG", t.getMessage());
                }

                @Override
                protected void onGetMovieFinderAPIError() {
                    progressDialog.dismiss();
                    Snackbar.make(recyclerView, R.string.enter_correct_movie_name, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            };
            apiMovieData.getMovieInfo(movieName);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        AADataManager.deleteAll(MovieBean.class);
    }

    /**
     * Adapter class for recycler view
     */
    class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

        private List<MovieBean> movieBeanList;

        public MovieAdapter(List<MovieBean> movieBeanList) {
            this.movieBeanList = movieBeanList;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_cardview_items, parent, false);
            return new MovieViewHolder(view);
        }

        class MovieViewHolder extends RecyclerView.ViewHolder {

            TextView TVTitle, TVRating, TVReleaseData, TVPlot, TVGenre;
            ImageView IVMoviePoster;

            public MovieViewHolder(View itemView) {
                super(itemView);

                TVTitle = (TextView) itemView.findViewById(R.id.TV_title);
                TVGenre = (TextView) itemView.findViewById(R.id.TV_genre);
                TVReleaseData = (TextView) itemView.findViewById(R.id.TV_release_date);
                TVRating = (TextView) itemView.findViewById(R.id.TV_rating);
                TVPlot = (TextView) itemView.findViewById(R.id.TV_plot);
                IVMoviePoster = (ImageView) itemView.findViewById(R.id.IV_movie_poster);
            }
        }

        @Override
        public void onBindViewHolder(final MovieViewHolder holder, final int position) {

            holder.TVTitle.setText(movieBeanList.get(position).getTitle());
            holder.TVGenre.setText(movieBeanList.get(position).getGenre());
            holder.TVReleaseData.setText(movieBeanList.get(position).getReleased());
            holder.TVRating.setText(movieBeanList.get(position).getImdbRating());
            holder.TVPlot.setText(movieBeanList.get(position).getPlot());

            Glide.with(MainActivity.this)
                    .load(movieBeanList.get(position).getPoster().toString())
                    .placeholder(R.drawable.default_movie)
                    .into(holder.IVMoviePoster);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setTitle(movieBeanList.get(position).getTitle());

                    // set dialog message
                    alertDialogBuilder
                            .setMessage(movieBeanList.get(position).getPlot())
                            .setCancelable(false)
                            .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return movieBeanList.size();
        }
    }
}
