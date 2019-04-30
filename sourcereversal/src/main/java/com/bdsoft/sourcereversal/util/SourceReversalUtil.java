package com.bdsoft.sourcereversal.util;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * @author mister_wei
 * @version 1.1.1
 * @title web_service
 * @package com.bdsoft.sourcereversal.util
 * @date 2019/4/26 17:00
 */
@Component
public class SourceReversalUtil {


    public String getKey(Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : map.keySet()) {
            stringBuilder.append("\"").append(o).append("\"").append(",");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }

    public String  wgDepartmentIdToName(String id, List<Map<String,Object>> mapList){
        boolean flag = false;
        String name = null;
        if (mapList == null){
            return null;
        }
        for (Map map : mapList) {
            for (Object o : map.keySet()) {
               if (o.toString().equalsIgnoreCase("Deptid")){
                   Object value = map.get(o);
                   if (value != null){
                       if (value.toString().equals(id)){
                        flag = true;
                        name = (String) map.get("DeptName");
                        return name;
                       }
                   }

               }
            }
        }
        if (flag){
            return name;
        }else{
            return name;
        }
    }

    public String deptNameToCode(String deptName , List<Map<String,Object>> mapList){
        if (deptName == null){
            return null;
        }
        if (mapList == null){
            return null;
        }
        String code = null;
        for (Map<String,Object> map : mapList) {
            for (String key : map.keySet()) {
                if (map.get(key) != null){
                    if (deptName.equalsIgnoreCase(map.get(key).toString())){
                       code =  map.get("CODE_NO") == null ? null:map.get("CODE_NO").toString();
                    }
                }

            }
        }
                     return code;
    }

    public String getValue(Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object value : map.values()) {
            stringBuilder.append("'").append(value).append("'").append(",");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }
//這是新旧执法线索的ID互译功能.了
    public Object isRepoertType(Object obj) {
        if (obj == null){
            return null;
        }
        switch (Integer.parseInt(obj.toString())) {
            case 2:
                return 23;
            case 3:
                return 28;
            case 4:
                return 25;
            case 5:
                return 33;
            case 6:
                return 24;
            case 7:
                return 60;
            case 8:
                return 43;
            case 9:
                return 31;
            case 10:
                return 32;
            case 11:
                return 64;
            case 12:
                return 52;
            case 13:
                return 43;
            case 14:
                return 47;
            case 15:
                return 44;
            case 16:
                return 58;
            case 17:
                return 61;
            case 38:
                return 61;
            default:
                return null;

        }
    }
}
