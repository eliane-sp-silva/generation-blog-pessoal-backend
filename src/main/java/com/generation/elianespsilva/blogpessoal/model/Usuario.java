package com.generation.elianespsilva.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id //termina que é uma primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Nome é obrigatório")
	private String nome;
	
	@Size(max = 5000,
	message = "o link da foto não pode ser maior do que 5000 caracteres")
	private String foto;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O atributo Usuário é obrigatório")
	@Email(message = "Digite um e-mail válido!")
	private String usuario;
	
	@NotBlank(message = "O atributo Senha é obrigatório")
	@Size(min = 8, message = "A senha deve ter no mínimo de 8 caracteres")
	private String senha;
	
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	public Usuario() {
		
	}

	
	public Usuario(Long id, String nome, String foto,String usuario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.usuario = usuario;
		this.senha = senha;
	}

	//getters e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	

	
	
}
