var url = "jsonTest/publisher.json?adc=1&cde=1&333";

var pnsid = 1;
var pnsgid = 8;
var clientid = getCustomerId();

$(document).ready(function() {
	createData();
} );

function resetTable(){
	$('#example').DataTable().ajax.reload();
}

function createData(){
	var table = $('#example').DataTable( {
			    	"bPaginate": true, //??页
			        "processing": true,
			        "serverSide": true,
			        "bFilter": false, //????
			        "bLengthChange": false, //选????页??
			        "iDisplayLength" : 10,// 每页??示????   
			        "bSort": false, //????
			        "bInfo": true,//展示页????息
			        //"ordering": false,
			        
			        "ajax": {

			            "url": urlSubscriberPrefix() + "ownpns",
			            "contentType" : 'application/json',
			            "data": function ( d ) {
			            	  
			            	  d.side = "S";
			            	  d.pnsid = pnsid;
			            	  d.pnsgid = pnsgid;
			            	  d.clientid = clientid;
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
			            { "data": "price" , "class": "center" },
			            { "data": "quant" , "class": "center" },
			            { "data": "traded" , "class": "center" },
			            { "data": "margin" , "class": "center" },
			            { "data": "net" , "class": "center" },
			            { "data": "can" , "class": "center" },
			            { "data": "max" , "class": "center" },
			            { "data": "min" , "class": "center" },
			            { "data": "status" , "class": "center" },
			            { "data": "operate" , "class": "center" , "render": function(data, type, row) {
				                return  '<a href="#" onclick="scanOrder(this)" style="cursor:pointer">scan order</a>' ;
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
				        "sLengthMenu": "??示 _MENU_ ??????",
				        "sZeroRecords": "没??匹??????",
				        "sInfo": "??示?? _START_ ?? _END_ ?????????? _TOTAL_ ??",
				        "sInfoEmpty": "??示?? 0 ?? 0 ?????????? 0 ??",
				        "sInfoFiltered": "(?? _MAX_ ??????????)",
				        "sInfoPostFix": "",
				        "sSearch": "????:",
				        "sUrl": "",
				        "sEmptyTable": "????????为??",
				        "sLoadingRecords": "??????...",
				        "sInfoThousands": ",",
				        "oPaginate": {
				            "sFirst": "??页",
				            "sPrevious": "??页",
				            "sNext": "??页",
				            "sLast": "末页"
				        },
				        "oAria": {
				            "sSortAscending": ": ?????????写???",
				            "sSortDescending": ": ?越??????写???"
				        }
				    }, */

				    "pagingType": "full_numbers_no_ellipses"
			    } );
				//var table = $('#example').DataTable(); 

				/*$('#example tbody').on('click', 'tr', function () { 
					
					var data = table.row(this).data(); //??取???械?????

				} ); */

        return table;
}

            
function scanOrder(object){
					
					console.log(object);
					var td = $(object).parent();
					console.log(td);
					var tr = td.parent();
					console.log(tr);
					var table = $('#example').DataTable();
					var data = table.row(tr).data(); //??取???械?????
					console.log(data);

					window.open("scanOrder.html?username="+getParam("username")+"&pnsoid="+data.pnsoid);
}
			