package com.ds.dreamstation.util;

/**
 * @author phn
 * @date 2015-6-9
 * @email 1016593477@qq.com
 * @TODO 
 */
public enum ImgFileType {
	JPG,JPEG,PNG,GIF,BMP;
	
	public static boolean isContains(String str){
		for(ImgFileType s: ImgFileType.values()){
			if(s.toString().equalsIgnoreCase(str)){
				return true;
			}
		}
		return false;
	}
	/**
	 * @TODO 测试 isContains方法是否生效
	 * @param args
	 */
	public static void main(String[] args) {
		String ext ="jPeg";
		System.out.println(ImgFileType.isContains(ext));
	}
}
