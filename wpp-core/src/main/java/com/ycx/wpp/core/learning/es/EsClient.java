package com.ycx.wpp.core.learning.es;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.sort.SortParseElement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.commonTermsQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created by apple on 2018/5/9.
 */
public class EsClient {
    public static void main(String[] args) {
        try {
            Settings settings = Settings.settingsBuilder()
                    .put("cluster.name", "my-application").build();
            TransportClient client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//            BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//                queryBuilder.filter(QueryBuilders.termsQuery("primary_tag_id", supermarketPoiTag));
//            queryBuilder.filter(QueryBuilders.termQuery("brand_id", brand.getId()));
//            QueryBuilder qb =commonTermsQuery("name",
//                    "梅西");
            QueryBuilder queryBuilder = matchAllQuery();
            SearchResponse scrollResp = client.prepareSearch("mote01").setTypes("mote01")
                    .addSort("name", SortOrder.ASC)
                    .setScroll(new TimeValue(60000)).setQuery(queryBuilder).setFetchSource("name", null).setSize(5).execute().actionGet();

            int scollTime = 1;
            List<String> docIdList = Lists.newArrayList();
            Map<String, Map<String, Object>> map = Maps.newHashMap();
            for (;;) {
                for (SearchHit hit : scrollResp.getHits().getHits()) {

                    docIdList.add(hit.getId());
                    map.put(hit.getId(), hit.getSource());
                    System.out.println(hit.getSource());
                }

                scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
//                long search_sleep_time = com.sankuai.meituan.util.ConfigUtilAdapter.getLong("es_search_sleep_time", 100);
                Thread.sleep(1000);
                if (scrollResp.getHits().getHits().length == 0) {
                    client.prepareClearScroll().addScrollId(scrollResp.getScrollId()).execute().actionGet();
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
