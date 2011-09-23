package servlets;

import java.io.IOException;
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
import dto.Pet;
import dto.Statemate;

/**
 * Servlet implementation class EditStatemate
 */
public class EditStatemate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStatemate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		String cityName=null;
		String petType=null;
		String petSpecies=null;
		String petName=null;
		Integer weight=null;
		String region=null;
		String specialFiture=null;
		DiskFileItemFactory f=new DiskFileItemFactory();
		ServletFileUpload up=new ServletFileUpload(f); 
		List reqList=null;
		reqList=up.parseRequest(request);
		String id=null;

			
			int i=0;
			FileItem photoForSave=null;
			for(i=0;i<reqList.size();i++)
			{	
				FileItem fi=(FileItem) reqList.get(i);
				String tmp=fi.getFieldName();
				if(fi.getFieldName().equals("petName"))
				{	if(fi.getString().length()!=0)
					petName=fi.getString();
				}
				if(fi.getFieldName().equals("weight"))
				{	if(fi.getString().length()!=0)
					weight=Integer.parseInt(fi.getString());
				}
				if(fi.getFieldName().equals("regionMenu"))
				{	if(fi.getString().length()!=0)
					region=fi.getString();
				}
				if(fi.getFieldName().equals("idS"))
				{	if(fi.getString().length()!=0)
					id=fi.getString();
				}
				if(fi.getFieldName().equals("cityMenu"))
				{	if(fi.getString().length()!=0)
					cityName=fi.getString();
				}
				if(fi.getFieldName().equals("petTypeMenu"))
				{	if(fi.getString().length()!=0)
					petType=fi.getString();
				}
				if(fi.getFieldName().equals("SpeciesMenu"))
				{	if(fi.getString().length()!=0)
					petSpecies=fi.getString();
				}
				if(fi.getFieldName().equals("foto_f"))
				{	if(fi.getString()!=null)
					photoForSave=fi;
				}
				if(fi.getFieldName().equals("specialFiture"))
				{	if(fi.getString().length()!=0)
					specialFiture=fi.getString();
				}
			}
			if(id==null)
				return;
			Statemate stat=DaoFactory.getStatemateDao().findById(Integer.parseInt(id));
			Statemate oldStat=DaoFactory.getStatemateDao().findById(Integer.parseInt(id));
			
			if(specialFiture!=null)
			stat.setSpecialFeatures(specialFiture);
			if((cityName!=null)&&(region!=null))
			{City curCity=DaoFactory.getCityDao().findByNameAndRegion(cityName, region);	
			curCity.getStatemateCollection().remove(oldStat);
			curCity.getStatemateCollection().add(stat);
			stat.setCity(curCity);
			}
			if((petSpecies!=null)&&(petType!=null))
			{
			Pet curPet=DaoFactory.getPetDao().getByTypeAndSpecies(petType, petSpecies);
			curPet.getStatemateCollection().remove(oldStat);
			curPet.getStatemateCollection().add(stat);
			stat.setPet(curPet);
			}
			if(petName!=null)
				stat.setNamepat(petName);
			if(specialFiture!=null)
				stat.setSpecialFeatures(specialFiture);
			if(weight!=null)
				stat.setWeight(weight);
			if(photoForSave!=null)
			DaoFactory.getStatemateDao().save(stat, photoForSave);
			else 
				DaoFactory.getStatemateDao().save(stat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebConstruction.backToIndex(response, request);	
	}

}
