package com.mainCity.ui.fragment.missions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MissionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MissionsViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
}