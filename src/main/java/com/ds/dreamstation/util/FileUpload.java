package com.ds.dreamstation.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author phn
 * @date 2015-6-10
 * @email 1016593477@qq.com
 * @TODO
 */
public class FileUpload {
	/**
	 * @TODO 图片上传
	 * @param request
	 * @param fileUpload
	 * @return
	 */
	public static StringBuffer upload(HttpServletRequest request,
			MultipartFile fileUpload,String dirName,boolean isEdit) {
		String savepath = request.getSession().getServletContext()
				.getRealPath("WEB-INF/img/"+dirName);
		String fileName = fileUpload.getOriginalFilename();
		System.out.println(fileName);
		if(isEdit){
			if(fileName.equals("")){
				System.out.println("保持原图");
				return  new StringBuffer("keepOld");
			}
			
		}
		
		// 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length());
		if (!ImgFileType.isContains(ext)) { // 如果扩展名属于允许上传的类型，则创建文件
			System.out.println("文件类型不允许！");
			return null;
		}
		String fileSaveName = new Date().getTime() + ".jpg";
		File targetFile = new File(savepath, fileSaveName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			fileUpload.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer picSite = new StringBuffer();
		picSite.append("img/"+dirName+"/" + fileSaveName);
		return picSite;
	}
}
