package dao.ImplJPA;
import javax.persistence.EntityManagerFactory;

import Idao.ICommentsPet;
import dto.CommentsPet;

/**
 *
 * @author root
 */
public class CommentsPetJpaController extends GenericDaoJpa<CommentsPet> implements ICommentsPet {

	public CommentsPetJpaController(EntityManagerFactory emf) {
		super(CommentsPet.class, emf);
		// TODO Auto-generated constructor stub
	}




    
    
}
