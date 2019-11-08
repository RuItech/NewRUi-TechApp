package com.example.ru_itech.CommonUI.Aunthetication;

import android.os.Bundle;

import com.example.ru_itech.CommonUI.Adapters.DashBoardAdapter;
import com.example.ru_itech.CommonUI.DasboardModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ru_itech.R;
import java.util.ArrayList;
import java.util.List;

public class DashBoard extends AppCompatActivity {

    List<DasboardModel> models;
    DashBoardAdapter adapter;
    RecyclerView dashBoardRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        dashBoardRecyclerView = findViewById(R.id.dashBoardRecyclerView);
        setUpRecyclerView();

    }


    public void setUpRecyclerView(){
        models = new ArrayList<>();
        models.add(new DasboardModel("Business School","https://www.nsu.edu/NSU/media/Photos/2017/06/Nursing%20Building/TM50001-A4-Nursing-Building-109.jpg"));
        models.add(new DasboardModel("School of Computing Science","https://www.apc.edu.ph/wp-content/uploads/elementor/thumbs/work-731198_1920-o8ah72alownw49odo0tdnflz61uzyi1uonc0scfans.jpg"));
        models.add(new DasboardModel("School of Education","https://www.sbu.edu/images/default-source/school-of-education/education-landing-page.jpg"));
        models.add(new DasboardModel("School of Law","https://newintrigue.files.wordpress.com/2018/02/lawschools.jpg"));
        models.add(new DasboardModel("School of journalism","https://www.tmf.or.tz/images/themexpert/blog/banner12.jpg"));
        models.add(new DasboardModel("International relations","https://www.riarauniversity.ac.ke/international_relations/wp-content/uploads/2016/06/logo.jpg"));
        adapter = new DashBoardAdapter(models,DashBoard.this);
        GridLayoutManager layoutManager = new GridLayoutManager(DashBoard.this, 2);
        dashBoardRecyclerView.setLayoutManager(layoutManager);
        dashBoardRecyclerView.setAdapter(adapter);


    }
}
