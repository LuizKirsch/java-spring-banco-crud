package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.entities.Aluno;
import br.com.ienh.springacessobanco.entities.Professor;
import br.com.ienh.springacessobanco.repositories.AlunoRepository;
import br.com.ienh.springacessobanco.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("professores", professorRepository.findAll());
        return "/professor/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        professorRepository.deleteById(id);
        return "redirect:/professor/listar";
    }

    @GetMapping("/novo")
    public String novoForm(){
        return "/professor/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(String nome){
        Professor professor = new Professor();
        professor.setNome(nome);
        professorRepository.save(professor);
        return "redirect:/professor/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        professorRepository.findById(id).ifPresent(professor -> model.addAttribute("professor", professor));
        return "/professor/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(int id, String nome){
        professorRepository.findById(id).ifPresent(professor -> {
            professor.setNome(nome);
            professorRepository.save(professor);
        });
        return "redirect:/professor/listar";
    }
}
