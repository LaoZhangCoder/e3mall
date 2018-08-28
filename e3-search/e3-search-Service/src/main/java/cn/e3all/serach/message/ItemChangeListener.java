package cn.e3all.serach.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.importindex.Importitem;

public class ItemChangeListener implements MessageListener {
	@Autowired
	private Importitem improtitem;

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage textMessage = null;
		Long itemId = null; 
		textMessage=(TextMessage) message;
		try {
			String text = textMessage.getText();
			long parseLong = Long.parseLong(text);
			itemId=parseLong;
			
				improtitem.additentosolr(itemId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
	

}
