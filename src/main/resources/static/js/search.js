$(document).ready(function() {
  var typingTimer;
  var doneTypingInterval = 500; // Tiempo de espera después de la última escritura en ms
  var $input = $('#search');
  var $categoria = $('#categoria');

  //Focus al input y poder seguir escribiendo
  
  function focusInput(){
	  
	
  $input.focus();
  var inputLength = $input.val().length;
  $input[0].selectionStart = inputLength;
  $input[0].selectionEnd = inputLength;
  
}


  // Evento de entrada (en lugar de keyup)
  $input.on('keyup', function() {
    clearTimeout(typingTimer);
    typingTimer = setTimeout(doneTyping, doneTypingInterval);
    
  });
  
  

  // Evento de selección de categoría
  $categoria.on('change', function() {
    doneTyping();
  
  });
  
  

	
  // Evento de búsqueda
  function doneTyping() {
    var searchTerm = $input.val();
    var categoria = $categoria.val();
    
    if (searchTerm !== '' || categoria !== '') {
		
      $('#form').submit();   
      
    }
    else {
		focusInput();
        window.location.href = '/';
   
    } 

  }
  
  
  focusInput();
});
