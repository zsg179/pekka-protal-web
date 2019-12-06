package com.pekka.portal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pekka.common.pojo.EasyUIDataGridResult;
import com.pekka.common.util.JsonUtils;
import com.pekka.content.service.ContentService;
import com.pekka.pojo.TbContent;
import com.pekka.pojo.TbItem;
import com.pekka.portal.pojo.AD1Node;
import com.pekka.service.ItemADService;
import com.pekka.service.ItemService;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;
	@Autowired
	private ItemADService itemADService;
	@Autowired
	private ItemService itemService;
	@Value("${AD1_CID}")
	private Long AD1_CID;// 大广告id
	@Value("${AD1_WIDTH}")
	private Integer AD1_WIDTH;// 大广告宽
	@Value("${AD1_WIDTH_B}")
	private Integer AD1_WIDTH_B;// 大广告宽
	@Value("${AD1_HEIGHT}")
	private Integer AD1_HEIGHT;// 大广告高
	@Value("${AD1_HEIGHT_B}")
	private Integer AD1_HEIGHT_B;// 大广告高
	@Value("${HOT_AD_CID}")
	private Long HOT_AD_CID;// 当季热卖广告
	@Value("${YIZHI_AD_CID}")
	private Long YIZHI_AD_CID;// 益智玩具广告
	@Value("${YAOKONG_AD_CID}")
	private Long YAOKONG_AD_CID;// 遥控电动广告
	@Value("${JMPC_AD_CID}")
	private Long JMPC_AD_CID;// 积木拼插广告
	@Value("${DMMX_AD_CID}")
	private Long DMMX_AD_CID;// 动漫模型广告
	@Value("${JSWJ_AD_CID}")
	private Long JSWJ_AD_CID;// 健身玩具广告
	@Value("${MRWJ_AD_CID}")
	private Long MRWJ_AD_CID;// 毛绒玩具广告
	@Value("${CYDIY_AD_CID}")
	private Long CYDIY_AD_CID;// 创意DIY广告
	@Value("${YQ_AD_CID}")
	private Long YQ_AD_CID;// 乐器广告

	@RequestMapping("/index")
	public String index(Model model) {
		showLunBo(model);
		showHotAD(model);
		showHotItem(model);
		showYizhiAD(model);
		showYizhiItem(model);
		showYaokongAD(model);
		showYaokongItem(model);
		showJMPCAD(model);
		showJMPCItem(model);
		showDMMXAD(model);
		showDMMXItem(model);
		showJSWJAD(model);
		showJSWJItem(model);
		showMRWJAD(model);
		showMRWJItem(model);
		showCYDIYAD(model);
		showCYDIYItem(model);
		showYQAD(model);
		showYQItem(model);
		return "index";
	}

	// 大广告轮播图
	void showLunBo(Model model) {
		List<TbContent> list = contentService.getContentByCid(AD1_CID);
		List<AD1Node> AD1Nodes = new ArrayList<>();
		for (TbContent tbContent : list) {
			AD1Node ad1Node = new AD1Node();
			ad1Node.setAlt(tbContent.getContent());
			ad1Node.setHref(tbContent.getUrl());
			ad1Node.setSrc(tbContent.getPic());
			ad1Node.setSrcB(tbContent.getPic2());
			ad1Node.setHeight(AD1_HEIGHT);
			ad1Node.setHeightB(AD1_HEIGHT_B);
			ad1Node.setWidth(AD1_WIDTH);
			ad1Node.setWidthB(AD1_WIDTH_B);
			AD1Nodes.add(ad1Node);
		}
		String json = JsonUtils.objectToJson(AD1Nodes);
		model.addAttribute("ad1", json);
	}

	// 当季热卖广告
	void showHotAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(HOT_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("hotAD", pic);
		model.addAttribute("hotADURL", list.get(0).getUrl());
	}

	// 当季热卖商品广告
	void showHotItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADHotList();
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("hotItemList", list);
	}

	// 益智玩具广告
	void showYizhiAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(YIZHI_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("yizhiAD", pic);
		model.addAttribute("yizhiADURL", list.get(0).getUrl());
	}

	// 益智玩具商品广告
	void showYizhiItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("益智玩具");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("yizhiItemList", list);
	}

	// 遥控电动广告
	void showYaokongAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(YAOKONG_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("yaokongAD", pic);
		model.addAttribute("yaokongADURL", list.get(0).getUrl());
	}

	// 遥控电动商品
	void showYaokongItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("遥控电动");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("yaokongItemList", list);
	}

	// 积木拼插广告
	void showJMPCAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(JMPC_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("jmpcAD", pic);
		model.addAttribute("jmpcADURL", list.get(0).getUrl());
	}

	// 积木拼插商品
	void showJMPCItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("积木拼插");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("jmpcItemList", list);
	}

	// 动漫模型广告
	void showDMMXAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(DMMX_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("dmmxAD", pic);
		model.addAttribute("dmmxADURL", list.get(0).getUrl());
	}

	// 动漫模型商品
	void showDMMXItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("动漫模型");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("dmmxItemList", list);
	}

	// 健身玩具广告
	void showJSWJAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(JSWJ_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("jswjAD", pic);
		model.addAttribute("jswjADURL", list.get(0).getUrl());
	}

	// 健身玩具商品
	void showJSWJItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("健身玩具");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("jswjItemList", list);
	}

	// 毛绒玩具广告
	void showMRWJAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(MRWJ_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("mrwjAD", pic);
		model.addAttribute("mrwjADURL", list.get(0).getUrl());
	}

	// 毛绒玩具商品
	void showMRWJItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("毛绒玩具");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("mrwjItemList", list);
	}

	// 创意DIY广告
	void showCYDIYAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(CYDIY_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("cyDIYAD", pic);
		model.addAttribute("cyDIYADURL", list.get(0).getUrl());
	}

	// 创意DIY商品
	void showCYDIYItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("创意DIY");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("cyDIYItemList", list);
	}

	// 乐器广告
	void showYQAD(Model model) {
		List<TbContent> list = contentService.getContentByCid(YQ_AD_CID);
		// list里只有一个内容
		String pic = list.get(0).getPic();
		model.addAttribute("yqAD", pic);
		model.addAttribute("yqADURL", list.get(0).getUrl());
	}

	// 乐器商品
	void showYQItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList("乐器");
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("yqItemList", list);
	}

	@RequestMapping(value = "/item/getSalesRanking", method = RequestMethod.POST)
	public String getSalesRanking(String key, HttpServletRequest request) {
		// 返回销量排名前七位的商品
		List<TbItem> saelsRanking = itemService.getSaelsRanking(key, 0, 6);
		switch (key) {
		case "_HOT_AD":
			// model.addAttribute("hotItemRanking", saelsRanking);
			request.getSession().setAttribute("hotItemRanking", saelsRanking);
			break;
		case "_YIZHI_AD":
			// model.addAttribute("YZItemRanking", saelsRanking);
			request.getSession().setAttribute("YZItemRanking", saelsRanking);
			break;
		case "_YAOKONG_AD":
			// model.addAttribute("YKItemRanking", saelsRanking);
			request.getSession().setAttribute("YKItemRanking", saelsRanking);
			break;
		case "_JMPC_AD":
			// model.addAttribute("JMPCItemRanking", saelsRanking);
			request.getSession().setAttribute("JMPCItemRanking", saelsRanking);
			break;
		case "_DMMX_AD":
			// model.addAttribute("DMMXItemRanking", saelsRanking);
			request.getSession().setAttribute("DMMXItemRanking", saelsRanking);
			break;
		case "_JSWJ_AD":
			// model.addAttribute("JSItemRanking", saelsRanking);
			request.getSession().setAttribute("JSItemRanking", saelsRanking);
			break;
		case "_MRWJ_AD":
			// model.addAttribute("MRItemRanking", saelsRanking);
			request.getSession().setAttribute("MRItemRanking", saelsRanking);
			break;
		case "_CYDIY_AD":
			// model.addAttribute("CYDIYItemRanking", saelsRanking);
			request.getSession().setAttribute("CYDIYItemRanking", saelsRanking);
			break;
		case "_YQ_AD":
			// model.addAttribute("YQItemRanking", saelsRanking);
			request.getSession().setAttribute("YQItemRanking", saelsRanking);
			break;
		default:
			break;
		}
		return key;
	}
}
