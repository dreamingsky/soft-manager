    function addTab(title, url){
    	if ($('#tt').tabs('exists', title)){
    		$('#tt').tabs('select', title);
    	} else {
    		var content = '<iframe scrolling="auto" frameborder="0"  src="'+baseUrl+url+'" style="width:100%;height:100%;"></iframe>';
    		$('#tt').tabs('add',{
    			title:title,
    			content:content,
    			closable:true,
    			width: $('#mainPanle').width() - 10,
                height: $('#mainPanle').height() - 26
    		});
    	}
    }

    $(document).ready(function () {
               $('.easyui-accordion li a').click(function () {
                   var tabTitle = $(this).text();
                   var url = $(this).attr("href");
                   addTab(tabTitle, url);
                   $('.easyui-accordion li div').removeClass("selected");
                   $(this).parent().addClass("selected");
               }).hover(function () {
                   $(this).parent().addClass("hover");
               }, function () {
                   $(this).parent().removeClass("hover");
               });
      })