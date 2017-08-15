package com.imob.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.imob.model.Imob;
import com.imob.model.ImobRN;

@ManagedBean (name = "ViewImob")
public class ImobBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Imob imob = new Imob();

	public Imob getImob() {
		return imob;
	}

	public void setImob(Imob imob) {
		this.imob = imob;
	}
	
	public String actionNovo(){
		this.setImob(new Imob());
		return "formulario_imovel";
	}
	
	public String actionGravar(){
		new ImobRN().salvar(getImob());
		return "listagem_imovel";
	}
	
	public String actionApagar(){
		new ImobRN().delete(getImob());
		return "listagem_imovel";
	}
	
	public List<Imob> getTodasImob(){
		return new ImobRN().listarTodos();
	}
}
