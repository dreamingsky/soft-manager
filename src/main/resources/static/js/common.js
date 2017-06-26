function baseTable(id, url,dg_toolbar,cols, opts){
    //默认参数
    var defaultOpts = {
            'method': 'post',
    		'border': false,
    		'fitColumns': true,
    		'pagination': true,
    		'rownumbers': true,
    		'singleSelect': false,
    		'checkOnSelect': true,
    		'selectOnCheck': true,
    		'pageSize': 20,
    		'pageList': [20, 40, 60, 80, 100]
    }

    for(var o in opts){
       defaultOpts[o] = opts[o];
    }
var $grid = $('#' + id).datagrid({
		url: url,
		toolbar: '#' + dg_toolbar,
		columns: cols,
		fit : true,
		sortName: defaultOpts['sortName'],
		sortOrder: defaultOpts['sortOrder'],
		queryParams: defaultOpts['queryParams'],
		method: defaultOpts['method'],
		border: defaultOpts['border'],
		fitColumns: defaultOpts['fitColumns'],
		pagination: defaultOpts['pagination'],
		rownumbers: defaultOpts['rownumbers'],
		singleSelect: defaultOpts['singleSelect'],
		checkOnSelect: defaultOpts['checkOnSelect'],
		selectOnCheck: defaultOpts['selectOnCheck'],
		pageSize: defaultOpts['pageSize'],
		pageList: defaultOpts['pageList'],
		onLoadSuccess: function(data) {
			if(data.code != '1') {
				$.messager.show({
					title: '提示',
					msg: data.desc
				});
			}
			$(this).datagrid('clearSelections');
		}
	});
	window.$grid = $grid;

}

/**
 * 增加formatString功能
 * 使用方法：$.formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 * @returns 格式化后的字符串
 */
$.formatString = function(str) {
	for ( var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};

function deleteFun(url,id,module) {
	$.messager.confirm('请确认', '您确认要删除此记录?', function(r) {
		if(r) {
			$.ajax({
				url: url + id,
				type: 'POST',
				dataType: 'json',
				success: function(data) {
					if(data.code == '1') {
    					$('#'+module).datagrid('reload');
    					$.messager.show({
                            title: '提示',
                            msg: '操作成功'
                        });
    				} else {
    					$.messager.show({
    						title: '提示',
                            msg: data.desc
    					});
    				}
				}
			});
		}
	});
}