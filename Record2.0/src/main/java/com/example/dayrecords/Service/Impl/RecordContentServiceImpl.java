package com.example.dayrecords.Service.Impl;




import com.example.dayrecords.Bean.RecordContent;
import com.example.dayrecords.Bean.RecordType;
import com.example.dayrecords.Dao.RecordContentDao;
import com.example.dayrecords.Dao.RecordTypeListDao;
import com.example.dayrecords.Enum.ResponseEnum;
import com.example.dayrecords.Exception.OrdinaryException;
import com.example.dayrecords.Service.RecordContentService;
import com.example.dayrecords.Utils.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RecordContentServiceImpl implements RecordContentService {
    @Autowired
    RecordContentDao recordContentDao;
    @Autowired
    RecordTypeListDao typeListDao;
    /**
     * 获取日记首页日记数据
     * @param userId
     * @return
     */
    @Override
    public ResultDTO getRecordInfo(int userId) {
        String moduleName = "RecordContentServiceImpl-getRecordInfo";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数位[%s]",moduleName,userId));
        List<String> content = recordContentDao.getContent(userId);
        int count = 0;
        //循环获取日记字数
        if (content != null) {
            for (int i = 0; i < content.size(); i++) {
                count += content.get(i).toString().length();
            }
        }
        //日记总数
        RecordContent recordContent = new RecordContent();
        recordContent.setRecordUser(userId);
        int totalPage = recordContentDao.getPage(recordContent);
        List<RecordType> recordType = typeListDao.getRecordType();
        if (recordType == null){
            throw new OrdinaryException(String.format("系统错误：[%s]:[%s],没有日记类型",
                    ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg()));
        }
        int typeNum = recordType.size();
        Map<String,Object> qList = new HashMap<String,Object>();
        List<Map> typeInfoList = new ArrayList<Map>();
        for (int i = 0;  i<typeNum ; i++) {
            Map<String,Object> typePageList = new HashMap<String,Object>();
            RecordContent recordContent1 = new RecordContent();
            recordContent1.setRecordUser(userId);
            recordContent1.setRecordType(recordType.get(i).getRecordType());
            int typePage = recordContentDao.getPage(recordContent1);
            typePageList.put("desc",recordType.get(i).getRecordName()+typePage+"篇");
            typeInfoList.add(typePageList);
        }
        qList.put("totalPage","共有"+totalPage+"篇记录");
        qList.put("totalWord","总字数:"+count);
        qList.put("typeInfoList",typeInfoList);
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),qList);
    }

    /**
     * 获取日记
     * @param userId
     * @return
     */
    @Override
    public ResultDTO getRecord(int userId, int page) {
        String moduleName = "RecordContentServiceImpl-getRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数位[%s]",moduleName,userId));
        List<String> content = recordContentDao.getContent(userId);
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(),content);
    }

    /**
     * 添加日记
     * @param recordContent
     * @return
     */
    @Override
    public ResultDTO addRecord(RecordContent recordContent) {
        String moduleName = "RecordContentServiceImpl-addRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数位[%s]",moduleName,recordContent));
        //拼接日期
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int dayOfMonth = localDate.getDayOfMonth();
        String Date = year+"-"+month+"-"+dayOfMonth;
        recordContent.setRecordDate(Date);
        //标识不为空，为修改日记
        if(recordContent.getRecordSign() != null){
            recordContentDao.updateRecord(recordContent);
            return new ResultDTO(ResponseEnum.SUCCESS.getCode(),
                    ResponseEnum.SUCCESS.getMsg(),
                    recordContent.getRecordSign());
        }
        //拼接日记标识
        String head = "record";
        String rear = recordContent.getRecordUser()+recordContent.getRecordType()+recordContent.getRecordImg();
        String sign = head+rear;
        recordContent.setRecordSign(sign);
        boolean add = recordContentDao.addRecord(recordContent);
        if (add){
            //增加成功返回sign标识
            return new ResultDTO(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),sign);
        }
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg(),sign);
    }

    /**
     * 分页获取日记
     * @param userId
     * @param page
     * @return
     */
    @Override
    public ResultDTO getPageRecord(int userId, int page) {
        Map<String,Object> ret = new HashMap<String,Object>();
        String moduleName = "RecordContentServiceImpl-getPageRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数:[%s],[%s]",moduleName,userId,page));
        //配置分页起始行
        int startRow = (page-1)*5;
        List<RecordContent> recordWithPage = recordContentDao.getRecordWithPage( userId, startRow);
        ret.put("recordData",recordWithPage);
        //日记篇数
        int total = recordContentDao.getTotalPage(userId);
        ret.put("total",total);
        List<Map> result = new ArrayList<Map>();
        result.add(ret);
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),result);
    }

    /**
     * 依靠日记id获取日记信息
     * @param recordId
     * @return
     */
    @Override
    public ResultDTO getRecordById(int recordId) {
        Map<String,Object> ret = new HashMap<String,Object>();
        String moduleName = "RecordContentServiceImpl-getPageRecord";
        long startTime = System.currentTimeMillis();
        log.info(String.format(">>>进入处理方法[%s],参数:日记id:[%s]",moduleName,recordId));
        Map<String, Object> recordById = recordContentDao.getRecordById(recordId);
        log.info(String.format(">>>执行处理方法[%s],共耗时[%s]",moduleName,System.currentTimeMillis()-startTime));
        return new ResultDTO(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),recordById);
    }
}
