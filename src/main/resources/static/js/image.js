var images = {
	config: {
		imageList: baseUrl + '/image/list',
	},
	opts: {
		'sortName': 'id',
		'sortOrder': 'desc',
		'queryParams': {}
	},
	cols: [[
		{ field: 'imageName', title: '图片名', align: 'center', formatter: function(value, row, index) {
			return value;
		}, width: 150 },
        { field: 'fileName', title: '文件名称', align: 'center', formatter: function(value, row, index) {
			return value;
		}, width: 200 },
		{ field: 'fileUrl', title: '文件路径', align: 'center', formatter: function(value, row, index) {
        	return value;
        }, width: 200 }
	]],
	init: function() {
		baseTable('module', images.config.imageList, 'toolbar', images.cols, images.opts);
	}
}

function newImage(){
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
                        $('#fm').attr('action', baseUrl+"/image/add");
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
	images.init();
});