package com.marselsampe.tictactoe.lib;

class Player {
	private String name;
	private SeedTypeEnum type;
	
	public Player( String name, SeedTypeEnum type ){
		this.name = name;
		this.type = type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public SeedTypeEnum getType(){
		return this.type;
	}
}