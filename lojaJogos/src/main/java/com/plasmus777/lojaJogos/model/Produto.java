package com.plasmus777.lojaJogos.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo descricao não pode ser vazio!")
	private String nome;
	
	@NotBlank(message = "O atributo descricao não pode ser vazio!")
	private String descricao;
	
	@NotNull(message = "O atributo quantidade é obrigatório!")
	@Positive(message = "O atributo quantidade deve ser maior do que zero!")
	@Min(0)
	private int quantidade;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "O atributo preço é obrigatório!")
	@Positive(message = "O atributo preço deve ser maior do que zero!")
	private float preco;
}
