package com.app.movie

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.support.v7.widget.Toolbar
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.app.movie.adapter.MovieFragmentPagerAdapter
import com.lib.frame.view.simple.BaseSimpleActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import com.app.movie.databinding.MovieActivityMainBinding
import com.app.movie.databinding.MovieNavHeaderMainBinding
import com.app.movie.ui.douban.DoubanFragment
import com.app.movie.ui.dry.DryFragment
import com.app.movie.ui.learn.LearnFragment
import com.app.movie.utils.*
import com.app.movie.utils.http.rx.RxBus
import com.app.movie.utils.http.rx.RxBusBaseMessage
import com.app.movie.utils.http.rx.RxCodeConstants
import com.app.movie.view.statusbar.StatusBarUtil
import java.util.ArrayList

@Route(path = "/movie/main")
class MainActivity : BaseSimpleActivity(), View.OnClickListener,ViewPager.OnPageChangeListener {

    @Autowired
    @JvmField
    var title: String = ""
    private lateinit var binding: MovieActivityMainBinding
    private lateinit var navHeaderBind:MovieNavHeaderMainBinding

    private var isLaunch: Boolean = false
    private var mainLlTitleMenu:FrameLayout ?= null
    private var mainLlSearchMenu:FrameLayout ?= null
    private var mainToobar:Toolbar ?= null
    private var mainDrawerLayout:DrawerLayout ?= null
    private var vpContent:ViewPager ?= null
    private var ivTitleTwo: ImageView? = null
    private var ivTitleOne: ImageView? = null
    private var ivTitleThree: ImageView? = null
    private var navView: NavigationView? = null
    private val mFragmentList = ArrayList<Fragment>()

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
        initDrawerLayout()
        initListener()

    }

    private fun initListener() {
        mainLlTitleMenu?.setOnClickListener(this)
        mainLlSearchMenu?.setOnClickListener(this)
        binding.include.ivTitleOne.setOnClickListener(this)
        binding.include.ivTitleTwo.setOnClickListener(this)
        binding.include.ivTitleThree.setOnClickListener(this)
        getClipContent()
    }

    private fun getClipContent() {
        /*val clipContent = BaseTools.getClipContent(this)
        if (!TextUtils.isEmpty(clipContent)) {
            DialogBuild.showCustom(vpContent, clipContent, "打开其中链接", DialogInterface.OnClickListener { dialog, which ->
                WebViewActivity.loadUrl(this@MainActivity, clipContent, "加载中..")
                BaseTools.clearClipboard(this@MainActivity)
            })
        }*/
    }

    //inflateHeaderView 进来的布局要宽一些
    private fun initDrawerLayout() {
        navView?.inflateHeaderView(R.layout.movie_nav_header_main)
        val headerView = navView?.getHeaderView(0)
        navHeaderBind = DataBindingUtil.bind(headerView!!)!!
        navHeaderBind.listener = this
        navHeaderBind.dayNightSwitch.isChecked = SPUtils.getNightMode(this)
        ImageLoadUtil.displayCircle(navHeaderBind.ivAvatar, ConstantsImageUrl.IC_AVATAR)
        navHeaderBind.llNavExit.setOnClickListener(this)
        navHeaderBind.ivAvatar.setOnClickListener(this)

        navHeaderBind.llNavHomepage.setOnClickListener(listener)
        navHeaderBind.llNavScanDownload.setOnClickListener(listener)
        navHeaderBind.llNavDeedback.setOnClickListener(listener)
        navHeaderBind.llNavAbout.setOnClickListener(listener)
        navHeaderBind.llNavLogin.setOnClickListener(listener)
        navHeaderBind.llNavCollect.setOnClickListener(listener)
    }

    private fun initContentFragment() {
        mFragmentList.add(LearnFragment())
        mFragmentList.add(DryFragment())
        mFragmentList.add(DoubanFragment())
        val fragmentPagerAdapter = MovieFragmentPagerAdapter(supportFragmentManager,mFragmentList)
        vpContent?.adapter = fragmentPagerAdapter
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        vpContent?.offscreenPageLimit = 2
        vpContent?.addOnPageChangeListener(this)
        setSupportActionBar(mainToobar)
        val actionbar = supportActionBar
        if (actionbar != null){
            //去掉actionBar
            actionbar.setDisplayShowTitleEnabled(false)
        }
        setCurrentItem(0)
    }

    private fun initView() {
        navView = binding.navView
        mainDrawerLayout = binding.drawerLayout
        mainToobar = binding.include.toolbar
        mainLlTitleMenu = binding.include.llTitleMenu
        mainLlSearchMenu = binding.include.llSearchMenu
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

    override fun onClick(v: View?) {
        when{
            v?.id == R.id.ll_title_menu -> {//开启菜单
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
            v?.id == R.id.ll_search_menu -> {//搜索
                Toast.makeText(this@MainActivity,"搜索",Toast.LENGTH_SHORT).show()
            }
            v?.id == R.id.iv_title_two -> {//不然cpu会有损耗
                if (vpContent?.currentItem != 1){
                    setCurrentItem(1)
                }
                Toast.makeText(this@MainActivity,"Title Two",Toast.LENGTH_SHORT).show()
            }
            v?.id == R.id.iv_title_one -> {
                if (vpContent?.currentItem != 0){
                    setCurrentItem(0)
                }
                Toast.makeText(this@MainActivity,"Title One",Toast.LENGTH_SHORT).show()
            }
            v?.id == R.id.iv_title_three -> {
                if (vpContent?.currentItem != 2){
                    setCurrentItem(2)
                }
                Toast.makeText(this@MainActivity,"Title Three",Toast.LENGTH_SHORT).show()
            }
            v?.id == R.id.iv_avatar -> {//头像进入GitHub
                Toast.makeText(this@MainActivity,"头像进入GitHub",Toast.LENGTH_SHORT).show()
            }
            v?.id == R.id.ll_nav_exit -> {//退出应用
                finish()
            }
        }
    }

    val listener = object:PerfectClickListener(){
        override fun onNoDoubleClick(v: View?) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            binding.drawerLayout.postDelayed({
                when {
                    v?.id == R.id.ll_nav_homepage -> {//主页
                        Toast.makeText(this@MainActivity,"主页",Toast.LENGTH_SHORT).show()
                    }
                    v?.id == R.id.ll_nav_scan_download -> {//扫描下载
                        Toast.makeText(this@MainActivity,"扫描下载",Toast.LENGTH_SHORT).show()
                    }
                    v?.id == R.id.ll_nav_deedback -> {//问题反馈
                        Toast.makeText(this@MainActivity,"问题反馈",Toast.LENGTH_SHORT).show()
                    }
                    v?.id == R.id.ll_nav_about -> {//关于微头条
                        Toast.makeText(this@MainActivity,"关于微头条",Toast.LENGTH_SHORT).show()
                    }
                    v?.id == R.id.ll_nav_collect -> {//收藏
                        Toast.makeText(this@MainActivity,"收藏",Toast.LENGTH_SHORT).show()
                    }
                    v?.id == R.id.ll_nav_login -> {//登录
                        Toast.makeText(this@MainActivity,"登录",Toast.LENGTH_SHORT).show()
                    }
                }
            }, 260)
        }
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

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> setCurrentItem(0)
            1 -> setCurrentItem(1)
            2 -> setCurrentItem(2)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.fontScale != 1f) {
            resources
        }
    }

    //禁止改变字体大小
    override fun getResources(): Resources {
        val res = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
        return res
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                // 不退出程序，进入后台
                moveTaskToBack(true)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (this.mCompositeDisposable != null && !mCompositeDisposable!!.isDisposed) {
            this.mCompositeDisposable!!.clear()
        }
        isLaunch = false
    }

    fun start(context: Context) {
        context.startActivity(Intent(context, MainActivity::class.java))
    }
}
