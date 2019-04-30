package com.bdsoft.sourcereversal.constant;

import org.springframework.stereotype.Component;

/**
 * @author mister_wei
 * @version 1.1.1
 * @title web_service
 * @package com.bdsoft.sourcereversal.constant
 * @date 2019/4/26 17:03
 */
@Component
public class SourceReversalConstant {

   public interface Constant{
       //区域代码语句
        public static final int TO_2 = 1;
       //根据所有sql查询
        public static final String SQL="select uuid() as ID,'03005' as CLUE_SOURCE, '03' as REPORT_FORM,t.clue_type as REPORT_TYPE,\n" +
                "t.add_time as DOCUMENT_DATE,t.info as REPORT_CONTENT,t.area_id as Area,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then '1' when t2.`name` is null then '2'  else '2' end REPORTED_TYPE,\n" +
                "t.is_reply as is_reply,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then t2.leader when t2.`name` is null then ''  else '' end PERSONAL_REPORTED_NAME,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then t2.name when t2.`name` is null then ''  else '' end PERSONAL_REPORTED_SHOP_NAME,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then t2.leader_tel when t2.`name` is null then '' else '' end PERSONAL_REPORTED_TEL,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then t2.address when t2.`name` is null then '' else '' end PERSONAL_REPORTED_ADDRESS,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then t.obj_name  else t2.name end ORGAN_REPORTED_NAME,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then ''  else t2.code end ORGAN_REPORTED_CODE,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then t.obj_address else t2.address end ORGAN_REPORTED_ADDRESS,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then '' else t2.leader end ORGAN_REPORTED_PERSON_NAME,\n" +
                "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then '' else t2.leader_tel end ORGAN_REPORTED_PERSON_TEL,\n" +
                "'1' as SEND_STAUS, t.area_id as CREATE_DEPT_ID,\n" +
                "\n" +
                "\n" +
                "'1' as INFORMER_TYPE,\n" +
                "t.obj_name as ORGANIZATION_NAME,\n" +
                "t.obj_address as ORGANIZATION_ADDRESS,\n" +
                "t2.`code` as ORGANIZATION_CODE,\n" +
                "'0' as IS_CONTACTS ,\n" +
                "t2.leader as ORGAN_INFORMER_PERSON_NAME,\n" +
                "t2.leader_tel as ORGAN_INFORMER_PERSON_TEL\n" +
                "\n" +
                "\n" +
                "\n" +
                "from clue t\n" +
                "left JOIN regulatory_obj t2\n" +
                "on t.obj_id = t2.id\n" +
                "left join  staff t3\n" +
                "on t.user_id = t3.id";
       //根据线索查询最大时间戳,用这个sql来表示批量采集数据的样式模板.
       public static final String SQL_MAX_DATE = "SELECT MAX(c.add_time) as maxData FROM clue as c;";

       public static final String SQL_MAX_DATA="select uuid() as ID,'03005' as CLUE_SOURCE, '03' as REPORT_FORM,t.clue_type as REPORT_TYPE,\n" +
               "t.add_time as DOCUMENT_DATE,t.info as REPORT_CONTENT,t.area_id as Area,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then '1' when t2.`name` is null then '2'  else '2' end REPORTED_TYPE,\n" +
               "t.is_reply as is_reply,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then t2.leader when t2.`name` is null then ''  else '' end PERSONAL_REPORTED_NAME,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then t2.name when t2.`name` is null then ''  else '' end PERSONAL_REPORTED_SHOP_NAME,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then t2.leader_tel when t2.`name` is null then '' else '' end PERSONAL_REPORTED_TEL,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then t2.address when t2.`name` is null then '' else '' end PERSONAL_REPORTED_ADDRESS,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then t.obj_name  else t2.name end ORGAN_REPORTED_NAME,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then ''  else t2.code end ORGAN_REPORTED_CODE,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then t.obj_address else t2.address end ORGAN_REPORTED_ADDRESS,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then '' else t2.leader end ORGAN_REPORTED_PERSON_NAME,\n" +
               "CASE when  t2.`name` like '＊＊＊%' then '' when t2.`name` is null then '' else t2.leader_tel end ORGAN_REPORTED_PERSON_TEL,\n" +
               "'1' as SEND_STAUS, t.area_id as CREATE_DEPT_ID,\n" +
               "\n" +
               "\n" +
               "'1' as INFORMER_TYPE,\n" +
               "t.obj_name as ORGANIZATION_NAME,\n" +
               "t.obj_address as ORGANIZATION_ADDRESS,\n" +
               "t2.`code` as ORGANIZATION_CODE,\n" +
               "'0' as IS_CONTACTS ,\n" +
               "t2.leader as ORGAN_INFORMER_PERSON_NAME,\n" +
               "t2.leader_tel as ORGAN_INFORMER_PERSON_TEL\n" +
               "\n" +
               "\n" +
               "\n" +
               "from clue t\n" +
               "left JOIN regulatory_obj t2\n" +
               "on t.obj_id = t2.id\n" +
               "left join  staff t3\n" +
               "on t.user_id = t3.id where t.add_time >  str_to_date('&&&', '%Y-%m-%d %H:%i:%s')";

       public static final String SQL_WG_DEPARTMENT = "SELECT *  FROM \"PUBLIC\".\"wg_department\"\n";

       public static final String SQL_DEPT_ID = "SELECT * FROM \"PUBLIC\".\"department\" where \"dept_name\" = '&&&'";
       public static final String SQL_DEPT_WG_ID = "SELECT * FROM \"PUBLIC\".\"wg_department\" where \"DeptName\" = '&&&'";
       public static final String SQL_CODE_NO = "SELECT \"SID\",\"CODE_FLAG\",\"CODE_NAME\",\"CODE_NO\",\"CODE_ORDER\",\"PARENT_ID\" FROM \"PUBLIC\".\"SYS_CODE\" where \"CODE_NO\" like '11%'";


   }
}
