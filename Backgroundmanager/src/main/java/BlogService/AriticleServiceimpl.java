package BlogService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Untils.MD5Utils;
import mapper.ArticleMapper;
import mapper.LinksMapper;
import mapper.RootuserMapper;
import pojo.Article;
import pojo.ArticleExample;
import pojo.ArticleExample.Criteria;
import pojo.Links;
import pojo.Resultdata;
import pojo.Rootuser;
import pojo.RootuserExample;


@Service
public class AriticleServiceimpl implements AriticleSerivice {
@Autowired
private ArticleMapper ariticlemapper;
@Autowired
private LinksMapper linksmapper;
@Autowired
private SolrServer solrserver;

public void addariticle(Article ariticle) {
		// TODO Auto-generated method stub
	Date date = new Date();
		ariticle.setDate(date);
		ariticlemapper.insert(ariticle);
		SolrInputDocument document = new SolrInputDocument();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String string = format.format(date);
		document.addField("id",ariticle.getId());
		document.addField("article_title", ariticle.getTitle());
		document.addField("article_content", ariticle.getContent());
		document.addField("article_category", ariticle.getCategory());
		document.addField("article_date", string);
		document.addField("article_href", ariticle.getImghref());
		document.addField("article_autor", ariticle.getAutor());
		document.addField("article_tag", ariticle.getTag());
		try {
			solrserver.add(document);
			solrserver.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Article toeditor(int article_id) {
		ArticleExample example =new ArticleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(article_id);
		// TODO Auto-generated method stub
		List<Article> selectByExample = ariticlemapper.selectByExampleWithBLOBs(example);
		Article at=selectByExample.get(0);
		
		return at;
		
	}
	public void toupdate(int article_id,Article article) {
		article.setDate(new Date());
		
		ArticleExample example=new ArticleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(article_id);
		List<Article> list = ariticlemapper.selectByExample(example);
		Article article2 = list.get(0);
		article.setBackimghref(article2.getBackimghref());
		 ariticlemapper.updateByExampleWithBLOBs(article, example);
		
		 
		
	}
	public void addlink(Links link) {
		// TODO Auto-generated method stub
		linksmapper.insert(link);
		
	}
	@Override
	public Resultdata queryarticlewithhighlingting(String search) throws Exception {
		// TODO Auto-generated method stub
		SolrQuery query = new SolrQuery();
		String trim = search.trim();
		if("".equals(trim)) {
			query.setQuery("*:*");
		}else {
			query.setQuery(search);
		}
		
		query.set("df", "article_title");
		query.setHighlight(true);
		query.addHighlightField("article_title");
		query.setHighlightSimplePre("<em style='color:red'>");
		query.setHighlightSimplePost("</em>");
		QueryResponse queryResponse = solrserver.query(query);
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		long l = solrDocumentList.getNumFound();
		
		Resultdata resultdata = new Resultdata();
		List<Article> list=new ArrayList<Article>();
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : solrDocumentList) {
			//取商品信息
			Article article = new Article();
			article.setTitle((String) solrDocument.get("article_title"));
			String object = (String) solrDocument.get("id");
			int id = Integer.parseInt(object);
			
			article.setId(id);
			article.setImghref((String) solrDocument.get("article_href"));
			article.setContent((String) solrDocument.get("article_content"));
			article.setCategory((String) solrDocument.get("article_category"));
			 String date = (String) solrDocument.get("article_date");
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Date parse = sdf.parse(date);
			article.setDate(parse);
			article.setAutor((String) solrDocument.get("article_autor"));
			article.setTag((String) solrDocument.get("article_tag"));
			
			//取高亮结果
			List<String> listheight = highlighting.get(solrDocument.get("id")).get("article_title");
			String articleTitle = "";
			if (listheight != null && listheight.size() > 0) {
			articleTitle = listheight.get(0);
			} else {
				articleTitle = (String) solrDocument.get("article_title");
			}
			article.setTitle(articleTitle);
			//添加到商品列表
			list.add(article);
		}
		//把列表添加到返回结果对象中
		resultdata.setList(list);
		resultdata.setCount((int) l);
		resultdata.setOk(true);
		
		

		return resultdata;
	}
	
		
		
		
	}
	


