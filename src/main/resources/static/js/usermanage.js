var webRoot = "http://localhost:8080"


Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};


/**
 * 每次加载500条数据
 * */
var pageLimit=500;

/**
 * DynamoDB分页最后一条index数据
 * */
var lastEvaluatedFile = null;

/**
 * 权限列表顺序
 * */
var checkboxContent = ["上传文件", "新建文件夹", "新建文件", "复制到", "移动到", "删除", "重复名", "下载", "分享", "启动分析流程"];

/**
 * 表格数据缓存
 * */
var tableDataCatch;

/**
 * 是否加载完了数据
 * */
var isNoData = false;

/**
 * 初始化。
 */
$(function () {
    var sessionUsername = $("#sessionUsername").html();
    if (typeof(sessionUsername) != 'undefined' && sessionUsername.length > 7) {
        $('#sessionUsername').html(sessionUsername.substring(0, 7) + '...');
    }
    $('#UserNavTab .search input').attr('placeholder', '搜索用户名称');


    /**
     * 点击分页页数触发：
     *          如果数据没有加载完，且页数*每页数量大于表格缓存数据量则继续加载数据
     *              如果本次加载将数据加载完 isNoData=true
     *              将本次加载的数据放进缓存
     * */
    $("#table").on("page-change.bs.table", function (number, size,pagesize) {
        if(pagesize * size > tableDataCatch.length && !isNoData){
            var data={};
            data.limit=10;
            data.page=1;
            $.ajax({
                url: webRoot + '/usermanage/list',
                type: 'get',
                data: data,
                success: function (data) {
                    for(var i in data.rows){
                        tableDataCatch.push(data.rows[i]);
                    }
                    if( data.lastKey == null ){
                        isNoData = true;
                    }
                    lastEvaluatedFile = data.lastKey;
                    $('#table').bootstrapTable('load', tableDataCatch);
                }
            });
        }
    });
});


/**
 * 第一次加载表格数据的AJAX。
 */
function ajaxRequestClient(params) {



    $.ajax({
        url: webRoot + '/usermanage/list?limit=10&page=1',
        type: 'get',
        data: params.data,
        success: function (data) {
            params.success({
                total: data.total,
                rows: data.rows
            });
            if(data.lastKey == null ){ //如果加载了所有数据
                isNoData = true;
            }
            lastEvaluatedFile = data.lastKey;
            $('#table').bootstrapTable('load', data.rows);
            tableDataCatch = data.rows;
        }
    });
}


function timeFormatter(value, row, index) {
    var date = new Date(value * 1000);
    return date.Format("yyyy-MM-dd hh:mm:ss");
}

function addOperations(value, row, index) {
    return '<a class="edit" href="javascript:void(0);">修改权限</a>';
}

function authFormatter(value, row, index) {
    if (value && value!='0000000000') {
        var str = '';
        for (i = 0; i < value.length; i++) {
            if (value.charAt(i) == "1") {
                str += checkboxContent[i] + "、";
            }
        }
        return str.substring(0, str.length - 1);
    } else {
        return "--"
    }
}

window.operateEvents = {
    'click .edit': function (e, value, row, index) {

        var auth = row.auth;

        var ul = $("#checkboxUl");

        ul.empty();

        if (auth && auth.length == checkboxContent.length) {
            for (i = 0; i < auth.length; i++) {
                if (auth.charAt(i) == "1") {
                    ul.append("<li><div class='checkbox'></div><label><input type='checkbox' checked='checked' value=" + i + " onclick='Choose(this)'/>" + checkboxContent[i] + "</label></li>");
                } else {
                    ul.append("<li><div class='checkbox'></div><label><input type='checkbox' value=" + i + " onclick='Choose(this)'/>" + checkboxContent[i] + "</label></li>");
                }
            }
        } else {
            for (i = 0; i < checkboxContent.length; i++) {
                ul.append("<li><div class='checkbox'></div><label><input type='checkbox' value=" + i + " onclick='Choose(this)'/>" + checkboxContent[i] + "</label></li>");
            }
        }

        $('button#save').unbind('click');
        $('button#save').click(function () {
            var str = '';
            $('#checkboxUl input[type=checkbox]').each(function (index, element) {
                if ($(this).is(':checked')) {
                    str += "1";
                } else {
                    str += "0";
                }
            })

            var params = {};
            params['userName'] = row.userName;
            params['auth'] = str;
            $.get('/usermanage/updateUserAuth', params, function (data) {
                if(data.code == "0"){
                    $('#edit-modal').modal('hide');
                    $('#table').bootstrapTable('refresh');
                }
            });
        });

        $('#edit-modal').modal('show');
    }
}

function Choose(t) {
    //console.log($(t).val());
}