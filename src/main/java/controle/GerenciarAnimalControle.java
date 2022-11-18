package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Tutor;
import modelo.Usuario;
import util.JsfUtil;

/**
 *
 * @author José
 */
@Named
@ViewScoped
public class GerenciarAnimalControle implements Serializable {
    private Dao<Tutor> daoTutor;
    private List<Tutor> listaTutores;
    private Animal animal; 
    
    @PostConstruct
    public void iniciar() {
        daoTutor = new Dao(Tutor.class);
        listaTutores = daoTutor.listarTodos();
        animal = new Animal();
    }

    public String salvar(){
        animal.getTutor().getAnimais().add(animal);
        daoTutor.alterar(animal.getTutor());
        animal = new Animal(); // limpa os campos 
        JsfUtil.mostrarSucesso("Animal cadastrado");
//        lista = dao.listarTodos(); // atualiza tabela 
        return null;
        
    }
    public List<Tutor> getListaTutores() {
        return listaTutores;
    }

    public void setListaTutores(List<Tutor> listaTutores) {
        this.listaTutores = listaTutores;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
       
}