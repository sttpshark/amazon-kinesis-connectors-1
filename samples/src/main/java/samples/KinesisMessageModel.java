/*
 * Copyright 2013-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
package samples;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * This is the data model for the objects being sent through the Amazon Kinesis streams in the samples
 * 
 */
public class KinesisMessageModel implements Serializable {

    // public int userid;
    // public String username;
    // public String firstname;
    // public String lastname;
    public String key;

    /**
     * Default constructor for Jackson JSON mapper - uses bean pattern.
     */
    public KinesisMessageModel() {

    }

    /*
     * 
     * @param userid
     *        Sample int data field
     * @param username
     *        Sample String data field
     * @param firstname
     *        Sample String data field
     * @param lastname
     *        Sample String data field
     **/
    public KinesisMessageModel(/*int userid,*/
            /*String username,*/
            /*String firstname,*/
            /*String lastname)*/ 
            String key) {
        // this.userid = userid;
        // this.username = username;
        // this.firstname = firstname;
        // this.lastname = lastname;
        this.key = key;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }

    /**
     * Getter for userid
     * 
     * @return userid
     */
    // public int getUserid() {
    //     return userid;
    // }

    /**
     * Setter for userid
     * 
     * @param userid
     *        Value for userid
     */
    // public void setUserid(int userid) {
    //     this.userid = userid;
    // }

    /**
     * Getter for username
     * 
     * @return username
     */
    // public String getUsername() {
    //     return username;
    // }

    /**
     * Setter for username
     * 
     * @param username
     *        Value for username
     */
    // public void setUsername(String username) {
    //     this.username = username;
    // }

    /**
     * Getter for firstname
     * 
     * @return firstname
     */
    // public String getFirstname() {
    //     return firstname;
    // }

    /**
     * Setter for firstname
     * 
     * @param firstname
     *        Value for firstname
     */
    // public void setFirstname(String firstname) {
    //     this.firstname = firstname;
    // }

    /**
     * Getter for lastname
     * 
     * @return lastname
     */
    // public String getLastname() {
    //     return lastname;
    // }

    /**
     * Setter for lastname
     * 
     * @param lastname
     *        Value for lastname
     */
    // public void setLastname(String lastname) {
    //     this.lastname = lastname;
    // }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        // result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        // result = prime * result + userid;
        // result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof KinesisMessageModel)) {
            return false;
        }
        KinesisMessageModel other = (KinesisMessageModel) obj;
        // if (firstname == null) {
        //     if (other.firstname != null) {
        //         return false;
        //     }
        // } else if (!firstname.equals(other.firstname)) {
        //     return false;
        // }
        // if (lastname == null) {
        //     if (other.lastname != null) {
        //         return false;
        //     }
        // } else if (!lastname.equals(other.lastname)) {
        //     return false;
        // }
        // if (userid != other.userid) {
        //     return false;
        // }
        // if (username == null) {
        //     if (other.username != null) {
        //         return false;
        //     }
        // } else if (!username.equals(other.username)) {
        //     return false;
        // }
        if (key != other.key) {
            return false;
        }
        return true;
    }
}
