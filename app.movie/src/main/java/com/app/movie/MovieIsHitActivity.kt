package com.app.movie

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.movie.databinding.MovieActivityIsHitBinding
import com.app.movie.interfaces.IMovie
import com.app.movie.viewmodel.MovieIsHitViewModel
import com.lib.frame.view.BaseActivity
import fm.qingting.qtsdk.QTSDK

@Route(path = "/movie/is_hit")
class MovieIsHitActivity : BaseActivity<IMovie,MovieIsHitViewModel>() {

    @Autowired
    @JvmField
    var title: String = ""

    private lateinit var binding:MovieActivityIsHitBinding

    override fun createViewModel(): MovieIsHitViewModel {
        ARouter.getInstance().inject(this)
        return MovieIsHitViewModel()
    }

    override fun initVarAndView(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this,R.layout.movie_activity_is_hit)
        initToolbar(title,true)
        binding.vm = mViewModel

        mViewModel.setDefault()


    }

    override fun initDoing() {
        super.initDoing()
        mViewModel.load()
    }
}
