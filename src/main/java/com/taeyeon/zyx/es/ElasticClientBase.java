package com.taeyeon.zyx.es;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.admin.cluster.node.info.NodeInfo;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public abstract class ElasticClientBase {
	private static final Logger logger = LoggerFactory.getLogger(ElasticClientBase.class);
	
	/**
	 * 获取Elastic Client
	 * */
	public TransportClient getElasticClient(){
		return EsClientFactory.getTransportClient();
	}
	
	/**
	 * 创建索引名称
	 * @param indices 索引名称
	 */
//	public static boolean createIndex(Client client,String indices){
//		if (!indexExist(client,indices)) {
//			CreateIndexResponse resp = client.admin().indices().prepareCreate(indices).execute().actionGet();
//			return resp.isAcknowledged();
//		}
//	    return true;
//	}
	    
	/**
	 * 判断mapping是否存在
	 * */
//	public static boolean isExistMapping(Client client,String index ,String mappingType){
//		ClusterState state = client.admin().cluster().prepareState()
//				.setFilterIndices(index).execute().actionGet().getState();
//
//		IndexMetaData imd = state.getMetaData().index(index);
//		MappingMetaData mdd = imd.mapping(mappingType);
//
//		return mdd != null;
//	}

    public boolean insert(final String index, final String type, final String id, XContentBuilder xContentBuilder) throws IOException {
        if(null == xContentBuilder){
            return false;
        }
        IndexRequestBuilder indexRequest = getElasticClient().prepareIndex(index, type, id).setSource(xContentBuilder);
        IndexResponse response = indexRequest.execute().actionGet();
        RestStatus status = response.status();
        return status == RestStatus.CREATED;
    }

    public boolean update(final String index, final String type, final String id, XContentBuilder xContentBuilder) throws Exception {
        if(null == xContentBuilder){
            return false;
        }
        UpdateRequestBuilder indexRequest = getElasticClient().prepareUpdate(index, type, id).setDoc(xContentBuilder);
        UpdateResponse response = indexRequest.execute().actionGet();
        RestStatus status = response.status();
        return true;
    }

    public boolean delete(final String index, final String type, final String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        DeleteRequestBuilder indexRequest = getElasticClient().prepareDelete(index, type, String.valueOf(id));
        DeleteResponse response = indexRequest.execute().actionGet();
        RestStatus status = response.status();
        return status == RestStatus.OK;
    }
//    public boolean insertBatch(final String index, final String type,  List<XContentBuilderBean> xContentBuilderList) throws IOException {
//        if (CollectionUtils.isEmpty(xContentBuilderList) ) {
//            return false;
//        }
//
//        BulkRequestBuilder bulk = getElasticClient().prepareBulk();
//        for (XContentBuilderBean xContentBuilderBean : xContentBuilderList) {
//            IndexRequestBuilder indexRequest = getElasticClient().prepareIndex(index, type, xContentBuilderBean.getId()).setSource(xContentBuilderBean.getxContentBuilder());
//            bulk.add(indexRequest);
//        }
//
//        BulkResponse bulkRespons = bulk.execute().actionGet();
//        return true;
//    }

    /**
     * 索引库是否存在 
     *  
     * @author Geloin 
     * @param client 
     *            客户端 
     * @param index 
     *            索引库名 
     * @return 存在则返回true，不存在则返回false 
     */
//    public static Boolean indexExist(Client client, String index) {
//        IndicesExistsRequest request = new IndicesExistsRequestBuilder(client
//                .admin().indices(), index).request();
//        IndicesExistsResponse response = client.admin().indices()
//                .exists(request).actionGet();
//        return response.isExists();
//    }
    /** 
     * 测试连接状态
     *  
     * @param client 
     * @return 存在则返回true，不存在则返回false
     */
    public static boolean testConnection(Client client) throws Exception{
    	try{
    		//超时时间设置为半分钟  
            NodesInfoResponse response = client.admin().cluster().nodesInfo(new NodesInfoRequest().timeout("30")).actionGet();
            Map<String, NodeInfo> nodesMap = response.getNodesMap();
            //打印节点信息
            for(Map.Entry<String, NodeInfo> entry : nodesMap.entrySet()){
            	logger.info(entry.getKey() + ":" + entry.getValue().getHostname());
            }
            return true;
        }
        catch(Exception e){
            logger.error("无法连接到Elasticsearch",e);
            return false;
        }  
    }
	
    
	public long dateTimeToMillisecond(Date date) {
        if (date != null) {
            return date.getTime();
        }
        return 0;
    }

	public Date millisecondToDateTime(long millisecond) {
        if (millisecond > 0) {
            return new Date(millisecond);
        }
        return null;
    }
}
