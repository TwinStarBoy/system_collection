function login(){
	$("#loading_image").show();

	var username = $("#username").val();
	var password = $("#password").val();
	$.ajax({
		url:urlPrefix() + "crm-test/onlineManage/login",
		data:{username:username,password:password},
		type: 'POST',
		success:function(data){
			$("#loading_image").hide();
			console.log(data);
			if(data.returnCode == undefined){
				BootstrapDialog.show({  
					closable: true, 
		            message: "busy service , please try again after 5 minutes .",
		            buttons: [{
		            	label: 'Close the dialog',
					    action: function(dialogRef){
					      dialogRef.close();   //总是能关闭弹出框
					    }
		            }]
		    	});
				return ;
			}
			if(data.returnCode == "0000"){
				sessionStorage.customerId = data.lists[0].id;
				sessionStorage.username = data.lists[0].username;
				console.log("customerDetail:"+sessionStorage.customerDetail);

                var cookie = "clientid=" + data.lists[0].id ; 
                var cookie1 = "username=" + data.lists[0].username ;
                document.cookie = cookie ;
                document.cookie = cookie1 ;

				window.location.href = "profile.html?username=" + data.lists[0].username;
			}else{
				BootstrapDialog.show({  
					closable: true, 
		            message: data.returnDesc,
		            buttons: [{
		            	label: 'Close the dialog',
					    action: function(dialogRef){
					      dialogRef.close();   //总是能关闭弹出框
					    }
		            }]
		    });
			}
        },
        error:function(){
        	BootstrapDialog.show({  
					closable: true, 
		            message: "internal error",
		            buttons: [{
		            	label: 'Close the dialog',
					    action: function(dialogRef){
					      dialogRef.close();   //总是能关闭弹出框
					    }
		            }]
		    });
        }
	});
}