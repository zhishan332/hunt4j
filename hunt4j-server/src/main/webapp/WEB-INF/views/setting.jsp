<%--
  Created by IntelliJ IDEA.
  User: wangq
  Date: 14-5-17
  Time: 下午2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../statics/all.css"/>
    <title>设置</title>
</head>
<body>
<div class="nav">
    <a href="" target="_blank" style="float: right;">保存并应用</a>
</div>
<table border="1" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="300">配置项</th>
        <th width="500">配置值</th>
        <th width="400">说明</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>最小图片高度</td>
        <td>
            <input type="text" value="1">
        </td>
        <td>
            <input type="text" value="1">
        </td>
    </tr>
    <tr>
        <td>最小图片宽度</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>最小图片大小</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>图片保存路径</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>图片命名方式</td>
        <td>
            <select>
                <option value="1">保持原名称遇重名时自动加后缀</option>
                <option value="2">按时间命名</option>
            </select>
        </td>
        <td></td>
    </tr>
    <tr>
        <td>是否自动生成文件夹</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>自动生成文件夹方式</td>
        <td>
            <select>
                <option value="1">智能分组</option>
                <option value="2">每百张分组</option>
                <option value="3">每千张分组</option>
                <option value="4">每万张分组</option>
            </select>
        </td>
        <td>
            只有选择了自动生成文件夹该值才有效
        </td>
    </tr>
    <tr>
        <td>站点抓取间隔</td>
        <td>600</td>
        <td>单位：秒，每隔一段时间，会重新对站点进行抓取</td>
    </tr>
    <tr>
        <td>同时处理站点数</td>
        <td>5</td>
        <td></td>
    </tr>
    <tr>
        <td>图片任务最大缓存数</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>图片任务每次处理数</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>图片任务缓存Worker线程数</td>
        <td></td>
        <td>注：修改该配置会重启CachePhotoTaskWorker</td>
    </tr>
    <tr>
        <td>图片任务数据库Worker线程数</td>
        <td></td>
        <td>注：修改该配置会重启DbPhotoTaskWorker</td>
    </tr>
    <tr>
        <td>页面分析任务最大缓存数</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>页面分析任务每次处理数</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>页面分析任务缓存Worker线程数</td>
        <td></td>
        <td>注：修改该配置会重启CacheUrlTaskWorker</td>
    </tr>
    <tr>
        <td>页面分析任务数据库Worker线程数</td>
        <td></td>
        <td>注：修改该配置会重启DbUrlTaskWorker</td>
    </tr>
    </tbody>
</table>
</body>
<script src="../../statics/jquery-1.7.2.min.js"></script>
</html>