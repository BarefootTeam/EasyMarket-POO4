(function($) {
	"use strict";
	
	let percent2pixel = {
		W: (percent) => {
			let width = $(window).width()
			return ((width * percent) / 100)
		},
		H: (percent) => {
			let height = $(window).height()
			return ((height * percent) / 100)
		}
	}
	
	$(function() {
		
		$('.toggle-menu').click(function(event) {
			event.preventDefault();
			
			let nav = $('nav');
			let wrapper = $('.wrapper');
			let open = nav.attr('data-open')
			
			if(open == "true" || open == undefined) {
				nav.animate({ 'left': - $('nav').width() }, 250, function() {
					nav.attr('data-open', 'false')
				})
				wrapper.animate({ 'margin-left': 0, 'width': '100%' }, 250)
			} else {
				nav.animate({ 'left': 0 }, 250, function() {
					nav.attr('data-open', 'true')
				})
				wrapper.animate({
					'margin-left': 250,
					'width': (percent2pixel.W(100) - 250)
				}, 250)
			}
			
		});
		
		$('.cpf').mask('999.999.999-99');
		$('select').material_select();
		
	});	
})(jQuery);