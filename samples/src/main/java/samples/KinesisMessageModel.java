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

    public int pmuID;
    public String ts;
    public String status;
    public String gpsLock;
    public String error;
    public String frequency;
    public String sRate;
    public String dfdt;
    public String phasors;
    

    /**
     * Default constructor for Jackson JSON mapper - uses bean pattern.
     */
    public KinesisMessageModel() {

    }

    /*
     * 
     * @param ID
     *        Sample int ID field
     * @param Date
     *        Sample String Date field
     * @param Time
     *        Sample String Time field
     **/
    public KinesisMessageModel(int pmuID,
            String ts,
            String status,
            String gpsLock,
            String sRate,
            String error,
            String frequency,
            String dfdt,
            String phasors) {
        this.pmuID = pmuID;
        this.ts = ts;
        this.status = status;
        this.gpsLock = gpsLock;
        this.sRate = sRate;
        this.error = error;
        this.frequency = frequency;
        this.dfdt = dfdt;
        this.phasors = phasors;
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
     * Getter for ID
     * 
     * @return ID
     */

    public int getID() {
        return pmuID;
    }

    /**
     * Setter for ID
     * 
     * @param ID
     *        Value for ID
     */

    public void setID(int pmuID) {
        this.pmuID = pmuID;
    }

    /**
     * Getter for Date
     * 
     * @return Date
     */

    // public String getDate() {
    //     return Date;
    // }

    // /**
    //  * Setter for Date
    //  * 
    //  * @param Date
    //  *        Value for Date
    //  */

    // public void setDate(String Date) {
    //     this.Date = Date;
    // }

    // /**
    //  * Getter for Time
    //  * 
    //  * @return Time
    //  */

    // public String getTime() {
    //     return Time;
    // }

    // /**
    //  * Setter for Time
    //  * 
    //  * @param Time
    //  *        Value for Time
    //  */

    // public void setTime(String Time) {
    //     this.Time = Time;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        // result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        // result = prime * result + userid;
        // result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + pmuID;
        result = prime * result + ((ts == null) ? 0 : ts.hashCode());
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
        // if (key != other.key) {
        //     return false;
        // }
        return true;
    }
}
