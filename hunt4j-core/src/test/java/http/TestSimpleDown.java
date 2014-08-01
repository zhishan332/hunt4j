package http;

import com.yermoon.hunt4j.core.http.SimpleDownLoader;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestSimpleDown {
    @Test
    public void testDownImg() {
        String str ="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/77/dinofanu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7b/dinochijing_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/4f/dinohejiu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0b/dinoyaoshoupa_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e1/dinochoumei_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b7/dinokunhuo_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7b/dinoxuyuan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/19/dinodagun_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/4e/yzwodao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e0/yzzhuangboli_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/77/yzlinyu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a4/yznani_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e8/yzhuanhu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e4/yzpaizhuozi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b8/yzguanglun_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/8a/yzwawajiao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/91/yzqiunile_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9b/yzfangun_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/22/yztouzhexiao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/66/yzye_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/32/yztouxiang_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2d/yzchoufeng_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7b/yzoye_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c1/yzsahua_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fd/yzbaozhentou_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ae/yzshuaishoujuan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6f/yzyoubianliangle_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f5/yzrenne_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9a/yzshaxixi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ac/yzza_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ba/yzzhaocaimao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/63/yzshanshanzi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/df/yzbune_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/cc/yzpaipigu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/be/yzweiquku_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f8/yztingge_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3f/yzchigua_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/70/yzhaowa_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fb/yzlaikankan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/eb/yzjiaotangwu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/99/yzfangpi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/87/yzchipingguo_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/61/yztaihaole_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/13/yzhaojinzhang_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e1/weisuo_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c9/tiaomei_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3c/tiaodou_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1c/qinerduo_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/32/meiyan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/32/maogepao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f0/jiongerduo_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/14/guilian_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fd/fangdian_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ea/beiju_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/78/touch_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/13/sweat_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/74/suprise_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0c/supcry_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5c/stareyes_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/8b/sleepy_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/75/sick_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ee/plus1_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/19/pipioye_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c6/muamua_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fd/mianchou_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/laugh_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d6/knead_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/38/jiong_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/53/honeyoye_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/happy_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/af/handkerchief_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6b/go_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a4/dizzy_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/af/cry_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a1/coverface_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ea/angery_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6f/886_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/07/byz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/46/ssz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e2/syz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/89/szz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6b/tpz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1e/txz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1b/spz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/62/cnz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3b/jnz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d2/jxz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/4a/leo2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/16/mjz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/09/txz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c1/tpz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d4/szz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7f/syz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5d/ssz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/00/spz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/da/mjz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/23/leo_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a3/jxz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/8d/jnz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/09/cnz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e0/byz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b8/aixincd_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/59/red_band_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9b/green_band_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/77/pink_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/03/zxhdese_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9a/xiaoheweixiao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/02/xiaoheweiqu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c1/xiaohetua_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/66/xiaoheshengqi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/08/xiaoheliubiti_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a0/xiaohekuqi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e3/xiaohehan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/44/xiaohefadai_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a8/xiaohebulini_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d4/xiaohebishi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c5/fanzao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c1/ciya_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e6/youqian_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/05/weixiao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c1/shuaibao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0a/shengqi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/19/shengbing_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/90/semimi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d1/pilao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/14/miao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/79/ku_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/76/kelian_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/75/jinzhang_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/dc/jingya_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/bb/jidong_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2b/jianqian_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7d/han_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/4e/fendou_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/09/xrdz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/cc/whh_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/90/tq_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d3/sjdj_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1d/q_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ec/pz_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7c/pp_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/4d/nh_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9f/mb2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/70/lg_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/34/lb_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/cd/lbs_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/05/kiss_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/86/kb_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e2/jgwb_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2b/hxgw_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c7/gx3_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/43/gg_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/4e/fd_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/19/fc_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fb/dy_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/fa/cn_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2f/cf_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/eb/ceg_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ee/cdyn_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5a/bz2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6e/bt_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/cf/bs3_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e8/bgws_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/64/bf_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b6/bdw_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/79/bco_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/1a/yeah_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5f/xh_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/5f/xd_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/53/wl_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b2/gx_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/09/gx2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/eb/gd_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/38/fn2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/31/d2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b0/bx_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/91/longniandx_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/78/daxiongzhadan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/07/daxiongxizao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ff/daxiongwozhua_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/4f/daxiongshuluo_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f5/daxiongshuaya_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/aa/daxiongsha_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c4/daxiongshai_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/45/daxiongpaomeiyan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7b/daxiongpaipaishou_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/10/daxiongoye_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/00/daxiongniu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7f/daxiongmeiyou_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/51/daxiongmaimeng_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b7/daxionglianhong_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ca/daxiongleibenxiong_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d7/daxiongjiayouxiong_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/daxiongjiaotache_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b9/daxionghuaxin_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/01/daxionghuanle_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/9f/daxionghuaban_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/57/daxiongdao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/70/daxiongchaoren_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/27/daxiongbao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/da/daxiongai_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3b/zy2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/ec/zs_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/17/wh2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/79/ts_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b1/q3_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/37/lb2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6a/kt_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/55/bya_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a2/bx2_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2c/kkxzhuan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c0/kkxyouhaoli_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/96/kkxwhat_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/07/kkxshengli_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/49/kkxqinqin_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/06/kkxposui_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/e3/kkxhaqian_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7e/kkxguzhang_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/2d/kkxdonggan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/93/kkxding_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/54/kxzhayan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/c5/kxweixiao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d5/kxweiqu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/46/kxwanpi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/b5/kxnu_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/db/kxkuqi_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/eb/kxjiong_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/f8/kxhuaixiao_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6f/kxhan_org.gif%" +
                "http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/0a/kxdiantou_org.gif%";
        String[] dd = str.split("%");
        SimpleDownLoader simpleDownLoader = new SimpleDownLoader(1);
        String path ="D:\\programs\\nginx-1.5.9\\html\\hunter\\emotion\\";
        for (String ss : dd) {
            if (ss == null || ss.trim().equals("")) continue;
            Pattern pp= Pattern.compile("normal/.*/(.*gif)");
            Matcher m = pp.matcher(ss);
            if(m.find()){
                String name=m.group(1);
                String pt=path+name;
                try {
                    simpleDownLoader.downLoad(ss, pt, 10);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void  test2(){
        Pattern pp= Pattern.compile("normal/.*/(.*gif)");
        String name="http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/6d/zhh_org.gif";
        Matcher m = pp.matcher(name);
        if(m.find()){
            System.out.println(m.group(1));
        }
    }
}
