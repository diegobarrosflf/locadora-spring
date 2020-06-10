package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Filme;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.FilmeRepository;

@SpringBootApplication
public class LocadoraSpringApplication implements CommandLineRunner{


	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LocadoraSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 =  new Categoria(null,"Ação");
		Categoria cat2 =  new Categoria(null,"Terror");
		
		Filme f1 = new Filme(null, "Matrix", 5.00);
		Filme f2 = new Filme(null, "O chamado", 6.00);
		Filme f3 = new Filme(null, "Exterminador do futuro", 4.50);
		
		cat1.getFilmes().addAll(Arrays.asList(f1,f2,f3));
		cat2.getFilmes().addAll(Arrays.asList(f2));
		
		f1.getCategorias().addAll(Arrays.asList(cat1));
		f2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		f3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		filmeRepository.saveAll(Arrays.asList(f1,f2,f3));
		
		
	}

}
