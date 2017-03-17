package com.example.zero.test2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zero on 2017/3/16.
 */

@Module
public class ContainerModule {
    @Provides
    ShoppingCartModel provideCartModel() {
        return new ShoppingCartModel();
    }
}
