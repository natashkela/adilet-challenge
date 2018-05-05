$(document).ready(function(){

	//Needed for popup box in existing company
	//on work-email form submit
	//if the input field is not empty
	//show the Popup
	//and show the mask style for blurry background
	$('.work-email').on('submit',function(e){
		e.preventDefault();
		let email = $('input').val();
		if(email !== ""){
			$('.mask').show();
			$('.popup').show();
		}
	});

	//if close popup button is pressed
	//hide the popup and hide the blurry background as well
	$('.close-popup').on('click',function(e){
		$('.popup').hide();
		$('.mask').hide();
	});

	//if we are submitting an email that is lready exists
	//show a red border on the input field
	//and on every hover on the input field, show a Tooltip
	//with the error text on it
	$('.sub-err-email').on('submit',function(e){
		e.preventDefault();
			$('.error-email').css('border','1px solid #de5454');
			$('.error-email').tooltip({'trigger':'hover', 'container': 'body', 'title': 'tooltip for email error'});
	});

	//every time the companyName is entered
	//we assume that companyName already exists and user
	//might want to find their team.
	$('.setup-error').on('submit',function(e){
		e.preventDefault();
		$('input[name="companyName"]').css('border','1px solid #de5454');
		$('input[name="companyName"]').tooltip({'trigger':'hover', 'container': 'body', 'title': 'Company Exists tooltip'});
	});

	//on every radio button selection
	//remove radio-selected class on all radio buttons
	//add the radio-selected class on the current one
	//if the first radio button is pressed
	//show first tags input and hide second
	//if second radio button is pressed
	//show second one and hide first
	$('.radio-button').on('click',function(e){
		$('.radio-button').removeClass('radio-selected');
		$(this).addClass('radio-selected');
		if($(this).attr("data-choose")==="1"){
			$("#tags-input1").show();
			$("#tags-input2").hide();
		}
		else{
			$("#tags-input2").show();
			$("#tags-input1").hide();
		}
	});
	// $('.email-domains').on('submit',function(e){
	// 	e.preventDefault();
	// });
});
