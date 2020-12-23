package com.example.result;

import lombok.Getter;

@Getter
public class Result {

	private String status="";
	
	/**
	 * Constructeur vide
	 */
	public Result () {
		
	}
	
	/**
	 * Constructeur avec parma status
	 * @param status
	 */
	public Result (final String status) {
		this.status=status;
	}
}
