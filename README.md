Phoenicia
=========

Install MongoDB
================
1. Download http://www.mongodb.org/dr//fastdl.mongodb.org/osx/mongodb-osx-x86_64-2.6.4.tgz/download

2. Start MongoDB:
`sudo ./bin/mongod --rest`
By default it starts on port 27017
Add 1000 to this port and open it in your browser to view the rest interface. I did: http://localhost:28017

3. By default all data is stored in `/data/db`. You can change this if you would like to.

Handy commands:
---------------
# Drop database: change directory to mongodb and then run:

`./bin/mongo phoenicia --eval "db.dropDatabase()`


# Setup sample db: change directory to Phoenicia and then run:

`../mongodb-osx-x86_64-2.6.4/bin/mongo < ./scripts/db/sample.js`

# View records through shell:

`./bin/mongo`

`show dbs`

`use phoenicia`

`db.graph.count()`


Install SBT
============
`brew install sbt`

Start Phoenicia
=================
> cd Phoenicia
> sbt

Start Phoenicia in dev mode (to benefit from auto-reloading feature)
`~run`

By default, Phoenicia runs on port 9000. If you would like to change it to say 9002, you can run: `sbt "run 9002"`
