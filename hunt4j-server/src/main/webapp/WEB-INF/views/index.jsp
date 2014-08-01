<%--
  Created by IntelliJ IDEA.
  User: wangq
  Date: 14-5-17
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../statics/all.css"/>
    <title>控制台</title>
    <script type="text/javascript">
        function go(flag) {
            AjaxUtil.get("/go.do", {flag:flag}, function (resp) {
                if (resp == undefined || resp == null) {
                    alert("HTTP请求无数据返回！");
                    return;
                }
                if (resp.status == 1) {
                    var myDate = new Date();
                    myDate = myDate.toLocaleString() + " ";
                    switch (flag) {
                        case 0:
                            $('#oper_consle').append("<p>" + myDate + "页面分析处理<span style='color: green'>已启动<span></p>");
                            $('#oper_consle').append("<p>" + myDate + "页面任务处理<span style='color: green'>已启动<span></p>");
                            break;
                        case 1:
                            $('#oper_consle').append("<p>" + myDate + "页面分析处理<span style='color: green'>已启动<span></p>");
                            break;
                        case 2:
                            $('#oper_consle').append("<p>" + myDate + "页面任务处理<span style='color: green'>已启动<span></p>");
                            break;
                        default :
                            $('#oper_consle').append("<p>" + myDate + "页面分析处理<span style='color: green'>已启动<span></p>");
                            $('#oper_consle').append("<p>" + myDate + "页面任务处理<span style='color: green'>已启动<span></p>");
                            break;
                    }
                }
            })
        }
        function stop(flag) {
            AjaxUtil.get("/stop.do", {flag:flag}, function (resp) {
                if (resp == undefined || resp == null) {
                    alert("HTTP请求无数据返回！");
                    return;
                }
                if (resp.status == 1) {
                    var myDate = new Date();
                    myDate = myDate.toLocaleString() + " ";
                    switch (flag) {
                        case 0:
                            $('#oper_consle').append("<p>" + myDate + "页面分析处理<span style='color: red'>已关闭<span></p>");
                            $('#oper_consle').append("<p>" + myDate + "页面任务处理<span style='color: red'>已关闭<span></p>");
                            break;
                        case 1:
                            $('#oper_consle').append("<p>" + myDate + "页面分析处理<span style='color: red'>已关闭<span></p>");
                            break;
                        case 2:
                            $('#oper_consle').append("<p>" + myDate + "页面任务处理<span style='color: red'>已关闭<span></p>");
                            break;
                        default :
                            $('#oper_consle').append("<p>" + myDate + "页面分析处理<span style='color: red'>已关闭<span></p>");
                            $('#oper_consle').append("<p>" + myDate + "页面任务处理<span style='color: red'>已关闭<span></p>");
                            break;
                    }
                }
            })
        }
    </script>
</head>
<body>
<div class="nav">
    <a href="/setting.do" target="_blank">打开设置</a>
    <a href="/search.do" target="_blank">进入检索</a>
    <a href="javascript:void(0)" onclick="go(0)" style="color: green;">全部启动</a>
    <a href="javascript:void(0)" onclick="stop(0)" style="color: #ff8850">全部关闭</a> |
    <a href="javascript:void(0)" onclick="go(1)" style="color: green;">启动页面分析</a>
    <a href="javascript:void(0)" onclick="go(2)" style="color: green;">启动任务处理</a>
    <a href="javascript:void(0)" onclick="stop(1)" style="color: #ff8850">关闭页面分析</a>
    <a href="javascript:void(0)" onclick="stop(2)" style="color: #ff8850">关闭任务处理</a>
</div>
<div class="content">
    <div class="console" id="res_console">
        <p>实时监控：</p>
    </div>
    <div class="console" id="oper_consle">
        <p>操作历史：</p>
    </div>
</div>
</body>
<script src="../../statics/jquery-1.7.2.min.js"></script>
<script src="../../statics/jquery.blockUI.js"></script>
<script src="../../statics/jcamera.js"></script>
</html>