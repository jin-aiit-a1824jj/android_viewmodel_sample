package a1824jj.jp.ac.aiit.viewmodel.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private  int clickCount = 0;

    public int getInitialCount() {
        return this.clickCount;
    }

    public int getCurrentCount() {
        this.clickCount += 1;
        return this.clickCount;
    }

}
