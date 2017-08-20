$(function(){
 
  function formSwitch(e) {
    var self = $(this),
        form = $('div'),
        reg1 = 0,
        acc = 'Нет аккаунта?',
        reg2 = 'Уже зарегистрированы?',
        login = 'Войти!';
    
    if(form.hasClass('back-visible')) 
    {
       self.siblings($('h2')).html('<s:message code="page.index.account" />');
       self.html('<s:message code="page.index.registration" />');
       form.removeClass('back-visible');
    } else {
      self.siblings($('h2')).text(reg2);
      self.text(login);
      form.addClass('back-visible');
    }
    
    e.preventDefault();
  }
  
  $('#form-switch').on('click', formSwitch);
  
});