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

    $('#logout').click(function () {
        window.location.href=webRoot + '/user/logout';
        window.location.href=webRoot;
    })
    $('#add_user').click(function () {

        $('.modal-title').text('添加物品');
        $('#eidt_goodsname').val("");
        $('#eidt_goodsstock').val("");

        $('button#save').unbind('click');
        $('button#save').click(function () {
            var params = {};

            params['goodsName'] = $('#eidt_goodsname').val();
            params['goodsStock'] = $('#eidt_goodsstock').val();

            $.ajax({
                url: '/storemanage/insert',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(params),
                success: function(data) {
                    if(data.code == "0"){
                        $('#edit-modal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                    }
                }
            })

        });

        $('#edit-modal').modal('show');
    })


});

function labpage() {
    window.location.href=webRoot + '/labpage';
}
function labstorepage() {
    window.location.href=webRoot + '/labstorepage';
}
function userpage() {
    window.location.href=webRoot + '/userpage';
}


/**
 * 第一次加载表格数据的AJAX。
 */
function ajaxRequestClient(params) {
    $.ajax({
        url: '/storemanage/list',
        type: 'get',
        data: params.data,
        success: function (data) {
            console.log(data.totalCount);
            params.success({
                total: data.totalCount,
                rows: data.list
            });
            tableDataCatch = data.list;
        }
    });
}

function queryParams(params) {

    params.page=params.offset/params.limit + 1;
    return params;
}


function addOperations(value, row, index) {
    return '<a class="edit" href="javascript:void(0);">修改</a> <a class="delete" href="javascript:void(0);">删除</a>';
}

window.operateEvents = {
    'click .delete':function (e, value, row, index) {
        $.ajax({
            url: '/storemanage/delete/'+row.goodsId,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            success: function(data) {
                if(data.code == "0"){
                    $('#table').bootstrapTable('refresh');
                }
            }
        });
    },
    
    'click .edit': function (e, value, row, index) {

        $('.modal-title').text('修改物品');
        $('#eidt_goodsname').val(row.goodsName);
        $('#eidt_goodsstock').val(row.goodsStock);


        $('button#save').unbind('click');
        $('button#save').click(function () {
            var params = {};
            params['goodsId'] = row.goodsId;
            params['goodsName'] = $('#eidt_goodsname').val();
            params['goodsStock'] = $('#eidt_goodsstock').val();

            $.ajax({
                url: '/storemanage/update',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(params),
                success: function(data) {
                    if(data.code == "0"){
                        $('#edit-modal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                    }
                }
            })

        });

        $('#edit-modal').modal('show');
    }
}

function Choose(t) {
    //console.log($(t).val());
}