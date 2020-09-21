package com.xiaoka.service;

import com.xiaoka.bean.EBP;
import com.xiaoka.dao.EbpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EbpService {

    @Autowired
    private EbpDao ebpDao;


    public EBP getByidCard(String idCard) {
        return ebpDao.getByidCard(idCard);
    }

    public int updateEbp(EBP ebp){

        return ebpDao.updateEbp(ebp);
    }

}
