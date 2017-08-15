package com.imob.model;

import java.util.List;

public class ImobRN {

	public void salvar(Imob m) {
		new ImobDAO().inserir(m);	
	}

	public List<Imob> listarTodos() {
		return new ImobDAO().listar();
	}

	public void delete(Imob m) {
		new ImobDAO().delete(m);
	}
}
