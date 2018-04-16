function modifyPassword(){

	var oldPassword = $("#oldPassword").val();

	var newPassword = $("#newPassword").val();
	
	var confirmPassword = $("#confirmPassword").val();
	
	var username = getParam("username");
	
	$.ajax({
		url:urlPrefix() + "/crm-test/customerEdit/modifyPassword",
		data:{
			username:username,
			oldPassword:oldPassword,
			newPassword:newPassword,
			confirmPassword:confirmPassword
		},
		type: 'POST',
		success:function(data){
			console.log(data);

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

			/*
			if(data.returnCode == "00000"){
				//alert("reset password successfully");
				BootstrapDialog.show({  
		            message: 'reset password successfully'  
		        });
			}else{
				//alert(data.returnDesc);
				BootstrapDialog.show({  
		            message: data.returnDesc  
		        });
			}
			*/
        }
	});
}