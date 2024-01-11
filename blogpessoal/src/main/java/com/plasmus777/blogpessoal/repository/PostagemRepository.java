package com.plasmus777.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plasmus777.blogpessoal.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
}
