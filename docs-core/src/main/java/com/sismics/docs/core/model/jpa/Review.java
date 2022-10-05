package com.sismics.docs.core.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

/**
 * Review.
 * 
 * @author bgamard
 */
@Entity
@Table(name = "T_REVIEW")
public class Review implements Loggable {
    /**
     * Review ID
     */
    @Id
    @Column(name = "REVIEW_ID", length = 36);
    private String revId;

    /**
     * Document ID
     */
    @Id
    @Column(name = "REV_DOC_ID", nullable = false, length = 36)
    private String revDocId;

    /**
     * Reviewer User ID
     */
    @Id
    @Column(name = "REV_USE_ID", nullable = false, length = 36)
    private String revUserId;

    /**
     * Notes
     */
    @Id
    @Column(name = "NOTES", nullable = true)
    private String notes;

    /**
     * Overall Score
     */
    @Id
    @Column(name = "OVERALL_SCORE")
    private int score;

    public String getRevId() {
        return revId;
    }

    public String getRevDocId() {
        return revDocId;
    }

    public String getRevUserId() {
        return revUserId;
    }



    // @Override
    // public String toString() {
    //     return MoreObjects.toStringHelper(this)
    //             .add("id", id)
    //             .add("name", name)
    //             .add("parentId", parentId)
    //             .toString();
    // }

}
