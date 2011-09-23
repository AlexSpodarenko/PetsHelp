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
import dto.FindingPet;
import dto.Pet;

/**
 * Servlet implementation class EditFindingPet
 */
public class EditFindingPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFindingPet() {
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
		String cityName=null;
		String petType=null;
		String petSpecies=null;
		String region=null;
		String specialFiture=null;
		String wherePlaced=null;
		String id=null;
		DiskFileItemFactory f=new DiskFileItemFactory();
		ServletFileUpload up=new ServletFileUpload(f); 
		List reqList=null;
		Date dat=null;
		try {
			reqList=up.parseRequest(request);
			int i=0;
			FileItem photoForSave=null;
			for(i=0;i<reqList.size();i++)
			{	
				FileItem fi=(FileItem) reqList.get(i);
				
				String tmp=fi.getFieldName();
				if(fi.getFieldName().equals("where_placed"))
				{	if(fi.getString().length()!=0)
					wherePlaced=fi.getString();
				}
				if(fi.getFieldName().equals("data"))
				{	if(fi.getString().length()!=0)
					{
					String tmpStr=fi.getString();
					int day =Integer.parseInt(tmpStr.substring(0,tmpStr.indexOf('.')));
					tmpStr=tmpStr.substring(tmpStr.indexOf('.')+1);
					int month=Integer.parseInt(tmpStr.substring(0,tmpStr.indexOf('.')));
					tmpStr=tmpStr.substring(tmpStr.indexOf('.')+1);
					int year=Integer.parseInt(tmpStr);
					 dat=new Date(year, month, day);
					}
					
				}
				if(fi.getFieldName().equals("regionMenu"))
				{	if(fi.getString().length()!=0)
					region=fi.getString();
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
				{	if(fi.getString().length()!=0)
					photoForSave=fi;
				}
				if(fi.getFieldName().equals("specialFiture"))
				{	if(fi.getString().length()!=0)
					specialFiture=fi.getString();
				}
				if(fi.getFieldName().equals("idF"))
				{	if(fi.getString().length()!=0)
					id=fi.getString();
				}
				if(fi.getFieldName().equals("where_placed"))
				{
					if(fi.getString().length()!=0)
						wherePlaced=fi.getString();
				}
				
			}
			if(id==null)
				return;
			FindingPet fpet=DaoFactory.getFindingPetDao().findById(Integer.parseInt(id));
			FindingPet oldFp=DaoFactory.getFindingPetDao().findById(Integer.parseInt(id));
			if(specialFiture!=null)
			fpet.setSpecialFeatures(specialFiture);
			if(wherePlaced!=null)
				fpet.setWherePlaced(wherePlaced);
			
			if((cityName!=null)&&(region!=null))
			{City curCity=DaoFactory.getCityDao().findByNameAndRegion(cityName, region);	
			curCity.getFindingPetCollection().remove(oldFp);
			curCity.getFindingPetCollection().add(fpet);
			fpet.setCity(curCity);
			}
			if((petSpecies!=null)&&(petType!=null))
			{
			Pet curPet=DaoFactory.getPetDao().getByTypeAndSpecies(petType, petSpecies);
			curPet.getFindingPetCollection().remove(oldFp);
			curPet.getFindingPetCollection().add(fpet);
			fpet.setIdPet(curPet);
			}
			if(dat!=null)
				fpet.setDate(dat);
			if(photoForSave!=null)
				DaoFactory.getFindingPetDao().save(fpet, photoForSave);
				else 
			DaoFactory.getFindingPetDao().save(fpet);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebConstruction.backToIndex(response, request);		
	}

}
