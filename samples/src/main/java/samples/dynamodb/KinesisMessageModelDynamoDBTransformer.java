/*
 * Copyright 2013-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
package samples.dynamodb;

import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import samples.KinesisMessageModel;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.kinesis.connectors.BasicJsonTransformer;
import com.amazonaws.services.kinesis.connectors.dynamodb.DynamoDBTransformer;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;
import org.json.JSONObject;
// import org.json.JSONArray;
// import java.lang.String;

/**
 * A custom transfomer for {@link KinesisMessageModel} records in JSON format. The output is in a format
 * usable for insertions to Amazon DynamoDB.
 */
public class KinesisMessageModelDynamoDBTransformer extends
        BasicJsonTransformer<KinesisMessageModel, Map<String, AttributeValue>> implements
        DynamoDBTransformer<KinesisMessageModel> {

    /**
     * Creates a new KinesisMessageModelDynamoDBTransformer.
     */
    public KinesisMessageModelDynamoDBTransformer() {
        super(KinesisMessageModel.class);
    }

    @Override
    public Map<String, AttributeValue> fromClass(KinesisMessageModel message) {
        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        putIntegerIfNonempty(item, "pmuID", message.ID);
        putStringIfNonempty(item, "ts", getTimeStamp(message.Date + ' ' + message.Time));
        putStringIfNonempty(item, "Status", message.Status);
        putStringIfNonempty(item, "gpsLock", message.gpsLock);
        putStringIfNonempty(item, "error", message.error);
        putStringIfNonempty(item, "Frequency", message.Frequency);
        putStringIfNonempty(item, "sRate", message.sRate);
        putStringIfNonempty(item, "dfdt", message.dfdt);
        putDynamicIfNonempty(item, message.Phasors);
        return item;
    }

    /**
     * Helper method to map nonempty String attributes to an AttributeValue.
     * 
     * @param item The map of attribute names to AttributeValues to store the attribute in
     * @param key The key to store in the map
     * @param value The value to check before inserting into the item map
     */
    private void putStringIfNonempty(Map<String, AttributeValue> item, String key, String value) {
        if (value != null && !value.isEmpty()) {
            item.put(key, new AttributeValue().withS(value));
        }
    }

    /**
     * Helper method to map boolean attributes to an AttributeValue.
     * 
     * @param item The map of attribute names to AttributeValues to store the attribute in
     * @param key The key to store in the map
     * @param value The value to insert into the item map
     */
    private void putBoolIfNonempty(Map<String, AttributeValue> item, String key, Boolean value) {
        putStringIfNonempty(item, key, Boolean.toString(value));
    }

    /**
     * Helper method to map nonempty Integer attributes to an AttributeValue.
     * 
     * @param item The map of attribute names to AttributeValues to store the attribute in
     * @param key The key to store in the map
     * @param value The value to insert into the item map
     */
    private void putIntegerIfNonempty(Map<String, AttributeValue> item, String key, Integer value) {
        putStringIfNonempty(item, key, Integer.toString(value));
    }

    private String getTimeStamp(String input) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS zzz");
        String timestamp = null;
        try {
            Date date = format.parse(input + " UTC");
            System.out.println(date);
            timestamp = String.valueOf(date.getTime());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return timestamp;
    }

    private void putDynamicIfNonempty(Map<String, AttributeValue> item, String input) {
        JSONObject obj1 = new JSONObject(input);
        Iterator<String> keys= obj1.keys();
        while (keys.hasNext()) 
            {
                String keyValue = (String)keys.next();
                JSONObject obj2 = obj1.getJSONObject(keyValue);
                String data = obj2.toString();
                item.put(keyValue, new AttributeValue().withS(data));
                //getting string values with keys- pageid and title
            }
        }
    
}
