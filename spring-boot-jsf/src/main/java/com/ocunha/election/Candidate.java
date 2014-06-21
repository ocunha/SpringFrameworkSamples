package com.ocunha.election;

public class Candidate {
	
	private String name;
	private Integer votos;
	
	public Candidate(String name) {
		this.name = name;
		this.votos = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVotos() {
		return votos;
	}

	public void setVotos(Integer votos) {
		this.votos = votos;
	}
	

}
