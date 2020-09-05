package br.com.fiap.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private Date dataNasc;
	private char genero;
	private String telefone;
	
	public Cliente() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dataNasc = sf.parse(dataNasc);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
