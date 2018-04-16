$(function(){
	scanPersonalInformation();
});

function scanPersonalInformation(){
	var username = getParam("username");
	
	$.ajax({
		url:urlPrefix() + "crm-test/customerEdit/scanPersonalInformation",
		data:{username:username},
		type: 'POST',
		success:function(data){
			console.log(data);
			if(data.returnCode == "0000"){
				
				$("#mobile").val(data.lists[0].mobile);
				$("#identification").val(data.lists[0].identification);
				$("#id").val(data.lists[0].id);
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
        error : function(xhr,textStatus,errorThrown){
       　　if (xhr.status == 401) {
       			BootstrapDialog.show({  
					closable: true, 
		            message: "please login",
		            buttons: [{
		            	label: 'Close the dialog',
					    action: function(dialogRef){
					      dialogRef.close();   //总是能关闭弹出框
					      window.location.href = "login.html";
					    }
		            }]
		        });
         　} else{
           　　// 调用外部的error
            　 error && error(xhr,textStatus,errorThrown);
      　　 }
    　　}
	});
}


function modifyPersonalInformation(){
	var username = getParam("username");
	var id = $("#id").val();
	//var username = $("#username").val();
	//var username = getParam("username");
	//var password = $("#password").val();
	//var confirmPassword = $("#confirmPassword").val();
	var mobile = $("#mobile").val();
	var identification = $("#identification").val();
	
	$.ajax({
		url:urlPrefix() + "crm-test/customerEdit/modifyPersonalInformation",
		data:{
		    username:username,			
			mobile:mobile,
			identification:identification,
			id:id
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
			if(data.returnCode == "0000"){
				scanPersonalInformation();
			}
        }
	});
}