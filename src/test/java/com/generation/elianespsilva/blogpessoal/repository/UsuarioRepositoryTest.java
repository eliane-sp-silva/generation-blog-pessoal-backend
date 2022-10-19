package com.generation.elianespsilva.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.generation.elianespsilva.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		usuarioRepository.save(
				new Usuario(0L, "João da Silva", "https://i.imgur.com/h4t8loa.jpg", "joao@email.com.br", "13465278"));
				//dados na mesma ordem do construtor

		usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "https://i.imgur.com/NtyGneo.jpg",
				"manuela@email.com.br", "13465278"));

		usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "https://i.imgur.com/5M2p5Wb.jpg",
				"adriana@email.com.br", "13465278"));

		usuarioRepository.save(
				new Usuario(0L, "Paulo Antunes", "https://i.imgur.com/FETvs20.jpg", "paulo@email.com.br", "13465278"));
	}

	@Test
	@DisplayName("Retornar 1 usuário")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br"); //dados cadastrados no banco de dados
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br")); 
		//assertTrue(usuario.get().getUsuario().equals("joao@email.com")); //vai falhar porque não tem "br" >> entrada do usuário se não tiver igual o teste vai dar falha e não erro!

	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva"); //criar objeto para guardar lista.
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
		//assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana Santos")); vai falhar porque o filtro é Silva
	}


}
