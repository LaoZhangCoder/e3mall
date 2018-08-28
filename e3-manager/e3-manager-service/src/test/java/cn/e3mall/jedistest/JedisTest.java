package cn.e3mall.jedistest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.mysql.jdbc.JDBC4DatabaseMetaDataUsingInfoSchema;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@SuppressWarnings("resource")
	
	public void testjedis() {
		
		Jedis jedis = new Jedis("192.168.25.129",6379);
		String key1=jedis.get("key1");
		System.out.println(key1);
		jedis.set("key5", "value");
		String string = jedis.get("key5");
		System.out.println(string);
		jedis.close();
		
	}
	//通过连接池来连接
	
	public void jedispool() {
		JedisPool pool=new JedisPool("192.168.25.129",6379);
		Jedis jedis = pool.getResource();
		String string = jedis.get("key5");
		System.out.println(string);
		pool.close();
		
	}
	//测试集群版redis
	
	@Test
	public void jediscluster() {
		Set<HostAndPort> nodes=new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.129", 7001));
		nodes.add(new HostAndPort("192.168.25.129", 7002));
		nodes.add(new HostAndPort("192.168.25.129", 7003));
		nodes.add(new HostAndPort("192.168.25.129", 7004));
		nodes.add(new HostAndPort("192.168.25.129", 7005));
		nodes.add(new HostAndPort("192.168.25.129", 7006));
		// 第一步：使用JedisCluster对象。需要一个Set<HostAndPort>参数。Redis节点的列表。
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("hello", "100");
		String string = jedisCluster.get("hello");
		System.out.println(string);
		jedisCluster.close();
		
	}
	
}
