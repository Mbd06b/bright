package com.worscipe.bright.users.repository;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.worscipe.bright.users.model.User;

public class UserRepositoryImpl implements UserRepositoryCustom {
	
	private static final Logger logger = LogManager.getLogger(UserRepositoryImpl.class); 
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public Optional<List<User>> findContributorsByIdea(Long ideaId) {
//			logger.debug(" findingContributorsByIdeaId ("+ ideaId + ")");
//			Session session = this.sessionFactory.getCurrentSession();
//			
//			// Create a criteriaBuilder from the session
//			CriteriaBuilder cb = session.getCriteriaBuilder();
//			
//			// Create a query to use
//			CriteriaQuery<User> cq = cb.createQuery(User.class);
//			
//			// Define a range variable in FROM clause
//			Root<UserRecord> root = cq.from(UserRecord.class);
//			
//			// Specify the type the query result will be
//			cq.select(root).where(
//					cb.like(root.<String>get(MESSAGE_KEY), cb.parameter(String.class, LIKE_KEY_CONDITION)),
//					cb.like(root.<String>get(LOCALE), cb.parameter(String.class, LIKE_LOCALE_CONDITION)));
//			
//			// Prepare the query for execution
//			TypedQuery<MessagePropertyImpl> typedQuery = session.createQuery(cq);
//			typedQuery.setParameter(LIKE_KEY_CONDITION, "%"+key+"%");
//			typedQuery.setParameter(LIKE_LOCALE_CONDITION, "%"+locale+"%");
//			
//			
//			// Execute query and return 
//			return typedQuery.getResultList();
//		}
		// TODO Auto-generated method stub
		return null;
	}

}
