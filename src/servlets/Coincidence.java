package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.SendMailUsingAuthentication;
import dao.ImplJPA.DaoFactory;
import dto.Statemate;

/**
 * Servlet implementation class Coincidence
 */
public class Coincidence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Coincidence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Метод вызываеться когда сотрудник находит совпадение между потеряным животным и найденым.
	 * В данном методе устанавливаеться связь между найденым животным и заявлении о потере в базе данных
	 * и отправляетьс email пользователю который оставил завяление о пропаже животного
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foundId=request.getParameter("foundId");
		String soughtId=request.getParameter("soughtId");
		Integer fIdInt=Integer.parseInt(foundId.substring(4));
		Integer sIdInt=Integer.parseInt(soughtId.substring(4));
		Statemate tmp=DaoFactory.getStatemateDao().findById(sIdInt);
		tmp.setAlreadyFinding(fIdInt);
		DaoFactory.getStatemateDao().save(tmp);
		SendMailUsingAuthentication mailer=new SendMailUsingAuthentication();
		Collection<String> recipients=new ArrayList<String>();
		recipients.add(DaoFactory.getStatemateDao().findById(sIdInt).getClient().getEMail());
		try {
			mailer.postMail(recipients, "найдено животное", "забирайте быстрее", "SpodarenkoAlex@mail.ru");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
