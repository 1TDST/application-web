/**
 * 
 */

 function padronizandoTel(campo){

		campo.value = campo.value.replace(/(\d{3})?(\d{3})?(\d{3})?(\d{2})/, "$1.$2.$3-$4"); 

 }