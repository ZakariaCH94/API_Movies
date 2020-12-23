package com.example.result;

import lombok.Getter;
import lombok.Setter;

/**
 * Resultat KO
 * @author marjorie
 *
 */
@Getter
@Setter 
public class ErrorResult extends Result {

	private String code="";
	
	public ErrorResult () {
		super ("error");
	}
	
	public ErrorResult (final String code) {
		
		super ("error");
		this.code=code;
		
	}
}
