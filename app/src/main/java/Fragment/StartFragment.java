package Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import henrik.mau.assignment4.Controller;
import henrik.mau.assignment4.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {
    private Controller controller;
    private TextView tvStepsTaken;
    private TextView tvDate;

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View view){
        tvStepsTaken = (TextView) view.findViewById(R.id.tvStepsTaken);
        tvDate = (TextView) view.findViewById(R.id.tvDate);
    }

    public void setTextViews(String stepsTaken, String date){
        tvStepsTaken.setText(stepsTaken);
        tvDate.setText(date);
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

}
