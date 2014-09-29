package com.artExchange.main;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ItemDAO {
	protected String collectionName;
	protected DB artExchangeDatabase;
	protected DBCollection itemsCollection;

	public ItemDAO(final DB artExchangeDatabase) {
		itemsCollection = artExchangeDatabase.getCollection("items");
	}
	
	public String addItem(String title, String category, String type, String name, String description, List<String> tags, String userId) {

        System.out.println("inserting item " + name);

        BasicDBObject item = new BasicDBObject("name", name);
        item.append("userId", userId);
        item.append("type", type);
        item.append("description", description);
        item.append("tags", tags);
        item.append("category", category);
        item.append("date", new java.util.Date());

        try {
            itemsCollection.insert(item);
            System.out.println("Inserting item for user: " + userId);
        } catch (Exception e) {
            System.out.println("Error inserting item");
            return null;
        }

        return name;
    }

	public List<DBObject> getItemsByUser(String id) {
		List<DBObject> items;
		DBCursor cursor = itemsCollection.find(new BasicDBObject("userId", id));
		try {
			items = cursor.toArray();
			System.out.println(items);
		} finally {
			cursor.close();
		}
		return items;
	}

	public List<DBObject> getItemsByCategory(String category) {
		List<DBObject> items;
		DBCursor cursor = itemsCollection.find(new BasicDBObject("category", category));
		try {
			items = cursor.toArray();
			System.out.println(items);
		} finally {
			cursor.close();
		}
		return items;
	}

	public List<DBObject> getItemsByType(String type) {
		List<DBObject> items;
		DBCursor cursor = itemsCollection.find(new BasicDBObject("type", type));
		try {
			items = cursor.toArray();
			System.out.println(items);
		} finally {
			cursor.close();
		}
		return items;
	}
}
