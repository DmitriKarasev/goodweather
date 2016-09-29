package com.example.goodweather.Interface;

import android.content.Loader;
import android.os.Bundle;

public interface LoaderCallbacks<D> {
    public Loader<D> onCreateLoader(int id, Bundle args);
    public void onLoadFinished(Loader<D> loader, D data);
    public void onLoaderReset(Loader<D> loader);
}