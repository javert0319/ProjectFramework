package com.app.movie

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.support.v7.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lib.frame.view.simple.BaseSimpleActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import com.app.movie.databinding.MovieActivityMainBinding
import com.app.movie.databinding.MovieNavHeaderMainBinding
import com.app.movie.utils.CommonUtils
import com.app.movie.utils.SPUtils
import com.app.movie.utils.http.rx.RxBus
import com.app.movie.utils.http.rx.RxBusBaseMessage
import com.app.movie.utils.http.rx.RxCodeConstants
import com.app.movie.view.statusbar.StatusBarUtil
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.movie_app_bar_main.*
import java.util.ArrayList

@Route(path = "/movie/main")
class MainActivity : BaseSimpleActivity() {

    @Autowired
    @JvmField
    var title: String = ""
    private lateinit var binding: MovieActivityMainBinding
    private lateinit var navHeaderBind:MovieNavHeaderMainBinding

    private var isLaunch: Boolean = false
    private var mainLlTitleMenu:FrameLayout ?= null
    private var mainToobar:Toolbar ?= null
    private var mainDrawerLayout:DrawerLayout ?= null
    private var vpContent:ViewPager ?= null
    private var ivTitleTwo: ImageView? = null
    private var ivTitleOne: ImageView? = null
    private var ivTitleThree: ImageView? = null
    private var navView: NavigationView? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    override fun initVarAndView(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this,R.layout.movie_activity_main)
        ARouter.getInstance().inject(this)
        isLaunch = true
        initStatusView()
        initView()
        initRxBus()
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(
            this@MainActivity, mainDrawerLayout,
            CommonUtils.getColor(this@MainActivity,R.color.movie_colorTheme)
        )
        initContentFragment()
    }

    private fun initContentFragment() {
        val mFragmentList = ArrayList<Fragment>()

    }

    private fun initView() {
        mainDrawerLayout = binding.drawerLayout
        mainToobar = binding.include.toolbar
        mainLlTitleMenu = binding.include.llTitleMenu
        vpContent = binding.include.vpContent
        ivTitleOne = binding.include.ivTitleOne
        ivTitleTwo = binding.include.ivTitleTwo
        ivTitleThree = binding.include.ivTitleThree
    }

    private fun initStatusView() {
        val layoutParams = binding.include.viewStatus.layoutParams
        layoutParams.height = StatusBarUtil.getStatusBarHeight(this)
        binding.include.viewStatus.layoutParams = layoutParams
    }

    /**
     * 夜间模式待完善
     */
    fun getNightMode(): Boolean {
        return SPUtils.getNightMode(this)
    }

    fun onNightModeClick(view: View) {
        if (!SPUtils.getNightMode(this)) {
            //            SkinCompatManager.getInstance().loadSkin(Constants.NIGHT_SKIN);
        } else {
            // 恢复应用默认皮肤
            //            SkinCompatManager.getInstance().restoreDefaultTheme();
        }
        SPUtils.setNightMode(this,!SPUtils.getNightMode(this))
        navHeaderBind.dayNightSwitch.isChecked = SPUtils.getNightMode(this)
    }

    /**
     * 每日推荐点击"新电影热映榜"跳转
     */
    private fun initRxBus() {
        val subscribe = RxBus.getDefault().toObservable(RxCodeConstants.JUMP_TYPE_TO_ONE, RxBusBaseMessage::class.java)
            .subscribe { setCurrentItem(2) }
        addSubscription(subscribe)
    }

    /**
     * 切换页面
     * @param position 分类角标
     */
    private fun setCurrentItem(position: Int) {
        var isOne = false
        var isTwo = false
        var isThree = false
        when (position) {
            0 -> isOne = true
            1 -> isTwo = true
            2 -> isThree = true
            else -> isTwo = true
        }
        vpContent?.currentItem = position
        ivTitleOne?.isSelected = isOne
        ivTitleTwo?.isSelected = isTwo
        ivTitleThree?.isSelected = isThree
    }

    private fun addSubscription(s: Disposable) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = CompositeDisposable()
        }
        this.mCompositeDisposable!!.add(s)
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (this.mCompositeDisposable != null && !mCompositeDisposable!!.isDisposed) {
            this.mCompositeDisposable!!.clear()
        }
        isLaunch = false
    }
}
