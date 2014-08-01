var waitimg = "wait.gif";

function AjaxUtil(){}

AjaxUtil.prototype = {};
//上下文路径
AjaxUtil.contextPath = "";

/**
 * Ajax[POST] 异步数据请求
 * @author suihonghua
 * @param url	[String] 请求url
 * @param param	[Object] 参数
 * @param successFunction [Function] 成功回调函数
 */
AjaxUtil.post = function(url,param,successFunction){
    AjaxUtil.ajax("POST", url, param, successFunction);
};

/**
 * Ajax[GET] 异步数据请求
 * @author suihonghua
 * @param url	[String] 请求url
 * @param param	[Object] 参数
 * @param successFunction [Function] 成功回调函数
 */
AjaxUtil.get = function(url,param,successFunction){
    AjaxUtil.ajax("GET", url, param, successFunction);
};

/**
 * Ajax 异步数据请求
 * @author suihonghua
 * @param type	[String] e.g.:"POST" or "GET"
 * @param url	[String] 请求url
 * @param param	[Object] 参数
 * @param successFunction [Function] 成功回调函数
 */
AjaxUtil.ajax = function(type,url,param,successFunction){
    if(param == null){
        param = {};
    }
    param.t_i_m_e = new Date().getTime();//防止请求使用缓存数据
    jQuery.ajax({
        type: type,
        url: AjaxUtil.contextPath + url,
        data: param,
        cache: false,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        beforeSend: function(jqXHR, settings){
            $.blockUI({ message:"<span class='pl20 icon-loading'>正在处理,请稍后...</span>"});
        },
        success: successFunction,
        error: function(jqXHR, textStatus, errorThrown){
            if(jqXHR.status > 0){
                alert("Error:status["+jqXHR.status+"],statusText["+ jqXHR.statusText +"]");
            }
        },
        complete: function(jqXHR, textStatus){
            $.unblockUI();
        }
    });
};
