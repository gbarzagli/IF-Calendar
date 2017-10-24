package teste;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teste;
import dao.TesteDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;

@WebServlet("/teste-servlet")
public class TesteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TesteDAO testeDao = DAOFactory.getDAO(DAOConstants.JPA);

        Teste teste1 = new Teste();
        teste1.setValue(500);
        testeDao.insert(teste1);

        Teste teste2 = new Teste();
        teste2.setValue(600);
        testeDao.insert(teste2);

        List<Teste> dados = testeDao.all();
        request.setAttribute("dados", dados);

        request.getRequestDispatcher("WEB-INF/jsp/teste-jsp.jsp").forward(request, response);

    }

}
