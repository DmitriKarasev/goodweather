package com.example.goodweather.Class;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.SystemClock;

public class StubLoader extends AsyncTaskLoader<Integer> {

    public StubLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Integer loadInBackground() {
        SystemClock.sleep(2000);
        return 5;
    }
}


