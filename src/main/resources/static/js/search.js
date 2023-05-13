$(document).ready(function() {
  var typingTimer;
  var doneTypingInterval = 500; // Tiempo de espera después de la última escritura en ms
  var $input = $('#search');
  var $categoria = $('#categoria');

  // Evento de entrada (en lugar de keyup)
  $input.on('input', function() {
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
        window.location.href = '/';
    }    
  }
});
