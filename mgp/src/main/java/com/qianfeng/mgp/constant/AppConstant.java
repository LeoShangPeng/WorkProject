package com.qianfeng.mgp.constant;

public class AppConstant {
    public static String BASE_URL = "http://mobileapi.72g.com/index.php?tp=andv4/";
    /**
     * 积分100
     */
    public static String HOME_JFENG_URL = "index_new&op=jifen&point=100";
    /**
     * 广告
     */
    public static String HOME_BANNER_URL = "index_new&op=banner";
    /**
     * 达人推荐
     */
    public static String HOME_RECOMMEND_URL = "index_new&op=recommand";
    /**
     * 热点
     */
    public static String HOME_HOT_URL = "index_new&tp=andv4/gift3&op=hot";
    /**
     * 活动
     * http://mobileapi.72g.com/index.php?tp=andv4/activity&op=actindex
     */
    public static String HOME_ACTINDEX_URL = "activity&op=actindex";
    /**
     * 大神圈 list数据源
     */
    public static String MANITO_LIST_URL = "/quan&op=qinfo";
    /**
     * 大神圈headurl
     */
    public static String MANITO_HEAD_URL = "banner&op=get&pos=7";

    public static String JI_FENG_UPDATE_URL = "index_new&op=jifen&point=100&compare=0fc734030f398bd9187279687632fa19";

    public static String getUrl(String url) {
        return BASE_URL + url;
    }

}
