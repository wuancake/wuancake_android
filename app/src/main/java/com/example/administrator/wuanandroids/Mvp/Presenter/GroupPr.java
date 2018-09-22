package com.example.administrator.wuanandroids.Mvp.Presenter;

import com.example.administrator.wuanandroids.Mvp.Contract.GroupCons;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GetGroup;
import com.example.administrator.wuanandroids.Mvp.Model.GroupBean.GroupBody;
import com.example.administrator.wuanandroids.Mvp.Model.GroupModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @class name: GroupPr
 * @anthor ：卫士
 * @time :Create on 2018/9/15  7:46
 */
public class GroupPr {
    private GroupModel groupModel;
    private GroupCons.View view;
    public GroupPr(GroupModel groupModel,GroupCons.View view){
        this.groupModel=groupModel;
        this.view=view;
    }
    public void GetDate(GroupBody groupBody){
        Observable<GetGroup> getGroupObservable=groupModel.PostGroup(groupBody);
        getGroupObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetGroup>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetGroup getGroup) {
                        view.getDateSuccess(getGroup);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getDataFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
