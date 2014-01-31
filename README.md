# ElasticSearch OSEM

Object Search Engine Mapper for ElasticSearch

[![Build Status](https://travis-ci.org/kzwang/elasticsearch-osem.png?branch=master)](https://travis-ci.org/kzwang/elasticsearch-osem)


|           OSEM            |   elasticsearch   | Release date |
|---------------------------|-------------------|--------------|
| 1.0.0-SNAPSHOT (master)   |   0.90.10         |              |


## Example

Create model:

```Java
    @Indexable(name = "tweetIndex", numericDetection = NumericDetectionEnum.TRUE)
    public class Tweet {
    
        @IndexableId(index = IndexEnum.NOT_ANALYZED)
        @IndexableProperty
        private Long id;
    
        @IndexableComponent
        private User user;
    
        @IndexableProperty(store = true)
        private String tweetString;
    
        @IndexableProperty(format = "yyyy/MM/dd")
        private Date tweetDate;
    
        @IndexableProperty
        private String image;
    
        @IndexableProperty(analyzer = "standard")
        private List<String> urls;
    
        @IndexableComponent(name = "mentionedUsers")
        private List<User> mentionedUserList;
    
        @IndexableProperty
        private Boolean flagged;
        
        @IndexableProperty(name = "tweetDatetime", format = "yyyy/MM/dd HH:mm:ss")
        public Date getTweetDatetime() {
            return tweetDate;
        }
    }
```
Create Mapping:

```Java
    Client client = nodeBuilder().node().client();
    ElasticSearchIndexer indexer = new ElasticSearchIndexer(client, indexName);
    indexer.createMapping(Tweet.class);
```
Index Object:

```Java
    Tweet tweet = new Tweet();
    ...
    indexer.index(tweet);
```

Delete Object:

```Java    
    Tweet tweet = ...;
    indexer.delete(tweet);
```

Get Object from index:

```Java
    ElasticSearchSearcher searcher = new ElasticSearchSearcherImpl(client, indexName);
    Tweet tweet = searcher.getById(Tweet.class, tweet.getId().toString());
```
    
Search Object:

```Java
    List<Tweet> searchResult = searcher.search(Tweet.class, QueryBuilders.matchAllQuery(), null);
```

## Maven
```xml
    <dependency>
        <groupId>com.github.kzwang</groupId>
        <artifactId>elasticsearch-osem</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
```