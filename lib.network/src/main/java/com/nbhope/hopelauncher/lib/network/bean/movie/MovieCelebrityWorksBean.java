package com.nbhope.hopelauncher.lib.network.bean.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 影人作品
 *
 * Created by Tnno Wu on 2018/01/30.
 */

public class MovieCelebrityWorksBean {

    private int count;
    private int start;
    private CelebrityBean celebrity;
    private int total;
    private List<WorksBean> works;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public CelebrityBean getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(CelebrityBean celebrity) {
        this.celebrity = celebrity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<WorksBean> getWorks() {
        return works;
    }

    public void setWorks(List<WorksBean> works) {
        this.works = works;
    }

    public static class CelebrityBean {

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class WorksBean {

        private SubjectBean subject;
        private List<String> roles;

        public SubjectBean getSubject() {
            return subject;
        }

        public void setSubject(SubjectBean subject) {
            this.subject = subject;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public static class SubjectBean {

            private RatingBean rating;
            private String title;
            private String collect_count;
            private String mainland_pubdate;
            private boolean has_video;
            private String original_title;
            private String subtype;
            private String year;
            private ImagesBean images;
            private String alt;
            private String id;
            private List<String> genres;
            private List<CastsBean> casts;
            private List<?> durations;
            private List<?> directors;
            private List<?> pubdates;

            public RatingBean getRating() {
                return rating;
            }

            public void setRating(RatingBean rating) {
                this.rating = rating;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCollect_count() {
                return collect_count;
            }

            public void setCollect_count(String collect_count) {
                this.collect_count = collect_count;
            }

            public String getMainland_pubdate() {
                return mainland_pubdate;
            }

            public void setMainland_pubdate(String mainland_pubdate) {
                this.mainland_pubdate = mainland_pubdate;
            }

            public boolean isHas_video() {
                return has_video;
            }

            public void setHas_video(boolean has_video) {
                this.has_video = has_video;
            }

            public String getOriginal_title() {
                return original_title;
            }

            public void setOriginal_title(String original_title) {
                this.original_title = original_title;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public ImagesBean getImages() {
                return images;
            }

            public void setImages(ImagesBean images) {
                this.images = images;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<String> getGenres() {
                return genres;
            }

            public void setGenres(List<String> genres) {
                this.genres = genres;
            }

            public List<CastsBean> getCasts() {
                return casts;
            }

            public void setCasts(List<CastsBean> casts) {
                this.casts = casts;
            }

            public List<?> getDurations() {
                return durations;
            }

            public void setDurations(List<?> durations) {
                this.durations = durations;
            }

            public List<?> getDirectors() {
                return directors;
            }

            public void setDirectors(List<?> directors) {
                this.directors = directors;
            }

            public List<?> getPubdates() {
                return pubdates;
            }

            public void setPubdates(List<?> pubdates) {
                this.pubdates = pubdates;
            }

            public static class RatingBean {

                private String max;
                private String average;
                private DetailsBean details;
                private String stars;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getAverage() {
                    return average;
                }

                public void setAverage(String average) {
                    this.average = average;
                }

                public DetailsBean getDetails() {
                    return details;
                }

                public void setDetails(DetailsBean details) {
                    this.details = details;
                }

                public String getStars() {
                    return stars;
                }

                public void setStars(String stars) {
                    this.stars = stars;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }

                public static class DetailsBean {

                    @SerializedName("1")
                    private int _$1;
                    @SerializedName("2")
                    private int _$2;
                    @SerializedName("3")
                    private int _$3;
                    @SerializedName("4")
                    private int _$4;
                    @SerializedName("5")
                    private int _$5;

                    public int get_$1() {
                        return _$1;
                    }

                    public void set_$1(int _$1) {
                        this._$1 = _$1;
                    }

                    public int get_$2() {
                        return _$2;
                    }

                    public void set_$2(int _$2) {
                        this._$2 = _$2;
                    }

                    public int get_$3() {
                        return _$3;
                    }

                    public void set_$3(int _$3) {
                        this._$3 = _$3;
                    }

                    public int get_$4() {
                        return _$4;
                    }

                    public void set_$4(int _$4) {
                        this._$4 = _$4;
                    }

                    public int get_$5() {
                        return _$5;
                    }

                    public void set_$5(int _$5) {
                        this._$5 = _$5;
                    }
                }
            }

            public static class ImagesBean {

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }

            public static class CastsBean {

                private AvatarsBeanX avatars;
                private String name_en;
                private String name;
                private String alt;
                private String id;

                public AvatarsBeanX getAvatars() {
                    return avatars;
                }

                public void setAvatars(AvatarsBeanX avatars) {
                    this.avatars = avatars;
                }

                public String getName_en() {
                    return name_en;
                }

                public void setName_en(String name_en) {
                    this.name_en = name_en;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAlt() {
                    return alt;
                }

                public void setAlt(String alt) {
                    this.alt = alt;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public static class AvatarsBeanX {

                    private String small;
                    private String large;
                    private String medium;

                    public String getSmall() {
                        return small;
                    }

                    public void setSmall(String small) {
                        this.small = small;
                    }

                    public String getLarge() {
                        return large;
                    }

                    public void setLarge(String large) {
                        this.large = large;
                    }

                    public String getMedium() {
                        return medium;
                    }

                    public void setMedium(String medium) {
                        this.medium = medium;
                    }
                }
            }
        }
    }
}
