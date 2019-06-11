package com.worscipe.bright.ideas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.ideas.model.idea.IdeaImpl;

@Repository
public class IdeaRepositoryImpl implements IdeaRepositoryCustom {
	
	private static final Logger logger = LogManager.getLogger(IdeaRepositoryImpl.class); 
	
	private static final String IDEA_TITLE = "title";
	private static final String IDEA_SUBTITLE = "subtitle";
	private static final String IDEA_STORY = "story"; 
	
	private static final String LIKE_TITLE_CONDITION = "likeTitleCondition";
	private static final String LIKE_SUBTITLE_CONDITION = "likeSubtitleCondition";
	private static final String LIKE_STORY_CONDITION = "likeStoryCondition";
	
	@Autowired 
	private EntityManager sessionFactory;

	@Override
	public List<IdeaImpl> findIdeasByQueryPageAndSize(String searchText, Integer pageNumber, Integer limit) {
		logger.debug(">>>>>>> findIdeasByQueryPageAndSize() ");
		
		CriteriaBuilder cb = this.sessionFactory.getCriteriaBuilder();
		CriteriaQuery<IdeaImpl> cq = cb.createQuery(IdeaImpl.class);
		Root<IdeaImpl> root = cq.from(IdeaImpl.class);
		
		cq.select(root).where(  // SELECT * FROM table WHERE ( IDEA_TITLE LIKE %% OR IDEA_SUBTITLE %% OR IDEA_STORY %%)
				cb.like(root.<String>get(IDEA_TITLE), cb.parameter(String.class, LIKE_TITLE_CONDITION)),
				cb.like(root.<String>get(IDEA_SUBTITLE),  cb.parameter(String.class, LIKE_SUBTITLE_CONDITION)),
				cb.like(root.<String>get(IDEA_STORY), cb.parameter(String.class, LIKE_STORY_CONDITION))
		
				);
		TypedQuery<IdeaImpl> typedQuery = this.sessionFactory.createQuery(cq);
		typedQuery.setParameter(LIKE_TITLE_CONDITION,  "%"+searchText+"%");
		typedQuery.setParameter(LIKE_SUBTITLE_CONDITION, "%"+searchText+"%");
		typedQuery.setParameter(LIKE_STORY_CONDITION,  "%"+searchText+"%");
		
		Integer selectedPageIndex = (pageNumber * limit) - limit;
		typedQuery.setFirstResult(selectedPageIndex);
		typedQuery.setMaxResults(limit);
		
		return typedQuery.getResultList();
	}

	
	
	@Override
	public Long getIdeaQueryTotalResultCount(String searchText) {
	  return this.countTotalIdeaResultsBySearchText(searchText);
	}

	@Override
	public Integer getIdeaQueryTotalResultPagesCount(String searchText, Integer limit) {
		Long count = this.countTotalIdeaResultsBySearchText(searchText);
		return (int) ((count / limit) + 1);
	}
	
	
	/**
	 * Private helper containing the COUNT query for SELECT idea searches
	 * @param searchText
	 * @return
	 */
	
	private Long countTotalIdeaResultsBySearchText(String searchText) {
		
		CriteriaBuilder cb = this.sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<IdeaImpl> root = cq.from(IdeaImpl.class);
		
		cq.select(cb.count(root)).where(  // SELECT * FROM table WHERE ( IDEA_TITLE LIKE %% OR IDEA_SUBTITLE %% OR IDEA_STORY %%)
				cb.like(root.<String>get(IDEA_TITLE), cb.parameter(String.class, LIKE_TITLE_CONDITION)),
				cb.like(root.<String>get(IDEA_SUBTITLE),  cb.parameter(String.class, LIKE_SUBTITLE_CONDITION)),
				cb.like(root.<String>get(IDEA_STORY), cb.parameter(String.class, LIKE_STORY_CONDITION))
		
				);
		TypedQuery<Long> typedQuery = this.sessionFactory.createQuery(cq);
		typedQuery.setParameter(LIKE_TITLE_CONDITION,  "%"+searchText+"%");
		typedQuery.setParameter(LIKE_SUBTITLE_CONDITION, "%"+searchText+"%");
		typedQuery.setParameter(LIKE_STORY_CONDITION,  "%"+searchText+"%");
		
		return typedQuery.getSingleResult();
	}


}
