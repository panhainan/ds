package com.ds.dreamstation.service;

import com.ds.dreamstation.dto.MailType;

/**
 * @author phn
 * @date 2015-6-23
 * @email 1016593477@qq.com
 * @TODO
 */
public interface IMailService {
	public void sendSingleMail(MailType mailType);
}
