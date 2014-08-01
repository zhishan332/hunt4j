package solr;


import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;

/**
* To change this template use File | Settings | File Templates.
*
* @author wangqing
* @since 14-5-22 下午3:31
*/
public class Test1 {
    public static void fail(Object o) {

        System.out.println(o);

    }

    public static void main(String[] args) throws IOException, SolrServerException {
        String DEFAULT_URL = "http://localhost:8983/solr/";
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", 3);

        doc.addField("name", "王爷");

        doc.addField("manu", "上天生我意何如");

        SolrServer server = new HttpSolrServer(DEFAULT_URL);
        //添加一个doc文档

        UpdateResponse response = server.add(doc);

        fail(server.commit());//commit后才保存到索引库

        fail(response);

        fail("query time：" + response.getQTime());

        fail("Elapsed Time：" + response.getElapsedTime());

        fail("status：" + response.getStatus());

        SolrParams params = new SolrQuery("manu:我是三个代表");
        QueryResponse response2;
        response2 = server.query(params);
        SolrDocumentList list = response2.getResults();
        for (Object aList : list) {
            fail(aList);
        }
    }
}
