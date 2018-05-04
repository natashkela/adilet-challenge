$(document).ready(function(){
	$('.work-email').on('submit',function(e){
		e.preventDefault();
		let name = $('input').val();
		if(name !== ""){
			$('.popup').show();
			$('.mask').show();
		}
	});
	$('.non-existent-email').on('submit',function(e){
		if($('input').val() === ""){
			e.preventDefault();
		}
	});
	$('.close-popup').on('click',function(e){
		$('.popup').hide();
		$('.mask').hide();
	});
	$('.sub-err-email').on('submit',function(e){
		e.preventDefault();
		if($('.error-email').val()!==""){
			$('.error-email').css('border','1px solid #de5454');
			$('.error-email').tooltip({'trigger':'hover', 'container': 'body', 'title': 'Password tooltip'});	
		}
	});
	$('.setup-error').on('submit',function(e){
	e.preventDefault();
	if($('input[name="companyName"]').val()!==""){
		$('input[name="companyName"]').css('border','1px solid #de5454');
		$('input[name="companyName"]').tooltip({'trigger':'hover', 'container': 'body', 'title': 'Password tooltip'});	
	}
	});
	$('.radio-button').on('click',function(e){
		$('.radio-button').removeClass('radio-selected');
		$(this).addClass('radio-selected');
	});
	$('.email-domains').on('submit',function(e){
			e.preventDefault();
	});
});