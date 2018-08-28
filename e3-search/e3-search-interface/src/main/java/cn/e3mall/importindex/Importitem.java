package cn.e3mall.importindex;

import cn.e3mall.common.untils.E3Result;

public interface Importitem {
	public  abstract E3Result importdate();
	E3Result additentosolr(Long itemId) throws Exception;

}
