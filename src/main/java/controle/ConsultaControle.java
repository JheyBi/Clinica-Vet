package controle;
import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Tutor;
import modelo.Consulta;
import util.JsfUtil;

@Named
@ViewScoped
public class ConsultaControle implements Serializable{
    private Dao<Animal> daoAnimal;
    private List<Animal> listaAnimal;
    private Consulta consulta; 
    
@PostConstruct
    public void iniciar() {
        daoAnimal = new Dao(Animal.class);
        listaAnimal = daoAnimal.listarTodos();
        consulta = new Consulta();
    }

    public String salvar(){
        consulta.getAnimal().getConsultas().add(consulta);
        daoAnimal.alterar(consulta.getAnimal());
        consulta = new Consulta(); // limpa os campos 
        JsfUtil.mostrarSucesso("Consulta cadastrada");
//        lista = dao.listarTodos(); // atualiza tabela 
        return null;
        
    }
    public Dao<Animal> getDaoAnimal() {
        return daoAnimal;
    }

    public void setDaoAnimal(Dao<Animal> daoAnimal) {
        this.daoAnimal = daoAnimal;
    }

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public void setListaAnimal(List<Animal> listaAnimal) {
        this.listaAnimal = listaAnimal;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    
   
}
