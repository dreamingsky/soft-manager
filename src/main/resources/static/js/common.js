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