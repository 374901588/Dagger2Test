package com.example.zero.test1;

import dagger.Component;

/**
 * Created by Zero on 2017/3/16.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    //这里的方法名“inject”是自定义的，也可以是其它正规的命名
//    void inject(MainActivity activity);

    //多层依赖时使用
    UserModel userModel();
}


