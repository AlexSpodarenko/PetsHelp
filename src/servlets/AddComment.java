package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.WebConstruction;
import dao.ImplJPA.DaoFactory;
import dto.Client;
import dto.CommentsPet;
import dto.FindingPet;
import dto.Statemate;

/**
 * Servlet implementation class AddComment
 */
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Вызываеться для обработки запроса на добавления коментария. Сохраняет коментарий в базе
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object login=request.getSession().getAttribute("login");
		if(login==null)
		{	WebConstruction.backToIndex(response, request);
			return;
		}
		String text=request.getParameter("commentText");
		String idS=request.getParameter("idForComment");
		CommentsPet cur=new CommentsPet();
		Client cl=DaoFactory.getClientDao().testLogin(login.toString());
		cur.setIdClient(cl);
		cur.setCommentText(text);
		if(idS.substring(0,1).equals("S"))
		{
			Integer numId=Integer.parseInt(idS.substring(1,idS.length()));
			Statemate st=DaoFactory.getStatemateDao().findById(numId);
			cur.setIdStatemate(st);
			st.getCommentsPetCollection().add(cur);
		}
		if(idS.substring(0,1).equals("F"))
		{
			Integer numId=Integer.parseInt(idS.substring(1,idS.length()));
			FindingPet fp=DaoFactory.getFindingPetDao().findById(numId);
			cur.setIdFindingPet(fp);
			fp.getCommentsPetCollection().add(cur);
		}
		DaoFactory.getCommentsDao().save(cur);
		response.getOutputStream().write(login.toString().getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
