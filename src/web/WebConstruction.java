package web;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplJPA.DaoFactory;
import dto.City;
import dto.CommentsPet;
import dto.FindingPet;
import dto.Pet;
import dto.Statemate;
/**
 * Класс написан с целю избежать смешивания Java кода с HTML тэгами и JavaScript кодом. На страницах в нужном месте
 * вызываеться статический метод из этого класса который возвращает строку которая представляет собой фрагмент HTML 
 * страницы. 
 * @author corwin
 *
 */

public class WebConstruction {
	/**
	 * 
	 * @param items коллекция строк которые должны быть в листбоксе
	 * @param numSelected количество строк которые могут быть одновременно выбраны
	 * @param menuID id ListBoxа
	 * @param menuName имя ListBoxа
	 * @return
	 * Возвращает строку HTML тэгов которая представляет собой ListBox сформированый их коллекции строк
	 * items переданой в метод в качестве параметра
	 */
	public static String getlistBox(Collection<String> items,int numSelected,String menuID,String menuName)
	{	
		if(items.isEmpty())
			return null;
		Iterator<String> it=items.iterator();
		int i=0;
		String res="<select id="+menuID+" size=\"1\""+" name="+menuName+" style=\"width:100%;\">\n\"";
		res+="<option >non set</option>\n";
		while(it.hasNext())
		{	String tmp=it.next();
			res+="<option >"+tmp+"</option>\n";
		}
		res+="</select>\n";
		return res;
	}
	
