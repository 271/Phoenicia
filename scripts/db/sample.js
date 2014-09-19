#!/usr/bin/sh

use phoenicia

db.dropDatabase()

db.createCollection('users')

db.users.insert({
	firstName: 'Venkat',
	lastName: 'Aedama',
	age: 25
})