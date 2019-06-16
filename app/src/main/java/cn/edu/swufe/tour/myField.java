package cn.edu.swufe.tour;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toolbar;


public class myField extends AppCompatActivity { 
    
    private Toolbar menu_person;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_my_field);
        
        menu_person = (Toolbar)findViewById(R.id.menu_myField);
        setSupportActionBar(menu_person);
        menu_person.setTitleTextColor(Color.WHITE);
    }

    private void setSupportActionBar(Toolbar menu_person) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        int base = Menu.FIRST;

        SubMenu subMenu1 = menu.addSubMenu("我的帖子");
        SubMenu subMenu2 = menu.addSubMenu("我的计划");


        //menu.add(1,1,1,"我的帖子").setIntent(new Intent(this,tiezi.class));
        //menu.add(1,2,2,R.string.btn_myFootprint);
        //menu.setGroupVisible(1, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.menu_myField){
            //待完善点击完设置后出现的列表
        }

        return super.onOptionsItemSelected(item);
    }

}
