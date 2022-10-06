package com.sismics.docs.core.model.jpa;

// import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// import com.google.common.base.MoreObjects;


/**
 * Review.
 * 
 * @author bgamard
 */
@Entity
@Table(name = "T_REVIEW")
public class Review {
    /**
     * Review ID
     */
    @Id
    @Column(name = "REVIEW_ID", length = 36)
    private String revId;

    /**
     * Reviewer User ID
     */
    @Id
    @Column(name = "REV_USE_ID", nullable = false, length = 36)
    private String revUserId;

    /**
     * Reviewed Name
     */
    @Id
    @Column(name = "APPLICANT_NAME", nullable = false)
    private String applicantName;

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
    private String score;

    public void setRevId(String id) {
        this.revId = id;
    }

    public String getRevId() {
        return revId;
    }

    public void setRevUserId(String id) {
        this.revUserId = id;
    }

    public String getRevUserId() {
        return revUserId;
    }

    public void setApplicantName(String name) {
        this.applicantName = name;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return this.score;
    }

    public String create(Review review, String id) {
        return null;
    }

}
