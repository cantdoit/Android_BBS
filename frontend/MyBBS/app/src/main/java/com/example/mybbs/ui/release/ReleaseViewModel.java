package com.example.mybbs.ui.release;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReleaseViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ReleaseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is release fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}