package com.artExchange.main;

import java.io.IOException;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.artExchange.main.ItemDAO;

public class MongoConnection {
	/*
	 * public static DB getDB(String mongoURIString) throws IOException { return
	 * new MongoClient(new MongoClientURI(mongoURIString)).getDB("ArtExchange");
	 * } }
	 */
	private final ItemDAO itemDAO;
	//private final UserDAO userDAO;
	
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
            new MongoConnection("mongodb://localhost");
        }
        else {
            new MongoConnection(args[0]);
        }
	}
	
	public MongoConnection(String mongoURIString) throws IOException{
		final MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoURIString));
        final DB artExchangeDatabase = mongoClient.getDB("ArtExchange");

        //userDAO = new UserDAO(artExchangeDatabase);
        itemDAO = new ItemDAO(artExchangeDatabase);
	    
	    
	    //userDAO.addUser("testUser1","password", "email@gmail.com");
	    //System.out.println(itemDAO.itemsCollection.findOne());
	    itemDAO.getItemsByCategory("doc");
	    itemDAO.getItemsByType("Item");
	    itemDAO.getItemsByUser("testUser1");
	    //itemDAO.getItemsByType("Service");
	}
}
