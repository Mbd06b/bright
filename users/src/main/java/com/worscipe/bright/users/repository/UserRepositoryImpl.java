package com.worscipe.bright.users.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.worscipe.bright.users.model.User;
import com.worscipe.bright.users.model.UserRecord;

public class UserRepositoryImpl implements UserRepositoryCustom {
	
	private static final Logger logger = LogManager.getLogger(UserRepositoryImpl.class); 
	
	@Autowired 
	private SessionFactory sessionFactory;

	// SELECT * from brightusersdb.USER WHERE entityId IN User.elections = ideaId; 
	@Override
	public Optional<List<User>> findContributorsByIdea(Long ideaId) {
			logger.debug(" findingContributorsByIdeaId ("+ ideaId + ")");
			Session session = this.sessionFactory.getCurrentSession();
			
//			// Create a criteriaBuilder from the session
			CriteriaBuilder cb = session.getCriteriaBuilder();
//			
//			// Create a query to use
//			CriteriaQuery<User> cq = cb.createQuery(User.class);
//			
//			// Define a range variable in FROM clause
//			Root<User> users = cq.from(User.class);
//			Root<UserRecord> root = cq.from(UserRecord.class);
//			
//			
//			// Specify the type the query result will be
//		    cq.select(users).where(
//		    		
//		    		cq.select(root).
//		    		cb.equal(root.<Long>get("entityId"), cb.parameter(Long.class, "equals"))
//		    		
//		    		);
//		    //.where(cb.like(root.<Long>get("user."), cb.parameter(Long.class),		
//			
//			// Prepare the query for execution
//			TypedQuery<User> typedQuery = session.createQuery(cq);
//			typedQuery.setParameter("equals", ideaId);

			CriteriaQuery<User> criteria = cb.createQuery((Class<User>) User.class);
			Root<User> users = criteria.from(User.class);

			criteria.select(users);
			
			SetJoin<User, UserRecord> ideas = users.joinSet("ideas", JoinType.LEFT);

			Predicate ideaPredicate = cb.equal(ideas.get("entityId"), ideaId);
			
			//users.fetch(ideas);
			//parent.fetch("children");//try also this

			 criteria.where(ideaPredicate);
			
			 TypedQuery<User> typedQuery = session.createQuery(criteria);
			 
			// Execute query and return 
			List<User> ideaContributors = typedQuery.getResultList();
			
			return Optional.ofNullable(ideaContributors); 
		// TODO Auto-generated method stub
	}

}
