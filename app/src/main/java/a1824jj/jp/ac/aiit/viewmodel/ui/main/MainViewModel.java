package a1824jj.jp.ac.aiit.viewmodel.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private  int clickCount = 0;
    private MutableLiveData<Integer> countLiveData = new MutableLiveData<Integer>();


    public MutableLiveData<Integer> getInitialCount() {
        return countLiveData;
    }

    public void getCurrentCount() {
        this.clickCount += 1;
        countLiveData.setValue(clickCount);
    }

}
