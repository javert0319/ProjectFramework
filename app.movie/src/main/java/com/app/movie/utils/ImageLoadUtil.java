package com.app.movie.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.app.movie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lib.frame.bindingadapter.image.GlideRoundTransform;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * @author JAIWEI
 * @company Thredim
 * @date on 2019/4/6.
 * @org www.thredim.com (宁波视睿迪光电有限公司)
 * @email thredim@thredim.com
 * @describe 添加描述
 */
public class ImageLoadUtil {
    private static ImageLoadUtil instance;
    private static RequestOptions options = new RequestOptions();

    private ImageLoadUtil() {
    }

    public static ImageLoadUtil getInstance() {
        if (instance == null) {
            instance = new ImageLoadUtil();
        }
        return instance;
    }


    /**
     * 显示随机的图片(每日推荐)
     *
     * @param imgNumber 有几张图片要显示,对应默认图
     * @param imageUrl  显示图片的url
     * @param imageView 对应图片控件
     */
    public static void displayRandom(int imgNumber, String imageUrl, ImageView imageView) {
        options.placeholder(getMusicDefaultPic(imgNumber))
                .error(getMusicDefaultPic(imgNumber));
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }

    private static int getMusicDefaultPic(int imgNumber) {
        switch (imgNumber) {
            case 1:
                return R.drawable.img_two_bi_one;
            case 2:
                return R.drawable.img_four_bi_three;
            case 3:
                return R.drawable.img_one_bi_one;
            case 4:
                return R.drawable.movie_shape_bg_loading;
            default:
                break;
        }
        return R.drawable.img_four_bi_three;
    }

//--------------------------------------

    /**
     * 用于干货item，将gif图转换为静态图
     */
    public static void displayGif(String url, ImageView imageView) {
        options.placeholder(R.drawable.movie_shape_bg_loading)
                .error(R.drawable.movie_shape_bg_loading);
        Glide.with(imageView.getContext()).asBitmap().load(url)
                .apply(options)
//                .skipMemoryCache(true) //跳过内存缓存
//                .crossFade(1000)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)// 缓存图片源文件（解决加载gif内存溢出问题）
//                .into(new GlideDrawableImageViewTarget(imageView, 1));
                .into(imageView);
    }

    /**
     * 书籍、妹子图、电影列表图
     * 默认图区别
     */
    public static void displayEspImage(String url, ImageView imageView, int type) {
        options.placeholder(getDefaultPic(type))
                .error(getDefaultPic(type));
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    private static int getDefaultPic(int type) {
        switch (type) {
            case 0:// 电影
                return R.drawable.img_default_movie;
            case 1:// 妹子
                return R.drawable.img_default_meizi;
            case 2:// 书籍
                return R.drawable.img_default_book;
            case 3:
                return R.drawable.movie_shape_bg_loading;
            default:
                break;
        }
        return R.drawable.img_default_meizi;
    }

    /**
     * 显示高斯模糊效果（电影详情页）
     */
    private static void displayGaussian(Context context, String url, ImageView imageView) {
        // "23":模糊度；"4":图片缩放4倍后再进行模糊
        options.error(R.drawable.stackblur_default)
        .placeholder(R.drawable.stackblur_default)
        .bitmapTransform(new BlurTransformation(23, 4));
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载圆角图,暂时用到显示头像
     */
    @BindingAdapter("android:displayCircle")
    public static void displayCircle(ImageView imageView, String imageUrl) {
        options.error(R.drawable.ic_avatar_default)
                .transform(new GlideRoundTransform(imageView.getContext()));
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }

    /**
     * 妹子，电影列表图
     *
     * @param defaultPicType 电影：0；妹子：1； 书籍：2
     */
    @BindingAdapter({"android:displayFadeImage", "android:defaultPicType"})
    public static void displayFadeImage(ImageView imageView, String url, int defaultPicType) {
        displayEspImage(url, imageView, defaultPicType);
    }

    /**
     * 电影详情页显示电影图片(等待被替换)（测试的还在，已可以弃用）
     * 没有加载中的图
     */
    @BindingAdapter("android:showImg")
    public static void showImg(ImageView imageView, String url) {
        options.error(getDefaultPic(0));
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 电影列表图片
     */
    @BindingAdapter("android:showMovieImg")
    public static void showMovieImg(ImageView imageView, String url) {
        options.override((int) CommonUtils.getDimens(imageView.getContext(),R.dimen.movie_detail_width),
                (int) CommonUtils.getDimens(imageView.getContext(),R.dimen.movie_detail_height))
                .placeholder(getDefaultPic(0))
                .error(getDefaultPic(0));
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 书籍列表图片
     */
    @BindingAdapter("android:showBookImg")
    public static void showBookImg(ImageView imageView, String url) {
        options.override((int) CommonUtils.getDimens(imageView.getContext(),R.dimen.movie_book_detail_width),
                (int) CommonUtils.getDimens(imageView.getContext(),R.dimen.movie_book_detail_height))
                .placeholder(getDefaultPic(2))
                .error(getDefaultPic(2));
        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 电影详情页显示高斯背景图
     */
    @BindingAdapter("android:showImgBg")
    public static void showImgBg(ImageView imageView, String url) {
        displayGaussian(imageView.getContext(), url, imageView);
    }


    /**
     * 热门电影头部图片
     */
    @BindingAdapter({"android:displayRandom", "android:imgType"})
    public static void displayRandom(ImageView imageView, int imageUrl, int imgType) {
        options.placeholder(getMusicDefaultPic(imgType))
                .error(getMusicDefaultPic(imgType));
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }
}
