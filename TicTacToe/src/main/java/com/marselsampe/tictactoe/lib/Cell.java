package com.marselsampe.tictactoe.lib;

class Cell {
	private SeedTypeEnum content;
	
	public Cell(){
		this.content = SeedTypeEnum.EMPTY;
	}

	public SeedTypeEnum getContent(){
		return this.content;
	}

	public void setContent( SeedTypeEnum content ){
		this.content = content;
	}
}