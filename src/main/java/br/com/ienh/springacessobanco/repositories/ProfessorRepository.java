package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

}