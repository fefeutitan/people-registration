package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pessoa implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date idade;

    @Column(length = 2, nullable = false)
    private String sexo;

    // Getters and Setters
}
