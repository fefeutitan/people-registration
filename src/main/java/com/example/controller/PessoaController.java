package com.example.controller;

import com.example.model.Pessoa;
import com.example.repository.PessoaRepository;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PessoaController {
    @EJB
    private PessoaRepository pessoaRepository;

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;

    @PostConstruct
    public void init() {
        loadPessoas();
    }

    public void save() {
        pessoaRepository.salvar(pessoa);
        resetForm();
        refresh();
    }

    public void update() {
        pessoaRepository.update(pessoa);
        resetForm();
        refresh();
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
        refresh();
    }

    public void edit(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void resetForm() {
        pessoa = new Pessoa();
    }

    public boolean isEditing() {
        return pessoa.getId() != null;
    }

    public void refresh() {
        loadPessoas();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    private void loadPessoas() {
        if (pessoaRepository == null) {
            pessoas = new ArrayList<>();
            return;
        }
        pessoas = pessoaRepository.findAll();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    void setPessoaRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
}
