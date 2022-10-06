package com.sismics.docs.rest.resource;

import com.google.common.collect.Sets;
import com.sismics.docs.core.constant.AclType;
import com.sismics.docs.core.constant.PermType;
import com.sismics.docs.core.dao.AclDao;
import com.sismics.docs.core.dao.ReviewDao;
import com.sismics.docs.core.dao.TagDao;
import com.sismics.docs.core.dao.criteria.TagCriteria;
import com.sismics.docs.core.dao.dto.TagDto;
import com.sismics.docs.core.model.jpa.Acl;
import com.sismics.docs.core.model.jpa.Review;
import com.sismics.docs.core.model.jpa.Tag;
import com.sismics.docs.core.util.jpa.SortCriteria;
import com.sismics.rest.exception.ClientException;
import com.sismics.rest.exception.ForbiddenClientException;
import com.sismics.rest.util.AclUtil;
import com.sismics.rest.util.ValidationUtil;
import org.apache.commons.lang.StringUtils;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;

/**
 * Tag REST resources.
 * 
 * @author haoweif
 */
@Path("/review")
public class ReviewResource extends BaseResource {

    /**
     * Creates a new Form.
     *
     * @api {put} /tag Create a form
     * @apiName putForm
     * @apiGroup Form
     * @apiParam {String} name Name
     * @apiParam {String} color Score
     * @apiSuccess {String} id Form ID
     * @apiPermission user
     * @apiVersion 1.5.0
     *
     * @param name string
     * @param score string
     * @param notes string
     * @return Response
     */
    @PUT
    public Response add(
            @FormParam("name") String name,
            @FormParam("score") String score,
            @FormParam("notes") String notes) {
        if (!authenticate()) {
            throw new ForbiddenClientException();
        }

        // Create the form
        ReviewDao reviewDao = new ReviewDao();
        Review review = new Review();
        review.setApplicantName(name);
        review.setNotes(notes);
        review.setScore(score);
        review.setRevUserId(principal.getId());
        String id = reviewDao.create(review, principal.getId());

        JsonObjectBuilder response = Json.createObjectBuilder()
                .add("id", id);
        return Response.ok().entity(response.build()).build();
    }
}
