package com.pekka.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pekka.common.pojo.EasyUIDataGridResult;
import com.pekka.common.util.JsonUtils;
import com.pekka.content.service.ContentService;
import com.pekka.pojo.TbContent;
import com.pekka.pojo.TbItem;
import com.pekka.portal.pojo.AD1Node;
import com.pekka.service.ItemADService;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;
	@Autowired
	private ItemADService itemADService;
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
	@Value("${HOT_ITEM_ADID}")
	private Long HOT_ITEM_ADID;// 当季热卖商品
	@Value("${YIZHI_AD_CID}")
	private Long YIZHI_AD_CID;// 益智玩具广告
	@Value("${YIZHI_ITEM_ADID}")
	private Long YIZHI_ITEM_ADID;// 益智玩具商品
	@Value("${YAOKONG_AD_CID}")
	private Long YAOKONG_AD_CID;// 遥控电动广告
	@Value("${YAOKONG_ITEM_ADID}")
	private Long YAOKONG_ITEM_ADID;// 遥控电动商品
	@Value("${JMPC_AD_CID}")
	private Long JMPC_AD_CID;// 积木拼插广告
	@Value("${JMPC_ITEM_ADID}")
	private Long JMPC_ITEM_ADID;// 积木拼插商品
	@Value("${DMMX_ITEM_ADID}")
	private Long DMMX_ITEM_ADID;// 动漫模型商品
	@Value("${DMMX_AD_CID}")
	private Long DMMX_AD_CID;// 动漫模型广告
	@Value("${JSWJ_ITEM_ADID}")
	private Long JSWJ_ITEM_ADID;// 健身玩具商品
	@Value("${JSWJ_AD_CID}")
	private Long JSWJ_AD_CID;// 健身玩具广告
	@Value("${MRWJ_AD_CID}")
	private Long MRWJ_AD_CID;// 毛绒玩具广告
	@Value("${MRWJ_ITEM_ADID}")
	private Long MRWJ_ITEM_ADID;// 毛绒玩具商品
	@Value("${CYDIY_AD_CID}")
	private Long CYDIY_AD_CID;// 创意DIY广告
	@Value("${CYDIY_ITEM_ADID}")
	private Long CYDIY_ITEM_ADID;// 创意DIY商品
	@Value("${YQ_AD_CID}")
	private Long YQ_AD_CID;// 乐器广告
	@Value("${YQ_ITEM_ADID}")
	private Long YQ_ITEM_ADID;// 乐器商品

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

	// 当季热卖商品
	void showHotItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList(HOT_ITEM_ADID);
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

	// 益智玩具商品
	void showYizhiItem(Model model) {
		EasyUIDataGridResult result = itemADService.getItemADList(YIZHI_ITEM_ADID);
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
		EasyUIDataGridResult result = itemADService.getItemADList(YAOKONG_ITEM_ADID);
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
		EasyUIDataGridResult result = itemADService.getItemADList(JMPC_ITEM_ADID);
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
		EasyUIDataGridResult result = itemADService.getItemADList(DMMX_ITEM_ADID);
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
		EasyUIDataGridResult result = itemADService.getItemADList(JSWJ_ITEM_ADID);
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
		EasyUIDataGridResult result = itemADService.getItemADList(MRWJ_ITEM_ADID);
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
		EasyUIDataGridResult result = itemADService.getItemADList(CYDIY_ITEM_ADID);
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
		EasyUIDataGridResult result = itemADService.getItemADList(YQ_ITEM_ADID);
		List<TbItem> list = result.getRows();
		for (TbItem tbItem : list) {
			String img = tbItem.getImage().split(",")[0];
			tbItem.setImage(img);
		}
		model.addAttribute("yqItemList", list);
	}
}
