package com.example.zero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.zero.test1.DaggerMainActivityComponent;
import com.example.zero.test1.MainActivityComponent;
import com.example.zero.test1.MainActivityModule;
import com.example.zero.test1.UserModel;
import com.example.zero.test2.ContainerComponent;
import com.example.zero.test2.ContainerModule;
import com.example.zero.test2.DaggerContainerComponent;
import com.example.zero.test2.ShoppingCartModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private MainActivityComponent mMainActivityComponent;

    //被注入的实例对象将被user引用
    @Inject UserModel user;
    //就算需要两个userModel类型的实例对象，也只需使用inject方法注入一次
    @Inject UserModel user2;

    @Inject
    ShoppingCartModel cartModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test2();
    }

    public void test2() {
        mMainActivityComponent = DaggerMainActivityComponent.builder().mainActivityModule(new MainActivityModule()).build();
        ContainerComponent containerComponent = DaggerContainerComponent.builder().mainActivityComponent(mMainActivityComponent).containerModule(new ContainerModule()).build();

        containerComponent.inject(this);

        user.setId(1);
        user.setName("Bill");
        user.setGender('M');
        cartModel.setTest("this is a test");

        ((TextView) findViewById(R.id.tv)).setText(user.getName()+"---"+cartModel.getTest());
    }

    private void test1() {
        //原来的实现方式
//        UserModel user=new UserModel();

        //在使用DaggerMainActivityComponent前，需要ReBuild一次，才能正常使用，否在会出现编译错误
        //DaggerXXX，“XXX”为相应的Component接口名字
        //mainActivityModule的命名对应与相应的Module接口名字
        mMainActivityComponent = DaggerMainActivityComponent.builder().mainActivityModule(new MainActivityModule()).build();

//        mMainActivityComponent.inject(this);

        user.setId(1);
        user.setName("Bill");
        user.setGender('M');

        Log.d("测试", user2.getId() + " " + user2.getName() + " " + user2.getGender());
        Log.d("测试",""+(user==user2));

        ((TextView) findViewById(R.id.tv)).setText(user.getId() + " " + user.getName() + " " + user.getGender());
    }
}
