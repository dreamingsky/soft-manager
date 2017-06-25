var users = {
	config: {
		userList: baseUrl + '/user/list',
	},
	opts: {
		'sortName': 'id',
		'sortOrder': 'desc',
		'queryParams': {}
	},
	cols: [[
		{ field: 'userName', title: '用户名', align: 'center', formatter: function(value, row, index) {
			return value;
		}, width: 150 },
        { field: 'phone', title: '手机号', align: 'center', formatter: function(value, row, index) {
			return value;
		}, width: 200 }
	]],
	init: function() {
		baseTable('module', users.config.userList, 'toolbar', users.cols, users.opts);
	}
}

function newUser(){
           	$("#dlg").dialog({
           	    open :true,
           	    center :true,
           		title: "新建",
           		width: 400,
           		height: 300,
           		closed: false,
           		modal : true,
           		buttons : [
           		{
           		    text: '保存',
           		    iconCls:'icon-save',
                	handler: function() {
                        $('#fm').attr('action', baseUrl+"/user/add");
                        $('#fm').submit();
                	}
                },
                {
                           		    text: '取消',
                           		    iconCls:'icon-cancel',
                                	handler: function() {
                                        $('#dlg').dialog('close');
                                	}
                                }
           		]
           	});
        }

function saveUser(){

}

$(document).ready(function() {
	users.init();
});