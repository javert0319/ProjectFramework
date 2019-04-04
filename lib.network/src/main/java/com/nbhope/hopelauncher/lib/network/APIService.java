package com.nbhope.hopelauncher.lib.network;

import com.nbhope.hopelauncher.lib.network.bean.movie.MovieCelebrityInfoBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieCelebrityPhotosBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieCelebrityWorksBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieComingSoonBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieInTheatersBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieNewMoviesBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieSearchByQueryBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieSearchByTagBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieSubjectCommentsBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieSubjectInfoBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieSubjectPhotosBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieSubjectReviewsBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieTop250Bean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieUsBoxBean;
import com.nbhope.hopelauncher.lib.network.bean.movie.MovieWeeklyBean;
import com.nbhope.hopelauncher.lib.network.bean.music.MusicBannerInfo;
import com.nbhope.hopelauncher.lib.network.bean.music.MusicMoreListBean;
import com.nbhope.hopelauncher.lib.network.bean.response.BaseListResponse;
import com.nbhope.hopelauncher.lib.network.bean.response.BaseResponse;
import java.util.Map;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 豆瓣电影 API 官方地址：https://developers.douban.com/wiki/?title=movie_v2
 */
public interface APIService {

    @Multipart
    @POST("/hopeApi/device/status")
    Observable<BaseResponse> uploadStatus(@PartMap Map<String, RequestBody> options);

    @Multipart
    @POST("/hopeApi/platform/image")
    Observable<BaseListResponse<Object, MusicBannerInfo>> adsInfo(@PartMap Map<String, RequestBody> options);

    @Multipart
    @POST("/hopeApi/music/slist")
    Flowable<BaseListResponse<Object, MusicMoreListBean>> qureyResourcePage(@PartMap Map<String, RequestBody> options);

    /* 电影条目 */

    /**
     * 电影条目信息
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * city：所在城市，例如北京、上海等
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：http://api.douban.com/v2/movie/subject/26004132?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：http://api.douban.com/v2/movie/subject/26004132?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&client=&udid=
     */
    @GET("subject/{movieId}")
    Observable<MovieSubjectInfoBean> getMovieSubjectInfo(@Path("movieId") String movieId,
                                                         @Query("apikey") String apikey);

    /**
     * 电影条目剧照
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/subject/26004132/photos?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/subject/26004132/photos?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=100&client=&udid=
     */
    @GET("subject/{movieId}/photos")
    Observable<MovieSubjectPhotosBean> getMovieSubjectPhotos(@Path("movieId") String movieId,
                                                             @Query("apikey") String apikey);

    /**
     * 电影条目长评
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/subject/26004132/reviews?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/subject/26004132/reviews?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=20&client=&udid=
     */
    @GET("subject/{movieId}/reviews")
    Observable<MovieSubjectReviewsBean> getMovieSubjectReviews(@Path("movieId") String movieId,
                                                               @Query("apikey") String apikey);

    /**
     * 电影条目短评
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/subject/26004132/comments?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/subject/26004132/comments?apikey=0b2bdeda43b5688921839c8ecb20399b&count=20&client=&udid=
     */
    @GET("subject/{movieId}/comments")
    Observable<MovieSubjectCommentsBean> getMovieSubjectComments(@Path("movieId") String movieId,
                                                                 @Query("apikey") String apikey);

    /* 影人条目 */

    /**
     * 影人条目信息
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     *
     * 全：https://api.douban.com/v2/movie/celebrity/1044707?apikey=0b2bdeda43b5688921839c8ecb20399b
     */
    @GET("celebrity/{celebrityId}")
    Observable<MovieCelebrityInfoBean> getMovieCelebrityInfo(@Path("celebrityId") String celebrityId,
                                                             @Query("apikey") String apikey);

    /**
     * 影人剧照
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     *
     * 全：https://api.douban.com/v2/movie/celebrity/1044707/photos?apikey=0b2bdeda43b5688921839c8ecb20399b
     */
    @GET("celebrity/{celebrityId}/photos")
    Observable<MovieCelebrityPhotosBean> getMovieCelebrityPhotos(@Path("celebrityId") String celebrityId,
                                                                 @Query("apikey") String apikey);

    /**
     * 影人作品
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     *
     * 全：https://api.douban.com/v2/movie/celebrity/1044707/works?apikey=0b2bdeda43b5688921839c8ecb20399b
     */
    @GET("celebrity/{celebrityId}/works")
    Observable<MovieCelebrityWorksBean> getMovieCelebrityWorks(@Path("celebrityId") String celebrityId,
                                                               @Query("apikey") String apikey);

    /* 搜索 */

    /**
     * 电影搜索
     *
     * q:字符串
     * tag:标签
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     *
     * 全：https://api.douban.com/v2/movie/search?q=张艺谋&apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=10
     * 全：https://api.douban.com/v2/movie/search?tag=喜剧&apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=10
     */
    // 根据字段搜索
    @GET("search")
    Observable<MovieSearchByQueryBean> getMovieSearchByQuery(@Query("q") String q,
                                                             @Query("apikey") String apikey,
                                                             @Query("start") int start,
                                                             @Query("count") int count);

    // 根据标签搜索
    @GET("search")
    Observable<MovieSearchByTagBean> getMovieSearchByTag(@Query("tag") String tag,
                                                         @Query("apikey") String apikey,
                                                         @Query("start") int start,
                                                         @Query("count") int count);

    /* 榜单 */

    /**
     * 正在热映
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * city：所在城市，例如北京、上海等
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=&udid=
     */
    @GET("in_theaters")
    Flowable<MovieInTheatersBean> getMovieInTheaters(@Query("apikey") String apikey,
                                                        @Query("start") int index,
                                                       @Query("count") int count);

    @Multipart
    @POST("/in_theaters")
    Flowable<BaseListResponse<Object, MovieInTheatersBean>> loadMovieInTheaters(@PartMap Map<String, RequestBody> options);

    /**
     * 即将上映
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * city：所在城市，例如北京、上海等
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/coming_soon?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/coming_soon?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=&udid=
     */
    @GET("coming_soon")
    Observable<MovieComingSoonBean> getMovieComingSoon(@Query("apikey") String apikey);

    /**
     * Top250
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * city：所在城市，例如北京、上海等
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/top250?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/top250?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=&udid=
     */
    @GET("top250")
    Observable<MovieTop250Bean> getMovieTop250(@Query("apikey") String apikey);

    /**
     * 口碑榜
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * city：所在城市，例如北京、上海等
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/weekly?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/weekly?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&client=&udid=
     */
    @GET("weekly")
    Observable<MovieWeeklyBean> getMovieWeekly(@Query("apikey") String apikey);

    /**
     * 北美票房榜
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/us_box?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/us_box?apikey=0b2bdeda43b5688921839c8ecb20399b&client=&udid=
     */
    @GET("us_box")
    Observable<MovieUsBoxBean> getMovieUsBox(@Query("apikey") String apikey);

    /**
     * 新片榜
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/new_movies?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/new_movies?apikey=0b2bdeda43b5688921839c8ecb20399b&client=&udid=
     */
    @GET("new_movies")
    Observable<MovieNewMoviesBean> getMovieNewMovies(@Query("apikey") String apikey);
}
