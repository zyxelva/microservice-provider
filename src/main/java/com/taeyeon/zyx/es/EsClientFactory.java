package com.taeyeon.zyx.es;

import com.taeyeon.zyx.exception.EsException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Properties;

/**
 * ES Client
 *
 * */
public class EsClientFactory {
	private static final Logger logger = LoggerFactory.getLogger(EsClientFactory.class);
	// 创建私有对象，使用TransportClient创建连接池
	private static TransportClient transportClient;

	static {
		try {
			logger.debug("init es client");
			System.setProperty("es.set.netty.runtime.available.processors", "false");
			Properties properties = new Properties();
			properties.load(ClassLoader.getSystemResourceAsStream("env.properties"));
			String clusterName = properties.getProperty("cluster.name", "es_default");
			String clusterHost = properties.getProperty("cluster.host", "127.0.0.1");
			int clusterPort = Integer.valueOf(properties.getProperty("cluster.port", "9300")).intValue();

			Settings settings = Settings.builder().put("client.transport.sniff", true)
					.put("cluster.name", clusterName).put("transport.tcp.port", clusterPort).build();

			transportClient = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName(clusterHost), clusterPort));
			logger.debug("init es client end ,client is null ? {}", null == transportClient);
		} catch (Exception e) {
			logger.error("init es client error", e);
		}
	}

	// 取得实例
	public static synchronized TransportClient getTransportClient() {
		if(null == transportClient){
			throw new EsException("transportClient null");
		}
		return transportClient;
	}

	public static synchronized void close() {
		transportClient.close();
	}
}
