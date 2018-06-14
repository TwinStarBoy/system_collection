$(function(){
	        $( "#dialog-form" ).dialog({
            	autoOpen: false,
            	modal: false
            });
});
var url = "jsonTest/publisher.json?adc=1&cde=1&333";

var pnsid = 1;
var pnsgid = 8;
var messageid_global = "7003";

$(document).ready(function() {
	createData();
} );

function resetTable(){
	$('#example').DataTable().ajax.reload();
}

function createData(){
	var table = $('#example').DataTable( {
			    	"bPaginate": true, //??ҳ
			        "processing": true,
			        "serverSide": true,
			        "bFilter": false, //????
			        "bLengthChange": false, //ѡ????ҳ??
			        "iDisplayLength" : 10,// ÿҳ??ʾ????   
			        "bSort": false, //????
			        "bInfo": true,//չʾҳ????Ϣ
			        //"ordering": false,
			        
			        "ajax": {

			            "url": urlSubscriberPrefix() + "market",
			            "contentType" : 'application/json',
			            "data": function ( d ) {
			            	  
			            	  d.side = "S";
			            	  d.pnsid = pnsid;
			            	  d.pnsgid = pnsgid;
			            	  d.clientid = getCookie("clientid");
			            	  console.log(d);
						      return JSON.stringify( d );
						  },
			            
			            "type": "post"
			        },
			        
			        /*
			        "ajax": {
			        	"url": "jsonTest/publisher.json?" + new Date(),
						//"url": url,
						"type": "get"
			        },
                    */
			        "columns": [
			            { "data": "pnsoid" , "class": "center" },
			            { "data": "poid" , "class": "center" },
			            { "data": "poname" , "class": "center" },
			            { "data": "price" , "class": "center" },
			            { "data": "quant" , "class": "center" },
			            { "data": "net" , "class": "center" },
			            { "data": "min" , "class": "center" },
			            { "data": "max" , "class": "center" },
			            { "data": "operate" , "class": "center" , "render": function(data, type, row) {
				                return  '<a href="javascript:void(0);" onclick="buy(this)" style="cursor:pointer">Buy</a>' ;
				            }
				        },
				        { "data": "chat" , "class": "center" , "render": function(data, type, row) {
				                return  '<a href="javascript:void(0);" onclick="chatMultipleOrder(this)" style="cursor:pointer">chat</a>' ;
				            }
				        }
			        ],
			        /*
			        "columnDefs": [
				        {
				        	"render": function(data, type, row) {
				                return  '<a href="#" onclick="buy(this)" style="cursor:pointer">Buy</a>' ;
				            },
				            "targets": 2
				        }
			        ],*/
			        language: {
			        	"sInfoFiltered": ""
			        },
			        /*
			        language: {
				        "sProcessing": "??????...",
				        "sLengthMenu": "??ʾ _MENU_ ??????",
				        "sZeroRecords": "û??ƥ??????",
				        "sInfo": "??ʾ?? _START_ ?? _END_ ?????????? _TOTAL_ ??",
				        "sInfoEmpty": "??ʾ?? 0 ?? 0 ?????????? 0 ??",
				        "sInfoFiltered": "(?? _MAX_ ??????????)",
				        "sInfoPostFix": "",
				        "sSearch": "????:",
				        "sUrl": "",
				        "sEmptyTable": "????????Ϊ??",
				        "sLoadingRecords": "??????...",
				        "sInfoThousands": ",",
				        "oPaginate": {
				            "sFirst": "??ҳ",
				            "sPrevious": "??ҳ",
				            "sNext": "??ҳ",
				            "sLast": "ĩҳ"
				        },
				        "oAria": {
				            "sSortAscending": ": ?????????д???",
				            "sSortDescending": ": ?Խ??????д???"
				        }
				    }, */

				    "pagingType": "full_numbers_no_ellipses"
			    } );
				//var table = $('#example').DataTable(); 

				/*$('#example tbody').on('click', 'tr', function () { 
					
					var data = table.row(this).data(); //??ȡ???е?????

				} ); */

        return table;
}

