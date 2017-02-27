# LifeCycleBinder
**LifeCycleBinder**提供了极其简单的API用于绑定Activity/Fragment的生命周期回调，当Activity/Fragment进行到
相应的生命周期时就会调用相应的回调方法。对于想要在Activity/Fragment的销毁的时候自动完成内存释放的同学，这是一个
极佳的解决方案。目前，Google极力推荐的Android图片处理库[Glide](https://github.com/bumptech/glide)就使用了
同样的方式完成Glide相应生命周期的绑定，自动帮忙完成图片内存的释放，极大地减少了不必要的开发工作。

使用方法：

1）增加以下脚本到你的工程根目录的build.gradle文件中
<pre>
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
</pre>

2）在你的app工程中，增加如下依赖:
<pre>
dependencies {

}
</pre>

完成以上两个步骤之后，你就可以使用LifeCycleBinder的所有API，这里以绑定Activity的生命周期为例，仅仅只需要一行
代码就可以实现针对Activity的生命周期绑定:
<pre>
    LifeCycleBinder.bind(this, new OnLifeCycleChangedListener() {
        @Override
        public void onStart() {
            ToastUtil.toast(BindedActivity.this , BindedActivity.class , "onStart");
        }

        @Override
        public void onStop() {
            ToastUtil.toast(BindedActivity.this , BindedActivity.class , "onStop");
        }

        @Override
        public void onDestroy() {
            ToastUtil.toast(BindedActivity.this , BindedActivity.class , "onDestroy");
        }
    });
</pre>

对于Fragment的绑定方法和Activity是完全一样的，具体请参照例子[sample](https://github.com/yuanhoujun/Android_Life_Cycle_Binder/tree/master/sample)

目前，仅仅实现了onStart/onStop/onDestroy方法回调，如果需要更多生命周期方法绑定，请给我推送issue 。
想要了解更多，请关注我的[欧阳锋的简书](http://www.jianshu.com/u/db019edd34b4)