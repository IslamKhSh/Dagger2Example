package com.example.islam.dagger2example.di;

import com.example.islam.dagger2example.ConstructorInjectionAdapter;
import com.example.islam.dagger2example.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RecyclerViewModule.class)
public interface RecyclerViewComponent {

    void inject(MainActivity mainActivity);

    ConstructorInjectionAdapter getConstructorInjectionAdapter();
}
