package a1824jj.jp.ac.aiit.viewmodel.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import a1824jj.jp.ac.aiit.viewmodel.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView textView;
    private Button  button;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.main_fragment, container, false);
        textView = v.findViewById(R.id.message);
        button = v.findViewById(R.id.button);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
                //ViewModelProviders.of(this).get(MainViewModel.class);

        LiveData<Integer> count = this.mViewModel.getInitialCount();
        count.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText("Count is: " + integer);
            }
        });



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mViewModel.getCurrentCount();
                //textView.setText("Count is: " + mViewModel.getCurrentCount());
            }
        });

    }

}
