package com.chia.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.lib.frame.view.simple.BaseSimpleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseSimpleActivity() {

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        initToolbar("豆瓣视频",true)
        btn_movie.setOnClickListener {
            //Toast.makeText(this,"正在热映",Toast.LENGTH_SHORT).show()
            ARouter.getInstance().build("/movie/is_hit")
                .withString("title", "正在热映")
                .navigation()
        }
    }
}
