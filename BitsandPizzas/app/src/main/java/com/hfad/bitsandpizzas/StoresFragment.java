package com.hfad.bitsandpizzas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoresFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView storesRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_stores, container, false);

        String[] storesNames = new String[Stores.stores.length];

        for (int i = 0; i < storesNames.length; i++) {
            storesNames[i] = Stores.stores[i].getName();
        }

        int[] storesImages = new int[Stores.stores.length];

        for (int i = 0; i < storesImages.length; i++) {
            storesImages[i] = Stores.stores[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(storesNames, storesImages);
        storesRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        storesRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), StoresDetailActivity.class);
                intent.putExtra(StoresDetailActivity.EXTRA_STORES_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return storesRecycler;
    }
}
