package com.example.zero.test2;

import com.example.zero.MainActivity;
import com.example.zero.test1.MainActivityComponent;

import dagger.Component;

/**
 * Created by Zero on 2017/3/16.
 */

@Component(dependencies = MainActivityComponent.class, modules = ContainerModule.class)
public interface ContainerComponent {
    void inject(MainActivity mainActivity);
}
