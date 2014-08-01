<%@ page import="com.yermoon.server.entity.Page" %>
<%@ page import="com.yermoon.server.helper.PageHelper" %>
<%@ page import="org.apache.commons.lang.time.DateFormatUtils" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: yfwangqing
  Date: 14-5-19
  Time: 下午3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../statics/all.css"/>
    <link href="../../statics/page-bar.css" rel="stylesheet" type="text/css"/>
    <%--<link href='http://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>--%>
    <title>图豹-服务器</title>

</head>
<body>

<div class="findbox">
    <span class="glow in tlt logospan">图豹</span>
    <%
        String key = URLDecoder.decode(request.getParameter("keyword") == null ? "" : request.getParameter("keyword"), "utf-8");
    %>
    <input type="text" class="search" id="key" value="<%=key%>">
    <input type="hidden" id="page"
           value="<%=Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"))%>">
    <input type="hidden" id="total" value="<%=request.getAttribute("total")%>">
    <input id="su1" class="btn" type="button" onclick="find()" value="搜索一下">
    <input type="button" value="全部删除" id="delAllBtn">
</div>
<div class="reslist">
    <ul class="resul">
        <%
            List<Page> pages = (List<Page>) request.getAttribute("data");
            if (pages != null) {
                for (Page data : pages) {
                    int id = data.getId();
                    String title = data.getTitle();
                    int num = data.getImgNum();
                    String numStr = " [" + num + "P]";
                    String desc = "";
                    String url = "";
                    if (title.length() > 44) title = title.substring(0, 44) + "src/test";
                    title = PageHelper.addStrongTag(title, key);
                    desc = PageHelper.addStrongTag(desc, key);
                    if (desc.length() > 100) desc = desc.substring(0, 100) + "..";
                    if (url.length() > 100) url = url.substring(0, 100);
                    String date = DateFormatUtils.format(data.getUdate(), "yyyy-MM-dd hh:mm");

        %>
        <li>
            <h3><a href="<%=url%>" target='_blank'><%=title%>
            </a><span class="num_s"><%=numStr%></span>
                <input type="button" value="删除" name="delBtn" id="<%=id%>"/>
            </h3>

            <p class='desc'><%=desc%>
            </p>
            <cite><%=url%>
            </cite>
            <cite><%=date%>
            </cite>
        </li>
        <% }
        } %>
    </ul>
    <div style="width: 660px;float: left;margin-bottom: 10px">
        <div id="pageBarDiv" class="tbl-n"></div>
    </div>
</div>
</body>
<script src="../../statics/jquery-1.7.2.min.js"></script>
<script src="../../statics/jquery.blockUI.js"></script>
<script src="../../statics/jcamera.js"></script>
<script type="text/javascript" src="../../statics/page-bar.js"></script>
<script type="text/javascript">
    var start = $('#page').val();
    var total = $('#total').val();
    $(function () {
        $('#key').keydown(function (e) {
            if (e.keyCode == 13) {
                find();
            }
        });
        $("input[name='delBtn']").click(function () {
            var id = $(this).attr("id");
            var ids=[];
            ids.push(id);
            $.ajax({
                type: "POST",
                url: "delPage.do",
                data: {ids:ids},
                dataType: "json",
                success: function (data) {
                    var sta = data['status'];
                    var num = data['num'];
                    alert(sta);
                    alert(num);
                }
            });
        });
        $("#delAllBtn").click(function () {
            var id = $(this).attr("id");
            alert(id);
        });
        var count_num = Math.ceil(total / 10);
        var pageParam = {};
        pageParam.totalRow = total;
        pageParam.currentPage = start;
        pageParam.totalPage = count_num;
        PageBar.fillHtml("gofind", "pageBarDiv", pageParam);//填充分页框
    });
    function gofind(page) {
        var key = $('#key').val();
        key = encodeURI(key);
        window.location.href = "search.do?keyword=" + key + "&page=" + page;
    }
    function find() {
        var key = $('#key').val();
        key = encodeURI(key);
        window.location.href = "search.do?keyword=" + key + "&page=1";
    }
</script>
</html>