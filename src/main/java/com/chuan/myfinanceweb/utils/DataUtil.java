package com.chuan.myfinanceweb.utils;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DataUtil {
	public static void main(String[] args) {
		Document doc = Jsoup.parseBodyFragment("<select name=\"commodity\" align=\"middle\">  <option selected=\"\" value=\"\">--品种名称--</option>  <option value=\"CF\">棉花CF</option>  <option value=\"ER\">早籼ER</option>  <option value=\"RO\">菜油RO</option>  <option value=\"SR\">白糖SR</option>  <option value=\"TA\">PTA</option>  <option value=\"WS\">强麦WS</option>  <option value=\"WT\">硬麦WT</option>  <option value=\"ME\">甲醇ME</option>  <option value=\"OI\">菜油OI</option>  <option value=\"RI\">早籼RI</option>  <option value=\"WH\">强麦WH</option>  <option value=\"FG\">玻璃FG</option>  <option value=\"PM\">普麦PM</option>  <option value=\"RS\">油菜籽RS</option>  <option value=\"RM\">菜籽粕RM</option>  <option value=\"TC\">动力煤TC</option>  <option value=\"ZC\">动力煤ZC</option>  <option value=\"JR\">粳稻JR</option>  <option value=\"MA\">甲醇MA</option>  <option value=\"LR\">晚籼LR</option>  <option value=\"SF\">硅铁SF</option>  <option value=\"SM\">锰硅SM</option>  <option value=\"CY\">棉纱CY</option>  <option value=\"AP\">苹果AP</option>  <option value=\"CJ\">红枣CJ</option>  <option value=\"UR\">尿素UR</option>  <option value=\"SA\">纯碱SA</option>  </select>");
		List<Element> list = doc.select("option");
		for (Element ele:list) {
			System.out.println(ele.html().substring(0,ele.html().length()-2)+"="+ele.attr("value"));
		}
	}
}
