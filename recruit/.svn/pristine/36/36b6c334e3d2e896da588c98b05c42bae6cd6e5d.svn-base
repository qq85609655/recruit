package com.csot.recruit.service.job.impl;


import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.csot.recruit.common.util.Result;
import com.csot.recruit.model.resume.PositionSearch;
import com.csot.recruit.service.job.JobService;
import com.csot.recruit.service.resume.MyResumeRepositoryService;
@Component
public class JobServiceImpl implements InitializingBean,JobService {
	private Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
	@Resource
	private MyResumeRepositoryService myResumeRepositoryService;
	

	// 定时创建知识索引  每天1点执行
	@Scheduled(cron ="0 0 1 * * ?")
	@Override
	public void createIndex() {
		// 获取要建索引的人才库id
		//isSearch不等于99的值需要创建 此处为创建失败的数据有5此创建机会每次失败isSearch++;
		List<PositionSearch> positionSearchs = myResumeRepositoryService.querySearchPosition();
		if (positionSearchs.size() > 0) {
			for (PositionSearch positionSearch : positionSearchs) {
				if (Integer.valueOf(positionSearch.getIsSearch()) < 5) {
					Result result = myResumeRepositoryService.createIndexImpl(positionSearch.getPositionId(),0);
					if (result.isSuccess()) {
						myResumeRepositoryService.updatePositionIsSearch(positionSearch.getPositionId());
					} else {
						myResumeRepositoryService.updatePositionAddIsSearch(positionSearch.getPositionId());
					}
				}
				
			}
		}
		
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

}
