package com.example.controller;

import com.example.model.Pessoa;
import com.example.repository.PessoaRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PessoaControllerTest {

    private PessoaController controller;
    private FakePessoaRepository repository;

    @Before
    public void setUp() {
        repository = new FakePessoaRepository();
        controller = new PessoaController();
        controller.setPessoaRepository(repository);
        controller.init();
    }

    @Test
    public void shouldLoadEmptyListWhenInitialized() {
        assertNotNull(controller.getPessoas());
        assertTrue(controller.getPessoas().isEmpty());
    }

    @Test
    public void shouldSaveAndResetForm() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setIdade(28);
        pessoa.setSexo("F");
        controller.setPessoa(pessoa);

        controller.save();

        assertEquals(1, controller.getPessoas().size());
        assertEquals("Maria", controller.getPessoas().get(0).getNome());
        assertFalse(controller.isEditing());
        assertNull(controller.getPessoa().getId());
    }

    @Test
    public void shouldEnterEditModeAndUpdatePerson() {
        Pessoa pessoa = repository.create("Joao", 30, "M");
        controller.refresh();

        controller.edit(pessoa);
        controller.getPessoa().setNome("Joao Silva");
        controller.update();

        assertEquals(1, controller.getPessoas().size());
        assertEquals("Joao Silva", controller.getPessoas().get(0).getNome());
        assertFalse(controller.isEditing());
    }

    @Test
    public void shouldDeletePerson() {
        Pessoa pessoa = repository.create("Ana", 25, "F");
        controller.refresh();

        controller.delete(pessoa);

        assertTrue(controller.getPessoas().isEmpty());
    }

    @Test
    public void shouldResetFormWithoutChangingList() {
        Pessoa pessoa = repository.create("Carlos", 40, "M");
        controller.refresh();
        controller.edit(pessoa);

        controller.resetForm();

        assertFalse(controller.isEditing());
        assertEquals(1, controller.getPessoas().size());
    }

    private static class FakePessoaRepository extends PessoaRepository {
        private final List<Pessoa> pessoas = new ArrayList<>();
        private long nextId = 1L;

        @Override
        public void salvar(Pessoa pessoa) {
            pessoa.setId(nextId++);
            pessoas.add(pessoa);
        }

        @Override
        public void update(Pessoa pessoa) {
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i).getId().equals(pessoa.getId())) {
                    pessoas.set(i, pessoa);
                    return;
                }
            }
        }

        @Override
        public void delete(Pessoa pessoa) {
            pessoas.removeIf(existing -> existing.getId().equals(pessoa.getId()));
        }

        @Override
        public List<Pessoa> findAll() {
            return new ArrayList<>(pessoas);
        }

        private Pessoa create(String nome, int idade, String sexo) {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setIdade(idade);
            pessoa.setSexo(sexo);
            salvar(pessoa);
            return pessoa;
        }
    }
}
