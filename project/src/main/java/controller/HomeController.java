package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import dao.TesteDAO;
import factory.DAOFactory;
import model.Teste;

@Controller
public class HomeController {

    @Inject
    private Result result;

    @Path("")
    public void index() {
        Teste teste = new Teste();
        teste.setValue(1337);
        TesteDAO dao = (TesteDAO) DAOFactory.getDAO(Teste.CLASS_NAME);
        dao.insert(teste);
        result.include("message", "Hello World!");
    }

}
