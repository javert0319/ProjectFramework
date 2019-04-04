package com.app.movie

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.lib.frame.view.simple.BaseSimpleActivity
import kotlinx.android.synthetic.main.movie_activity_main.*

@Route(path = "/movie/main")
class MainActivity : BaseSimpleActivity() {

    @Autowired
    @JvmField
    var title: String = ""

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.movie_activity_main)
        ARouter.getInstance().inject(this)
        initToolbar(title,true)
        movie_tv_main_title.text = title

    }
}
