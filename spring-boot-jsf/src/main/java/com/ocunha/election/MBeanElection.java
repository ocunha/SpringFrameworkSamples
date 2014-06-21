package com.ocunha.election;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean("mBeanElection")
@ViewScoped
public class MBeanElection {
	
	private List<SelectItem> candidates;
	
	private String candidateName;
	
	@PostConstruct
	public void init(){
		candidates = new ArrayList<>();
	}
	
	public void add() {
		if(candidateName != null && !"".equals(candidateName.trim())){
			candidates.add(new SelectItem(new Candidate(candidateName), candidateName));
			candidateName = "";
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha o nome do candidato") );
		}
	}

	public void increaseVote(int index){
		Candidate candidate = (Candidate) candidates.get(index).getValue();
		((Candidate) candidates.get(index).getValue()).setVotos(candidate.getVotos()+1);
	}
	
	public void decreaseVote(int index){
		Candidate candidate = (Candidate) candidates.get(index).getValue();
		if(candidate.getVotos() > 0){
			((Candidate) candidates.get(index).getValue()).setVotos(candidate.getVotos()-1);
		}
	}

	public List<SelectItem> getCandidates() {
		return candidates;
	}


	public void setCandidates(List<SelectItem> candidates) {
		this.candidates = candidates;
	}


	public String getCandidateName() {
		return candidateName;
	}


	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}


}
