package cn.e3mall.importindeximpl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.SearchItem;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.importindex.Importitem;
import cn.e3mall.search.mapper.ItemMapper;
@Service
public class Importitemimpl implements Importitem{
	@Autowired
	private SolrServer solrserver;
	@Autowired
	private ItemMapper itemmapper;

	@Override
	public E3Result importdate() {
		// TODO Auto-generated method stub
		
		try {	
			List<SearchItem> itemList = itemmapper.getItemList();
			for (SearchItem searchItem : itemList) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", searchItem.getId());
			document.addField("item_title", searchItem.getTitle());
			document.addField("item_sell_point", searchItem.getSell_point());
			document.addField("item_price", searchItem.getPrice());
			document.addField("item_image", searchItem.getImage());
			document.addField("item_category_name", searchItem.getCategory_name());
             solrserver.add(document);
           
			
		}
			  solrserver.commit();
	             return E3Result.ok();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return E3Result.build(500, "导入商品失败");
		}
		 
		
	}

	@Override
	public E3Result additentosolr(Long itemId) throws Exception {
		SearchItem searchItem = itemmapper.getItem(itemId);
		// 2、创建一SolrInputDocument对象。
				SolrInputDocument document = new SolrInputDocument();
				// 3、使用SolrServer对象写入索引库。
				document.addField("id", searchItem.getId());
				document.addField("item_title", searchItem.getTitle());
				document.addField("item_sell_point", searchItem.getSell_point());
				document.addField("item_price", searchItem.getPrice());
				document.addField("item_image", searchItem.getImage());
				document.addField("item_category_name", searchItem.getCategory_name());
			
				// 5、向索引库中添加文档。
				solrserver.add(document);
				solrserver.commit();
				// 4、返回成功，返回e3Result。
				return E3Result.ok();

	}
	

}
