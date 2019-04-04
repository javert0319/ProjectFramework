package com.app.movie.viewmodel

import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.app.movie.R
import com.app.movie.BR
import com.app.movie.interfaces.IMovie
import com.lib.frame.view.encapsulation.brvah.binding.BrvahItemBinding
import com.lib.frame.view.encapsulation.brvah.binding.action.BrvahAction1
import com.lib.frame.viewmodel.LoadMoreBindingViewModel
import com.nbhope.hopelauncher.lib.network.NetFacade
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieInTheatersBean
import com.nbhope.hopelauncher.lib.network.common.Constant
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @ClassName:   MovieIsHitViewModel
 * @Description: 作用描述
 * @Author:      CHIA
 * @CreateDate:  2019/3/29 17:29
 */
class MovieIsHitViewModel : LoadMoreBindingViewModel<IMovie, MovieInTheatersBean.SubjectsBean>() {

    override fun getItemBinding(): BrvahItemBinding<MovieInTheatersBean.SubjectsBean> {
        return BrvahItemBinding.of<MovieInTheatersBean.SubjectsBean>(BR.bean, R.layout.movie_activity_item_is_hit)
                .clearExtras()
                .bindExtra(BR.itemClick, BrvahAction1 <MovieInTheatersBean.SubjectsBean>{ bean ->
                    Log.i("jiawei","豆瓣 ${bean.title}")
                    ARouter.getInstance().build("/movie/main")
                            .withString("title", "首页")
                            .navigation()
                })

    }

    override fun load(mPage: Int) {
        load(getData(mPage))
    }

    fun setDefault() {
        setDefaultStart(1)
    }

    private fun getData(mPage: Int): Flowable<MutableList<MovieInTheatersBean.SubjectsBean>>? {
        Log.i("jiawei","getData info ")
        return Flowable.create({ emitter ->
                NetFacade.getInstance().provideDefualtService()
                        .getMovieInTheaters(Constant.API_KEY,mPage,20)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ info ->
                            Log.i("jiawei","getData info ${info.subjects[0].title}")
                            //mViewRef.get()?.insertDate()
                            if (info != null){
                                emitter.onNext(info.subjects)
                                emitter.onComplete()
                            }
                        }, {})
        }, BackpressureStrategy.BUFFER)
    }
}