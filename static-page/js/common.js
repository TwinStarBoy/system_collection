$(function(){
				$("#navigation").load('./commonPage/navigation.html');
				$("#menu_bar").load('./commonPage/menu_bar.html',function(){

					var filename=window.location.href;  
					var start_index = filename.lastIndexOf("/")+1 ; 
					var end_index = filename.indexOf("?") ;
					console.log("start_index:"+start_index+",end_index:"+end_index);
					filename=filename.substring(start_index,end_index);

					$(".nav-list li a").each(function(){
                       
						var href = $(this).attr("href");
						
						if(href == filename){
							
							$(".nav-list li").removeClass("active");//删除全部avtive
							$(this).parent().addClass("active");//显示当前对象的active

							$(".nav-list i").css("background-image","url(../img/glyphicons-halflings.png)");//删除图标的白色效果
							$(this).children().css("background-image","url(../img/glyphicons-halflings-white.png)");//增加图标的白色效果	

						}

					});
				});
				

				

});

function getParam(paramName) { 
    paramValue = "", isFound = !1; 
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) { 
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0; 
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++ 
    } 
    return paramValue == "" && (paramValue = null), paramValue 
}

function goBack(){
	window.location.href = document.referrer;//返回上一页并刷新  
}

function urlPrefix(){
	return "crm/";
}

function changeUrl(e){
	var href = $(e).attr("href");
	window.location.href = href + "?username=" + getParam("username");
	$(e).removeAttr("href");
	return false;
}

function logout(){
	$.ajax({
		url:urlPrefix() + "crm-test/onlineManage/logout",
		success:function(result){
			window.location.href = "login.html";
        },
        error : function(xhr,textStatus,errorThrown){
       　　window.location.href = "login.html";
    　　}
	});


}

