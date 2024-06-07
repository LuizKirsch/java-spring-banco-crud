package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.AlunoDTO;
import br.com.ienh.springacessobanco.entities.Aluno;
import br.com.ienh.springacessobanco.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void salvarAluno(AlunoDTO aluno){
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(aluno.nome());
        novoAluno.setEndereco(aluno.endereco());
        novoAluno.setNascimento(aluno.nascimento());
        alunoRepository.save(novoAluno);
    }
}
