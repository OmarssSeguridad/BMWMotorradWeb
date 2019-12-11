$('#btnSubmit').click(function(e) {
  e.preventDefault();
  if ($('form').smkValidate()) {
  	 $('form').submit();
  }
  else{
  	$.smkAlert({
      text: 'Faltan datos!',
      type: 'warning'
    });
  }
});

// Form Clear
$('#btnClear').click(function(e) {
  e.preventDefault();
  $('form').smkClear();
});
$(document).ready(function() {
  $("a[rel=example_group]").fancybox({
    'transitionIn'    : 'none',
    'transitionOut'   : 'none',
    'titlePosition'   : 'over',
    'titleFormat'   : function(title, currentArray, currentIndex, currentOpts) {
      return '<span id="fancybox-title-over">Foto ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
    }
  });

    // Update item cart
  $(".btn-update-item").on('click', function(e){
    e.preventDefault();
    
    var id = $(this).data('id');
    var href = $(this).data('href');
    var quantity = $("#product_" + id).val();

    window.location.href = href + "/" + quantity;
  });

});

/*PRACTICA EXAMEN*/
var clic = 1;
function divLogin(){ 
   if(clic==1){
   document.getElementById("caja").style.height = "100px";
   clic = clic + 1;
   } else{
       document.getElementById("caja").style.height = "0px";      
    clic = 1;
   }   
}
//Cantidad

