package it.corso.service;

import java.util.List;

import it.corso.model.Opera;

public interface OperaService {

	Opera getOperaById(int id);
	List<Opera> getOpera();
	void deleteOpera(Opera opera);
	void createOpera(Opera opera);
	
}
