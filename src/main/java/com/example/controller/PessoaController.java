package com.example.controller;

import com.example.model.Pessoa;
import com.example.repository.PessoaRepository;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PessoaController {
    @EJB
    private PessoaRepository pessoaRepository;

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;

    public void save() {
        pessoaRepository.save(pessoa);
        pessoa = new Pessoa();
        loadPessoas();
    }

    public void update() {
        pessoaRepository.update(pessoa);
        loadPessoas();
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
        loadPessoas();
    }

    public List<Pessoa> getPessoas() {
        if (pessoas == null) {
            loadPessoas();
        }
        return pessoas;
    }

    private void loadPessoas() {
        pessoas = pessoaRepository.findAll();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
