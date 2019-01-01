package com.amirahmed.myapplication;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.annotation.Nullable;

public class ImageFragment extends DialogFragment {

    ImageView image;
    Button close;

    TinyDB tinyDB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_image,container);

        tinyDB = new TinyDB(getActivity());

        close = rootView.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });

        image = rootView.findViewById(R.id.image);

        Glide.with(this).load(tinyDB.getString("image")).into(image);


        return rootView;


    }
}
