package com.example.repository;

import com.example.model.Pessoa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PessoaRepository {
    @PersistenceContext
    private EntityManager em;

    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    public void update(Pessoa pessoa) {
        em.merge(pessoa);
    }

    public void delete(Pessoa pessoa) {
        em.remove(em.contains(pessoa) ? pessoa : em.merge(pessoa));
    }

    public Pessoa find(Long id) {
        return em.find(Pessoa.class, id);
    }

    public List<Pessoa> findAll() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }
}
