package com.app.movie

import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.lib.frame.view.simple.BaseSimpleActivity
import kotlinx.android.synthetic.main.movie_activity_debug_main.*

class DebugMainActivity : BaseSimpleActivity() {

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.movie_activity_debug_main)
        initToolbar("豆瓣视频",true)
    }

    override fun initEvent() {
        super.initEvent()
        movie_btn_debug_main.setOnClickListener {
            //Toast.makeText(this,"首页",Toast.LENGTH_SHORT).show()
            ARouter.getInstance().build("/movie/main")
                    .withString("title", "首页")
                    .navigation(DebugMainActivity@ this)
        }

        movie_btn_debug_is_hit.setOnClickListener {
            //Toast.makeText(this,"正在热映",Toast.LENGTH_SHORT).show()
            ARouter.getInstance().build("/movie/is_hit")
                    .withString("title", "正在热映")
                    .navigation()
        }
    }
}
