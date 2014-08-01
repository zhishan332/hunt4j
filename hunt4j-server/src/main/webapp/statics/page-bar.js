/**
 * 分页组件
 * 
 * @returns {PageBar}
 * 
 * @author suihonghua
 */
function PageBar(){}
PageBar.prototype = new Object();

//PageBar.prototype.length = 1;

/**
 * 填充分页框
 * 
 * clickFunction 点击分页时调用的函数名（String类型）
 * elementId	所填充的元素ID
 * page			Page对象
 * 
 * @author suihonghua
 */
PageBar.fillHtml = function(clickFunction, elementId, page){
	var pagebar_html = this.getHtml(clickFunction, page.totalRow, page.currentPage, page.totalPage);
	document.getElementById(elementId).innerHTML = pagebar_html;
};

/**
 * 获得分页框Html
 * 
 * clickFunction 点击分页时调用的函数名（String类型）
 * totalRow 	分页总条数
 * currentPage	当前页数
 * totalPage	分页总页数
 * 
 * @author suihonghua
 */
PageBar.getHtml = function(clickFunction, totalRow, currentPage, totalPage){
	var tmp = [];// html 构建
	var start = 0;
	var end = 0;
	
	// ////
	if(totalPage > 10){
		start = currentPage - 1;
		if(start < 1){
			start = 1;

		}
		end = start + 9;
		if(end > totalPage){
			end = totalPage;
			start = end - 2;
		}
	}else{
		start = 1;
		end = totalPage;
	}
	var _prePage = start - 1;
	var _nextPage = end + 1;
	var prePage = currentPage - 1;
	var nextPage = parseInt(currentPage) + 1;
	
	tmp.push('<table border="0" cellpadding="0" cellspacing="0" width="100%">');
	tmp.push('<tbody>');
	tmp.push('<tr>');
//	tmp.push('<td align="left" width="56"></td>');
//	tmp.push('<td width="104" align="center">&nbsp;</td>');
	tmp.push('<td width="650" align="left">');
	tmp.push('<div class="m clearfix">');
	//页码显示规则
	if(totalRow>0){
		
		tmp.push('<div class="pagin fr">');
		tmp.push('<span class="text">共'+ totalRow +'条记录</span>');
		tmp.push('<span class="text">共'+ totalPage +'页</span>');
		if(currentPage>1){
			tmp.push('<a href="#" onclick="' + clickFunction + '(1)">首页<b></b></a> ');
			tmp.push('<a href="#" onclick="' + clickFunction + '(' + prePage + ')">上一页<b></b></a>');
		}else{
			tmp.push('<span class="prev-disabled">首页<b></b></span> <span class="prev-disabled">上一页</span>');
		}
		if(_prePage>0){
			tmp.push('<span class="text">...</span>');
		}
		for ( var idx = start; idx <= end; idx++) {
			if(idx == currentPage){
				tmp.push('<a class="current" href="javascript:;">' + idx + '</a>');
			}
			else{
				tmp.push('<a href="#" onclick="' + clickFunction + '(' + idx + ');">' + idx + '</a>');
			}
		}
		if(_nextPage <= totalPage){
			tmp.push('<span class="text">...</span>');
		}
		if(currentPage < totalPage){
			tmp.push('<a href="#" onclick="' + clickFunction + '(' + nextPage + ')">下一页<b></b></a>');
			tmp.push('<a href="#" onclick="' + clickFunction + '(' + totalPage + ')" class="next">末页</a>');
		}
		else{
			tmp.push('<span class="prev-disabled">下一页<b></b></span> <span class="prev-disabled">末页</span>');
		}
		tmp.push(' </div>');
	}
	else{
		tmp.push('<div class="pagin fr"><span class="text">暂无相关记录</span></div>');
	}
	tmp.push('</div>');
	tmp.push('</td>');
	tmp.push('</tr>');
	tmp.push('</tbody>');
	tmp.push('</table>');
	return tmp.join("");
};
