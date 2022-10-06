package com.sismics.docs.core.dao;

import com.google.common.base.Joiner;
import com.sismics.docs.core.constant.AuditLogType;
import com.sismics.docs.core.dao.criteria.TagCriteria;
import com.sismics.docs.core.dao.dto.TagDto;
import com.sismics.docs.core.model.jpa.DocumentTag;
import com.sismics.docs.core.model.jpa.Review;
import com.sismics.docs.core.model.jpa.Tag;
import com.sismics.docs.core.util.AuditLogUtil;
import com.sismics.docs.core.util.SecurityUtil;
import com.sismics.docs.core.util.jpa.QueryParam;
import com.sismics.docs.core.util.jpa.QueryUtil;
import com.sismics.docs.core.util.jpa.SortCriteria;
import com.sismics.util.context.ThreadLocalContext;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.*;

/**
 * Form DAO.
 * 
 * @author haoweif
 */
public class ReviewDao {

    /**
     * Creates a new Form.
     * 
     * @param review Review
     * @param userId User ID
     * @return New ID
     */
    public String create(Review review, String userId) {
        // Create the UUID
        review.setRevId(UUID.randomUUID().toString());
        EntityManager em = ThreadLocalContext.get().getEntityManager();
        em.persist(review);
        return review.getRevId();
    }
    
}

