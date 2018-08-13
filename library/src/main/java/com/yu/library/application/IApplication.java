package com.yu.library.application;

import android.app.Activity;
import android.app.Application;

public interface IApplication {
    void init(Application application);

    Application getApplication();
}
