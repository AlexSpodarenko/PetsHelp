package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.WebConstruction;
import dao.ImplJPA.DaoFactory;
import dto.City;
import dto.Client;
import dto.FindingPet;
import dto.Pet;

/**
 * Servlet implementation class AddFindingPet
 */
public class AddFindingPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFindingPet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Вызываеться при отправлении запроса от формы добавления найденого животного. Загружает фотографию на сервер
	 * и сохраняет фотографию в файловой системе и обект класса "FindingPet в базе
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object loginO=request.getSession().getAttribute("login");	
		if(loginO==null)
		{	WebConstruction.backToIndex(response, request);
			return;
		}
		String login=loginO.toString();
		String cityName=null;
		String petType=null;
		String petSpecies=null;
		String region=null;
		String specialFiture=null;
		DiskFileItemFactory f=new DiskFileItemFactory();
		ServletFileUpload up=new ServletFileUpload(f); 
		List reqList=null;
		FindingPet fpet=new FindingPet();
		try {
			reqList=up.parseRequest(request);
			int i=0;
			FileItem photoForSave=null;
			for(i=0;i<reqList.size();i++)
			{	
				FileItem fi=(FileItem) reqList.get(i);
				
				String tmp=fi.getFieldName();
				if(fi.getFieldName().equals("where_placed"))
				{
					fpet.setWherePlaced(fi.getString());
				}
				if(fi.getFieldName().equals("data"))
				{	String tmpStr=fi.getString();
					int day =Integer.parseInt(tmpStr.substring(0,tmpStr.indexOf('.')));
					tmpStr=tmpStr.substring(tmpStr.indexOf('.')+1);
					int month=Integer.parseInt(tmpStr.substring(0,tmpStr.indexOf('.')));
					tmpStr=tmpStr.substring(tmpStr.indexOf('.')+1);
					int year=Integer.parseInt(tmpStr);
					Date dat=new Date(year, month, day);
					fpet.setDate(dat);
				}
				if(fi.getFieldName().equals("regionMenu"))
				{	
					region=fi.getString();
				}
				
				if(fi.getFieldName().equals("cityMenu"))
				{
					cityName=fi.getString();
				}
				if(fi.getFieldName().equals("petTypeMenu"))
				{
					petType=fi.getString();
				}
				if(fi.getFieldName().equals("SpeciesMenu"))
				{
					petSpecies=fi.getString();
				}
				if(fi.getFieldName().equals("foto_f"))
				{
					photoForSave=fi;
				}
				if(fi.getFieldName().equals("specialFiture"))
				{
					specialFiture=fi.getString();
				}
				
			}
			fpet.setSpecialFeatures(specialFiture);
			City curCity=DaoFactory.getCityDao().findByNameAndRegion(cityName, region);
			if(curCity==null)
				{	WebConstruction.backToIndex(response, request);
					return;
				};
			curCity.getFindingPetCollection().add(fpet);
			Client curClient=DaoFactory.getClientDao().testLogin(login);
			if(curClient==null)
			{	
				WebConstruction.backToIndex(response, request);
				return;
			};
			curClient.getFindingPetCollection().add(fpet);
			Pet curPet=DaoFactory.getPetDao().getByTypeAndSpecies(petType, petSpecies);
			if(curPet==null)
				{
				WebConstruction.backToIndex(response, request);
				return;
				};
			curPet.getFindingPetCollection().add(fpet);
			fpet.setClient(curClient);
			fpet.setCity(curCity);
			fpet.setIdPet(curPet);
			DaoFactory.getFindingPetDao().save(fpet, photoForSave);
			//DaoFactory.getCityDao().save(curCity);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebConstruction.backToIndex(response, request);		
	}

}
