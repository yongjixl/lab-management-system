/**
 * Bootstrap Table Chinese translation
 * Author: Zhixin Wen<wenzhixin2010@gmail.com>
 */
(function ($) {
    'use strict';
    
    var language_zh_cn = "zh-cn";  
		var language_zh_hk = "zh-hk"; 
		var language_zh_tw = "zh-tw"; 
		var currentLang = window.navigator.language.toLowerCase();
		
		if(currentLang == language_zh_cn)  
		{  
		    $.fn.bootstrapTable.locales['zh-CN'] = {
		        formatLoadingMessage: function () {
		            return '正在努力地加载数据中，请稍候……';
		        },
		        formatRecordsPerPage: function (pageNumber) {
		            return '每页显示 ' + pageNumber + ' 条记录';
		        },
		        formatShowingRows: function (pageFrom, pageTo, totalRows) {
		            return '显示第 ' + pageFrom + ' 到第 ' + pageTo + ' 条记录，总共 ' + totalRows + ' 条记录';
		        },
		        formatSearch: function () {
		            return '搜索';
		        },
		        formatNoMatches: function () {
		            return '没有找到匹配的记录';
		        },
		        formatPaginationSwitch: function () {
		            return '隐藏/显示分页';
		        },
		        formatRefresh: function () {
		            return '刷新';
		        },
		        formatToggle: function () {
		            return '切换';
		        },
		        formatColumns: function () {
		            return '列';
		        }
		    };
		
		    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']); 
		}  
		else if(currentLang == language_zh_hk || currentLang == language_zh_tw)  
		{
				$.fn.bootstrapTable.locales['zh-HK'] = {
		        formatLoadingMessage: function () {
		            return '正在努力地載入資料，請稍候……';
		        },
		        formatRecordsPerPage: function (pageNumber) {
		            return '每頁顯示 ' + pageNumber + ' 項記錄';
		        },
		        formatShowingRows: function (pageFrom, pageTo, totalRows) {
		            return '顯示第 ' + pageFrom + ' 到第 ' + pageTo + ' 項記錄，總共 ' + totalRows + ' 項記錄';
		        },
		        formatSearch: function () {
		            return '搜尋';
		        },
		        formatNoMatches: function () {
		            return '沒有找符合的結果';
		        },
		        formatPaginationSwitch: function () {
		            return '隱藏/顯示分頁';
		        },
		        formatRefresh: function () {
		            return '刷新';
		        },
		        formatToggle: function () {
		            return '切換';
		        },
		        formatColumns: function () {
		            return '列';
		        }
		    };
		
		    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-HK']);	
		}  

})(jQuery);
