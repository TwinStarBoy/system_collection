function estimate(){
	
}

function reset(){
	location.reload();
}

function publish(){

	var digitalCurrencyType = $("#digitalCurrencyType").val();

	var arr = digitalCurrencyType.split(",");
    
    var pnsid = arr[0];

	var pnsgid = arr[1];	


	var price = $("#price").val();

	var quant = $("#quant").val();
	
	var min = $("#min").val();

	var max = $("#max").val();

	//var side = "S";

	var side = $("#side").val();

	//var pnsid = $("#pnsid").val();

	//var pnsgid = $("#pnsgid").val();
	
	if (!(price>0 && quant>0 && min>0 && max>0 && side && digitalCurrencyType)){
		BootstrapDialog.show({
			closable: true,
			message: "please complete form",
			buttons: [{
				label: 'Close the dialog',
				action: function(dialogRef) {
					dialogRef.close(); //总是能关闭弹出框
				}
			}]
		});
		return false;
	}

	var username = getParam("username");

	var clientid = getCustomerId();

	var params = {
		messageid: "7001",
		requestid: generateUUID(),
		price: price,
		quant: quant,
		min: min,
		max: max,
		side: side,
		clientid: clientid,
		pnsid: pnsid,
		pnsgid: pnsgid
	};

	
	$.ajax({
		url:urlNewTradePrefix() + "publish",
		contentType : 'application/json',
		data:JSON.stringify(params),
		type: 'POST',
		success:function(data){
			console.log(data);

			BootstrapDialog.show({  
					closable: true, 
		            message: data.status,
		            buttons: [{
		            	label: 'Close the dialog',
					    action: function(dialogRef){
					      dialogRef.close();   //总是能关闭弹出框
					      location.reload();   //refresh current page
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