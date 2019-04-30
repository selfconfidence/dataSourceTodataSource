package com.bdsoft.sourcereversal.gather;
import com.bdsoft.sourcereversal.constant.SourceReversalConstant;
import com.bdsoft.sourcereversal.util.SourceReversalMap;
import com.bdsoft.sourcereversal.util.SourceReversalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author mister_wei
 * @version 1.1.1
 * @title web_service
 * @package com.bdsoft.sourcereversal.gather
 * @date 2019/4/25 20:57
 */
@Component
public class TimeStaskGather {
    private Logger logger = LoggerFactory.getLogger(TimeStaskGather.class);

    @Qualifier("mysqlTemplate")
    @Resource
    private JdbcTemplate mysqlJdbcTemplate;

    @Qualifier("kingBaseTemplate")
    @Resource
    private JdbcTemplate kingBaseJdbcTemplate;

    @Autowired
    private SourceReversalUtil sourceReversalUtil;


    @Scheduled(cron = "0 0 0/1 * * ?")//生产环境定时任务!
    //@Scheduled(cron = "0 * * * * ?")//测试环境定时任务!
    public void kingBaseToMysqlReversal() {
        logger.info("定时任务开始,执行读写任务!");
        String path = "C:\\data.txt";
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String departmentIdToName = null;
        SourceReversalMap sourceReversalMap = new SourceReversalMap();
        Map zfClueBaseMap = sourceReversalMap.getZfClueBaseMap();
        Map zfClueInformerMap = sourceReversalMap.getZfClueInformerMap();
        Map deptMap = new HashMap();
        Map  zfClueBaseMaps = new HashMap();
        Map  zfClueInformerMaps = new HashMap();
        Map codeMap = new HashMap();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            File filePath = new File(path);
            byte[] arr = new byte[1024];
            int len;
            if (!filePath.exists()) {
                logger.info("未检测出文本信息,第一次执行系统批量导入操作!");
                //这个日期必须查询出来是表数据中最大日期值以便于定时采集数据的时候有条件.
                Map dataMap = mysqlJdbcTemplate.queryForMap(SourceReversalConstant.Constant.SQL_MAX_DATE);
                Date date = (Date) dataMap.get("maxData"); //把最大的时间拿出来,写入到文本,到下次作为条件.
                //第一次,需要全量导出kingbase数据库 把当前最大时间存储到文件中
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
                bufferedOutputStream.write(simpleDateFormat.format(date).getBytes());
                bufferedOutputStream.flush();
                //逻辑区
                {
                    //第一次把所有的数据查询出来
                    List<Map<String, Object>> mysqlList = mysqlJdbcTemplate.queryForList(SourceReversalConstant.Constant.SQL);
                    //这是 wg_department所有数据用来进行翻译.
                    dataTransfer(departmentIdToName, deptMap,codeMap, zfClueBaseMap, zfClueInformerMap, mysqlList, sourceReversalMap,zfClueBaseMaps,zfClueInformerMaps);
                }
            } else {
                logger.info("检测出文本信息,按照添加事件过滤数据进行导入!");
                Map dataMap = mysqlJdbcTemplate.queryForMap(SourceReversalConstant.Constant.SQL_MAX_DATE);
                Date date = (Date) dataMap.get("maxData"); //把最大的时间拿出来,写入到文本,到下次作为条件.
                //把文件中得文件读出来
                bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                if (line == null) {
                    logger.error("文件日期为null,请检查系统文件!");
                    return;
                }
                filePath.delete();
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
                bufferedOutputStream.write(simpleDateFormat.format(date).getBytes());
                bufferedOutputStream.flush();
                //获取到时间
                Date parse = simpleDateFormat.parse(line);
                //批量导出操作,把这个日期最大值查询出来,然后再次存到请求域(更换域日期),
                //逻辑区
                {
                    List<Map<String, Object>> mysqlListMap = mysqlJdbcTemplate.queryForList(SourceReversalConstant.Constant.SQL_MAX_DATA.replace("&&&", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(parse)));
                    //把读取的时间拿出来作为条件查询parse
                    dataTransfer(departmentIdToName, deptMap,codeMap, zfClueBaseMap, zfClueInformerMap, mysqlListMap, sourceReversalMap,zfClueBaseMaps,zfClueInformerMaps);

                }


            }

        } catch (Exception e) {
            //异常处理区
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            sourceReversalMap.close();
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            logger.info("在 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ";  的时间段执行了一次读写任务! ");
        }
    }

