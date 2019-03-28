package Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import henrik.mau.assignment4.Controller;
import henrik.mau.assignment4.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment {
    private Controller controller;
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvNoUser;
    private Button btnLogIn;

    public LogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        initializeComponents(view);
        registerListeners();
        return view;
    }

    private void initializeComponents(View view) {
        etUsername = (EditText) view.findViewById(R.id.etUsername);
        etPassword = (EditText) view.findViewById(R.id.etPassword);
        tvNoUser = (TextView) view.findViewById(R.id.tvNoUser);
        btnLogIn = (Button) view.findViewById(R.id.btnLogIn);
    }

    private void registerListeners(){
        tvNoUser.setOnClickListener(new TextViewListener());
        btnLogIn.setOnClickListener(new ButtonLogInListener());
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private class ButtonLogInListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            controller.logIn(etUsername.getText().toString(), etPassword.getText().toString());
        }
    }

    private class TextViewListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            controller.setCreateUserFragment();
        }
    }
}
