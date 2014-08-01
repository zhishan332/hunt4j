import com.yermoon.server.helper.PageHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestRgx {
    public static void main(String[] args) {
//        String regEx = "douban.com/group/topic/.*";
//        Pattern pat = Pattern.compile(regEx);
//        Matcher dd = pat.matcher("http://www.douban.com/group/topicr/53336307/");
//        if(dd.find()){
//            System.out.println("能找到");
//        }else{
//            System.out.println("找不到！！");
//        }
        String str="<!DOCTYPE html>\n" +
                "<html lang=\"zh-CN\" class=\"ua-windows ua-ff30\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "    <meta name=\"renderer\" content=\"webkit\">\n" +
                "\n" +
                "    <title>\n" +
                "    分手快乐\n" +
                "</title>\n" +
                "    \n" +
                "    \n" +
                "    <meta http-equiv=\"Pragma\" content=\"no-cache\">\n" +
                "    <meta http-equiv=\"Expires\" content=\"Sun, 6 Mar 2005 01:00:00 GMT\">\n" +
                "            <li>\n" +
                "            <a href=\"http://music.douban.com/\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-music&#34;,&#34;uid&#34;:&#34;0&#34;}\">音乐</a>\n" +
                "            </li>\n" +
                "          \n" +
                "            \n" +
                "            <li>\n" +
                "            <a href=\"http://www.douban.com/location/\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-location&#34;,&#34;uid&#34;:&#34;0&#34;}\">同城</a>\n" +
                "            </li>\n" +
                "          \n" +
                "            \n" +
                "            <li class=\"on\">\n" +
                "            <a href=\"http://www.douban.com/group/\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-group&#34;,&#34;uid&#34;:&#34;0&#34;}\">小组</a>\n" +
                "            </li>\n" +
                "          \n" +
                "            \n" +
                "            <li>\n" +
                "            <a href=\"http://read.douban.com/?dcs=top-nav&amp;dcm=douban\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-read&#34;,&#34;uid&#34;:&#34;0&#34;}\">阅读</a>\n" +
                "            </li>\n" +
                "          \n" +
                "            \n" +
                "            <li>\n" +
                "            <a href=\"http://douban.fm/\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-fm&#34;,&#34;uid&#34;:&#34;0&#34;}\">豆瓣FM</a>\n" +
                "            </li>\n" +
                "          \n" +
                "            \n" +
                "            <li>\n" +
                "            <a href=\"http://dongxi.douban.com/?dcs=top-nav&amp;dcm=douban\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-commodity&#34;,&#34;uid&#34;:&#34;0&#34;}\">东西</a>\n" +
                "            </li>\n" +
                "          \n" +
                "            <li>\n" +
                "              <a href=\"#more\" class=\"bn-more\"><span>更多</span></a>\n" +
                "              <div class=\"more-items\">\n" +
                "                <table cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                    \n" +
                "                    <tr><td><a href=\"http://9.douban.com\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-9&#34;,&#34;uid&#34;:&#34;0&#34;}\">九点</a></td></tr>\n" +
                "                    \n" +
                "                    <tr><td><a href=\"http://alphatown.com\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-town&#34;,&#34;uid&#34;:&#34;0&#34;}\">阿尔法城</a></td></tr>\n" +
                "                    \n" +
                "                    <tr><td><a href=\"http://www.douban.com/mobile/\" target=\"_blank\" data-moreurl-dict=\"{&#34;from&#34;:&#34;top-nav-click-mobile&#34;,&#34;uid&#34;:&#34;0&#34;}\">移动应用</a></td></tr>\n" +
                "                </table>\n" +
                "              </div>\n" +
                "            </li>\n" +
                "      </ul>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "      <li><a href=\"http://www.douban.com/group/explore\">精选</a></li>\n" +
                "      <li><a href=\"http://www.douban.com/group/explore/culture\">文化</a></li>\n" +
                "      <li><a href=\"http://www.douban.com/group/explore/travel\">行摄</a></li>\n" +
                "      <li><a href=\"http://www.douban.com/group/explore/ent\">娱乐</a></li>\n" +
                "      <li><a href=\"http://www.douban.com/group/explore/fashion\">时尚</a></li>\n" +
                "      <li><a href=\"http://www.douban.com/group/explore/life\">生活</a></li>\n" +
                "      <li><a href=\"http://www.douban.com/group/explore/tech\">科技</a></li>\n" +
                "   </ul>\n" +
                "   </div>\n" +
                "\n" +
                "    <div class=\"nav-search\">\n" +
                "      <form id='form' action=\"http://www.douban.com/group/search\" method=\"get\">\n" +
                "        <fieldset>\n" +
                "          <legend>搜索：</legend>\n" +
                "          \n" +
                "          <input type=\"hidden\" name=\"cat\" value=\"1019\" />\n" +
                "          <label for=\"inp-query\">小组、话题</label>\n" +
                "          <div class=\"inp\"><input id=\"inp-query\" name=\"q\" size=\"22\" maxlength=\"60\" value=\"\"></div>\n" +
                "          <div class=\"inp-btn\"><input type=\"submit\" value=\"搜索\"></div>\n" +
                "        </fieldset>\n" +
                "      </form>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  </div>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<script>\n" +
                "Do(function(){\n" +
                "  var nav = $('#db-nav-group');\n" +
                "  var inp=$(\"#inp-query\"),label=inp.closest(\".nav-search\").find(\"label\");if(\"placeholder\" in inp[0]){label.hide();inp.attr(\"placeholder\",label.text())}else{if(inp.val()!==\"\"){label.hide()}inp.parent().click(function(){inp.focus();label.hide()}).end().focusin(function(){label.hide()}).focusout(function(){if($.trim(this.value)===\"\"){label.show()}else{label.hide()}}).keydown(function(){label.hide()})}inp.parents(\"form\").submit(function(){if(!$.trim(inp.val()).length){return false}});nav.find(\".lnk-more, .lnk-account\").click(function(b){b.preventDefault();var d,a=$(this),c=a.hasClass(\"lnk-more\")?$(\"#db-productions\"):$(\"#db-usr-setting\");if(!c.data(\"init\")){d=a.offset();c.css({\"margin-left\":(d.left-$(window).width()/2-c.width()+a.width()+parseInt(a.css(\"padding-right\"),10))+\"px\",left:\"50%\",top:d.top+a.height()+\"px\"});c.data(\"init\",1);c.hide();$(\"body\").click(function(g){var f=$(g.target);if(f.hasClass(\"lnk-more\")||f.hasClass(\"lnk-account\")||f.closest(\"#db-usr-setting\").length||f.closest(\"#db-productions\").length){return}c.hide()})}if(c.css(\"display\")===\"none\"){$(\".dropdown\").hide();c.show()}else{$(\".dropdown\").hide()}});\n" +
                "});\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    <div id=\"wrapper\">\n" +
                "        \n" +
                "                          <div class=\"clear\"></div>\n" +
                "                          \n" +
                "                          <p>\n" +
                "<br/>生日当天，把现男友变成了前任，是不是很作？\n" +
                "<br/>其实我只是想要一个平淡的爱情。我真的不介意他没车没房没钱，可是这个男人好高鹜远、不切实际，总觉得自己可以一步登天，事实上却是天天在家上网打游戏，晚上天天不睡觉就跟各种女生聊骚。\n" +
                "<br/>你有什么资格？！在一起那么久出门花的都是我的钱，凭什么还不能一心一意的对我好？！\n" +
                "<br/>\n" +
                "<br/>第四天\n" +
                "<br/>其实我还好\n" +
                "<br/>张嘉佳说“很多人随随便便就相遇，欢天喜地走下去。想想那时我们为什么会分开，可能因为太用力，于是没有了好运气。”\n" +
                "<br/>大概我们就是这样，所以一直没能遇见对的那个人。这一路走来，跌跌撞撞、伤痕累累。\n" +
                "<br/>\n" +
                "<br/></p>\n" +
                "<br/>昨天晚上失眠了\n" +
                "<br/>倒不是因为难过，也没有想不开\n" +
                "<br/>分开一年多的EEX昨天联系我了，突然就心跳加速，真的太久没有这种感觉了。不得不承认的是，这一年多的时间我遇到过许多男生，喜欢我的，我喜欢的，可是都没有跟他在一起的那种心跳。\n" +
                "<br/>那个曾经让我奋不顾身的人，是不是这辈子除了他再也不会遇到这样一个人了。\n" +
                "<br/>\n" +
                "<br/>心一跳，爱就开始煎熬。\n" +
                "<br/></p>\n" +
                "                          \n" +
                "                          <div class=\"topic-figure cc\">\n" +
                "                              <img src=\"http://img5.douban.com/view/group_topic/large/public/p14990236.jpg\" alt=\"\" class=\"\">\n" +
                "                          </div>\n" +
                "                          <div class=\"clear\"></div>\n" +
                "                          \n" +
                "                          <div class=\"topic-figure cc\">\n" +
                "                              <img src=\"http://img3.douban.com/view/group_topic/large/public/p14991072.jpg\" alt=\"\" class=\"\">\n" +
                "                          </div>\n" +
                "                          <div class=\"clear\"></div>\n" +
                "                          \n" +
                "  喜欢\n" +
                "</span>\n" +
                "\n" +
                "    <a class=\"fav-add btn-fav j a_show_login\" title=\"标为喜欢？\" href=\"http://www.douban.com/accounts/register?reason=like\" data-tid=\"54006354\" data-tkind=\"1013\">喜欢</a>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<!--- douban ad begin -->\n" +
                "<div id=\"dale_group_special3\"></div>\n" +
                "<!--- douban ad end -->\n" +
                "\n" +
                "<div class=\"tabs\" id='reviews'>\n" +
                "  <a href=\"http://www.douban.com/group/topic/54006354/#sep\" class=on>回应</a>\n" +
                "    <a href=\"http://www.douban.com/group/topic/54006354/?type=rec#sep\" >推荐</a>\n" +
                "  <a href=\"http://www.douban.com/group/topic/54006354/?type=like#sep\" >喜欢</a>\n" +
                "\n" +
                "        <span style=\"float:right\">\n" +
                "            <a href=\"http://www.douban.com/group/topic/54006354/?author=1#sep\">只看楼主</a>\n" +
                "        </span>\n" +
                "</div>\n" +
                "    \n" +
                "\n" +
                "                        \n" +
                "\n" +
                "                    \n" +
                "    <ul class=\"topic-reply\" id=\"comments\">\n" +
                "        \n" +
                "\n" +
                "<li class=\"clearfix comment-item\" id=\"689651696\" data-cid=\"689651696\" >\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</li>\n" +
                "\n" +
                "        \n" +
                "\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</li>\n" +
                "\n" +
                "        \n" +
                "\n" +
                "<li class=\"clearfix comment-item\" id=\"689652722\" data-cid=\"689652722\" >\n" +
                "    <div class=\"user-face\">\n" +
                "        <a href=\"http://www.douban.com/group/people/mikomiko614/\"><img class=\"pil\" src=\"http://img3.douban.com/icon/u49675888-6.jpg\" alt=\"๓苦情人\"/></a>\n" +
                "    </div>\n" +
                "    <div class=\"reply-doc content\" style=\"padding-left:0px;\">\n" +
                "        <div class=\"bg-img-green\">\n" +
                "          <h4>\n" +
                "              <a href=\"http://www.douban.com/group/people/mikomiko614/\" class=\"\">๓苦情人</a> (伊人已去，君心可晴？)\n" +
                "              <span class=\"pubtime\">2014-06-15 11:52:22</span>\n" +
                "          </h4>\n" +
                "        </div>\n" +
                "        \n" +
                "        <div class=\"reply-quote\">\n" +
                "            <span class=\"short\">你是我的小呀小苹果儿</span>\n" +
                "            <span class=\"all\">你是我的小呀小苹果儿</span>\n" +
                "        <a href=\"#\" class=\"toggle-reply\">\n" +
                "        </a><span class=\"pubdate\"><a href=\"http://www.douban.com/group/people/85225264/\">花骨</a></span></div>\n" +
                "        <p class=\"\">？？？</p>\n" +
                "\n" +
                "        <div class=\"operation_div\" id=\"49675888\">\n" +
                "            <div class=\"operation-more\">\n" +
                "                <a rel=\"nofollow\" href=\"javascript:void(0);\" data-cid=\"689652722\" class=\"lnk-delete-comment\" title=\"真的要删除๓苦情人的发言?\">删除</a>\n" +
                "            </div>\n" +
                "            <a rel=\"nofollow\" href=\"javascript:void(0);\" class=\"comment-vote lnk-fav\">赞</a>\n" +
                "            <a href=\"http://www.douban.com/group/topic/54006354/?cid=689652722#last\" class=\"lnk-reply\">回应</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</li>\n" +
                "\n" +
                "        \n" +
                "\n" +
                "<li class=\"clearfix comment-item\" id=\"689653428\" data-cid=\"689653428\" >\n" +
                "    <div class=\"user-face\">\n" +
                "\n" +
                "<li class=\"clearfix comment-item\" id=\"689654875\" data-cid=\"689654875\" >\n" +
                "    <div class=\"user-face\">\n" +
                "        <a href=\"http://www.douban.com/group/people/mikomiko614/\"><img class=\"pil\" src=\"http://img3.douban.com/icon/u49675888-6.jpg\" alt=\"๓苦情人\"/></a>\n" +
                "    </div>\n" +
                "    <div class=\"reply-doc content\" style=\"padding-left:0px;\">\n" +
                "        <div class=\"bg-img-green\">\n" +
                "          <h4>\n" +
                "              <a href=\"http://www.douban.com/group/people/mikomiko614/\" class=\"\">๓苦情人</a> (伊人已去，君心可晴？)\n" +
                "              <span class=\"pubtime\">2014-06-15 11:56:33</span>\n" +
                "          </h4>\n" +
                "        </div>\n" +
                "        \n" +
                "        <div class=\"reply-quote\">\n" +
                "            <span class=\"short\">现在女的喜欢这样的男的？</span>\n" +
                "            <span class=\"all\">现在女的喜欢这样的男的？</span>\n" +
                "        <a href=\"#\" class=\"toggle-reply\">\n" +
                "        </a><span class=\"pubdate\"><a href=\"http://www.douban.com/group/people/88879957/\">左手那个标记</a></span></div>\n" +
                "        <p class=\"\">我也不知道当时怎么就鬼迷心窍的跟他在一起了。刚认识的时候我真就觉得跟这种天天上网打游戏的男的不可能。</p>\n" +
                "\n" +
                "        <div class=\"operation_div\" id=\"49675888\">\n" +
                "            <div class=\"operation-more\">\n" +
                "                <a rel=\"nofollow\" href=\"javascript:void(0);\" data-cid=\"689654875\" class=\"lnk-delete-comment\" title=\"真的要删除๓苦情人的发言?\">删除</a>\n" +
                "            </div>\n" +
                "            <a rel=\"nofollow\" href=\"javascript:void(0);\" class=\"comment-vote lnk-fav\">赞</a>\n" +
                "            <a href=\"http://www.douban.com/group/topic/54006354/?cid=689654875#last\" class=\"lnk-reply\">回应</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</li>\n" +
                "\n" +
                "        \n" +
                "\n" +
                "<li class=\"clearfix comment-item\" id=\"689654979\" data-cid=\"689654979\" >\n" +
                "    <div class=\"user-face\">\n" +
                "        <a href=\"http://www.douban.com/group/people/mikomiko614/\"><img class=\"pil\" src=\"http://img3.douban.com/icon/u49675888-6.jpg\" alt=\"๓苦情人\"/></a>\n" +
                "    </div>\n" +
                "    <div class=\"reply-doc content\" style=\"padding-left:0px;\">\n" +
                "        <div class=\"bg-img-green\">\n" +
                "          <h4>\n" +
                "              <a href=\"http://www.douban.com/group/people/mikomiko614/\" class=\"\">๓苦情人</a> (伊人已去，君心可晴？)\n" +
                "              <span class=\"pubtime\">2014-06-15 11:56:44</span>\n" +
                "          </h4>\n" +
                "        </div>\n" +
                "        \n" +
                "        <div class=\"reply-quote\">\n" +
                "            <span class=\"short\">分手快乐，为了更好的下一个</span>\n" +
                "            <span class=\"all\">分手快乐，为了更好的下一个</span>\n" +
                "        <a href=\"#\" class=\"toggle-reply\">\n" +
                "        </a><span class=\"pubdate\"><a href=\"http://www.douban.com/group/people/29096984/\">袁小帅</a></span></div>\n" +
                "        <p class=\"\">谢谢</p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    <!-- douban ad end -->\n" +
                "\n" +
                "    \n" +
                "    \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "var _paq = _paq || [];\n" +
                "_paq.push(['trackPageView']);\n" +
                "_paq.push(['enableLinkTracking']);\n" +
                "(function() {\n" +
                "    var u=((\"https:\" == document.location.protocol) ? \"https\" : \"http\") + \"://fundin.douban.com/\";\n" +
                "    _paq.push(['setTrackerUrl', u+'piwik']);\n" +
                "    _paq.push(['setSiteId', '100001']);\n" +
                "    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0]; \n" +
                "    g.type='text/javascript';\n" +
                "    g.defer=true; \n" +
                "    g.async=true; \n" +
                "    g.src=u+'piwik.js'; \n" +
                "    s.parentNode.insertBefore(g,s);\n" +
                "})();\n" +
                "</script>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "var _gaq = _gaq || [];\n" +
                "_gaq.push(['_setAccount', 'UA-7019765-1']);\n" +
                "_gaq.push(['_addOrganic', 'baidu', 'word']);\n" +
                "_gaq.push(['_addOrganic', 'soso', 'w']);\n" +
                "_gaq.push(['_addOrganic', '3721', 'name']);\n" +
                "_gaq.push(['_addOrganic', 'youdao', 'q']);\n" +
                "_gaq.push(['_addOrganic', 'so.360.cn', 'q']);\n" +
                "_gaq.push(['_addOrganic', 'vnet', 'kw']);\n" +
                "_gaq.push(['_addOrganic', 'sogou', 'query']);\n" +
                "_gaq.push(['_addIgnoredOrganic', '豆瓣']);\n" +
                "_gaq.push(['_addIgnoredOrganic', 'douban']);\n" +
                "_gaq.push(['_addIgnoredOrganic', '豆瓣网']);\n" +
                "_gaq.push(['_addIgnoredOrganic', 'www.douban.com']);\n" +
                "_gaq.push(['_setDomainName', '.douban.com']);\n" +
                "\n" +
                "\n" +
                "    _gaq.push(['_setCustomVar', 1, 'responsive_view_mode', 'desktop', 3]); \n" +
                "\n" +
                "_gaq.push(['_trackPageview']);\n" +
                "_gaq.push(['_trackPageLoadTime']);\n" +
                "\n" +
                "window._ga_init = function() {\n" +
                "    var ga = document.createElement('script');\n" +
                "    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n" +
                "    ga.setAttribute('async', 'true');\n" +
                "    document.documentElement.firstChild.appendChild(ga);\n" +
                "};\n" +
                "if (window.addEventListener) {\n" +
                "    window.addEventListener('load', _ga_init, false);\n" +
                "} else {\n" +
                "    window.attachEvent('onload', _ga_init);\n" +
                "}\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    <!-- dis8-->\n" +
                "\n" +
                "            \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div id=\"g-popup-reg\" class=\"popup-reg\" style=\"display:none;\">\n" +
                "  <div class=\"bd\">\n" +
                "  \n" +
                "  <iframe src=\"about:blank\" frameborder=\"0\" scrolling=\"no\"></iframe>\n" +
                "    <a href=\"#\" class=\"lnk-close\">&times;</a>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"landing-bar\" style=\"display:none;\">\n" +
                "    <div class=\"bd\">\n" +
                "        <p>在这里发现跟你一样特别的人，并与之交流...</p>\n" +
                "        <div class=\"operation\">\n" +
                "            <a href=\"\" class=\"j a_show_register\">注册</a>\n" +
                "            <a href=\"\" class=\"j a_show_login\">登录</a>\n" +
                "        </div>\n" +
                "        \n" +
                "        \n" +
                "  \n" +
                "  <div class=\"item item-3rd\">\n" +
                "    <label>\n" +
                "    第三方登录：\n" +
                "    </label>\n" +
                "    <a target=\"_top\" href=\"http://www.douban.com/accounts/connect/qq/?from=group&amp;redir=http%3A//www.douban.com/accounts/join_and_redir%3Fgroup_id%3D407518\" class=\"item-qq\"><img src=\"http://img3.douban.com/pics/connect_qq.png\" title=\"QQ\"></a>\n" +
                "    <a target=\"_top\" href=\"http://www.douban.com/accounts/connect/sina_weibo/?from=group&amp;redir=http%3A//www.douban.com/accounts/join_and_redir%3Fgroup_id%3D407518&amp;fallback=http://www.douban.com/group/meituikong/\" class=\"item-weibo\"><img src=\"http://img3.douban.com/pics/connect_sina_weibo.png\" title=\"新浪微博\"></a>\n" +
                "  </div>\n" +
                "\n" +
                "        <a href=\"#\" class=\"lnk-close\">&times;</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <script>_SPLITTEST=''</script>\n" +
                "\n" +
                "<script>var _check_hijack = function () {\n" +
                "    var _sig = \"RS7wSHjh\", _login = false, bid = get_cookie('bid');\n" +
                "    if (location.protocol != \"file:\" && (\n" +
                "            typeof(bid) != \"string\" && _login ||\n" +
                "            typeof(bid) == \"string\" && bid.substring(0,8) != _sig)) {\n" +
                "        location.href += (/\\?/.test(location.href)?\"&\":\"?\") + (\n" +
                "                \"_r=\" + Math.random().toString(16).substring(2));\n" +
                "    }};\n" +
                "if (typeof(Do) != 'undefined') Do(_check_hijack);\n" +
                "else if (typeof(get_cookie) != 'undefined') _check_hijack();\n" +
                "</script></body>\n" +
                "\n" +
                "</html>\n" +
                "\n";
        System.out.println(PageHelper.removeAllBlank(PageHelper.delHTMLTag(str)));
    }


    /**
     * 功能：去掉所有的<*>标记,去除html标签
     *
     * @param content
     * @return
     */
    public static String removeTagFromText(String content) {
        Pattern p = null;
        Matcher m = null;
        String value = null;

        // 去掉<>标签
        p = Pattern.compile("(<[^>]*>)");
        m = p.matcher(content);
        String temp = content;
        while (m.find()) {
            value = m.group(0);
            temp = temp.replace(value, "");
        }

        // 去掉换行或回车符号
        p = Pattern.compile("(/r+|/n+)");
        m = p.matcher(temp);
        while (m.find()) {
            value = m.group(0);
            temp = temp.replace(value, " ");
            // System.out.println("....." + value);
        }

        return temp;
    }

}
