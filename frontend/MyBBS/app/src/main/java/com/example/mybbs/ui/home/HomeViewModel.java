package com.example.mybbs.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mTextHome;
    private final MutableLiveData<String> mTextName;

    public HomeViewModel() {
        mTextHome = new MutableLiveData<>();
        mTextHome.setValue("This is my signature");
        mTextName = new MutableLiveData<>();
        mTextName.setValue("my name");
    }

    public LiveData<String> getTextHome() {
        return mTextHome;
    }
    public LiveData<String> getTextName() {
        return mTextName;
    }
}