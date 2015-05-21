
$(function() {

	$('#bigCarousel').carousel('cycle');

	$('a.pop').click(function(e) {
		e.preventDefault();
	});
	
	$('a.pop').popover();
	
	$('[rel="tooltip"]').tooltip();
	
	$(function() {
		var images = ["resources/images/imgb/1.jpg", "resources/images/imgb/2.jpg", "resources/images/imgb/3.jpg", "resources/images/imgb/4.jpg", 
		"resources/images/imgb/5.jpg", "resources/images/imgb/6.jpg", 
		"resources/images/imgb/7.jpg", "resources/images/imgb/8.jpg", "resources/images/imgb/9.jpg", "resources/images/imgb/10.jpg", 
		"resources/images/imgb/11.jpg", "resources/images/imgb/12.jpg", "resources/images/imgb/13.jpg", "resources/images/imgb/14.jpg", 
		"resources/images/imgb/15.jpg", "resources/images/imgb/16.jpg"];

		var currentImage = 0;
		
		$("#imgb1").attr("src", images[currentImage]);
		$("#imgb2").attr("src", images[currentImage + 1]);
		$("#imgb3").attr("src", images[currentImage + 2]);
		$("#imgb4").attr("src", images[currentImage + 3]);
		

		$("#previous").click(function(){
			if(currentImage != 0){
				currentImage--;
				$("#imgb1").attr("src", images[currentImage]);
				$("#imgb2").attr("src", images[currentImage + 1]);
				$("#imgb3").attr("src", images[currentImage + 2]);
				$("#imgb4").attr("src", images[currentImage + 3]);
				
			}
			return false;
		});
		$("#next").click(function(){
			if(currentImage != images.length - 5){
				currentImage++;
				$("#imgb1").attr("src", images[currentImage]);
				$("#imgb2").attr("src", images[currentImage + 1]);
				$("#imgb3").attr("src", images[currentImage + 2]);
				$("#imgb4").attr("src", images[currentImage + 3]);
				
			}
			return false;
		});
	});
});