package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.entities.Aluno;
import br.com.ienh.springacessobanco.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "/aluno/listar";
    }

    @GetMapping("/novo")
    public String novoForm(){
        return "/aluno/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(String nome, String endereco, String nascimento, String numeroMatricula, String cpf){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setNascimento(LocalDate.parse(nascimento));
        aluno.setNumeroMatricula(numeroMatricula);
        aluno.setCpf(cpf);
        alunoRepository.save(aluno);
        return "redirect:/aluno/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        alunoRepository.findById(id).ifPresent(aluno -> model.addAttribute("aluno", aluno));
        return "/aluno/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(int id, String nome, String endereco, String nascimento, String numeroMatricula, String cpf){
        alunoRepository.findById(id).ifPresent(aluno -> {
            aluno.setNome(nome);
            aluno.setEndereco(endereco);
            aluno.setNascimento(LocalDate.parse(nascimento));
            aluno.setNumeroMatricula(numeroMatricula);
            aluno.setCpf(cpf);
            alunoRepository.save(aluno);
        });
        return "redirect:/aluno/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        alunoRepository.deleteById(id);
        return "redirect:/aluno/listar";
    }

}
