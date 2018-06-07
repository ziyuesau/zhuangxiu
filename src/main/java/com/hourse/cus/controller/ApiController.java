package com.hourse.cus.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hourse.common.exception.RRException;
import com.hourse.common.utils.R;

@RestController
@RequestMapping("/cus/api")
public class ApiController {
	public final String OBJ_TAG = "data";

	 

	private void initPage(Map<String, Object> params) {
		params.put("page", "1");
		params.put("limit", "100");
		params.put("sidx", "");
		params.put("order", "");

	}

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	public R upload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws Exception {
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		// 上传文件
		String suffix = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."));
		System.out.println(suffix);
		// String url = OSSFactory.build().uploadSuffix(file.getBytes(),
		// suffix);

		String realPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/upload";// 文件的硬盘真实路径
		System.out.println(realPath);
		File file0 = new File(realPath);
		if (!file0.exists()) {
			file0.mkdirs();// 创建根目录
		}

		File savefile = new File(realPath + "/" + System.currentTimeMillis()
				+ suffix);
		System.out.println(savefile.getPath());
		// 文件拷贝到指定硬盘目录
		FileCopyUtils.copy(file.getBytes(), savefile);
		System.out.println("upload/" + savefile.getName());
		String contextPath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + contextPath;
		return R.ok().put("url", basePath + "/upload/" + savefile.getName());
	}

	 
}
