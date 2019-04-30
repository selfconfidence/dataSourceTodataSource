package com.bdsoft.sourcereversal.util;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mister_wei
 * @version 1.1.1
 * @title web_service
 * @package com.bdsoft.sourcereversal.util
 * @date 2019/4/26 17:13
 */
@Component
public class SourceReversalMap {

    private static ThreadLocal<Map<String,Object>> zfClueBaseMap = new ThreadLocal<Map<String,Object>>();
    private static ThreadLocal<Map<String,Object>> zfClueInformerMap = new ThreadLocal<Map<String,Object>>();
  static {

 }
   public SourceReversalMap(){
       zfClueInformerMap.set(new HashMap<String,Object>());
       zfClueBaseMap.set(new HashMap<String,Object>());
       Map zfClueBase = zfClueBaseMap.get();
       Map zfClueInformer = zfClueInformerMap.get();
       // 相当于就是一个 zfClueBase一个金仓数据.
       zfClueBase.put("ID",null);
       zfClueBase.put("BASE_ID",null);
       zfClueBase.put("CLUE_SOURCE",null);
       zfClueBase.put("CLUE_SOURCE_REMARK",null);
       zfClueBase.put("REPORT_FORM",null);
       zfClueBase.put("ANOTHER_PROVINCE",null);
       zfClueBase.put("ANOTHER_CITY",null);
       zfClueBase.put("ANOTHER_EMPLOYEE",null);
       zfClueBase.put("REPORT_TYPE",null);
       zfClueBase.put("DOCUMENT_TITLE",null);
       zfClueBase.put("DOCUMENT_CODE",null);
       zfClueBase.put("DOCUMENT_DATE",null);
       zfClueBase.put("REPORT_DATE",null);
       zfClueBase.put("REPORT_CONTENT",null);
       zfClueBase.put("REPORT_MATERIALS",null);
       zfClueBase.put("REMARKS",null);
       zfClueBase.put("SUBMIT_CONTENT",null);
       zfClueBase.put("DEAL_CONTENT",null);
       zfClueBase.put("Area",null);
       zfClueBase.put("REPORTED_TYPE",null);
       zfClueBase.put("IS_REWARD",null);
       zfClueBase.put("IS_REPLY",null);
       zfClueBase.put("PERSONAL_REPORTED_NAME",null);
       zfClueBase.put("PERSONAL_REPORTED_SHOP_NAME",null);
       zfClueBase.put("PERSONAL_REPORTED_TEL",null);
       zfClueBase.put("PERSONAL_REPORTED_ADDRESS",null);
       zfClueBase.put("PERSONAL_REPORTED_MAIL",null);
       zfClueBase.put("ORGAN_REPORTED_NAME",null);
       zfClueBase.put("ORGAN_REPORTED_CODE",null);
       zfClueBase.put("ORGAN_REPORTED_ADDRESS",null);
       zfClueBase.put("ORGAN_REPORTED_PERSON_TYPE",null);
       zfClueBase.put("ORGAN_REPORTED_PERSON_NAME",null);
       zfClueBase.put("ORGAN_REPORTED_PERSON_TEL",null);
       zfClueBase.put("IS_REPORTEDS",null);
       zfClueBase.put("IS_ACCEPT",null);
       zfClueBase.put("ACCEPT_USER_ID",null);
       zfClueBase.put("ACCEPT_USER_NAME",null);
       zfClueBase.put("DENIAL_REASON",null);
       zfClueBase.put("DEAL_DEPART",null);
       zfClueBase.put("DEAL_TIME",null);
       zfClueBase.put("DEAL_TIME_REMARK",null);
       zfClueBase.put("IS_ADMIT",null);
       zfClueBase.put("CREATE_USER_ID",null);
       zfClueBase.put("CREATE_USER_NAME",null);
       zfClueBase.put("CREATE_TIME",null);
       zfClueBase.put("UPDATE_TIME",null);
       zfClueBase.put("STAUS",null);
       zfClueBase.put("IS_DELETE",null);
       zfClueBase.put("FLOW_RUN_ID",null);
       zfClueBase.put("UPDATE_USER_ID",null);
       zfClueBase.put("UPDATE_USER_NAME",null);
       zfClueBase.put("LEADER_CONTENT",null);
       zfClueBase.put("LEADER_TIME",null);
       zfClueBase.put("ACCEPT_TIME",null);
       zfClueBase.put("DOC_NUMS",null);
       zfClueBase.put("RETURN_STATUS",null);
       zfClueBase.put("RETURN_REMARK",null);
       zfClueBase.put("ATT_REMARKS",null);
       zfClueBase.put("RECEIVE_USER_ID",null);
       zfClueBase.put("DISTINGUISH_STATUS",null);
       zfClueBase.put("ADMIT_USER_ID",null);
       zfClueBase.put("ADMIT_USER_NAME",null);
       zfClueBase.put("ADMIT_TIME",null);
       zfClueBase.put("SEND_STAUS",null);
       zfClueBase.put("DEAL_DEPART_NAME",null);
       zfClueBase.put("CREATE_DEPT_ID",null);
       zfClueBase.put("CREATE_DEPT_NAME",null);
       zfClueBase.put("HAS_SET_REPLY_PERSON",null);
       zfClueBase.put("IS_BACK_TO_LAW",null);
       zfClueBase.put("IS_BACK_TO_PUB",null);
       zfClueBase.put("IS_MORE_INFORMERS",null);
       zfClueBase.put("IS_MERGE",null);
       zfClueBase.put("DEAL_TIME_TYPE",null);
       zfClueBase.put("IS_YELLOW",null);
       zfClueBase.put("IS_INVOLVED",null);
       zfClueBase.put("IS_RELIGION",null);
       zfClueBase.put("IS_COPYRIGHT",null);
       zfClueBase.put("SEND_TIME",null);
       zfClueBase.put("REMAINDER_TIME",null);
  //相当于 zfClueInformer表
       zfClueInformer.put("ID",null);//uuid生成
       zfClueInformer.put("CLUE_ID",null);//根据函数uuid
       zfClueInformer.put("INFORMER_TYPE",null);
       zfClueInformer.put("PERSONAL_NAME",null);
       zfClueInformer.put("PERSONAL_ADDRESS",null);
       zfClueInformer.put("PERSONAL_TEL",null);
       zfClueInformer.put("PERSONAL_CODE",null);
       zfClueInformer.put("PERSONAL_REMARK",null);
       zfClueInformer.put("ORGANIZATION_NAME",null);
       zfClueInformer.put("ORGANIZATION_ADDRESS",null);
       zfClueInformer.put("ORGANIZATION_CODE",null);
       zfClueInformer.put("IS_CONTACTS",null);
       zfClueInformer.put("CONTACTS_NAME",null);
       zfClueInformer.put("CONTACTS_TEL",null);
       zfClueInformer.put("CONTACTS_MAIL",null);
       zfClueInformer.put("CONTACTS_ADDRESS",null);
       zfClueInformer.put("IS_INFORMERS",null);
       zfClueInformer.put("ORGAN_INFORMER_PERSON_NAME",null);
       zfClueInformer.put("ORGAN_INFORMER_PERSON_TEL",null);
       zfClueInformer.put("PERSONAL_MAIL",null);
   }

