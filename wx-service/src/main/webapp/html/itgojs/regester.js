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
			
			if(params.password != confirmPassword){
				$('#itgo-alert-info').removeClass('sr-only')
				                     .text('密码不一致!');
				return;
			}
			
			
		});
		
		$(window).bind('keydown.itgo.registerBtn',function(e){
			if(e.key == 'Enter'){
				
			}
		});
	},
	passwordInputFocuse:function(){
		 $("input[name='confirmPassword']").bind('focus.itgo.confirmPassword',function(){
			 this.passwordConfirm = true;
		 })
	}
	
}

$(function(){
	regester.init();
});