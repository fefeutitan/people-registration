package com.example;

import com.example.model.Pessoa;
import com.example.repository.PessoaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        PessoaRepository repo = new PessoaRepository();
        repo.setEntityManager(em);

        em.getTransaction().begin();
        
        Pessoa p = new Pessoa();
        p.setNome("João");
        p.setIdade(30);
        p.setSexo("M");

        repo.salvar(p);
        em.getTransaction().commit();

        System.out.println("Pessoas:");
        for (Pessoa pessoa : repo.listar()) {
            System.out.println(pessoa.getNome());
        }

        em.close();
        emf.close();
    }
}
