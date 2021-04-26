package com.mainCity.ui.fragment.missions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mainCity.R;
import com.mainCity.ui.Activity.TakePhotoActivity;
import com.mainCity.ui.login.LoginActivity;

import java.io.FileNotFoundException;

import static android.app.Activity.RESULT_OK;

/**
 * Mission fragment. Users will see their missions here.
 */
public class MissionsFragment extends Fragment {

    private MissionsViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(MissionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_missions, container, false);
        final LinearLayout layout = (LinearLayout)root.findViewById(R.id.mission_list);
        final ScrollView sv = (ScrollView) root.findViewById(R.id.scrollView_show);

        // Let the scrollView to scroll down every time we open this fragment so that
        // users will be able to see the newest missions.
        Handler handler = new Handler();

        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                sv.fullScroll(sv.FOCUS_DOWN);
            }
        });

        // TextView to show the mission.
        TextView mission_1 = new TextView(getContext());
        mission_1.setText("Mission 1");
        mission_1.setTextSize(20);
        mission_1.setClickable(true);
        mission_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_new_activity = new Intent(getContext(), TakePhotoActivity.class);
                startActivity(open_new_activity);
            }
        });
        layout.addView(mission_1);


        return root;
    }


}