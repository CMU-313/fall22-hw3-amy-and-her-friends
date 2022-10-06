package com.sismics.docs.rest;

import com.sismics.util.filter.TokenBasedSecurityFilter;
import org.junit.Assert;
import org.junit.Test;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Test the review resource.
 * 
 * @author bgamard
 */
public class TestFormResource extends BaseJerseyTest {
    /**
     * Test the review resource.
     */
    @Test
//     comment
    public void testFormResource() {
        // Login tag1
        clientUtil.createUser("tag1");
        String tag1Token = clientUtil.login("tag1");

        // Create a formm
        JsonObject json = target().path("/review").request()
                .cookie(TokenBasedSecurityFilter.COOKIE_NAME, tag1Token)
                .put(Entity.form(new Form()
                        .param("name", "User1")
                        .param("notes", "hi i love this class")
                        .param("score", "1"))
                        , JsonObject.class);
        String user1Id = json.getString("id");
        Assert.assertNotNull(user1Id);

        // Create a form
        json = target().path("/review").request()
                .cookie(TokenBasedSecurityFilter.COOKIE_NAME, tag1Token)
                .put(Entity.form(new Form()
                        .param("name", "User1")
                        .param("notes", "hi i don't love this class")
                        .param("score", "8"))
                        , JsonObject.class);
        String user2Id = json.getString("id");
        Assert.assertNotNull(user2Id);
    }
}