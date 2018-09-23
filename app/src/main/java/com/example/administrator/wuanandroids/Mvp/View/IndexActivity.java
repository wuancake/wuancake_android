package com.example.administrator.wuanandroids.Mvp.View;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.wuanandroids.Adapter.ViewPagerAdapter;
import com.example.administrator.wuanandroids.Mvp.Contract.IndexCons;
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.GetIndex;
import com.example.administrator.wuanandroids.Mvp.Model.IndexBean.IndexBody;
import com.example.administrator.wuanandroids.Mvp.Model.IndexModel;
import com.example.administrator.wuanandroids.Mvp.Presenter.IndexPr;
import com.example.administrator.wuanandroids.R;
import com.example.administrator.wuanandroids.Tool.PreUtils;
import com.example.administrator.wuanandroids.Util.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @class name: IndexActivity
 * @anthor ：卫士
 * @time :Create on 2018/9/11  3:31
 */
public class IndexActivity extends BaseActivity implements ViewPager.OnPageChangeListener, IndexCons.View {
    @BindView(R.id.report_btn)
    RadioButton reportBtn;
    @BindView(R.id.user_btn)
    RadioButton userBtn;
    @BindView(R.id.radio)
    RadioGroup radio;
    @BindView(R.id.index_btn)
    RadioButton indexBtn;
    @BindView(R.id.view)
    View view;
    ViewPagerAdapter adapter = null;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private IndexPr indexPr;
    private List<Fragment> fragmentList = new ArrayList<>();
   private Mythread mythread=null;
   private  boolean finish=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_index_view);
        ButterKnife.bind(this);
        mythread=new Mythread();


    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onStart() {
        super.onStart();
        indexPr = new IndexPr(new IndexModel(), this);
        indexPr.GetDate(new IndexBody(PreUtils.INSTANCE.getInt(this,"userId",0)));



    }
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }
    @Override
    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                indexBtn.setChecked(true);
                break;
            case 1:
                reportBtn.setChecked(true);
                break;
            case 2:
                userBtn.setChecked(true);
                break;

        }
    }
    @Override
    public void onPageScrollStateChanged(int i) {

    }
    @OnClick({R.id.index_btn, R.id.report_btn, R.id.user_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.index_btn:
                viewPager.setCurrentItem(0);
                break;
            case R.id.report_btn:
                viewPager.setCurrentItem(1);
                break;
            case R.id.user_btn:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void getDateSuccess(GetIndex getIndex) {
        if (getIndex.getInfoCode().equals("200")) {
            PreUtils.INSTANCE.setInt(this,"status",getIndex.getStatus());
            fragmentList.clear();
            int status = PreUtils.INSTANCE.getInt(this, "status", 1);
            if (status == 1) {
                fragmentList.add(new IndexOneFragment());
            } else if (status == 2) {
                fragmentList.add(new SubmitFragment());
            } else if (status == 3) {
                fragmentList.add(new LeaveFragment());
            }
            fragmentList.add(new MwrFragment());
            fragmentList.add(new UserFragment());
            adapter = new ViewPagerAdapter(this, getSupportFragmentManager(), fragmentList);
            viewPager.setAdapter(adapter);
            viewPager.setOnPageChangeListener(this);
            indexBtn.setChecked(true);
        } else {
//            show_Toast(getIndex.getInfoText());
        }
    }

    @Override
    public void getDataFail(Throwable throwable) {
        show_Toast("网络错误！");
    }
    //重写onKeyDown方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断当点击的是返回键
        if (keyCode == event.KEYCODE_BACK) {
            exit();//退出方法
        }
        return true;
    }

    private long time = 0;

    //退出方法
    private void exit() {
//如果在两秒大于2秒
        if (System.currentTimeMillis() - time > 2000) {
//获得当前的时间
            time = System.currentTimeMillis();
            show_Toast("再点击一次退出应用程序");
        } else {
//点击在两秒以内
//            PreUtils.clears(this);
            removeALLActivity();//执行移除所以Activity方法

        }
    }

    public void repalce(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.viewPager, fragment);
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
//            mythread=new Mythread();
//            mythread.execute(2);
//        }
//        if (requestCode == 2 && resultCode == 5) {
//            mythread=new Mythread();
//            mythread.execute(2);
//        }
//        if (requestCode== 3 && resultCode == 6) {
//            mythread=new Mythread();
//            mythread.execute(2);
//        }
//        if (requestCode == 7 && resultCode == 8) {
//            mythread=new Mythread();
//            mythread.execute(1);
//        }

    }


    class  Mythread extends AsyncTask<Integer,Integer,Integer> {


        @Override
        protected Integer doInBackground(Integer... integers) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return integers[0];
        }

        @Override
        protected void onPostExecute(Integer integer) {
            viewPager.setCurrentItem(integer);
        }
    }


}
