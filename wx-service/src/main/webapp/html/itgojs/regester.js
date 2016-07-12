var emails = [];

var regester = {
	passwordConfirm:false,
	
	init:function(){
		this.emailSelectedInit();
		this.emailDropDownItemInit();
		this.registerBtnClick();
		this.passwordInputFocuse();
	},
	emailSelectedInit:function(){
		$('#emailDropdown').on('hide.bs.dropdown',function(e){
			$(e.relatedTarget).next('.dropdown-menu')
			                  .find('li a')
			                  .each(function(index, item){
			                	  var isSelected = $(item).attr('beSelected');
			                	  if(isSelected == 'true'){
			                		  $('#emailDropdown Button').text($(item).text());
			                	  }
			                  });
		});
	},
	emailDropDownItemInit:function(){
		$('#emailDropdown').find('.dropdown-menu li a')
		                   .bind('click.itgo',function(){
		                	  $(this).parent().parent().find('a').each(function(index, item){
		                		  $(item).attr('beSelected','');
		                	  });
		                	  $(this).attr('beSelected','true');
		                   });
	},
	registerBtnClick:function(){
		$('#registerBtn').bind('click.itgo.registerbtn',function(e){
			var params = {};
			params.username = $("input[name='username']").val();
			params.email = $("input[name='email']").val()+$('#emailDropdown').children().first().text();
			params.password = $("input[name='password']").val();
			var confirmPassword = $("input[name='confirmPassword']").val();
			params.confirmPassword = confirmPassword;
			if(params.password != confirmPassword){
				$('#itgo-alert-info').removeClass('sr-only')
				                     .text('密码不一致!');
				return;
			}
			$.ajax({
				data:JSON.stringify(params),
				url:'../user/register.do',
				beforeSend:function(jqXHR, settings){
					$('#registerBtn').find('i').removeClass().addClass("fa fa-spinner fa-pulse  fa-fw");
				},
				success:function(result){
					console.log(result.JSONResponse.resultCode);
					if(result && result.JSONResponse.resultCode == "0000"){
						window.location.href = result.JSONResponse.obj;
					}
				},
				complete:function(jqXHR,textStatus){
					$('#registerBtn').find('i').removeClass().addClass("fa fa-registered");
				},
				error:function(jqXHR,textStatus,errorThrown){
					var error = textStatus.toUpperCase()+"("+jqXHR.status+"):"+errorThrown;
					$('#itgo-alert-info').removeClass('sr-only')
                    .text(error);
				}
			});
			
		});
		
		$(window).bind('keydown.itgo.registerBtn',function(e){
			if(e.key == 'Enter'){
				var params = {};
				params.username = $("input[name='username']").val();
				params.email = $("input[name='email']").val()+$('#emailDropdown').children().first().text();
				params.password = $("input[name='password']").val();
				var confirmPassword = $("input[name='confirmPassword']").val();
				params.confirmPassword = confirmPassword;
				if(params.password != confirmPassword){
					$('#itgo-alert-info').removeClass('sr-only')
					                     .text('密码不一致!');
					return;
				}
				$.ajax({
					data:JSON.stringify(params),
					url:'../user/register.do',
					beforeSend:function(jqXHR, settings){
						//<i class="fa fa-spinner fa-pulse  fa-fw"></i>
						$('#registerBtn').find('i').removeClass().addClass("fa fa-spinner fa-pulse  fa-fw");
					},
					success:function(result){
						if(result && result.JSONResponse.resultCode == "0000"){
							window.location.href = result.JSONResponse.obj;
						}
					},
					complete:function(jqXHR,textStatus){
						$('#registerBtn').find('i').removeClass().addClass("fa fa-registered");
					},
					error:function(jqXHR,textStatus,errorThrown){
						var error = textStatus.toUpperCase()+"("+jqXHR.status+"):"+errorThrown;
						$('#itgo-alert-info').removeClass('sr-only')
	                    .text(error);
					}
				});
			}
		});
	},
	passwordInputFocuse:function(){
		 $("input[name='confirmPassword']").bind('focus.itgo.confirmPassword',function(){
			 this.passwordConfirm = true;
		 }).bind('focusout.itgo.confirmPassword',function(){
			 if(this.passwordConfirm){
				 if($("input[name='password']").val() == $("input[name='confirmPassword']").val()){
					 $('#itgo-alert-info').addClass('sr-only')
					                      .text('');
				 }else{
					$('#itgo-alert-info').removeClass('sr-only')
	                     			     .text('密码不一致!');
				 }
			 }
			 this.passwordConfirm = false;
		 });

	}
	
}

$(function(){
	regester.init();
});