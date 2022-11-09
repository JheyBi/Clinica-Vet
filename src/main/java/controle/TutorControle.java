/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.Dao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Tutor;
import java.util.List;
import util.JsfUtil;

/**
 *
 * @author temporario
 */

@Named
@ViewScoped
public class TutorControle implements Serializable {
    private Tutor tutor1;
    private Dao<Tutor> dao;
    private List<Tutor> lista;
    
    @PostConstruct
    public void iniciar(){
        tutor1 = new Tutor();
        dao = new Dao(Tutor.class);
        setLista(dao.listarTodos()); 
    }
    
    public String salvar(){
        dao.inserir(tutor1);
        tutor1 = new Tutor(); // limpa os campos 
        JsfUtil.mostrarSucesso("Usuário cadastrado");
        lista = dao.listarTodos(); // atualiza tabela 
        return null; 
    }
    
    public void atualizar(){
        
    }

    public Tutor getTutor() {
        return tutor1;
    }

    public void setTutor(Tutor tutor1) {
        this.tutor1 = tutor1;
    }

    public Dao<Tutor> getDao() {
        return dao;
    }

    public void setDao(Dao<Tutor> dao) {
        this.dao = dao;
    }

    public List<Tutor> getLista() {
        return lista;
    }

    public void setLista(List<Tutor> lista) {
        this.lista = lista;
    }
    
}

