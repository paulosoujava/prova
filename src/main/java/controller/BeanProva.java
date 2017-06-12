package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.EnderecoDAO;
import enity.Endereco;



@ManagedBean
@SessionScoped
public class BeanProva implements Serializable{

	private static final long serialVersionUID = 1L;
	private Endereco endereco;
	private EnderecoDAO eD = new EnderecoDAO();
	private List<Endereco> listaEndereco= eD.listar();
	
	public BeanProva() {

	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getListaEndereco() {
		
		return listaEndereco;
	}

	

	public EnderecoDAO geteD() {
		return eD;
	}

	public void seteD(EnderecoDAO eD) {
		this.eD = eD;
	}
	
	public String editar( Endereco e){
		this.endereco = e;
		System.out.println(this.endereco);
		return "editar";
	}
	public String deletar( Endereco e ){
		
		if( eD.remover(e.getId()) ){
			return "lista";
		}else{
			return null;
		}
		
	}
	public String editarEndereco(){
		if( eD.atualizar(this.endereco) ){
			return "index";
		}else{
			return null;
		}
	}

	
	
	
}