	/**
	 * 
	 * @param items коллекция строк которые должны быть в листбоксе
	 * @param numSelected количество строк которые могут быть одновременно выбраны
	 * @param menuID id ListBoxа
	 * @param menuName имя ListBoxа
	 * @param scriptFuncName имя функции javaScript  которая будет повешена на даное меню по событию onclick
	 * @return
	 * Возвращает строку HTML тэгов которая представляет собой ListBox сформированый их коллекции строк
	 * items переданой в метод в качестве параметра
	 */
	public static String getlistBox(Collection<String> items,int numSelected,String menuId,String scriptFuncName,String menuName)
	{	
		if(items.isEmpty())
			return null;
		Iterator<String> it=items.iterator();
		int i=0;
		String res="<select id="+"\""+menuId+"\" size=\"1\"" +" name="+"\""+menuName+"\""+" onchange=\""+scriptFuncName+"\" style=\"width:100%;\">\n";
		res+="<option >non set</option>\n";
		while(it.hasNext())
		{	String tmp=it.next();
			res+="<option >"+tmp+"</option>\n";
		}
		res+="</select>\n";
		return res;
	}
	/**
	 * 
	 * @param request
	 * @return
	 * Возвращает на страницу сообщение которое информирует пользователе о том под каким именем он авторизировалься
	 * или о неудаче авторизации
	 */
	public static String getAutorizationMessage(HttpServletRequest request)
	{   Object mess=null;
		mess=request.getSession().getAttribute("message");
		if(mess==null)
			return "";
		else 
			return mess.toString();
	}
	/**
	 * 
	 * @param response
	 * @param request
	 * @throws IOException
	 * Походу изобретение велосипеда... Так я выхожу из сервлета и возвращаюсь на index.jsp после того как сервлет отработал
	 */
	public static void backToIndex(HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		
		String back="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"+
		"<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\"><head></head>";
		back+="<body><script type=\"text/javascript\">  location=\"index.jsp\"; </script></body></html>";			
		response.getOutputStream().write(back.getBytes());
	}
	/**
	 * 
	 * @param request
	 * @return
	 * Возвращает подробую информацию о животном на старницу просмотра подробной информации
	 */
	public static String getInfoForPageElem(HttpServletRequest request)
	{
	      String resParse=null;
	      String par=request.getParameter("id");
	      if (par.charAt(0)=='F')
	      {
	    	Integer id=Integer.parseInt(par.substring(1));
	      	FindingPet cur=DaoFactory.getFindingPetDao().findById(id);
	      	if(cur==null)
		  		return null;
			resParse="<table><tr><td style=\"width:40%\"><img src=\""+cur.getPhoto()+ "\"/></td>";
			resParse+="<td style=\"width:60% height:100px\">";
			String resHTML="<p> %s \n порода - %s \n найден в городе %s %s области \n в данный момент находиться: <input type=\"button\" onclick=\"showAddress(this.value)\" value=\"%s\" /> \n " +
					"особые приметы:%s</p> </td></tr></table>";
			resParse+=String.format(resHTML,cur.getIdPet().getPatType(),cur.getIdPet().getSpecies(),cur.getCity().getCityName(),
					cur.getCity().getRegion(),cur.getWherePlaced(),cur.getSpecialFeatures());

	      }
	      else
		  {
		      if(par.charAt(0)=='S')
		      {		Integer id=Integer.parseInt(par.substring(1));
		    	  	Statemate cur=DaoFactory.getStatemateDao().findById(id);
		    	  	if(cur==null)
		    	  		return null;
					resParse="<table><tr><td style=\"width:40%\"><img src=\""+cur.getPhoto()+ "\"/></td>";
					resParse+="<td style=\"width:60% height:100px\">";
					String resHTML="<p> %s \n порода - %s \n потеряно в городе <input type=\"button\" onclick=\"showAddress(this.value)\" value=\"%s\" /> %s области \n отзываеться на кличку \"%s\" \n " +
							" приблизительный вес в момент пропажи %s кг \n особые приметы:%s</p> </td></tr></table>";
					resParse+=String.format(resHTML,cur.getPet().getPatType(),cur.getPet().getSpecies(),cur.getCity().getCityName(),
							cur.getCity().getRegion(),cur.getNamepat(),cur.getWeight(),cur.getSpecialFeatures());			
				}
	      }
	      if((request.getSession().getAttribute("rights").equals("admin"))||(request.getSession().getAttribute("rights").equals("staff")))
	      {
				resParse+="<p><input type=\"button\" onclick=\"setVisibleFormStatemate()\" value=\"изменить\"/></p>";
	 	      }
				resParse+="<p><input type=\"button\" value=\"добавить коментарий\"onclick=\"showCommentBlock()\"/></p>";
				
//	     }
				return resParse;
	}
	/**
	 * @param isStat if true then show list of Statemate comments, if false show list FindingPet comments
	 * Возращает список коментариев к выбраному животному на страницу
	 */
	public static String getCommentsList(Integer id, boolean isStat, HttpServletRequest request)
	{	Object loginO=request.getSession().getAttribute("login");
		if(loginO==null)
			return null;
		String login=loginO.toString();
		Integer idUser=DaoFactory.getClientDao().testLogin(login).getId();
		String resString=null;
		if(isStat)
		{
			Statemate cur=DaoFactory.getStatemateDao().findById(id);
			Collection<CommentsPet> col=cur.getCommentsPetCollection();
			Iterator<CommentsPet> it=col.iterator();
			while(it.hasNext())
			{
				CommentsPet curComment=it.next();
				resString+="<div class=\"comment\" name=\"commentObject\" id=\"Container"+curComment.getId().toString()+"\"><br><p>"+curComment.getIdClient().getClientLogin()+" написал: </p>"+
				"<p>"+curComment.getCommentText()+"</p>";
				if(curComment.getIdClient().getId()==idUser)
					{
						resString+="<p><input type=\"button\" id=\""+curComment.getId().toString()+"\" value=\"удалить\" name=\"commentDeleteButton\"/>  </p>";
					}
				resString+="</div>";
			}
		}
		if(!isStat)
		{
			FindingPet cur=DaoFactory.getFindingPetDao().findById(id);
			Collection<CommentsPet> col=cur.getCommentsPetCollection();
			Iterator<CommentsPet> it=col.iterator();
			while(it.hasNext())
			{
				CommentsPet curComment=it.next();
				resString+="<div  class=\"comment\" name=\"commentObject\" id=\"Container"+curComment.getId().toString()+"\"><br><p>"+curComment.getIdClient().getClientLogin()+" написал: </p>"+
				"<p>"+curComment.getCommentText()+"</p>";
				if(curComment.getIdClient().getId()==idUser)
					{
						resString+="<p><input type=\"button\" value=\"удалить\" id=\""+curComment.getId().toString()+"\" name=\"commentDeleteButton\"/>  </p>";
					}
				resString+="</div>";
			}
		}
		return resString;
	}
	