var faceName ;
            function buy(object){
					
					console.log(object);
					var td = $(object).parent();
					console.log(td);
					var tr = td.parent();
					console.log(tr);
					var table = $('#example').DataTable();
					var data = table.row(tr).data(); //??ȡ???е?????
					console.log(data);

					faceName = data.poname;


					//var pnsid = $("<input type='hidden' name='pnsid' value=" + data.pnsid +"></input>");

					var price = $("<input type='hidden' name='price' value=" + data.price +"></input>");

					//var quant = $("<input type='hidden' name='quant' value=" + data.quant +"></input>");

					var pnsoid = $("<input type='hidden' name='pnsoid' value=" + data.pnsoid +"></input>");

					//var pnsgid = $("<input type='hidden' name='pnsgid' value=" + data.pnsgid +"></input>");
					
					var poid = $("<input type='hidden' name='poid' value=" + data.poid +"></input>");

					var side = $("<input type='hidden' name='side' value=" + "B" +"></input>");
	
				    var messageid = $("<input type='hidden' name='messageid' value=" + data.messageid +"></input>");
				   
				    var form = $("#form");

				    form.append(price,pnsoid,poid,side,messageid);

				    $('#myModal').modal({
				    	backdrop: 'static',//������ֲ㲻�ر�ģ̬��
				        keyboard: true//��esc�����˳�ģ̬��
				    })
	        }

	        function chat(orderStatus){
				var username = getParam("username");

	        	//var orderStatus = $("<div>this is order status</div>");
				
	        	var iframe = $("<iframe width='280' height='380' src='http://localhost:8883/autoLogin.html?loginname=" + username +"&faceName=" + faceName +"'></iframe>");
	        	/*
	        	var chatDialog = $( "#dialog-confirm" );
	        	chatDialog.empty();
	        	chatDialog.append(orderStatus,iframe);
                */

                var orderGroup = $("#orderGroup");
                orderGroup.empty();
                orderGroup.append(orderStatus);

                var chatGroup = $("#chatGroup");
                chatGroup.empty();
                chatGroup.append(iframe);

	        	$( "#dialog-confirm" ).dialog({
			      resizable: true,
			      height:530,
			      width:512,
			      modal: false,
			      buttons: {
			        "close": function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    });
	        }

	        function chatMultipleOrder(object){
	        	var orderStatus = $("<div id='orderStatus'></div>");
	        	chat(orderStatus);
	        	searchMultipleOrder(object);
				
	        }

	        function searchMultipleOrder(params){
	        	$.ajax({
					url:urlNewTradePrefix() + "deal",
					contentType : 'application/json',
					data:JSON.stringify(params),
					type: 'POST',
					success:function(data){
						console.log(data);
						
						var html
						for(var i=0;i<data.length;i++){
							var status = data[i].status;
							if("DEALING" == status){//����Ϊ"δ֧��"
								html += "<div>this order need to be confirmed , please click confirm button <input type='button' value='confirm' onclick='pay()'/></div><br/>";
													
							}
						}
						/*
						var element = $(html);

						var orderStatus = $("#orderStatus");
						var ss = $("<div>3333</div>");
						orderStatus.append(ss);
						*/
			        }
				});
				
                
				var orderStatus = $("#orderStatus");

				var html = "<div>this order need to be confirmed , please click confirm button <input type='button' value='confirm' onclick='pay()'/></div><br/>";
                html += html;
                //html += html;
				orderStatus.append(html);
				
	        }

	        function chatOneOrder(object){//�鿴����"δ֧��ȷ��"�Ķ���
				chat(object);
	        }

	        function searchOneOrder(params){
	        	$.ajax({
					url:urlSubscriberPrefix() + "ownord",
					contentType : 'application/json',
					data:JSON.stringify(params),
					type: 'POST',
					success:function(data){
						console.log(data);

						var status = data.ord.status;
						if("DEALING" == status){//����Ϊ"δ֧��"
                            
                            var strData = JSON.stringify(data);
							var time = new Date(data.ord.timestamp).format("yyyy-MM-dd hh:mm:ss");
							var orderStatus = "<div id='" + data.ord.oid + "'>"
							orderStatus += "<div>this order need to be confirmed , please click confirm button :</div>";
                            orderStatus += "<div>order id:" + data.ord.oid + "</div>"
                            orderStatus += "<div>time:" + time + "</div>"
                            orderStatus += "<div>price:" + data.ord.price +"</div>";
                            orderStatus += "<div>quant:" + data.ord.quant +"</div>";
                            orderStatus += "<div>status:" + data.ord.status +"</div>";
							orderStatus += "<input type='button' value='pay' onclick='pay(" + strData + ")'/>";
							orderStatus += "</div>";
							chat(orderStatus);//�������							
						}
						
			        }
				});
	        }

	        function pay(strData){
	        	//alert("pay confirm success ...");
	        	
	        	var paidParam = {
	        		            messageid:"7005",
	        		            requestid:generateUUID(),
                            	clientid:getCustomerId(),
                            	oid:strData.ord.oid,
                            	cid:strData.ord.cid,
                            	side:strData.side,
                            	pnsoid:strData.pnsoid,
                            	poid:strData.poid,
                            	pnsid:strData.pnsid,
                            	pnsgid:strData.pnsgid,
                            	price:strData.ord.price,
                            	quant:strData.ord.quant
                            };
	        	$.ajax({
					url:urlTradePrefix() + "paid",
					contentType : 'application/json',
					data:JSON.stringify(paidParam),
					type: 'POST',
					success:function(data){
						console.log(data);

						var status = data.status;

						if("SUCCESS" == status){
							var time = new Date(strData.ord.timestamp).format("yyyy-MM-dd hh:mm:ss");
							var elementId = "#" + data.oid;
							var orderId = $(elementId);	
							orderId.empty();
							var orderStatus = "<div id='" + data.oid + "'>"
							orderStatus += "<div>this order has paid confirmed , please wait saler comfrim , thank you :</div>";
                            orderStatus += "<div>order id:" + data.oid + "</div>"
                            orderStatus += "<div>time:" + time +"</div>";
                            orderStatus += "<div>price:" + data.price +"</div>";
                            orderStatus += "<div>quant:" + data.quant +"</div>";
                            //orderStatus += "<div>status:" + data.status +"</div>";
							orderStatus += "</div>";
							orderId.append(orderStatus);
						}
			        }
				});
	        }
			
			$("#submit").on("click",function(){
                
				//var pnsid = pnsid;

				//var pnsgid = pnsgid;

				var price = $("input[name='price']").val();

				var quant = $("input[name='quant']").val();
				
				var pnsoid = $("input[name='pnsoid']").val();

				var side = $("input[name='side']").val();

				var poid = $("input[name='poid']").val();

				var clientid = getCustomerId();
				
				var username = getUserName();

				var params = {
					    pnsid:pnsid,
						price:price,
						quant:quant,
						pnsoid:pnsoid,
						pnsgid:pnsgid,
						side:side,
						username:username,
						messageid:messageid_global,
						poid:poid,
						clientid:clientid
					};

				$.ajax({
					url:urlNewTradePrefix() + "deal",
					contentType : 'application/json',
					data:JSON.stringify(params),
					type: 'POST',
					success:function(data){
						console.log(data);

						closeModal();

						var searchParams = {
							oid:data.oid,
							cid:data.clientid,
							pnsoid:data.pnsoid,
							poid:data.poid,
							pnsgid:data.pnsgid,
							pnsid:data.pnsid,
							side:data.side
						};
						searchOneOrder(searchParams);//��ѯ����״̬
			        }
				});

				
			});

			function closeModal(){
				$('#myModal').modal('hide');//????ģ̬??
				//???ձ???
				$("#myModal :input").not(":button, :submit, :reset, :hidden, :checkbox, :radio").val(""); 
                $("#myModal :input").removeAttr("checked").remove("selected");  
			}

			