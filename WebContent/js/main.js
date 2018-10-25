function main() {
	$('.headline').hide();
	$('.headline').fadeIn(1500);
	$('.info-inside').hide();
	
	
	//click listener
	$('.info').on('click', function(){
	    //toggle from show to hide
		//$('.info').toggle;
		
		//toggles on off a css class style
		$('.info').toggleClass('active');
		
		// next() selects the next div in order
		// $(this).next().toggle();
		
		// this changes the text of the selected element
		$(this).text('Let me explain...');
		
		// this allows for just one of the divs of the same name
		 $(this).next().toggleClass('active');
		
		// this allows the info to slide out and slide back
		$(this).next().slideToggle(400);
	});
}

$(document).ready(main);