	/**
	 * Следующие 3 метода возвращают на старинцу элементы меню доступны только
	 * привилегированым пользователям
	 * @param request
	 * @return
	 */
	public static String getAdminAddPanel(HttpServletRequest request)
	{	Object rights=request.getSession().getAttribute("rights");
		if((rights!=null)&&(rights.toString().equals("admin")))
		{
		return "<li><a href=\"addCityForm.jsp\">Добавить город </a></li>"+
            "<li><a href=\"addStaffForm.jsp\">Добавить сотрудника </a></li>"+
           "<li><a href=\"addPetForm.jsp\">Добавить животное </a></li>";
		}
		else
			return "";
	}
	
	
	public static String getClientAddPanel(HttpServletRequest request)
	{	Object rights=request.getSession().getAttribute("rights");
		if((rights!=null)&&(rights.toString().equals("client")))
		{
		return "<li><a href=\"addFindinPetForm.jsp\">Добавить данные о находке</a></li>"+
				"<li><a href=\"addStatemateForm.jsp\">Добавить данные о пропаже</a></li>";
		}
		else
			return "";
	}
	
	public static String getStaffAddPanel(HttpServletRequest request)
	{	Object rights=request.getSession().getAttribute("rights");
		if((rights!=null)&&(rights.toString().equals("staff")))
		{
		return "<li><a href=\"gallery.jsp\">Поиск</a></li>";
		}
		else
			return "";
	}
	
	/**
	 * Нужно только для курсача по БД, отчет главный-детальный
	 * @return
	 */
	public static String getReport()
	{	Collection<City> cityCol=DaoFactory.getCityDao().findAll();
		Iterator<City> cit=cityCol.iterator();
		String resString="";
		while(cit.hasNext())
		{	City curC=cit.next();
			resString+="<p>Город "+curC.getCityName()+"</p>";			
			Collection<Pet> petCol=DaoFactory.getPetDao().getByCityNameAndRegion(curC.getRegion(), curC.getCityName());
			Iterator<Pet> petIt=petCol.iterator();
			Collection<String> uniquePetType=new LinkedList<String>();
			while(petIt.hasNext())
			{
				Pet curP=petIt.next();
				if(!uniquePetType.contains(curP.getPatType()))
				{
					uniquePetType.add(curP.getPatType());
				}		
			}
			Iterator<String> petTypeIt=uniquePetType.iterator();
			while(petTypeIt.hasNext())
			{	String curPetType=petTypeIt.next();
				resString+="<p>    тип животного: "+curPetType+"</p> <table>";
				Collection<FindingPet> fpCol=DaoFactory.getFindingPetDao().complexFind(curC.getRegion(), curC.getCityName(), curPetType, "non set", "non set");
				Iterator<FindingPet> fpit=fpCol.iterator();
				while(fpit.hasNext())
				{	
					FindingPet cur=fpit.next();			
					resString+="<tr><td style=\"width:40%\"><img src=\""+cur.getPhoto()+ "\"/></td>";
					resString+="<td style=\"width:60% height:100px\">";
					String resHTML="<p> %s \n порода - %s \n найден в городе %s %s области \n в данный момент находиться: %s \n " +
							"особые приметы:%s</p> <p> <input id=\"F" + cur.getId()+"\" name=\"moreReference\" type=\"button\" value=\"more\" /></p></td></tr>";
					resString+=String.format(resHTML,cur.getIdPet().getPatType(),cur.getIdPet().getSpecies(),cur.getCity().getCityName(),
							cur.getCity().getRegion(),cur.getWherePlaced(),cur.getSpecialFeatures());	
				}
				resString+="</table>";
			}
		}		
		return resString;
	}
	
	
	
	

}
