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


var isGoodsSelectInit = false;
var isLabSelectInit = false;
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


    $('#add_user').click(function () {

        $('#eidt_goodsname').val("");
        $('#eidt_goodsstock').val("");

        $('button#save').unbind('click');
        $('button#save').click(function () {
            var params = {};
            params['goodsId'] = $('#select_goods').val();
            params['labId'] = $('#select_lab').val();
            params['goodsAmount'] = $('#eidt_goodsamount').val();

            $.ajax({
                url: '/labstoremanage/insert',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(params),
                success: function(data) {
                    if(data.code == "0"){
                        $('#edit-modal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                    }else{
                        alert(data.msg);
                    }
                }
            })
        });

        initSelect();


        $('#edit-modal').modal('show');
    })


});



function initSelect() {
    var params = {};

    if(!isLabSelectInit){
        $.ajax({
            url: '/labmanage/list',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(params),
            success: function(data) {
                if(data != null){
                    var records = data.list;
                    for(var i=0;i<records.length;i++){
                        $('#select_lab').append("<option value=" + records[i].labId + ">" + records[i].labName + "</option>");
                    }
                    $('#select_lab').selectpicker('refresh');
                    $('#select_lab').selectpicker('render');
                    isLabSelectInit = true;
                }
            }
        });
    }


    if(!isGoodsSelectInit){
        $.ajax({
            url: '/storemanage/list',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(params),
            success: function(data) {
                if(data != null){
                    var records = data.list;
                    for(var i=0;i<records.length;i++){
                        $('#select_goods').append("<option value=" + records[i].goodsId + ">" + records[i].goodsName + "</option>");
                    }
                    $('#select_goods').selectpicker('refresh');
                    $('#select_goods').selectpicker('render');
                    isGoodsSelectInit = true;
                }
            }
        });
    }

}

function labpage() {
    window.location.href=webRoot + '/labpage';
}
function storepage() {
    window.location.href=webRoot + '/storepage';
}
function userpage() {
    window.location.href=webRoot + '/userpage';
}


/**
 * 第一次加载表格数据的AJAX。
 */
function ajaxRequestClient(params) {
    $.ajax({
        url: '/labstoremanage/list',
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
            url: '/labstoremanage/delete/'+row.id,
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

        initSelect();

        $('#select_goods').selectpicker('val',row.goodsId);
        $('#select_lab').selectpicker('val',row.labId);
        $('#eidt_goodsamount').val(row.goodsAmount);

        $('button#save').unbind('click');
        $('button#save').click(function () {
            var params = {};
            params['id'] = row.id;
            params['goodsId'] = $('#select_goods').val();
            params['labId'] = $('#select_lab').val();
            params['goodsAmount'] = $('#eidt_goodsamount').val();

            $.ajax({
                url: '/labstoremanage/update',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(params),
                success: function(data) {
                    if(data.code == "0"){
                        $('#edit-modal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                    }else{
                        alert(data.msg);
                    }
                }
            })

        });


        $('#edit-modal').modal('show');
    }
};

function Choose(t) {
    //console.log($(t).val());
}