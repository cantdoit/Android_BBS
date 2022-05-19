package com.example.mybbs.ui.moments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MomentsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MomentsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is moments fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}