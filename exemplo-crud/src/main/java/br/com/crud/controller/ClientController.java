package br.com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.crud.model.Client;
import br.com.crud.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	
	public void save (Client client) {
		service.save(client);
	}
	public void remove (Long idclient) {
		service.remove(idclient);
	}
	
	
	@GetMapping("list")
	public ResponseEntity<List<Client>> list(){
		List<Client>clients = service.list();
		if (clients.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}
	
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?>search(@PathVariable("id") Long id){
		Client client = service.searchId(id);
		if (client == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	public void update (Client client) {
		service.update(client);
	}
}