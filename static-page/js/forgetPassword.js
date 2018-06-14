$(function(){
	changeImage();
});

var rnd ;

function getRandom(){
	var timestamp = new Date().getTime();

	return timestamp + Math.random();
}

function changeImage(){
	rnd = getRandom();
	var src = urlPrefix() + "crm-test/onlineManage/verifyCode?rnd=" + rnd;  
	$("#img_code").attr("src",src);
}



function forgetPassword(){
	var email = $("#email").val();
	
	$.ajax({
		url:urlPrefix() + "crm-test/onlineManage/forgetPassword",
		data:{email:email},
		type: 'POST',
		success:function(data){
			console.log(data);
			if(data.returnCode == "0000"){
				$("#forgetPassword_message").text("send email successfully , please check it than reset your password");
			}else{
				alert(data.returnDesc);
			}
        }
	});
}