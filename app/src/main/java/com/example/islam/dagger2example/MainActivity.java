package com.example.islam.dagger2example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.islam.dagger2example.di.DaggerRecyclerViewComponent;
import com.example.islam.dagger2example.di.RecyclerViewComponent;
import com.example.islam.dagger2example.di.RecyclerViewModule;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;

public class MainActivity extends AppCompatActivity {

    RecyclerView moduleInjectionRecycler, constructorInjectionRecycler;

    @Inject
    ModuleInjectionAdapter moduleInjectionAdapter;

    @Inject
    LinearLayoutManager moduleInjectionLayoutManger, contructorInjectionLayoutManager;

    RecyclerViewComponent recyclerViewComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // perform injection
        recyclerViewComponent =  DaggerRecyclerViewComponent.builder().
                recyclerViewModule(new RecyclerViewModule(this)).build();
        recyclerViewComponent.inject(this);

        // init views
        moduleInjectionRecycler = findViewById(R.id.module_injection);
        constructorInjectionRecycler = findViewById(R.id.constructor_injection);

        // set layout managers
        moduleInjectionRecycler.setLayoutManager(moduleInjectionLayoutManger);
        constructorInjectionRecycler.setLayoutManager(contructorInjectionLayoutManager);

        // set adapters
        moduleInjectionRecycler.setAdapter(moduleInjectionAdapter);
        constructorInjectionRecycler.setAdapter(recyclerViewComponent.getConstructorInjectionAdapter());
    }
}
