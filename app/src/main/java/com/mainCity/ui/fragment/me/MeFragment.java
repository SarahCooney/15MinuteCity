package com.mainCity.ui.fragment.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mainCity.R;
import com.mainCity.ui.login.LoginActivity;

/**
 * User's account fragment. Users can manage their account picture, password, address, and more
 * information here. Also user can logout from this page(haven't finish this function yet).
 */
public class MeFragment extends Fragment {

    private MeViewModel meViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meViewModel =
                new ViewModelProvider(this).get(MeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_me, container, false);

//        TextView userName = (TextView) root.findViewById(R.id.userName_show);
//        TextView id = (TextView) root.findViewById(R.id.iD_show);
//        TextView email = (TextView)root.findViewById(R.id.email_show);
//        TextView gender = (TextView) root.findViewById(R.id.gender_show);

//        userName.setText("Name: " + LoginActivity.user_login.getUsername());
//        String id_str = String.valueOf(LoginActivity.user_login.getUerID());
//        id.setText("ID: " + id_str);
//        email.setText(LoginActivity.user_login.getEmail());
//        gender.setText(LoginActivity.user_login.gender);

        Button lg = (Button) root.findViewById(R.id.buttonLogout);
        lg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(root.getContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        return root;
    }


}