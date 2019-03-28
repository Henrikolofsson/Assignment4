package Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import henrik.mau.assignment4.Controller;
import henrik.mau.assignment4.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateUserFragment extends Fragment {
    private Controller controller;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnCreateUser;


    public CreateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_user, container, false);
        initializeComponents(view);
        registerListeners();
        return view;
    }

    private void initializeComponents(View view){
        etUsername = (EditText) view.findViewById(R.id.etCreateUserName);
        etPassword = (EditText) view.findViewById(R.id.etCreateUserPassword);
        btnCreateUser = (Button) view.findViewById(R.id.btnCreateUser);
    }

    private void registerListeners(){
        btnCreateUser.setOnClickListener(new CreateUserListener());
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private class CreateUserListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            controller.createUser(etUsername.getText().toString(), etPassword.getText().toString());
        }
    }

}
