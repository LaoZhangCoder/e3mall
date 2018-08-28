package cn.e3mall.importindex;

import cn.e3mall.common.pojo.SearchResult;

public interface SearchService {
	SearchResult searchitem(String keyword,int page,int rows) throws Exception ;

}
