package br.com.casadocodigo.loja.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
	    ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
	    
	    Produto produto = (Produto) obj; 
	    
	    if(produto.getPaginas() <= 0){
	        errors.rejectValue("paginas", "field.required");
	    }		
	}

}
