package com.example.a20211221livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {

    private MutableLiveData<Integer> LikedNumber;
   /* this is the likedNumber constructor
        ViewModelWithLiveData(){
        LikedNumber = new MutableLiveData<>();
       getLikedNumber().setValue(0);
       }

       */
    //get method
    public MutableLiveData<Integer> getLikedNumber() {
        // or instantiate object here instead of using constructor,recommend this method
        if (LikedNumber == null)
        {
            LikedNumber =new MutableLiveData<>();
            LikedNumber.setValue(0);

        }
        return LikedNumber;
    }

    public void addLikedNumber(int n){
        LikedNumber.setValue(LikedNumber.getValue()+n);

    }
}
