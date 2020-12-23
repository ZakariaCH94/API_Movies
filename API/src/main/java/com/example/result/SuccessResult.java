package com.example.result;

import lombok.Getter;
import lombok.Setter;

/**
 * Resultat OK
 * @author marjorie
 *
 */
@Getter
@Setter
public class SuccessResult extends Result {
	
	private Object data;
	
	
	public SuccessResult () {
		super("success");
	}
	
	public SuccessResult (final Object data ) {
		super ("success");
		this.data=data;
	}

}
