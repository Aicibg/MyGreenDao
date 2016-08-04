package com.app.mygreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btSearch,btAdd;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= (TextView) findViewById(R.id.tv_text);
        btSearch= (Button) findViewById(R.id.button);
        btAdd= (Button) findViewById(R.id.bt_add);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  i++;
                  User user=new User(1,"JAck","女"+i,"22");
                  DBManager dbManager=DBManager.getNewInstance(MainActivity.this);
                  dbManager.insertUSER(user);
            }
        });

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBManager dbManager=DBManager.getNewInstance(MainActivity.this);
                List<User> list=dbManager.queryUSER();
                StringBuilder builder=new StringBuilder();
                for (User user:list){
                    builder.append("id="+user.getId()+"\n"
                    +"name="+user.getName()+"\n"
                            +"gender="+user.getGender()+"\n"
                            +"age="+user.getAge());
                }
                textView.setText(builder.toString());
            }
        });
    }
}
