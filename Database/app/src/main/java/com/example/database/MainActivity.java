package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.database.Database.UserDatabase;
import com.example.database.Database.user;

import java.util.ArrayList;
import java.util.List;


/*
implementation 'android.arch.persistence.room:runtime:1.0.0'
    annotationProcessor 'android.arch.persistence.room:compiler:1.0.0'

    sono stati aggiunti in build.gradle
 */
public class MainActivity extends AppCompatActivity {

    private List<String> lista=new ArrayList<>();
    private ListView listView;
    private Button button;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        button=findViewById(R.id.button);
        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);

        final UserDatabase db= Room.databaseBuilder(getApplicationContext(),UserDatabase.class, "database").allowMainThreadQueries().build();


        List<user> list=new ArrayList<>();
        list.add(new user("marco","bianchi"));
        list.add(new user("Giovanni","rossi"));
        list.add(new user("Sara","Verdi"));

        final user[]users=list.toArray(new user[list.size()]);

        db.userDao().insertAll(users);





        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View view){
                user u=new user("guru guru","lalala");
                db.userDao().insertAll(u);
                lista.add(u.getName()+" "+u.getLastName());
                adapter.notifyDataSetChanged();
            }

        });

        List<user> users1=db.userDao().getAll();
        for (user user: users1){
            lista.add(user.getName()+" "+user.getLastName());
        }
        adapter.notifyDataSetChanged();

    }

}