package br.com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.model.Client;
import br.com.crud.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public void save (Client client) {
		repository.save(client);
	}
	
	public void remove (Long idclient) {
		repository.delete(idclient);
	}

	public List<Client> list (){
		return repository.findAll();
	}
	
	public Client searchId (Long idclient) {
		return repository.findOne(idclient);
	}
	public void update (Client client) {
		repository.saveAndFlush(client);
	}
	
	
}
