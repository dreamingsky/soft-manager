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

$(document).ready(function() {
	users.init();
});