   public Map getZfClueBaseMap(){
       return zfClueBaseMap.get();
   }
   public Map getZfClueInformerMap(){
       return zfClueInformerMap.get();
   }


   public void close(){ //在同一个线程执行该方法,只会把当前线程的map重新定义value为null;
       Map zfClueBase = zfClueBaseMap.get();
       Map zfClueInformer = zfClueInformerMap.get();
       // 相当于就是一个 zfClueBase一个金仓数据.  线索表
       zfClueBase.put("ID",null);
       zfClueBase.put("BASE_ID",null);
       zfClueBase.put("CLUE_SOURCE",null);
       zfClueBase.put("CLUE_SOURCE_REMARK",null);
       zfClueBase.put("REPORT_FORM",null);
       zfClueBase.put("ANOTHER_PROVINCE",null);
       zfClueBase.put("ANOTHER_CITY",null);
       zfClueBase.put("ANOTHER_EMPLOYEE",null);
       zfClueBase.put("REPORT_TYPE",null);
       zfClueBase.put("DOCUMENT_TITLE",null);
       zfClueBase.put("DOCUMENT_CODE",null);
       zfClueBase.put("DOCUMENT_DATE",null);
       zfClueBase.put("REPORT_DATE",null);
       zfClueBase.put("REPORT_CONTENT",null);
       zfClueBase.put("REPORT_MATERIALS",null);
       zfClueBase.put("REMARKS",null);
       zfClueBase.put("SUBMIT_CONTENT",null);
       zfClueBase.put("DEAL_CONTENT",null);
       zfClueBase.put("Area",null);
       zfClueBase.put("REPORTED_TYPE",null);
       zfClueBase.put("IS_REWARD",null);
       zfClueBase.put("IS_REPLY",null);
       zfClueBase.put("PERSONAL_REPORTED_NAME",null);
       zfClueBase.put("PERSONAL_REPORTED_SHOP_NAME",null);
       zfClueBase.put("PERSONAL_REPORTED_TEL",null);
       zfClueBase.put("PERSONAL_REPORTED_ADDRESS",null);
       zfClueBase.put("PERSONAL_REPORTED_MAIL",null);
       zfClueBase.put("ORGAN_REPORTED_NAME",null);
       zfClueBase.put("ORGAN_REPORTED_CODE",null);
       zfClueBase.put("ORGAN_REPORTED_ADDRESS",null);
       zfClueBase.put("ORGAN_REPORTED_PERSON_TYPE",null);
       zfClueBase.put("ORGAN_REPORTED_PERSON_NAME",null);
       zfClueBase.put("ORGAN_REPORTED_PERSON_TEL",null);
       zfClueBase.put("IS_REPORTEDS",null);
       zfClueBase.put("IS_ACCEPT",null);
       zfClueBase.put("ACCEPT_USER_ID",null);
       zfClueBase.put("ACCEPT_USER_NAME",null);
       zfClueBase.put("DENIAL_REASON",null);
       zfClueBase.put("DEAL_DEPART",null);
       zfClueBase.put("DEAL_TIME",null);
       zfClueBase.put("DEAL_TIME_REMARK",null);
       zfClueBase.put("IS_ADMIT",null);
       zfClueBase.put("CREATE_USER_ID",null);
       zfClueBase.put("CREATE_USER_NAME",null);
       zfClueBase.put("CREATE_TIME",null);
       zfClueBase.put("UPDATE_TIME",null);
       zfClueBase.put("STAUS",null);
       zfClueBase.put("IS_DELETE",null);
       zfClueBase.put("FLOW_RUN_ID",null);
       zfClueBase.put("UPDATE_USER_ID",null);
       zfClueBase.put("UPDATE_USER_NAME",null);
       zfClueBase.put("LEADER_CONTENT",null);
       zfClueBase.put("LEADER_TIME",null);
       zfClueBase.put("ACCEPT_TIME",null);
       zfClueBase.put("DOC_NUMS",null);
       zfClueBase.put("RETURN_STATUS",null);
       zfClueBase.put("RETURN_REMARK",null);
       zfClueBase.put("ATT_REMARKS",null);
       zfClueBase.put("RECEIVE_USER_ID",null);
       zfClueBase.put("DISTINGUISH_STATUS",null);
       zfClueBase.put("ADMIT_USER_ID",null);
       zfClueBase.put("ADMIT_USER_NAME",null);
       zfClueBase.put("ADMIT_TIME",null);
       zfClueBase.put("SEND_STAUS",null);
       zfClueBase.put("DEAL_DEPART_NAME",null);
       zfClueBase.put("CREATE_DEPT_ID",null);
       zfClueBase.put("CREATE_DEPT_NAME",null);
       zfClueBase.put("HAS_SET_REPLY_PERSON",null);
       zfClueBase.put("IS_BACK_TO_LAW",null);
       zfClueBase.put("IS_BACK_TO_PUB",null);
       zfClueBase.put("IS_MORE_INFORMERS",null);
       zfClueBase.put("IS_MERGE",null);
       zfClueBase.put("DEAL_TIME_TYPE",null);
       zfClueBase.put("IS_YELLOW",null);
       zfClueBase.put("IS_INVOLVED",null);
       zfClueBase.put("IS_RELIGION",null);
       zfClueBase.put("IS_COPYRIGHT",null);
       zfClueBase.put("SEND_TIME",null);
       zfClueBase.put("REMAINDER_TIME",null);
       //相当于 zfClueInformer表  线索举报人
       zfClueInformer.put("ID",null);//uuid生成
       zfClueInformer.put("CLUE_ID",null);//是线索ID
       zfClueInformer.put("INFORMER_TYPE",null);
       zfClueInformer.put("PERSONAL_NAME",null);
       zfClueInformer.put("PERSONAL_ADDRESS",null);
       zfClueInformer.put("PERSONAL_TEL",null);
       zfClueInformer.put("PERSONAL_CODE",null);
       zfClueInformer.put("PERSONAL_REMARK",null);
       zfClueInformer.put("ORGANIZATION_NAME",null);
       zfClueInformer.put("ORGANIZATION_ADDRESS",null);
       zfClueInformer.put("ORGANIZATION_CODE",null);
       zfClueInformer.put("IS_CONTACTS",null);
       zfClueInformer.put("CONTACTS_NAME",null);
       zfClueInformer.put("CONTACTS_TEL",null);
       zfClueInformer.put("CONTACTS_MAIL",null);
       zfClueInformer.put("CONTACTS_ADDRESS",null);
       zfClueInformer.put("IS_INFORMERS",null);
       zfClueInformer.put("ORGAN_INFORMER_PERSON_NAME",null);
       zfClueInformer.put("ORGAN_INFORMER_PERSON_TEL",null);
       zfClueInformer.put("PERSONAL_MAIL",null);

   }





}
