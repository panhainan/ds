package com.ds.dreamstation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ds.dreamstation.dao.IStudiesDao;
import com.ds.dreamstation.dto.NewsInfo;
import com.ds.dreamstation.dto.Pages;
import com.ds.dreamstation.dto.StudiesInfo;
import com.ds.dreamstation.po.News;
import com.ds.dreamstation.po.Studies;
import com.ds.dreamstation.service.IStudiesService;

/**
 * @author phn
 * @date 2015-6-14
 * @email 1016593477@qq.com
 * @TODO
 */
@Service("studiesService")
public class StudiesServiceImpl implements IStudiesService {

	@Resource
	private IStudiesDao studiesDao;

	@Override
	public long add(Studies studies) {
		return this.studiesDao.insert(studies);
	}

	@Override
	public void remove(long id) {
		this.studiesDao.delete(id);
	}

	@Override
	public Studies find(long id) {
		return this.studiesDao.select(id);
	}

	@Override
	public List<StudiesInfo> list(int memberId) {
		List<Studies> listStudies = this.studiesDao.selectByMemberId(memberId);
		List<StudiesInfo> listStudiesInfo = new ArrayList<StudiesInfo>();
		for (Studies studies : listStudies) {
			listStudiesInfo.add(new StudiesInfo(studies));
		}
		return listStudiesInfo;
	}

	@Override
	public Map<String, Object> paging(int current, int size) {
		int allRecords = this.studiesDao.count();
		Pages pageBean = new Pages(size, allRecords, current);
		List<Studies> listStudies = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (pageBean.getCurrentPage() != 0) {
			int currentPageOffset = pageBean.currentPageStartRecord();// 当前页的开始记录
			listStudies = this.studiesDao.paging(currentPageOffset, size );
			List<StudiesInfo> listStudiesInfo = new ArrayList<StudiesInfo>();
			for (Studies studies : listStudies) {
				listStudiesInfo.add(new StudiesInfo(studies));
			}
			pagedMap.put("listStudiesInfo", listStudiesInfo);
			pagedMap.put("pageBean", pageBean);
			return pagedMap;
		} else {
			System.out.println("当前页不符合标准！");
			return null;
		}
	}

}
