package com.example.ru_itech.CommonUI.Aunthetication;

import android.os.Bundle;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.ru_itech.CommonUI.Adapters.DashBoardAdapter;
import com.example.ru_itech.CommonUI.DasboardModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ru_itech.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DashBoard extends AppCompatActivity {

    List<DasboardModel> models;
    DashBoardAdapter adapter;
    RecyclerView dashBoardRecyclerView;
    HashMap<String,String> Hash_file_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        dashBoardRecyclerView = findViewById(R.id.dashBoardRecyclerView);

        setUpRecyclerView();

    }


    public void setUpRecyclerView(){
        models = new ArrayList<>();
        models.add(new DasboardModel("Business School","https://www.riarauniversity.ac.ke/business/wp-content/uploads/2016/06/logo-1.png"));
        models.add(new DasboardModel("School of Computing Science","https://www.riarauniversity.ac.ke/computing/wp-content/uploads/2016/06/SC-logo-white.jpg"));
        models.add(new DasboardModel("School of Education","https://www.riarauniversity.ac.ke/education/wp-content/uploads/2019/05/Schools-01.png"));
        models.add(new DasboardModel("School of Law","https://www.riarauniversity.ac.ke/law/wp-content/uploads/2016/07/logo-law.png"));
        models.add(new DasboardModel("School of journalism","https://www.riarauniversity.ac.ke/journalism/wp-content/uploads/2016/06/logo.png"));
        models.add(new DasboardModel("International relations","https://www.riarauniversity.ac.ke/international_relations/wp-content/uploads/2016/06/logo.jpg"));
        adapter = new DashBoardAdapter(models,DashBoard.this);
        GridLayoutManager layoutManager = new GridLayoutManager(DashBoard.this, 2);
        dashBoardRecyclerView.setLayoutManager(layoutManager);
        dashBoardRecyclerView.setAdapter(adapter);

    }


}
