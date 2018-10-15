package com.taeyeon.zyx.dao;

import com.taeyeon.zyx.common.ErrCodeConsts;
import com.taeyeon.zyx.common.UserConstants;
import com.taeyeon.zyx.entity.TbTeacher;
import com.taeyeon.zyx.es.ElasticClientBase;
import com.taeyeon.zyx.exception.BusinessException;
import com.taeyeon.zyx.exception.EsException;
import com.taeyeon.zyx.utils.GsonUtils;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/14 下午4:34
 * @Description:
 */
@Service("userEsDao")
public class UserEsDaoImpl extends ElasticClientBase implements UserEsDao {
    private static final Logger logger = LoggerFactory.getLogger(UserEsDaoImpl.class);

    private String index = "user_profile";//索引库的名字
    private String mappingType = "user";//索引库中profile的mapping名字
    @Override
    public boolean index(TbTeacher teacher) {
        if (teacher == null) {
            return true;
        }
        if (teacher.getUid() == null || StringUtils.isBlank(teacher.getNick())) {
            throw new BusinessException(ErrCodeConsts.BussinessError.ParamLost,"param valid , [uid or uname] is null");
        }
        TransportClient client = getElasticClient();
        if(null == client){
            throw new EsException("index fail,get client null, uid:"+ teacher.getUid());
        }
        try {
            BulkRequestBuilder bulkRequest = client.prepareBulk();
            XContentBuilder profileJson = buildProfileJson(teacher);

            bulkRequest.add(client.prepareIndex(getIndex(), getMappingType(), teacher.getUid().toString()).setSource(profileJson));
            logger.debug("begin to execute action,uid:{}", teacher.getUid());
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            logger.debug("end execute action,uid:{}", teacher.getUid());
            if (bulkResponse.hasFailures()) {
                logger.error("index failed,uid:{}, teacher:{}, failuremessage:{}", teacher.getUid(), GsonUtils.toJson(teacher), bulkResponse.buildFailureMessage());
                throw new EsException("index fail,uid:"+ teacher.getUid());
            } else {
                logger.info("Completed to index {} documents.", GsonUtils.toJson(teacher));
                return bulkRequest.numberOfActions() == 1;
            }
        } catch (Exception e) {
            logger.error("execute action excetion,uid:{}", teacher.getUid(), e);
            throw new EsException(e);
        }
    }

    @Override
    public TbTeacher getByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        TransportClient client = getElasticClient();
        try {
            QueryBuilder qb = QueryBuilders.matchPhraseQuery(UserConstants.PROFILE_REAL_NAME, name);
            SearchResponse resp = client.prepareSearch(getIndex()).setTypes(getMappingType())
                    .setQuery(qb).setFrom(0).setSize(1).execute().actionGet();
            SearchHits hits = resp.getHits();
            if (hits != null && hits.getTotalHits() > 0) {
                SearchHit hit = hits.getAt(0);
                String profileJson = hit.getSourceAsString();
                if (StringUtils.isNotBlank(profileJson)) {
                    return GsonUtils.fromDateFormateJson(profileJson, TbTeacher.class);
                }
            }
        } catch (Exception e) {
            logger.error("query By Name from es error, name :{}", name, e);
            throw new EsException("query Name error");
        }
        return null;

    }

    @Override
    public List<TbTeacher> listByName(String name) {
        return null;
    }

    private XContentBuilder buildProfileJson(TbTeacher profile) throws IOException {
        return XContentFactory.jsonBuilder().startObject()
                .field("uid", profile.getUid())
                .field("nick", profile.getNick())
//                .field("mobile", profile.getMobile())
                .field("realname", profile.getNick()).endObject();
//
//                .field("birthday", null == profile.getBirthday() ? null:DateUtils.formatDate(profile.getBirthday(), DateUtils.YEAR_TO_SEC))
//                .field("idCard", profile.getIdCard()).endObject();
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMappingType() {
        return mappingType;
    }

    public void setMappingType(String mappingType) {
        this.mappingType = mappingType;
    }
}
