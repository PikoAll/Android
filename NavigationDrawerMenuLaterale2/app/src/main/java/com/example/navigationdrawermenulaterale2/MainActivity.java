package com.example.navigationdrawermenulaterale2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);  // era cosi setContentView(R.layout.activity_main);

        //toolbar=findViewById(R.id.toolbar);

        drawerLayout=findViewById(R.id.DrawerLayout);
        navigationView=findViewById(R.id.navigationDrawer);

        navigationView.setNavigationItemSelectedListener(this);


        //ho aggiunto una cosa nel file string
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.setDrawerListener(toggle);




    }

    @Override
    protected void onPostCreate(@Nullable  Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {   // qua dentro analizziamo il tocco dei pulsanti

        int id=item.getItemId();

        if(id==R.id.inbox_id){

            Toast.makeText(getApplicationContext(),"hai cliccato",Toast.LENGTH_LONG).show();
            //dopo aver cliccato fare chiudere il menu laterale
            drawerLayout.closeDrawers();

        }else if(id==R.id.dele_id){

        }

        return true;
    }
}

