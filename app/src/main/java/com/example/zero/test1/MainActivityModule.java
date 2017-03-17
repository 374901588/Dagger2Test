package com.example.zero.test1;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zero on 2017/3/16.
 */

@Module
public class MainActivityModule {

    //这里的方法名“provideUserModel”是自定义的，也可以是其它正规的命名
    @Provides
    UserModel provideUserModel() {
        return new UserModel();
    }
}
