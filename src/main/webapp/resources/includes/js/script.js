
$(function() {

	$('#bigCarousel').carousel('cycle');

	$('a.pop').click(function(e) {
		e.preventDefault();
	});
	
	$('a.pop').popover();
	
	$('[rel="tooltip"]').tooltip();

	$('.nav-tabs a:first').tab('show');

});

