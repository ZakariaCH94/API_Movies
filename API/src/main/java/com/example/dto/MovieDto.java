package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

	private Long id=null;
	private String title="";
	private String language="";
	private Integer  recordedYear= null;
	private String image="";
	private  PersonDto specialMention=null;
	private String description="";
	private boolean selected=false;
	private Long categoryId;
	
	
	
}
