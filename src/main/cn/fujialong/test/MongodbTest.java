package cn.fujialong.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;


/**
 * @program: fujialongStudy
 * @description: mongo 测试
 * @author: fujialong
 * @create: 2018-07-07 16:26
 **/
public class MongodbTest {

    @Test
    public void test() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("myTestCollection");
        System.out.println(collection.find().first().get("age"));
    }
}
