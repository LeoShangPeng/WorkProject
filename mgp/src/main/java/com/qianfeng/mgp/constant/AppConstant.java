package com.qianfeng.mgp.constant;

public class AppConstant {

    /**
     * 基本的url
     */
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

    /**
     * 活动url
     */
    //    http://mobileapi.72g.com/index.php?tp=andv4/actinfo&op=actlist
    public static final String ACTINFO_LIST_URL = "actinfo&op=actlist";

    /**
     * 本地数据库升级的url
     */
    public static String JI_FENG_UPDATE_URL = "index_new&op=jifen&point=100&compare=0fc734030f398bd9187279687632fa19";
    /**
     *
     */
    public static final String CLASSIFY_GRID_URL = "game3&op=classify";

    //    http://mobileapi.72g.com/index.php?tp=andv4/game3&op=newlist&type=1&order     =integral
    public static final String CLASSIFY_TYPE_URL = "game3&op=newlist&type=1&order=integral";

    /**
     * 获得好评差评数
     */
    public static final String GOOD_BAD_URL = "game3&op=gb_qan&id=";
    /**
     * 详情界面礼包
     * http://mobileapi.72g.com/index.php?tp=andv4/gift3&op=virlist&gifttype=1&gameid=1300
     */
    public static final String GIFT_LIST_URL = "gift3&op=virlist&gifttype=1&gameid=";
    /**
     * 详情界面专区
     */
    public static final String DETAIL_URL = "game3&op=detail&id=";


    /**
     * 评论
     * http://mobileapi.72g.com/index.php?tp=andv4/comment&op=list&id=1799&page=1
     */
    public static final String COMMENT_URL = "";

    /**
     * 下载最多
     *
     * @param url
     * @return
     */
//    http://mobileapi.72g.com/index.php?tp=andv4/game3&op=newlist&type=1&order=mdown&page=6

    /**
     *
     * 热门推荐
     * @param url
     * @return
     *
     */
//    http://mobileapi.72g.com/index.php?tp=andv4/game3&op=newlist&type=1&order=rmtj&page=3

    /**
     * 金币最多
     *
     * @param url
     * @return
     */

//    http://mobileapi.72g.com/index.php?tp=andv4/game3&op=newlist&type=2&order=integral&page=7
    public static String getUrl(String url) {
        return BASE_URL + url;
    }


    /**
     * 获取分类子项的Url
     *
     * @param type
     * @return
     */
    public static String getTypeUrl(String type, String order, int page) {
        return new StringBuffer("game3&op=newlist&type=").append(type).append("&order=").append(order).append("&page=").append(page).toString();
    }

    /**
     * 获取好玩,不好玩 数据
     *
     * @param id
     * @return
     */
    public static String getGoodBadUrl(String id) {
        return GOOD_BAD_URL + id;
    }

    /**
     * 获取详情界面url
     *
     * @param id
     * @return
     */
    public static String getDetailUrl(String id) {
        return BASE_URL + DETAIL_URL + id;
    }

    /**
     * 图片sd卡文件夹
     */
    public static final String APP_CACHE = "1411";

    public static final String SYS_CACHE = "com.qianfeng.gz1411project";

    public static final String IMAGE_CACHE = "image";

    public static final String SUCCESS = "success";


}
