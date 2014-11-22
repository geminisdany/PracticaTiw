jQuery(document).ready(function($){




	/************** Scroll Navigation *********************/
	$('.navigation').singlePageNav({
        currentClass : 'active'
    });


	/************** FlexSlider *********************/
    $('.flexslider').flexslider({
	    animation: "fade",
	    directionNav: false
	});


    /************** Responsive Navigation *********************/

	$('.menu-toggle-btn').click(function(){
        $('.responsive-menu').stop(true,true).slideToggle();
    });
});

$(function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy' });
  });

$(document).ready(function(){
	$(".datos").hide();
	  $(".cerrar").click(function(){
		$(".datos").hide();
	  });
	  $(".ava").click(function(){
		$(".datos").show();
	  });
	});