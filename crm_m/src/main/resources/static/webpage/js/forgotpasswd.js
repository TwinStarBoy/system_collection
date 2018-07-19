function forgotpasswd(){
	
	////	mForgotPw	0x8007	{requestid, sessionid,managerid,email,verificationcode}	HTTP
	var requestid = "7a329632-36f1-11e8-b467-0ed5f89f718b";
	var messageid = "8007";
	var email = "hello@163.com";//
	var verificationcode = "hellocode";

	var data = {messageid:messageid,requestid:requestid,email:email,verificationcode:verificationcode};
	
	$.ajax({
		url: "/forgot",	// send message to method ("/forgot")
		data:data,		// data send
		type: 'POST',	// send method
		
		success:function(data){ // on receive callback function
			console.log(data);
			if(data.status == "SUCCESS"){
				alert(data.comment);
			}else{
				alert(data.comment);
				//
			}
        }
	});
}

