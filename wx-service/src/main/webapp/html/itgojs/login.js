var login={
	init:function(){
		this.loginBtnClick();
	},
	loginBtnClick:function(){ //登录按钮点击事件
		$('#loginBtn').bind('click.itgo.loginBtn',function(){
			var sendParam = {};
			sendParam.username = $("input[name='username']").val();
			sendParam.password = $("input[name='password']").val();
			sendParam.remebered = $("input[name='remember']").prop('checked')?"true":"false";
			console.log('send data:'+ JSON.stringify(sendParam));
			$.ajax({
				url:'../user/login.do',
				data:JSON.stringify(sendParam),
				beforeSend:function(jqXHR, settings){
					$('#loginBtn').find('i').removeClass().addClass("fa fa-spinner fa-pulse  fa-fw");
				},
				success:function(result){
					if(result && result.JSONResponse.resultCode == "0000"){
						window.location.href = result.JSONResponse.obj;
					}else{
						$('#itgo-alert-info').removeClass('sr-only')
	                    .text(result.JSONResponse.resultMessage);
					}
				},
				complete:function(jqXHR,textStatus){
					$('#loginBtn').find('i').removeClass().addClass("fa fa-sign-in");
				},
				error:function(jqXHR,textStatus,errorThrown){
					var error = textStatus.toUpperCase()+"("+jqXHR.status+"):"+errorThrown;
					$('#itgo-alert-info').removeClass('sr-only')
                    .text(error);
				}
			});
			
		});
		
	}
}

$(function(){
	login.init();
});