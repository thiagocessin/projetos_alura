package br.com.tcessin.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcessin.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nomeCurso);

}
