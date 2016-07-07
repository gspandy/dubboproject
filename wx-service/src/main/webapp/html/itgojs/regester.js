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
				contentType:'application/json',
				dataType:'json',
				type:'POST',
				data:JSON.stringify(params),
				url:'../user/register.do',
				success:function(result){
					console.log(result);
				},
				xhr:function(){
					var http_request;
					if (window.XMLHttpRequest) { // Mozilla, Safari, ...
					    http_request = new XMLHttpRequest();
					} else if (window.ActiveXObject) { // IE
					    http_request = new ActiveXObject("Microsoft.XMLHTTP");
					}
					http_request.upload.addEventListener("progress", function (evt) {
						//alert(evt.lengthComputable + "  " + evt.total);
			            if (evt.lengthComputable) {
			                var percentComplete = evt.loaded / evt.total;
			                $("#test").attr("style","width: "+Math.round(percentComplete * 100)+"%;").text(Math.round(percentComplete * 100)+"%");
			                console.log(Math.round(percentComplete * 100) + "%");
			            }
			        });
					
					
					return http_request;
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
					contentType:'application/json',
					dataType:'json',
					type:'POST',
					data:params,
					url:'../user/register.do',
					success:function(result){
						console.log(result);
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