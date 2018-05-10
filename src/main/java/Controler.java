import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.GerenciadorEstoque;

/**
 * Servlet implementation class Controler
 */
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String custoFalta = request.getParameter("custoFalta");
		String valorPeca = request.getParameter("valorPeca");
		String taxaArmazenamento = request.getParameter("taxaArmazenamento");
		String consumoMedio = request.getParameter("consumoMedio");
		String custoPedido = request.getParameter("custoPedido");
		String estoqueLimite = request.getParameter("estoqueLimite");
		
/*		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				custoFalta, valorPeca, taxaArmazenamento, consumoMedio, custoPedido, estoqueLimite);
		gerenciadorDeEstoque.calcular();*/
		
		request.getRequestDispatcher("resposta.jsp").forward(request, response);
	}


}
