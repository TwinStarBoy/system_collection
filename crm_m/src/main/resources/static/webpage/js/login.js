function login(){
	
	//var username = $("#username").val();
	//var password = $("#password").val();

	var managerid = 0;//
	var loginname = null;//
	var email = null;//
	var password = "123456";
	var requestid = "7a329632-36f1-11e8-b467-0ed5f89f718b";
	var messageid = "8001";
	var verificationcode = "hellocode";
	
	var data = {messageid:messageid,requestid:requestid,managerid:managerid,loginname:loginname,email:email,password:password,verificationcode:verificationcode};
	
	$.ajax({
		url: "/login",
		data:data,
		type: 'POST',
		success:function(data){
			console.log(data);
			if(data.loginst == "SUCCESS"){
				alert(data.comment);
			}else{
				alert(data.comment);
			}
        }
	});
}
