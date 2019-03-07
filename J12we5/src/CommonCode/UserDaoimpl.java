package CommonCode;

import java.util.List;


import encapsulation.News;
import implement.BaseDao;

public class UserDaoimpl extends  BaseDao {
	public int Svae(News i) {
		int flag = update("insert into news(ntitle,ncontent,npicPath) values(?,?,?)",i.getNtitle(),
			i.getNconcent(),i.getNipcpath());
		return flag;
	}
		
	
}