    private void dataTransfer(String departmentIdToName, Map deptMap,Map codeMap,Map zfClueBaseMap, Map zfClueInformerMap, List<Map<String, Object>> mysqlList, SourceReversalMap sourceReversalMap, Map  zfClueBaseMaps, Map  zfClueInformerMaps) {
        List<Map<String, Object>> wg_departmentList = null;
        List<Map<String,Object>>  code_nameMapList = null;
        if (mysqlList.size() != 0) {
            wg_departmentList = kingBaseJdbcTemplate.queryForList(SourceReversalConstant.Constant.SQL_WG_DEPARTMENT);
            code_nameMapList = kingBaseJdbcTemplate.queryForList(SourceReversalConstant.Constant.SQL_CODE_NO);
        }
        //遍历执行
        for (Map<String, Object> stringObjectMap : mysqlList) {
            try{
            for (String key : stringObjectMap.keySet()) {
                if(key.equalsIgnoreCase("ORGANIZATION_NAME")){
                    continue;
                }
                if (key.equalsIgnoreCase("ORGANIZATION_ADDRESS")){
                    continue;
                }
                if (key.equalsIgnoreCase("ORGANIZATION_CODE")){
                    continue;
                }
                //首先添加线索表的业务逻辑.
                for (Object zfClueBaseKey : zfClueBaseMap.keySet()) {

                    boolean flag = false;
                    if (zfClueBaseKey.toString().equalsIgnoreCase(key)) {
                        //进行数据填充
                        zfClueBaseMaps.put(zfClueBaseKey, stringObjectMap.get(key));
                        //逻辑加持
                    }
                    if (key.equalsIgnoreCase("REPORT_TYPE")) {//举报类别（代码表）
                        zfClueBaseMaps.put(key, sourceReversalUtil.isRepoertType(stringObjectMap.get(key)));
                    }
                    //举报地区  做翻译
                    if (key.equalsIgnoreCase("Area") ) {
                        if (stringObjectMap.get("Area") != null){
                            departmentIdToName = sourceReversalUtil.wgDepartmentIdToName(stringObjectMap.get("Area").toString(), wg_departmentList);
                            if (codeMap.get(departmentIdToName) == null){
                                String code_no = sourceReversalUtil.deptNameToCode(departmentIdToName, code_nameMapList);
                                zfClueBaseMaps.put(key,code_no );
                                codeMap.put(departmentIdToName,code_no);
                            }else{
                                zfClueBaseMaps.put(key,codeMap.get(departmentIdToName) );
                            }

                        }else{
                            zfClueBaseMaps.put(key, stringObjectMap.get(key));
                        }

                    }
                    //创建部门名
                    if (zfClueBaseMap.get("CREATE_DEPT_NAME") == null && departmentIdToName != null) {
                        zfClueBaseMaps.put("CREATE_DEPT_NAME", departmentIdToName);
                    }

                    //创建部门ID这个部门ID 必须通过name 查找数据
                    if (zfClueBaseMaps.get("CREATE_DEPT_ID") == null) {
                        if (departmentIdToName != null) {
                            if (deptMap.get(departmentIdToName) == null) {
                                Map<String, Object> stringObjectMap1 = kingBaseJdbcTemplate.queryForMap(SourceReversalConstant.Constant.SQL_DEPT_WG_ID.replace("&&&", departmentIdToName));
                                zfClueBaseMaps.put("CREATE_DEPT_ID", stringObjectMap1.get("Deptid"));
                                deptMap.put(departmentIdToName, stringObjectMap1.get("Deptid"));
                            } else {
                                zfClueBaseMaps.put("CREATE_DEPT_ID", deptMap.get(departmentIdToName));
                            }
                        }


                    }

                }
                for (Object zfClueInformerKey : zfClueInformerMap.keySet()) {

                    if (zfClueInformerKey.toString().equalsIgnoreCase(key)) {
                        zfClueInformerMaps.put(zfClueInformerKey, stringObjectMap.get(key));
                    }
                    //ID需要自己处理不管.
                    if (key.equalsIgnoreCase("ID")) {
                        zfClueInformerMaps.put("ID", UUID.randomUUID().toString());
                        //添加线索主键
                        zfClueInformerMaps.put("CLUE_ID", stringObjectMap.get(key));
                    }

                }
            }
            //执行插入操作,并清除map数据
            String zfClueBaseKey = sourceReversalUtil.getKey(zfClueBaseMaps);
            String zfClueBaseValues = sourceReversalUtil.getValue(zfClueBaseMaps);
            String zfClueInformerKey = sourceReversalUtil.getKey(zfClueInformerMaps);
            String zfClueInformerValues = sourceReversalUtil.getValue(zfClueInformerMaps);

                int clueBaseRow = kingBaseJdbcTemplate.update("INSERT INTO \"PUBLIC\".\"ZF_CLUE_BASE\" (" + zfClueBaseKey + ") values (" + zfClueBaseValues + ")");
                int clueInformerRow = kingBaseJdbcTemplate.update("INSERT INTO \"PUBLIC\".\"ZF_CLUE_INFORMER\" (" + zfClueInformerKey + ") values (" + zfClueInformerValues + ")");
                if (clueBaseRow != 0) {
                    logger.info("线索表插入成功! 线索ID 为"+ zfClueBaseMaps.get("ID"));
                } else {
                    logger.error("线索表插入失败! 线索ID为"+ zfClueBaseMaps.get("ID"));
                }
                if (clueInformerRow != 0) {
                    logger.info("举报人表插入成功! 举报人ID为"+ zfClueInformerMaps.get("ID"));
                } else {
                    logger.error("举报人表插入失败! 举报人ID为"+ zfClueInformerMaps.get("ID"));
                }
            }catch (Exception e){
                logger.error("插入数据错误.错误信息为"+e.getMessage()+"\r\n"+"失败的数据是:"+stringObjectMap.toString());
            }finally {
                sourceReversalMap.close();
                departmentIdToName = null;
                zfClueBaseMaps.clear();
                zfClueInformerMaps.clear();
            }

        }
    }
}
