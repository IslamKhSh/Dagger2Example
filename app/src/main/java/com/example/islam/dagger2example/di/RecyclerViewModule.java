package com.example.islam.dagger2example.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.example.islam.dagger2example.ModuleInjectionAdapter;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RecyclerViewModule {
    private Context context;

    public RecyclerViewModule(Context context) {
        this.context =  context;
    }

    @Singleton
    @Provides
    public ArrayList<String> provideItemList(){
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("islam");
        itemsList.add("khaled");
        itemsList.add("shneshn");

        return itemsList;
    }

    @Singleton
    @Provides
    public ModuleInjectionAdapter provideModuleInjectionAdapter(ArrayList<String> itemsList){
        return new ModuleInjectionAdapter(itemsList);
    }

    // no singleton annotation because every recycler need its own layoutManger
    @Provides
    public LinearLayoutManager provideLinearLayoutManager(){
        return new LinearLayoutManager(context);
    }


}
