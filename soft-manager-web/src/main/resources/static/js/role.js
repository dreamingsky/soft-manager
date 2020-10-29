var roles = {
    config: {
        roleList: baseUrl + '/role/list',
        deleteUrl: baseUrl + '/role/delete/',
        roleDelete: '<a href="javascript:void(0)" onclick="deleteFun(\'{0}\',\'{1}\',\'module\')">删除</a>'
    },
    opts: {
        'sortName': 'id',
        'sortOrder': 'desc',
        'queryParams': {}
    },
    cols: [[
        {
            field: 'roleCode', title: '角色code', align: 'center', formatter: function (value, row, index) {
                return value;
            }, width: 150
        },
        {
            field: 'roleName', title: '角色名称', align: 'center', formatter: function (value, row, index) {
                return value;
            }, width: 200
        },
        {
            field: 'action', title: '操作', align: 'center', formatter: function (value, row, index) {
                var btns = [];
                btns.push($.formatString(roles.config.roleDelete, roles.config.deleteUrl, row.id));
                return btns.join(' | ');
            }
        }
    ]],
    init: function () {
        baseTable('module', roles.config.roleList, 'toolbar', roles.cols, roles.opts);
    }
}

function newRole() {
    $("#dlg").dialog({
        open: true,
        center: true,
        title: "新建",
        width: 400,
        height: 300,
        closed: false,
        modal: true,
        buttons: [
            {
                text: '保存',
                iconCls: 'icon-save',
                handler: function () {
                    $('#fm').attr('action', baseUrl + "/role/add");
                    $('#fm').submit();
                }
            },
            {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#dlg').dialog('close');
                }
            }
        ]
    });
}

function saveRole() {

}

$(document).ready(function () {
    roles.init();
});