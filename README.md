
# Tiny Demo ElasticSearch App

## Introduction

This is a tiny demo app to experiment with concepts of ElasticSearch.
![Elasticsearch](https://techvccloud.mediacdn.vn/2018/10/15/elasticsearch-1539570535721747539902-0-50-832-1531-crop-15395705411511820530305.png)


## What-to-do

-   Set up a data source using traditional PostgreSQL. ✅
-   Set up basic interactions with ElasticSearch. ✅
-   Use LogStash to synchronize data from PostgreSQL to ElasticSearch. ([Reference](https://www.elastic.co/blog/how-to-keep-elasticsearch-synchronized-with-a-relational-database-using-logstash)) ✅
-   Use Kibana to visualize and analyze data. ✅

## How to Start

### Initial Setup

First, navigate to the project directory:

```sh
cd elastic-search-demo
```

For the first-time setup, run the following commands:

1.  Create bind mount directories for volumes:
    
    ```sh
    mkdir -p es/logs es/data
    ```
    
2.  Grant the necessary permissions:
    
    ```sh
    chmod -R 777 es
    ```

### Fill in the neccessities
For a PostgreSQL database, I recommend creating one at [Neon Tech](https://neon.tech/).

In order to run successfully, you have to:
1. Create a `.env` file from the template file `.env.example` and then fill in the required values.
2. Create a `postgres-elastic-sync.conf` file from `postgres-elastic-sync.conf.example` and then fill in the required values (database credentials specifically).

### Running the App

To start the app, simply run:

```sh
docker compose up
```

## Using Kibana

Kibana is a powerful visualization tool that works with ElasticSearch. Here are some basic steps to get started:

1.  **Access Kibana**: Open your browser and navigate to `http://localhost:5601`.
2.  **Create Index Patterns**: Define index patterns to visualize your data.
3.  **Visualize Data**: Use Kibana’s visualization tools to create charts, graphs, and dashboards.
4.  **Explore Discover**: Use the Discover feature to query and explore your data interactively.
