function login(){
	//var username = $("#username").val();
	//var password = $("#password").val();
	
	var messageid = 0x8001;
	var requestid = "9241018c-327d-11e8-b467-0ed5f89f718b";// uuid
	var managerid = "helloworld";
	var passwords = "hellopasswords"
	var verficationcode = "abcdef";
	
	
	$.ajax({
		url:"/",
		data:{messageid:messageid,requestid:requestid,managerid:managerid,passwords:passwords,verficationcode:verficationcode},
		type: 'POST',
		success:function(data){
			console.log(data);
			if(data.returnCode == "0000"){
				alert(data.returnDesc);
			}else{
				alert(data.returnDesc);
			}
        }
	});
}

