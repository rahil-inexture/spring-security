package com.example.demo.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PersistentLogin;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLogin> implements PersistentTokenRepository{
	
	static final Logger log = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);
	
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		log.info("create token for user {}", token.getUsername());
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
	}
	
	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		log.info("fetch token if any series id {}", seriesId);
		try {
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("series", seriesId));
			PersistentLogin persistentLogin = (PersistentLogin) criteria.uniqueResult();
			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(), persistentLogin.getToken(), persistentLogin.getLast_used());
			
		} catch (Exception e) {
			log.info("token not found ..");
			return null;
		}
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		log.info("update token by series id {}", series);
		PersistentLogin persistentLogin = getByKey(series);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLast_used(lastUsed);
		update(persistentLogin);
	}

	@Override
	public void removeUserTokens(String username) {
		log.info("remove token by username {}", username);
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		PersistentLogin persistentLogin = (PersistentLogin) criteria.uniqueResult();
		if(persistentLogin != null) {
			log.info("rememberMe Selected {}");
			delete(persistentLogin);
		}
	}
}
