var Defaultoptions = {
	type:"POST", //提交方式默认POST
	dataType:"json",
	beforeSend:function(jqXHR, settings){
		
	},
	cache:true,
	complete:function(jqXHR,textStatus){
		if(textStatus != "success"){
			
		}
	},
	contentType:"application/json;charset=UTF-8",
	error:function(jqXHR, textStatus, errorThrown){
		
	}
}

$.ajaxSetup(Defaultoptions);