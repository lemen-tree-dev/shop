package com.shop.service.impl;

import com.shop.domain.Goods;
import com.shop.service.EsService;
import com.shop.service.GoodsService;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company: 小米科技
 * @author： 小宝
 * @date： 2019/11/9 17:09
 */
@Service
public class EsServiceImpl implements EsService {

    @Resource
    private GoodsService goodsService;
    @Resource
    private RestHighLevelClient restHighLevelClient;


    //将数据库中的数据放进es索引库
    @Override
    public void putInEs() {
        List<Goods> all = goodsService.selectAll();
        Map<String, Object> jsonMap = new HashMap<>();
        for (Goods l:all) {
            jsonMap.put("goodsName", l.getGoodsName());
            jsonMap.put("goodsPic",l.getGoodsPic());
            jsonMap.put("goodsPrice", l.getGoodsPrice());
            jsonMap.put("goodsCount", l.getGoodsCount());
            jsonMap.put("goodsStock", l.getGoodsStock());
            jsonMap.put("goodsDiscount", l.getGoodsDiscount());
            jsonMap.put("goodsDescr", l.getGoodsDescr());
            //索引请求对象
            IndexRequest indexRequest = new IndexRequest("shop_project","doc");
            //指定索引文档内容
            indexRequest.source(jsonMap);
            String id=String.valueOf( l.getGoodsId());
            indexRequest.id(id);
            //索引响应对象
            try {
                IndexResponse indexResponse = restHighLevelClient.index(indexRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void addInEs(Goods goods) {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("goodsName", goods.getGoodsName());
        jsonMap.put("goodsPic",goods.getGoodsPic());
        jsonMap.put("goodsPrice", goods.getGoodsPrice());
        jsonMap.put("goodsCount", goods.getGoodsCount());
        jsonMap.put("goodsStock", goods.getGoodsStock());
        jsonMap.put("goodsDiscount", goods.getGoodsDiscount());
        jsonMap.put("goodsDescr", goods.getGoodsDescr());
        //索引请求对象
        IndexRequest indexRequest = new IndexRequest("shop_project","doc");
        //指定索引文档内容
        indexRequest.source(jsonMap);
        String id=String.valueOf( goods.getGoodsId());
        indexRequest.id(id);
        //索引响应对象
        IndexResponse indexResponse = null;
        try {
            indexResponse = restHighLevelClient.index(indexRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInEs(Goods goods) {
        int id=goods.getGoodsId();
        UpdateRequest updateRequest = new UpdateRequest("shop_project", "doc", "id");
        Map<String, String> map = new HashMap<>();
        map.put("pid",String.valueOf(goods.getGoodsId()));
        map.put("goodsName", goods.getGoodsName());
        map.put("goodsPic",goods.getGoodsPic());
        map.put("goodsPrice", String.valueOf(goods.getGoodsPrice()));
        map.put("goodsCount", String.valueOf(goods.getGoodsCount()));
        map.put("goodsStock", String.valueOf(goods.getGoodsStock()));
        map.put("goodsDiscount",String.valueOf(goods.getGoodsDiscount()));
        map.put("goodsDescr", goods.getGoodsDescr());
        updateRequest.doc(map);
        UpdateResponse update = null;
        try {
            update = restHighLevelClient.update(updateRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestStatus status = update.status();
        System.out.println(status);
    }

    @Override
    public void delInEs(Integer _id) {
        String id=String.valueOf(_id);
        //删除索引请求对象
        DeleteRequest deleteRequest = new DeleteRequest("shop_project","doc",id);
        //响应对象
        try {
            restHighLevelClient.delete(deleteRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询
    @Override
    public List<Goods> chaxun(String str) {

        //搜索请求对象
        SearchRequest searchRequest=new SearchRequest("shop_project");
        //设置类型
        searchRequest.types("doc");
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        //分页查询（参数）
//        int page=1;
//        int size=2;
//        int from=(page-1)*size;
//        searchSourceBuilder.from(from);//起始记录的下标
//        searchSourceBuilder.size(size);
        //搜索全部QueryBuilders.matchAllQuery()
        //精确查询QueryBuilders.termQuery("name","spring cloud实战")
        // 根据id精确匹配QueryBuilders.termsQuery("_id",1)
        //全文检索先将搜索关键字分词，再拿各各词语去索引中搜索
        //QueryBuilders.matchQuery("name","spring cloud实战").operator(Operator.OR)分词有一个及以上满足
        //QueryBuilders.matchQuery("name","spring cloud实战").operator(Operator.AND)分词必须都满足
        //字段权重
        //MultiMatchQueryBuilder multiMatchQueryBuilder=QueryBuilders.multiMatchQuery("spring","name","description").field("name",10);
        //searchSourceBuilder.query(multiMatchQueryBuilder);
        //布尔查询
//        BoolQueryBuilder boolQueryBuilder=new BoolQueryBuilder();
//        boolQueryBuilder.must(multiMatchQueryBuilder);
//        boolQueryBuilder.must(termQueryBuilder);
//        //排序
//        //过滤项
//        boolQueryBuilder.filter(QueryBuilders.termQuery("studymodel",201001));
//        //过滤范围
//        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(0).lte(10));
//        searchSourceBuilder.query(boolQueryBuilder);
        //高亮设置
//        HighlightBuilder highlightBuilder=new HighlightBuilder();
////        highlightBuilder.preTags("<font style='color:red'>");
////        highlightBuilder.postTags("</font>");
////        highlightBuilder.fields().add(new HighlightBuilder.Field("name"));
////        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(str,"pname","pinfomation","days"));

        //source 源字段过滤
//        searchSourceBuilder.fetchSource(new String[]{"name","studymodel","price","timestamp"},new String[]{});
        //设置搜索源
        searchRequest.source(searchSourceBuilder);
        //客户端执行搜索
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest);
            System.out.println(searchResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        List<Goods> list=new ArrayList<>();
        for(SearchHit hit:searchHits){
            Goods goods=new Goods();
            Map<String, Object> sourceAsMap= hit.getSourceAsMap();
            goods.setGoodsId((int)sourceAsMap.get("goodsId"));
            goods.setGoodsName((String)sourceAsMap.get("goodsName"));
            goods.setGoodsDescr((String)sourceAsMap.get("goodsDescr"));
            goods.setGoodsCount((int)sourceAsMap.get("goodsCount"));
            goods.setGoodsDiscount((long)sourceAsMap.get("goodsDiscount"));
            goods.setGoodsPic((String)sourceAsMap.get("goodsPic"));
            goods.setGoodsStock((int)sourceAsMap.get("goodsStock"));
            goods.setGoodsPrice((BigDecimal) sourceAsMap.get("goodsPrice"));
            list.add(goods);
        }
        return list;
    }

    @Override
    public List<Goods> search() {

        //搜索请求对象
        SearchRequest searchRequest = new SearchRequest("shop_project");
        //设置类型
        searchRequest.types("doc");
        //搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //分页查询（参数）
//        int page=1;
//        int size=2;
//        int from=(page-1)*size;
//        searchSourceBuilder.from(from);//起始记录的下标
//        searchSourceBuilder.size(size);
        //搜索全部QueryBuilders.matchAllQuery()
        //精确查询QueryBuilders.termQuery("name","spring cloud实战")
        // 根据id精确匹配QueryBuilders.termsQuery("_id",1)
        //全文检索先将搜索关键字分词，再拿各各词语去索引中搜索
        //QueryBuilders.matchQuery("name","spring cloud实战").operator(Operator.OR)分词有一个及以上满足
        //QueryBuilders.matchQuery("name","spring cloud实战").operator(Operator.AND)分词必须都满足
        //字段权重
        //MultiMatchQueryBuilder multiMatchQueryBuilder=QueryBuilders.multiMatchQuery("spring","name","description").field("name",10);
        //searchSourceBuilder.query(multiMatchQueryBuilder);
        //布尔查询
//        BoolQueryBuilder boolQueryBuilder=new BoolQueryBuilder();
//        boolQueryBuilder.must(multiMatchQueryBuilder);
//        boolQueryBuilder.must(termQueryBuilder);
//        //排序
//        //过滤项
//        boolQueryBuilder.filter(QueryBuilders.termQuery("studymodel",201001));
//        //过滤范围
//        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(0).lte(10));
//        searchSourceBuilder.query(boolQueryBuilder);
        //高亮设置
//        HighlightBuilder highlightBuilder=new HighlightBuilder();
////        highlightBuilder.preTags("<font style='color:red'>");
////        highlightBuilder.postTags("</font>");
////        highlightBuilder.fields().add(new HighlightBuilder.Field("name"));
////        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        //source 源字段过滤
//        searchSourceBuilder.fetchSource(new String[]{"name","studymodel","price","timestamp"},new String[]{});
        //设置搜索源
        searchRequest.source(searchSourceBuilder);
        //客户端执行搜索
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest);
            System.out.println(searchResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        String id = null;
        List<Goods> list=null;
        for (SearchHit s : searchHits) {
            id = s.getId();
            System.out.println(id);
            list = new ArrayList<>();
            for (SearchHit hit : searchHits) {
                Goods goods=new Goods();
                Map<String, Object> sourceAsMap= hit.getSourceAsMap();
                goods.setGoodsId((int)sourceAsMap.get("goodsId"));
                goods.setGoodsName((String)sourceAsMap.get("goodsName"));
                goods.setGoodsDescr((String)sourceAsMap.get("goodsDescr"));
                goods.setGoodsCount((int)sourceAsMap.get("goodsCount"));
                goods.setGoodsDiscount((long)sourceAsMap.get("goodsDiscount"));
                goods.setGoodsPic((String)sourceAsMap.get("goodsPic"));
                goods.setGoodsStock((int)sourceAsMap.get("goodsStock"));
                goods.setGoodsPrice((BigDecimal) sourceAsMap.get("goodsPrice"));
                list.add(goods);
            }
        } return list;
    }
}
