package com.example.babyak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bNavigation;

    ListFragment listFragment = new ListFragment();
    ChatFragment chatFragment = new ChatFragment();
    SearchFragment searchFragment = new SearchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 하단 navigation var 가져오기
        bNavigation = findViewById(R.id.navigation);

        // 첫 화면 띄우기 - 글 목록
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, listFragment).commit();

        // id 연결
        //Bundle bundle = new Bundle();
        //bundle.putString("user_id", new GlobalVar().getId());
        //chatFragment.setArguments(bundle);

        // navigation var 클릭 시 fragment 변경
        bNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_list:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, listFragment).commit();
                        break;
                    case R.id.nav_chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, chatFragment).commit();
                        break;
                    case R.id.nav_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new LoginFragment()).commit();
                        break;

                }
                return true;
            }
        });

    }
}